package se.threegirlsoneflop.springdatajpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Issue extends AbstractEntity {

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String issueDescription;

    @OneToOne
    private WorkItem workItem;

    public Issue(String issueDescription, WorkItem workItem) {
        this.issueDescription = issueDescription;
        this.workItem = workItem;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public WorkItem getWorkItem() {
        return workItem;
    }

    public void setWorkItem(WorkItem workItem) {
        this.workItem = workItem;
    }
}
