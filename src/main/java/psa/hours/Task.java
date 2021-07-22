package psa.hours;

import java.util.HashMap;
import java.util.Date;
import psa.hours.Hours;

public class Task {
    private final Integer taskID;
    private String description;
    private HashMap<Long, Hours> hours = new HashMap<>();

    public Task(Integer taskID, String description) {
        this.taskID = taskID;
        this.description = description;
    }

    /* Returns the ID of the Task. */
    public Integer getID() {
        return this.taskID;
    }

    /* Returns true if the requested Hours were added to the task,
     * false otherwise.
     */
    public Boolean addHours(Integer quantity, Date date, Integer responsible) {
        Hours hour = new Hours(quantity, date, responsible);
        
        for (HashMap.Entry<Long, Hours> entry : this.hours.entrySet()) {
            if (entry.getValue().isEqual(hour)) {
                entry.getValue().increaseHours(quantity);
                return true;
            }
        }
        
        this.hours.put(hour.getID(), hour);
        return true;
    }

    /* Returns true if the Hours were removed from the task, 
     * false if the hoursID is not existant in the task.
     */
    public Boolean removeHours(Long hoursID) {
        if (!this.hours.containsKey(hoursID)) {
            return false;
        }

        this.hours.remove(hoursID);
        return true;
    }
}