package br.com.motix.services;

import br.com.motix.models.Motorcycle;
import br.com.motix.repositories.MotorcycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Optional;

@Service
public class MotorcycleServiceImp implements MotorcycleService {

    @Autowired
    private MotorcycleRepository bikeRepository;

    @Override
    public List<Motorcycle> findAll() {
        return bikeRepository.findAll();
    }

    @Override
    public Motorcycle findById(UUID id) {
        return bikeRepository.findById(id).orElse(null);
    }

    @Override
    public Motorcycle findByPlate(String plate) {
        return bikeRepository.findByPlate(plate);
    }

    @Override
    public Motorcycle updatePlate(UUID id, String newPlate) {
        Optional<Motorcycle> bikeToUpdate = bikeRepository.findById(id);
        if (bikeToUpdate.isPresent()) {
            Motorcycle bike = bikeToUpdate.get();
            bike.setPlate(newPlate);
            return bikeRepository.save(bike);
        } return null;
    }

    @Override
    public List<Motorcycle> findAllReadPlatesFalse() {
        return bikeRepository.findAllByIsPlateReadableIsFalse();
    }
}
