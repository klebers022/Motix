package br.com.motix.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(of = "id")
@Table(name = "POST")
public class Post {

    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
