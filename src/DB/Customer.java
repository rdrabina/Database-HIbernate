package DB;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer extends Company {
    @Id
    @GeneratedValue
    private int id;
    private double discount;

    public Customer(){}

    public Customer(String name, String street, String city, String zipCode, double discount) {
        super(name, street, city, zipCode);
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
