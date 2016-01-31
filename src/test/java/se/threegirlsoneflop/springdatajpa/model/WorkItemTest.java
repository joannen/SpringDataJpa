package se.threegirlsoneflop.springdatajpa.model;

import org.junit.Before;
import org.junit.Test;
import se.threegirlsoneflop.springdatajpa.status.Status;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by TheYellowBelliedMarmot on 2016-01-31.
 */
public class WorkItemTest {

    private WorkItem itemOne;
    private WorkItem itemTwo;

    @Before
    public void setup(){
        itemOne = new WorkItem("First item");
        itemTwo = new WorkItem("First item");
    }

    @Test
    public void workItemWithSameParametersShouldBeEqual(){
        assertEquals(itemOne, itemTwo);
    }

    @Test
    public void equalsWorkItemsShouldProduceTheSameHashCode(){
        assertThat(itemOne.hashCode(), equalTo(itemTwo.hashCode()));
    }

    @Test
    public void workItemShouldHaveStatusUnstartedBuDefault(){
        assertThat(itemOne.getStatus(), equalTo(Status.Unstarted));
    }
}
