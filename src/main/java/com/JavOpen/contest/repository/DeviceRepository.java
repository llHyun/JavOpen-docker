package com.JavOpen.contest.repository;

import com.JavOpen.contest.model.Device;
import com.JavOpen.contest.model.DeviceDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Integer> {
    //boolean existsByUserIdAndLocation(int userId, String location);
    boolean existsByUser_UserIdAndLocation(int userId, String location);

    @Query("SELECT new com.JavOpen.contest.model.DeviceDTO(r.location) " +
            "FROM Device r WHERE r.user.userId = :userId")
    List<DeviceDTO> findResultsByUserId(@Param("userId") int userId);

}
