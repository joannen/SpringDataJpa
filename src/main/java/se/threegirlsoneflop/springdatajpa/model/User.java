package se.threegirlsoneflop.springdatajpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by josefinelantz on 28/01/16.
 */
@Entity
public class User {

    @Column
    private String userName;
    @Column
    private String firstName;
    @Column String lastName;



}
