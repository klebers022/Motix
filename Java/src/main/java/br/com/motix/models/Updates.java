package br.com.motix.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "updates")
public class Updates {

    @Id
    @Getter @Setter
    private UUID id;

    @Getter @Setter
    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;

    @Getter @Setter
    @JoinColumn(name = "motorcycle_id")
    @ManyToOne
    private Motorcycle motorcycle;

    @Getter @Setter
    private Date updateDate;

    @Getter @Setter
    private String updateMessage;
}
