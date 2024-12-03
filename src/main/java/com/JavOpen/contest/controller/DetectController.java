package com.JavOpen.contest.controller;

import com.JavOpen.contest.model.*;
import com.JavOpen.contest.service.DetectService;
import com.JavOpen.contest.service.DeviceService;
import com.JavOpen.contest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/detect")
public class DetectController {
    @Autowired
    private DetectService detectService;
    @Autowired
    private DeviceService deviceService;
    @Autowired
    private UserService userService;

    // 관측값 등록
    @PostMapping("/register")
    public ResponseEntity<String> registerDevice(@RequestBody Map<String, Object> requestData) {
        String adminId = (String) requestData.get("adminId");
        int user_Id = userService.findByAdminId(adminId);

        User user = new User();
        user.setUserId(user_Id);

        // Device 객체 생성
        Detect detect = new Detect();
        detect.setUser(user);
        detect.setLocation((String) requestData.get("location"));
        detect.setProbability((Double) requestData.get("probability"));
        detect.setAntImg((String) requestData.get("antImg"));

        detectService.registerDetect(detect);
        return ResponseEntity.ok("관측값 등록이 완료되었습니다.");
    }

    @GetMapping("/{adminId}")
    public ResponseEntity<List<DetectSummaryDTO>> getResultsByUserId(@PathVariable("adminId") String adminId) {
        int user_Id = userService.findByAdminId(adminId);
        List<DeviceDTO> devices = deviceService.getResultsByUserId(user_Id);
        List<String> locations = devices.stream()
                .map(DeviceDTO::getLocation)
                .toList();

        List<DetectSummaryDTO> summaries = detectService.getDetectSummaryByUserIdAndLocations(user_Id, locations);
        return ResponseEntity.ok(summaries);
    }
}
