package no.skildheim.brinken.repository;


import no.skildheim.brinken.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
    Team findByName(String name);
}
