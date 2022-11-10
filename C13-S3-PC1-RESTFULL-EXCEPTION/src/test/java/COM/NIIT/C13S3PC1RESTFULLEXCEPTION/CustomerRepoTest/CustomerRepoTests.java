package COM.NIIT.C13S3PC1RESTFULLEXCEPTION.CustomerRepoTest;

import COM.NIIT.C13S3PC1RESTFULLEXCEPTION.Domain.Customer;
import COM.NIIT.C13S3PC1RESTFULLEXCEPTION.Domain.Product;
import COM.NIIT.C13S3PC1RESTFULLEXCEPTION.Repository.CustomersRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class CustomerRepoTests {
    @Autowired
    private CustomersRepo customersRepo;
    private Product product;
    private Customer customer;

    @BeforeEach
    void setUp() {
        product = new Product(1, "samsung", "mobliePhn");
        customer = new Customer(1, "rishav", "11345677886", product);

    }
//
////        @AfterEach
////        void tearDown(){
////        product=null;
////        customer=null;
////        customersRepo.deleteAll();
////    }
    @Test
    @DisplayName("Test case for saving customer object")
    void givenCustomerToSaveShouldReturnSavedCustomer() {
        customersRepo.save(customer);
        Customer customer1 = customersRepo.findById(customer.getId()).get();
        assertNotNull(customer1);
        assertEquals(customer.getId(), customer1.getId());
    }
//
    @Test
    @DisplayName("Test case for delete customer objects")
    public void givenCustomerToDeleteShouldDeleteCustomer() {
     //   customersRepo.insert(customer);
        Customer customer1 = customersRepo.findById(customer.getId()).get();
        customersRepo.delete(customer1);
        assertEquals(Optional.empty(), customersRepo.findById(customer.getId()));

    }

    @Test
    @DisplayName("Test case for fetching all customer objects")
    public void givenCustomerReturnAllCustomerDetails(){

//        Product product1=new Product(2,"Nokia","smartPhn");
//        Customer customer1=new Customer(2,"kunal","4645754754",product);
//        customersRepo.insert(customer1);

        List<Customer> list=customersRepo.findAll();
        assertEquals(2,list.size());
        assertEquals("kunal",list.get(0).getName());
    }
}