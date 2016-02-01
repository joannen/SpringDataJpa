package se.threegirlsoneflop.springdatajpa.model;

import se.threegirlsoneflop.springdatajpa.status.Status;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Embeddable
public class Issue extends AbstractEntity {

    public final static String NoIssue = "No issue";

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String issueDescription;

    public Issue() {
        this.issueDescription = NoIssue;
        this.status = Status.Inactive;
    }

    public Issue(String issueDescription) {
        this.issueDescription = issueDescription;
        this.status = Status.Active;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setDone() {
        this.status = Status.Done;
    }
}
