package no.skildheim.brinken.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Player {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;
    private String age;

}
