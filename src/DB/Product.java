package DB;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int unitsOnStock;
    @ManyToOne
    @JoinColumn(name = "CATEGORY_FK")
    private Category category;

//    @ManyToOne
//    @JoinColumn(name = "SUPPLIER_FK")
//    private Supplier supplier;

    @ManyToMany(cascade = CascadeType.PERSIST)
    Set<Invoice> invoices;

    public Product(){

    }

    public Product(String name, int unitsOnStock) {
        this.name = name;
        this.unitsOnStock = unitsOnStock;
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

    public int getUnitsOnStock() {
        return unitsOnStock;
    }

    public void setUnitsOnStock(int unitsOnStock) {
        this.unitsOnStock = unitsOnStock;
    }

//    public Supplier getSupplier() {
//        return supplier;
//    }
//
//    public void setSupplier(Supplier supplier) {
//        this.supplier = supplier;
//    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(Set<Invoice> invoices) {
        this.invoices = invoices;
    }
}
