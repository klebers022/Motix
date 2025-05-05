package br.com.motix.services;

import br.com.motix.models.Motorcycle;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface MotorcycleService {

    List<Motorcycle> findAll();

    Motorcycle findById(UUID id);

    Motorcycle findByPlate(String plate);

    Motorcycle updatePlate(UUID id, String newPlate); //<-----------------------
}
