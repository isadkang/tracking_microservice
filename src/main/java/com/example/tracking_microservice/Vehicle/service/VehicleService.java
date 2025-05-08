package com.example.tracking_microservice.Vehicle.service;

import com.example.tracking_microservice.Vehicle.model.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleService {
    Vehicle createVehicle(Vehicle vehicle);
    Optional<Vehicle> getVehicleId(Long id);
    List<Vehicle> getAllVehicles();
}
