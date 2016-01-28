package se.threegirlsoneflop.springdatajpa.model;

import se.threegirlsoneflop.springdatajpa.status.Status;

import javax.persistence.*;

/**
 * Created by TheYellowBelliedMarmot on 2016-01-28.
 */
@Entity
public class WorkItem extends AbstractEntity{

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String status;

    @OneToOne
    private Issue issue;

    protected WorkItem(){
    }

    public WorkItem(String description){
        this.description = description;
        this.status = Status.Unstarted;
        this.issue = issue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus(){ return status;}

    public void setStatusUnstarted(){
        this.status = Status.Unstarted;
    }

    public void setStatusStarted(){
        this.status = Status.Started;
    }

    public void setStatusDone(){
        this.status = Status.Done;
    }

    public Issue getIssue(){
        return issue;
    }

    public void setIssue(Issue issue){
        this.issue = issue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkItem workItem = (WorkItem) o;

        if (description != null ? !description.equals(workItem.description) : workItem.description != null)
            return false;
        if (status != null ? !status.equals(workItem.status) : workItem.status != null) return false;
        return issue != null ? issue.equals(workItem.issue) : workItem.issue == null;

    }

    @Override
    public int hashCode() {
        int result = description != null ? description.hashCode() : 0;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (issue != null ? issue.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "WorkItem{" +
                "description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", issue=" + issue +
                '}';
    }
}
