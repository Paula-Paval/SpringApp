package app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="rent")
public class Rent {
    @Id
    private Integer id;

    private Integer itemId;
    private Integer clientId;
    private Date renteddate;
    private Date returneddate;



    public Rent() {
    }

    public Rent(Integer itemId, Integer clientId, Date renteddate, Date returneddate) {
        this.itemId = itemId;
        this.clientId = clientId;
        this.renteddate = renteddate;
        this.returneddate = returneddate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Date getRenteddate() {
        return renteddate;
    }

    public void setRenteddate(Date renteddate) {
        this.renteddate = renteddate;
    }

    public Date getReturneddate() {
        return returneddate;
    }

    public void setReturneddate(Date returneddate) {
        this.returneddate = returneddate;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rent rent = (Rent) o;
        return Objects.equals(id, rent.id) && Objects.equals(itemId, rent.itemId) && Objects.equals(clientId, rent.clientId) && Objects.equals(renteddate, rent.renteddate) && Objects.equals(returneddate, rent.returneddate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, itemId, clientId, renteddate, returneddate);
    }

    @Override
    public String toString() {
        return "Rent{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", clientId=" + clientId +
                ", renteddate=" + renteddate +
                ", returneddate=" + returneddate +
                '}';
    }
}
