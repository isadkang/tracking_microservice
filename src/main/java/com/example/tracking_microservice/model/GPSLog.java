package com.example.tracking_microservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GPSLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Vehicle vehicle;

    private Double latitude;
    private Double longitude;
    private Double speed;

    private LocalDateTime timestamp;

    private boolean speedViolation;
}
