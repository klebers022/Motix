package br.com.motix.models;

import br.com.motix.models.enums.BikeType;
import br.com.motix.models.enums.Sectors;
import jakarta.persistence.*;

import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Table(name = "MOTORCYCLE")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Motorcycle {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Getter @Setter
    private UUID id;

    //******************************Transformar Setor de Enum para um Classe
    @Getter @Setter
    @Enumerated(EnumType.STRING)
    @Column(length = 15) @NotNull
    private Sectors sector;


    //*****************************Posição vai virar Vaga e virá da classe Setor
    @Getter @Setter
    @Column(length = 10) @NotNull
    private String position;

    @Getter @Setter
    @Column(length = 10, unique = true) @NotNull
    private String plate;

    @Getter @Setter
    private boolean plateReadable;

    @Getter @Setter
    @Enumerated(EnumType.STRING)
    @Column(length = 15) @NotNull
        private BikeType type;

    @OneToMany(mappedBy = "motorcycle", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Update> updates = new ArrayList<>();

    public Motorcycle(UUID id, Sectors sector, String position, String plate, boolean plateReadable, BikeType type) {
        this.id = id;
        this.sector = sector;
        this.position = position;
        readPlate(plate);
        this.plateReadable = plateReadable;
        this.type = type;
    }

    public String readPlate(String plate) {
        if (plate != null) {
            setPlateReadable(true);
            return this.plate = plate;
        }else{
            setPlateReadable(false);
            return null;
        }
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

    @Override
    public String toString() {
        return "Motorcycle{" +
                "id=" + id +
                ", sector=" + sector +
                ", position='" + position + '\'' +
                ", plate='" + plate + '\'' +
                ", plateReadable=" + plateReadable +
                ", type=" + type +
                ", updates=" + updates +
                '}';
    }
}
