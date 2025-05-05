package br.com.motix.repositories;

import br.com.motix.models.Motorcycle;
import br.com.motix.models.enums.BikeType;
import br.com.motix.models.enums.Sectors;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;

import java.util.List;
import java.util.UUID;

public interface MotorcycleRepository extends JpaRepository<Motorcycle, UUID> {

    @Override
    @QueryHints(@QueryHint(name = "org.hibernate.cacheable", value = "true"))  //<-----------------------------------
    List<Motorcycle> findAll();

    List<Motorcycle> findAllBySector(Sectors sector);

    List<Motorcycle> findAllByType(BikeType type);

    List<Motorcycle> findAllByIsPlateReadable(boolean status);

    Motorcycle findByPlate(String plate);
}
