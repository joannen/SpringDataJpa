package se.threegirlsoneflop.springdatajpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import se.threegirlsoneflop.springdatajpa.model.WorkItem;

import java.util.Collection;

public interface WorkItemRepository extends JpaRepository<WorkItem, Long> {

    Collection<WorkItem> findWorkItemsWithIssue();

    Collection<WorkItem> findWorkItemsByStatus();




}
