package com.JavOpen.contest.repository;

import com.JavOpen.contest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // 이름으로 사용자 존재 여부 확인
    boolean existsByAdminId(String adminId);

    Optional<User> findByAdminId(String adminId);

    @Query("SELECT u.userId FROM User u WHERE u.adminId = :adminId")
    int findUserIdByAdminId(@Param("adminId") String adminId);
}
