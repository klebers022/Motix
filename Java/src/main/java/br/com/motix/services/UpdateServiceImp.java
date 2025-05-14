package br.com.motix.services;

import br.com.motix.models.Motorcycle;
import br.com.motix.models.Update;
import br.com.motix.models.User;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class UpdateServiceImp implements UpdatesService{
    @Override
    public List<Update> findAll() {
        return null;
    }

    @Override
    public Update findById(UUID id) {
        return null;
    }

    @Override
    public List<Update> findByUserId(User user) {
        return null;
    }

    @Override
    public List<Update> findByMotorcycleId(Motorcycle motorcycle) {
        return null;
    }

    @Override
    public List<Update> findByDate(Date date) {
        return null;
    }

    @Override
    public void deleteById(UUID id) {

    }

    @Override
    public Update update(Update update) {
        return null;
    }

    @Override
    public Update post(Update update) {
        return null;
    }
}
