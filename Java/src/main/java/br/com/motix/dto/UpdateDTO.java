package br.com.motix.dto;

import br.com.motix.models.Motorcycle;
import br.com.motix.models.Update;
import br.com.motix.models.User;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record UpdateDTO(@NotNull User user,
                        @NotNull Motorcycle motorcycle,
                        @NotNull Date date,
                        @NotNull String updateMessage
                        ){
    public Update toEntity(){
        return new Update(null, this.user, this.motorcycle, this.date, this.updateMessage);
    }
}
