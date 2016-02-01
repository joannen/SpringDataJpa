package se.threegirlsoneflop.springdatajpa.model;

import se.threegirlsoneflop.springdatajpa.status.Status;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class Team extends AbstractEntity {

    @Column(nullable = false, unique = true)
    private String teamName;

    @Column(nullable = false)
    private String status;

    @OneToMany(mappedBy = "team")
    private Collection<User> users;

    protected Team(){}

    public Team(String teamName) {
        this.teamName = teamName;
        this.status = Status.Active;
        this.users = new HashSet<>();
    }

    public String getTeamName() {
        return teamName;
    }

    public String getStatus() {
        return status;
    }

    public Collection<User> getUsers() {
        return new HashSet<>(users);
    }

    public Team addUser(User user){
        if(this.users.add(user)) {
            return this;
        }
        return null;
    }

    public Team setStatusInactive(){
        this.status = Status.Inactive;
        return this;
    }

    public Team setStatusActive(){
        this.status = Status.Active;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        if (teamName != null ? !teamName.equals(team.teamName) : team.teamName != null) return false;
        return !(status != null ? !status.equals(team.status) : team.status != null);

    }

    @Override
    public int hashCode() {
        int result = teamName != null ? teamName.hashCode() : 0;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamName='" + teamName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
