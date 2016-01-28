package se.threegirlsoneflop.springdatajpa.model;

import javax.persistence.*;

/**
 * Created by TheYellowBelliedMarmot on 2016-01-28.
 */
@Entity
public class WorkItem extends AbstractEntity{

    private String description;

    @Embeddable
    private Status status;

    protected WorkItem(){
    }

    public WorkItem(String description){
        this.description = description;
        this.status = Status.UNSTARTED;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        WorkItem workItem = (WorkItem) o;

        if (description != null ? !description.equals(workItem.description) : workItem.description != null)
            return false;
        return status != null ? status.equals(workItem.status) : workItem.status == null;

    }

    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
