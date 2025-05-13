package br.com.motix.dto;

import br.com.motix.models.User;

public record UserDTO(String name, String rm) {

    public User toEntity(){
        User user = new User();
        user.setName(this.name);
        user.setRm(this.rm);
        return user;
    }
}
