package com.example.tracking_microservice.repository;

import com.example.tracking_microservice.model.GPSLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface GPSLogRepository extends JpaRepository<GPSLog, Long> {
    List<GPSLog> findByVehicleIdAndTimestampBetween(Long vehicleId, LocalDateTime from, LocalDateTime to);
    Optional<GPSLog> findTopByVehicleIdOrderByTimestampDesc(Long vehicleId);
}
