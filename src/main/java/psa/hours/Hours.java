package psa.hours;

import java.util.Date;
import javax.persistence.*;

@Entity
public class Hours {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer quantity;
    private final Date date;
    private final Integer responsibleResourceID;

    public Hours(Integer quantity, Date date, 
                Integer responsibleResourceID) {

        this.quantity = quantity;
        this.date = date;
        this.responsibleResourceID = responsibleResourceID;
    }

    public Hours(){
        this.date = null;
        this.responsibleResourceID = null;
    }

    public Long getID() {
        return this.id;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public Date getDate() {
        return date;
    }

    public Integer getResponsibleResourceID() {
        return this.responsibleResourceID;
    }

    /* Receive an Hours instance and returns True if the date
     * and responsible resource of the hours are the same, False otherwise
     */
    public Boolean isEqual(Hours hour) {
        return (hour.getDate() == this.getDate() &&
                hour.getResponsibleResourceID() == this.getResponsibleResourceID());
    }

    public void increaseHours(Integer quantity) {
        this.quantity += quantity;
    }

    public void setId(Long id) {
        this.id = id;
    }
}