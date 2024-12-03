package com.JavOpen.contest.repository;

import com.JavOpen.contest.model.Detect;
import com.JavOpen.contest.model.DetectDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetectRepository extends JpaRepository<Detect, Integer> {
    @Query("SELECT new com.JavOpen.contest.model.DetectDTO(d.location, d.probability, d.antImg, d.date) " +
            "FROM Detect d WHERE d.user.userId = :userId AND d.location IN :locations")
    List<DetectDTO> findDetectsByUserIdAndLocations(@Param("userId") int userId, @Param("locations") List<String> locations);

    @Query("SELECT d.location, COUNT(d) FROM Detect d " +
            "WHERE d.user.userId = :userId AND d.location IN :locations " +
            "GROUP BY d.location")
    List<Object[]> findDetectCountsByUserIdAndLocations(@Param("userId") int userId, @Param("locations") List<String> locations);
}