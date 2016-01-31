package se.threegirlsoneflop.springdatajpa.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import se.threegirlsoneflop.springdatajpa.status.Status;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by joanne on 28/01/16.
 */
@Entity
public class User extends AbstractEntity {
    
    @Column ()
    private String userNumber;
    @Column (nullable = false, unique = true)
    private String firstName;
    @Column (nullable = false)
    private String lastName;
    @Column (nullable = false)
    private String status;

    @ManyToOne
    private Team team;

    @OneToMany(mappedBy = "user")
    private Collection<WorkItem> workItems;

    protected User() {}

    /*Vad gäller team initialisering. Hur ska jag initialisera denna? För mig känns det konstigt att man
    skulle behöva ange teamName när man skapar en User. En User kan väl ibland inte tillhöra ett team?
    Jag vill i konstruktorn kunna skriva this.team = new Team() och sen ha en setTeam() som tar emot det team som addUser
    i Team-klassen returnerar. Tycker ni att det skulle vara ok att införa ytterligare en konstruktor i Team? Se bort-
    kommenterad kod */
    public User(String firstName, String lastName) {
        setUserNumber();
        this.firstName = firstName;
        this.lastName = lastName;
        setStatusActive();
        this.team = new Team();
        this.workItems = new HashSet<>();
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber() {
        this.userNumber = userNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatusInActive() {
        this.status = Status.Inactive;
    }

    public void setStatusActive() {
        this.status = Status.Active;
    }

    public void addWorkItem(WorkItem workItem) {
        workItems.add(workItem);
    }

    public Collection<WorkItem> getWorkItem(){
        return workItems;
    }

    /*public void setTeam(User user) {
        this.team = team.addUser(this);
    }*/

    public Team getTeam() {
        return team;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other instanceof User) {
            final User otherUser = (User) other;

            return userNumber.equals(otherUser.userNumber) && status.equals(otherUser.getStatus()) && team.getTeamName().equals(otherUser.getTeam().getTeamName());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 1;
            result += 17 * userNumber.hashCode();
            result += 17 * status.hashCode();
            result += 17 * team.getTeamName().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
