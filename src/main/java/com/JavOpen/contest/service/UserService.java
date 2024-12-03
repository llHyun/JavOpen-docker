package com.JavOpen.contest.service;

import com.JavOpen.contest.model.User;
import com.JavOpen.contest.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //회원가입
    public User registerUser(User user) {
        // 비밀번호 암호화
        String encryptedPassword = passwordEncoder.encode(user.getAdminPw());

        user.setAdminPw(encryptedPassword);

        return userRepository.save(user); // DB에 사용자 저장
    }

    //중복체크
    public boolean isAdminIdExists(String adminId) {
        return userRepository.existsByAdminId(adminId);
    }

    public int findByAdminId(String adminId){
        return userRepository.findUserIdByAdminId(adminId);
    }

    //로그인 암호 확인
    public boolean authenticate(String adminId, String rawPassword) {
        User user = userRepository.findByAdminId(adminId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (user == null) {
            return false;
        }

        // 해시된 비밀번호와 비교
        return passwordEncoder.matches(rawPassword, user.getAdminPw());
    }
}