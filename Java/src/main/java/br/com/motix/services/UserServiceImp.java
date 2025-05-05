package br.com.motix.services;

import br.com.motix.models.User;
import br.com.motix.repositories.UserRepository;

import java.util.List;
import java.util.UUID;

public class UserServiceImp implements UserService{

    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(UUID id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User findByRm(String rm) {
        return userRepository.findAllByRm(rm);
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }
}
