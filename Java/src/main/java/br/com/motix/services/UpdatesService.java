package br.com.motix.services;

import br.com.motix.models.Motorcycle;
import br.com.motix.models.Update;
import br.com.motix.models.User;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface UpdatesService {
    List<Update> findAll();

    List<Update> findByUserId(User user);

    List<Update> findByMotorcycleId(Motorcycle motorcycle);

    List<Update> findByDate(Date date);

    void deleteById(UUID id);

    Update update(Update update);

    Update post(Update update);
}
