package com.JavOpen.contest.controller;


import com.JavOpen.contest.model.Device;
import com.JavOpen.contest.model.DeviceDTO;
import com.JavOpen.contest.model.User;
import com.JavOpen.contest.service.DeviceService;
import com.JavOpen.contest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/device")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;
    @Autowired
    private UserService userService;

    // 장치 등록
    @PostMapping("/register")
    public ResponseEntity<String> registerDevice(@RequestBody Map<String, Object> requestData) {
        String adminId = (String) requestData.get("adminId");
        int user_Id = userService.findByAdminId(adminId);

        User user = new User();
        user.setUserId(user_Id);

        // Device 객체 생성
        Device device = new Device();
        device.setUser(user);
        device.setLocation((String) requestData.get("location"));

        boolean isDuplicate = deviceService.isLocationExists(user_Id, device.getLocation());
        if (isDuplicate) {
            return ResponseEntity.badRequest().body("중복된 위치입니다.");
        }

        deviceService.registerDevice(device);
        return ResponseEntity.ok("장치 등록이 완료되었습니다.");
    }
}
