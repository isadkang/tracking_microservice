package com.example.tracking_microservice.service.impl;

import com.example.tracking_microservice.model.Vehicle;
import com.example.tracking_microservice.repository.VehicleRepository;
import com.example.tracking_microservice.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository vehicleRepository;

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Optional<Vehicle> getVehicleId(Long id) {
        return vehicleRepository.findById(id);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

}
