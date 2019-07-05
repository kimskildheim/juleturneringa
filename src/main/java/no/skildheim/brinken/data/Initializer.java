package no.skildheim.brinken.data;

import no.skildheim.brinken.model.Event;
import no.skildheim.brinken.model.Team;
import no.skildheim.brinken.repository.TeamRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Collections;
import java.util.stream.Stream;

@Component
public class Initializer implements CommandLineRunner {

    private final TeamRepository repository;

    public Initializer(TeamRepository repository){
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        Stream.of("FKBrinken", "Bygdetunet", "Isbjorn").forEach(name -> repository.save(new Team(name)));

        Team team = repository.findByName("FKBrinken");
        Event event = Event.builder().title("Jula2019").date(Instant.parse("2019-12-12T18:00:00.000Z")).build();
        team.setEvents(Collections.singleton(event));
        team.setTimesFinal("1");
        team.setTimesSemi("2");
        team.setFounded("2007");
        team.setTimesWon("3");
        repository.save(team);

        repository.findAll().forEach(System.out::println);
    }
}

