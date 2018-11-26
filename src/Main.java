package PACKAGE_NAME;

import DB.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    //private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

//            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static final EntityManagerFactory ourEntityManagerFactory;
    static {
        ourEntityManagerFactory = Persistence
                .createEntityManagerFactory("config");
    }
    public static EntityManager getEntityManager() {
        return ourEntityManagerFactory.createEntityManager();
    }


//    public static Session getSession() throws HibernateException {
//        return ourSessionFactory.openSession();
//    }


    public static void main(final String[] args) throws Exception {
        //final Session session = getSession();
        final EntityManager em = getEntityManager();
        try {
            EntityTransaction etx = em.getTransaction();
            etx.begin();

            List<Product> products = em.createQuery("from Product ").getResultList();
            System.out.println("Please enter a product, which you want to order:\n0. Exit");
            IntStream.range(1, products.size()).forEach(i -> {
                System.out.println(i + ". " + products.get(i - 1).getName());
            });

            int choice = -1;
            List<Product> orderedProducts = new ArrayList<>();
            Scanner scanner = new Scanner(System.in);

            while (choice != 0){
                choice = scanner.nextInt();
                if (choice != 0)
                orderedProducts.add(products.get(choice - 1));
            }

            System.out.println("Enter your street");
            String street = scanner.nextLine();

            System.out.println("Enter your city");
            String city = scanner.nextLine();

            System.out.println("Enter your zip code");
            String zipCode = scanner.nextLine();

            System.out.println("Thank you for your order. See you later.");

            List<Order> orders= em.createQuery("from Order ").getResultList();
            int orderId = orders.isEmpty() ? 0 : orders.get(orders.size() - 1).getId() + 1;

            List<Customer> customers = em.createQuery("from Customer").getResultList();
            int customerId = customers.isEmpty() ? 0 : customers.get(customers.size() - 1)
                    .getId() + 1;

            Order order = new Order("Order" + orderId,
                    new Customer("Customer" + customerId, street,
                            city, zipCode, 0.0),
                    products,
                    new Dates(new Date()));
            em.persist(order);
//            Company company1 = new Customer("Customer_Table_Per_Class",
//                    "Nawojki", "Warszawa", "19-999", 0.15);
//            Company company2 = new Supplier("Supplier_Table_Per_Class",
//                    "LongStreet.", "Londyn",
//                    "221441", "1234554321");
//            Arrays.asList(company1, company2).forEach(em::persist);
//            Company customer = em.find(Customer.class, 141);
//            Company supplier = em.find(Supplier.class, 142);
//            System.out.println(((Customer) customer).getDiscount());
//            System.out.println(((Supplier) supplier).getBankAccountNumber());
//            companies.stream().findFirst().
//                    ifPresent(x -> System.out.println(((Customer) x).getDiscount()));
//            companies.forEach(x -> System.out.println(x.getName()));
//            System.out.println(((Customer) company1Check).getDiscount());
//            System.out.println(((Supplier) company2Check).getBankAccountNumber());
            //Supplier supplier = new Supplier("Fejsbuk", "Krakowska", "Wrocław", "19-223");
            //em.persist(supplier);
            //em.persist(addresse);
//            Product product1 = new Product("Product1", 20);
//            Product product2= new Product("Product2", 25);
//            Product product3 = new Product("Product3", 5);
//            Category category = new Category("Meal");
//            Category category1 = new Category("Pastry");
//            product1.setCategory(category);
//            product2.setCategory(category);
//            product3.setCategory(category1);
//            category.setProducts(Arrays.asList(product1, product2));
//            category1.setProducts(Collections.singletonList(product3));
            //Arrays.asList(product1, product2, product3, category, category1).forEach(em::persist);

//            Product product1 = new Product("Computer", 20);
//            Product product2= new Product("Speaker", 25);
//            Product product3 = new Product("Monitor", 5);
//            Invoice invoice1 = new Invoice();
//            Invoice invoice2 = new Invoice();
//            Invoice invoice3 = new Invoice();
//            invoice1.setProducts(new HashSet<>(Collections.singletonList(product2)));
//            invoice2.setProducts(new HashSet<>(Arrays.asList(product2, product3)));
//            invoice3.setProducts(new HashSet<>(Arrays.asList(product1, product2, product3)));
//            product1.setInvoices(new HashSet<>(Collections.singletonList(invoice3)));
//            product2.setInvoices(new HashSet<>(Arrays.asList(invoice1, invoice2, invoice3)));
//            product3.setInvoices(new HashSet<>(Arrays.asList(invoice2, invoice3)));
//            Arrays.asList(invoice1, invoice2, invoice3).forEach(em::persist);
            etx.commit();


//            em.find(Category.class, 16).getProducts()
//                    .forEach(x-> System.out.println(x.getName()));
//            System.out.println(em.find(Product.class, 15)
//                    .getCategory().getName());


//            System.out.println("Podaj nazwe:");
//            Scanner scanner = new Scanner(System.in);
//            String productName = scanner.nextLine();
//            System.out.println("Podaj stan magazynowy:");
//            int units = scanner.nextInt();
//            Transaction tx = session.beginTransaction();
//            Product product = new Product(productName, units);
//            session.save(product);
//            tx.commit();
            //Transaction tx = session.beginTransaction();
            /*Product product2 = new Product("Product10", 20);
            Product product3= new Product("Product11", 25);
            Product product4 = new Product("Product12", 5);
            session.save(product2);
            session.save(product3);
            session.save(product4);
            Supplier supplier = new Supplier("AGH", "Krakowska", "Warsaw");
            session.save(supplier);
            product2.setSupplier(supplier);
            product3.setSupplier(supplier);
            product4.setSupplier(supplier);
            supplier.addProduct(Arrays.asList(product2, product3, product4));
            Category category = new Category("Category1");
            Category category1 = new Category("Category2");
            session.save(category);
            session.save(category1);
            product4.setCategory(category);
            product2.setCategory(category1);
            product3.setCategory(category);
            category.setProducts(Arrays.asList(product4, product3));
            category1.setProducts(Collections.singletonList(product2));
            Invoice invoice1 = new Invoice(10);
            Invoice invoice2 = new Invoice(20);
            session.save(invoice1);
            session.save(invoice2);
            product4.setInvoices(new HashSet<>(Arrays.asList(invoice1, invoice2)));
            product2.setInvoices(new HashSet<>(Collections.singletonList(invoice1)));
            product3.setInvoices(new HashSet<>(Arrays.asList(invoice1, invoice2)));*/

//            Invoice invoice = session.get(Invoice.class, 18);
//            Product product = session.get(Product.class, 2);
//
//            invoice.getProducts().forEach(x -> System.out.println(x.getName()));
//            product.getInvoices().forEach(x -> System.out.println(x.getId()));

            //tx.commit();


//            System.out.println("querying all the managed entities...");
//            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
//            for (EntityType<?> entityType : metamodel.getEntities()) {
//                final String entityName = entityType.getName();
//                final Query query = session.createQuery("from " + entityName);
//                System.out.println("executing: " + query.getQueryString());
//                for (Object o : query.list()) {
//                    System.out.println("  " + o);
//                }
//            }
        } finally {
            //session.close();
            em.close();
        }
    }
}