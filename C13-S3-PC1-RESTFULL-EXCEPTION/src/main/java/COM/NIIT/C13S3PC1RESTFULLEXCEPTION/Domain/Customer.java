package COM.NIIT.C13S3PC1RESTFULLEXCEPTION.Domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Customer {
    @Id
    private int id;
    private String Name;
    private String phoneNo;
    private Product product;

    public Customer(int id, String name, String phoneNo, Product product) {
        this.id = id;
        Name = name;
        this.phoneNo = phoneNo;
        this.product = product;
    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", product=" + product +
                '}';
    }
}
