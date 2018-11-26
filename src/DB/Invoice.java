package DB;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Invoice {
    @Id
    @GeneratedValue
    private int id;
    private int quantity;
    @ManyToMany(mappedBy = "invoices", cascade = CascadeType.PERSIST)
    private Set<Product> product;

    public Invoice(){}

    public Invoice(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Set<Product> getProducts() {
        return product;
    }

    public void setProducts(Set<Product> products) {
        this.product = products;
    }
}
