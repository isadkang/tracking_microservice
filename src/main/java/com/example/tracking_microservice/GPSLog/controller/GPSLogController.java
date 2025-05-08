package com.example.tracking_microservice.GPSLog.controller;

import com.example.tracking_microservice.GPSLog.dto.GPSLogRequestDTO;
import com.example.tracking_microservice.GPSLog.service.GPSLogService;
import com.example.tracking_microservice.GPSLog.model.GPSLog;
import com.example.tracking_microservice.Vehicle.model.Vehicle;
import com.example.tracking_microservice.Vehicle.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class GPSLogController {

    private final GPSLogService gpsLogService;
    private final VehicleService vehicleService;

    @PostMapping("/gps")
    public ResponseEntity<?> saveGPSLog(@RequestBody GPSLogRequestDTO dto) {
        Optional<Vehicle> vehicleOpt = vehicleService.getVehicleId(dto.getVehicleId());
        if (vehicleOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vehicle not found");
        }

        GPSLog log = GPSLog.builder()
                .vehicle(vehicleOpt.get())
                .latitude(dto.getLatitude())
                .longitude(dto.getLongitude())
                .speed(dto.getSpeed())
                .timestamp(dto.getTimestamp())
                .build();

        return ResponseEntity.ok(gpsLogService.saveGPSLog(log));
    }

    @GetMapping("/vehicles/{id}/last-location")
    public ResponseEntity<?> getLastLocation(@PathVariable Long id) {
        return gpsLogService.getLastLocation(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/vehicles/{id}/history")
    public ResponseEntity<List<GPSLog>> getHistory(
            @PathVariable Long id,
            @RequestParam LocalDateTime from,
            @RequestParam LocalDateTime to
    ) {
        return ResponseEntity.ok(gpsLogService.getGPSLogs(id, from, to));
    }
}
