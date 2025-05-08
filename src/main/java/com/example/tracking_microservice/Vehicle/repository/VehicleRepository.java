package com.example.tracking_microservice.Vehicle.repository;

import com.example.tracking_microservice.Vehicle.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
