package se.threegirlsoneflop.springdatajpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import se.threegirlsoneflop.springdatajpa.model.Team;

import java.util.Collection;

/**
 * Created by joanne on 28/01/16.
 */
 interface TeamRepository extends JpaRepository<Team, Long> {

    Collection<Team> findByTeamName(String teamName);
    Collection<Team> findByStatus(String status);

}
