package DB;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
//@SecondaryTable(name="ADDRESS_TBL")
public class Supplier extends Company{
    @Id
    @GeneratedValue
    private int id;

    private String bankAccountNumber;

    public Supplier(){

    }

    public Supplier(String companyName, String street, String city, String zipCode, String bankAccountNumber) {
        super(companyName, street, city, zipCode);
        //products = new HashSet<>();
        this.bankAccountNumber = bankAccountNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


//    @Column(table = "ADDRESS_TBL")
//    private String CompanyName;
//    @Column(table = "ADDRESS_TBL")
//    private String Street;
//    @Column(table = "ADDRESS_TBL")
//    private String City;
//    @Column(table = "ADDRESS_TBL")
//    private String ZipCode;
    //    @OneToMany(mappedBy = "supplier")
//    private Set<Product> products;

//    @Embedded
//    private Addresse addresse;

//    public String getCompanyName() {
//        return CompanyName;
//    }
//
//    public void setCompanyName(String companyName) {
//        CompanyName = companyName;
//    }
//
//    public String getStreet() {
//        return Street;
//    }
//
//    public void setStreet(String street) {
//        Street = street;
//    }
//
//    public String getCity() {
//        return City;
//    }
//
//    public void setCity(String city) {
//        City = city;
//    }

//    public void addProduct(List<Product> productsList) {
//        products.addAll(productsList);
//    }

//    public Addresse getAddresse() {
//        return addresse;
//    }
//
//    public void setAddresse(Addresse addresse) {
//        this.addresse = addresse;
//    }

//    public Set<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(Set<Product> products) {
//        this.products = products;
//    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }
}
