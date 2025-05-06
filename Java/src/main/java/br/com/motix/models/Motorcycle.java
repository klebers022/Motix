package br.com.motix.models;

import br.com.motix.models.enums.BikeType;
import br.com.motix.models.enums.Sectors;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.Objects;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MOTORCYCLE")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Motorcycle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private UUID id;

    @Getter @Setter
    private Sectors sector;

    @Getter @Setter
    private String position;

    @Getter @Setter @Nullable //<---------------------------------------------------
    private String plate;

    @Getter @Setter
    private boolean isPlateReadable;

    @Getter @Setter
    private BikeType type;

    private void readPlate() {   //<------------------------------------------------
        isPlateReadable = (plate != null);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Motorcycle that = (Motorcycle) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
