package com.example.tracking_microservice.GPSLog.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GPSLogRequestDTO {
    @NotNull(message = "Vehicle ID is Required.")
    private Long vehicleId;

    @NotNull(message = "Latitude is Required")
    @DecimalMin(value = "-90.0", message = "Latitude must be >= -90")
    @DecimalMax(value = "90.0", message = "Latitude must be <= 90")
    private Double latitude;

    @NotNull(message = "Longitude is Required")
    @DecimalMin(value = "-180.0", message = "Latitude must be >= -180")
    @DecimalMax(value = "180.0", message = "Latitude must be <= 180")
    private Double longitude;

    @NotNull(message = "Speed is Required")
    @DecimalMin(value = "0", message = "Speed must be >= 0")
    private Double speed;

    @NotNull(message = "Timestamp is Required")
    private LocalDateTime timestamp;
}
