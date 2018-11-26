package DB;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Date;

@Embeddable
public class Dates {
    @Column(name = "Date_of_order", nullable = false, updatable = false)
    private Date orderDate;
    @Column(name = "Date_of_shipment")
    private Date shipmentDate;

    public Dates(){}

    public Dates(Date orderDate) {
        this.orderDate = orderDate;
    }
}
