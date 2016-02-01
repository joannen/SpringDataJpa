package se.threegirlsoneflop.springdatajpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import se.threegirlsoneflop.springdatajpa.model.User;
import se.threegirlsoneflop.springdatajpa.model.WorkItem;

import java.util.Collection;

interface WorkItemRepository extends JpaRepository<WorkItem, Long> {

    Collection<WorkItem> findWorkItemsWithIssue();

    Collection<WorkItem> findWorkItemsByStatus(String status);

    Collection<WorkItem> findWorkItemsByUser(User user);

    Collection<WorkItem> getByDescriptionLike(String description);

}
