package com.JavOpen.contest.service;

import com.JavOpen.contest.model.Device;
import com.JavOpen.contest.model.DeviceDTO;
import com.JavOpen.contest.repository.DeviceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class DeviceService {
    private final DeviceRepository deviceRepository;

    @Autowired
    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    //장치등록
    public Device registerDevice(Device device) {
        return deviceRepository.save(device); // DB에 사용자 저장
    }

    //위치 중복체크
    public boolean isLocationExists(int userId, String location) {
        return deviceRepository.existsByUser_UserIdAndLocation(userId, location);
    }

    public List<DeviceDTO> getResultsByUserId(int userId) {
        return deviceRepository.findResultsByUserId(userId);
    }


}
