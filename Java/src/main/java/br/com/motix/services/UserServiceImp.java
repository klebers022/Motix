package br.com.motix.services;

import br.com.motix.models.User;
import br.com.motix.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;

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
    public List<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public User postUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        if (userRepository.existsByRm(user.getRm())) {
            throw new RuntimeException("User with RM: " + user.getRm() + " already exists.");
        } else return userRepository.save(user);


    }

    @Override
    public void deleteUserById(UUID id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else throw new RuntimeException("User with ID: " + id + " not found.");
    }

    @Override
    public void deleteUserByRm(String rm) {
        if (userRepository.existsByRm(rm)) {
            userRepository.deleteByRm(rm);
        } else throw new RuntimeException("User with RM: " + rm + " not found.");
    }
}
