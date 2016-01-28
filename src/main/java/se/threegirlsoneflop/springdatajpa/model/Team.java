package se.threegirlsoneflop.springdatajpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class Team extends AbstractEntity {

    @Column(nullable = false, unique = true)
    private String teamName;
    private Status status;
    @OneToMany
    private Collection<User> users;

    protected Team(){}

    public Team(String teamName) {
        this.teamName = teamName;
        this.users = new HashSet<>();
    }

    public String getTeamName() {
        return teamName;
    }

    public Collection<User> getUsers() {
        return new HashSet<>(users);
    }

    public Team addUser(User user){
        this.users.add(user);
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
}
