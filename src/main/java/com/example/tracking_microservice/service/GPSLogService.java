package com.example.tracking_microservice.service;

import com.example.tracking_microservice.model.GPSLog;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface GPSLogService {
    GPSLog saveGPSLog(GPSLog gpsLog);
    List<GPSLog> getGPSLogs(Long vehicleId, LocalDateTime from, LocalDateTime to);
    Optional<GPSLog> getLastLocation(Long vehicleId);
}
