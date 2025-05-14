package br.com.motix.repositories;


import br.com.motix.models.Update;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UpdateRepository extends JpaRepository<Update, UUID> {


    List<Update> findAll();

    Update findById();

    List<Update> findAllByUser();

    List<Update> findAllByMotorcycle();

    List<Update> findAllByUpdateDate();

    boolean existsById(UUID id);

    @Override
    void deleteById(UUID id);
}
