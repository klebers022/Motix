package br.com.motix.dto;

import br.com.motix.models.Motorcycle;
import br.com.motix.models.enums.Sectors;

public record MotorcycleDTO(Sectors sector, String position, String plate, boolean isPlateReadable) {
    public Motorcycle toEntity(){
        Motorcycle motorcycle = new Motorcycle();
        motorcycle.setSector(this.sector);
        motorcycle.setPosition(this.position);
        motorcycle.setPlate(this.plate);
        motorcycle.setPlateReadable(motorcycle.isPlateReadable());
        return motorcycle;
    }
}
