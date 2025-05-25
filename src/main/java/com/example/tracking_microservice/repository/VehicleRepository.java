package com.example.tracking_microservice.repository;

import com.example.tracking_microservice.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
