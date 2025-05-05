package br.com.motix.repositories;

import br.com.motix.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
   @Override
   List<User> findAll();

   User findAllByRm(String rm);

   User findByName(String name);
}
