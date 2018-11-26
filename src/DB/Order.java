package DB;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "MyOrder")
@SecondaryTable(name = "OrderName")
public class Order {

    @Id
    @GeneratedValue
    private int id;

    @Column(table = "OrderName", length = 100)
    private String name;

    @Transient
    private static final int MAX_PRODUCTS = 10;

    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;

    @Column(nullable = false)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ORDER_FK")
    private List<Product> products;

    @Embedded
    private Dates dates;

    public Order(){}

    public Order(String name, Customer customer, List<Product> products, Dates dates) {
        this.name = name;
        this.customer = customer;
        this.products = products;
        this.dates = dates;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getMaxProducts() {
        return MAX_PRODUCTS;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Dates getDates() {
        return dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }
}
