package com.example.tracking_microservice.GPSLog.service.impl;

import com.example.tracking_microservice.GPSLog.model.GPSLog;
import com.example.tracking_microservice.GPSLog.repository.GPSLogRepository;
import com.example.tracking_microservice.GPSLog.service.GPSLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GPSLogServiceImpl implements GPSLogService {

    private final GPSLogRepository gpsLogRepository;

    @Override
    public GPSLog saveGPSLog(GPSLog gpsLog) {
        if (gpsLog.getSpeed() > 100) {
            gpsLog.setSpeedViolation(true);
        }

        return gpsLogRepository.save(gpsLog);
    }

    @Override
    public List<GPSLog> getGPSLogs(Long vehicleId, LocalDateTime from, LocalDateTime to) {
        return gpsLogRepository.findByVehicleIdAndTimestampBetween(vehicleId, from, to);
    }

    @Override
    public Optional<GPSLog> getLastLocation(Long vehicleId) {
        return gpsLogRepository.findTopByVehicleIdOrderByTimestampDesc(vehicleId);
    }

}
