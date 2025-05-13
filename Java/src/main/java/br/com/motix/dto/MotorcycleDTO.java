package br.com.motix.dto;

import br.com.motix.models.Motorcycle;
import br.com.motix.models.enums.BikeType;
import br.com.motix.models.enums.Sectors;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record MotorcycleDTO(@NotNull Sectors sector,
                            @NotNull String position,
                            @NotNull @Pattern(regexp = "^[a-zA-Z]{3}[0-9][A-Za-z0-9][0-9]{2}$") String plate,
                            @NotNull BikeType type,
                            boolean isPlateReadable

                            ){
    public Motorcycle toEntity(){
        Motorcycle motorcycle = new Motorcycle(null, this.sector, this.position, this.plate, false, this.type) ;
        motorcycle.setPlateReadable(motorcycle.isPlateReadable());
        return motorcycle;
    }
}
