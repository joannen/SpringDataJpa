package se.threegirlsoneflop.springdatajpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import se.threegirlsoneflop.springdatajpa.model.Team;

/**
 * Created by joanne on 28/01/16.
 */
public interface TeamRepository extends JpaRepository<Team, Long> {

}
