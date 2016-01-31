package se.threegirlsoneflop.springdatajpa.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by joanne on 30/01/16.
 */
public class TeamTest {

    private Team team1;
    private Team equalTeam;


    @Before
    public void setup(){
        team1 = new Team("dreamteam");
        equalTeam = new Team("dreamteam");
    }

    @Test
    public void teamsWithEqualParametersShouldBeEqual(){
        assertEquals(team1, equalTeam);
    }

    @Test
    public void equalTeamsShouldProduceSameHashCode(){
        assertEquals(team1.hashCode(), equalTeam.hashCode());
    }



}