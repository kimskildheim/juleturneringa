package no.skildheim.brinken.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "user_team")
public class Team {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    private String founded;

    private String timesWon;

    private String timesFinal;

    private String timesSemi;

    private String timesFinalStages;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Player player;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Event> events;

}
