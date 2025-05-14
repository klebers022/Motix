package br.com.motix.dto;

import br.com.motix.models.User;
import jakarta.validation.constraints.NotNull;

public record UserDTO(@NotNull String name,
                      @NotNull String rm,
                      @NotNull String password) {

    public User toEntity(){
        return new User(null, this.rm, this.password, this.name, null);
    }
}
