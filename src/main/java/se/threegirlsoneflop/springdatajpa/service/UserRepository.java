package se.threegirlsoneflop.springdatajpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import se.threegirlsoneflop.springdatajpa.model.User;

import javax.persistence.Column;
import java.util.Collection;
import java.util.List;

/**
 * Created by josefinelantz on 29/01/16.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    Collection<User> findByUserNumber(String userNumber);
    Collection<User> findByFirstName(String firstName);
    Collection<User> findByLastName(String value);
    Collection<User> findByFirstNameAndLastName(String firstName, String lastName);

    @Query("select u from #{#entityName} u where u.team = ?1")
    List<User> findAllByTeam(String teamName);
}
