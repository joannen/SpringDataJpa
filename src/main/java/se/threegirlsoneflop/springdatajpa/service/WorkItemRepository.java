package se.threegirlsoneflop.springdatajpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import se.threegirlsoneflop.springdatajpa.model.User;
import se.threegirlsoneflop.springdatajpa.model.WorkItem;
import se.threegirlsoneflop.springdatajpa.status.Status;

import java.util.Collection;

public interface WorkItemRepository extends JpaRepository<WorkItem, Long> {

    Collection<WorkItem> findWorkItemsWithIssue();

    Collection<WorkItem> findWorkItemsByStatus(Status status);

    Collection<WorkItem> findWorkItemsByUser(User user);

    Collection<WorkItem> getByDescriptionLike(String description);

}
