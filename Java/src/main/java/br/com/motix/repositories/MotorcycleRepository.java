package br.com.motix.repositories;

import br.com.motix.models.Motorcycle;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;

import java.util.List;
import java.util.UUID;

public interface MotorcycleRepository extends JpaRepository<Motorcycle, UUID> {

    @Override
    @QueryHints(@QueryHint(name = "org.hibernate.cacheable", value = "true"))  //<-----------------------------------
    List<Motorcycle> findAll();

    List<Motorcycle> findAllBySector(String sector);

    List<Motorcycle> findAllByType(String type);

    List<Motorcycle> findAllBikesWithNoPlate();

    Motorcycle findByPlate(String plate);
}
