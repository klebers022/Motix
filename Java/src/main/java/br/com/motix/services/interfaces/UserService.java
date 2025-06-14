package br.com.motix.services.interfaces;

import br.com.motix.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;


public interface UserService {

    //A ideia é que a api seja usada por funcionarios logo eles nao devem poder fazer alteracoes em nenhum usuario
    //O usuarios ja estara criado quando o funcionario for utilizar o app que consumira a api
    //Logo apenas GETs foram criados para a autenticacao durante o login e tambem para a exibicao posteriormente

    Page<User> findAll(Pageable pageable);

    User findById(UUID id);

    User findByRm(String rm);

    List<User> findByName(String name);

    User postUser(User user);

    User updateUser(User user);

    void deleteUserById(UUID id);

    void deleteUserByRm(String rm);
}
