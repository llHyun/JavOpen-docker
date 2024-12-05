package com.JavOpen.contest.service;

import com.JavOpen.contest.model.*;
import com.JavOpen.contest.repository.DetectRepository;
import com.JavOpen.contest.repository.DeviceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class DetectService {
    private final DetectRepository detectRepository;


    @Autowired
    public DetectService(DetectRepository detectRepository) {
        this.detectRepository = detectRepository;
    }

    //장치등록
    public Detect registerDetect(Detect detect) {
        return detectRepository.save(detect); // DB에 사용자 저장
    }

    public List<DetectSummaryDTO> getDetectSummaryByUserIdAndLocations(int userId, List<String> locations) {
        // Detect 데이터를 가져옴
        List<DetectDTO> detects = detectRepository.findDetectsByUserIdAndLocations(userId, locations);

        // 장소별 개수 조회
        List<Object[]> detectCounts = detectRepository.findDetectCountsByUserIdAndLocations(userId, locations);

        // 장소별 개수와 address를 Map으로 변환
        Map<String, String> addressMap = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();

        for (Object[] row : detectCounts) {
            String location = (String) row[0];
            int count = ((Long) row[1]).intValue();
            String address = (String) row[2];
            countMap.put(location, count);
            addressMap.put(location, address);
        }

        // Detect 데이터를 location 기준으로 그룹화
        Map<String, List<DetectDTO>> detectsByLocation = detects.stream()
                .collect(Collectors.groupingBy(DetectDTO::getLocation));

        // 모든 location을 순회하며 Summary 생성
        return locations.stream()
                .map(location -> {
                    int count = countMap.getOrDefault(location, 0);
                    List<DetectDTO> detectDetails = detectsByLocation.getOrDefault(location, List.of());
                    return new DetectSummaryDTO(location, count, detectDetails);
                })
                .toList();
    }



}
