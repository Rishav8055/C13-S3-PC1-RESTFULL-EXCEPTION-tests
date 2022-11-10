package COM.NIIT.C13S3PC1RESTFULLEXCEPTION.Service;

import COM.NIIT.C13S3PC1RESTFULLEXCEPTION.Domain.Customer;
import COM.NIIT.C13S3PC1RESTFULLEXCEPTION.Domain.Product;
import COM.NIIT.C13S3PC1RESTFULLEXCEPTION.Exception.CustomerAlreadyExists;
import COM.NIIT.C13S3PC1RESTFULLEXCEPTION.Exception.CustomerNotFoundException;
import COM.NIIT.C13S3PC1RESTFULLEXCEPTION.Repository.CustomersRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplTests {
    @Mock
    private CustomersRepo customersRepo;

    @InjectMocks
    private CustomerServiceImpl customerService;

    private Customer customer1,customer2;
    List<Customer> customerList;
    Product product1,product2;

    @BeforeEach
    void setUp(){
        product1=new Product(1,"Nokia","SmartPhone");
        customer1=new Customer(1,"Rishav","235436565757",product1);
        product2=new Product(2,"realme","5G");
        customer2=new Customer(2,"priyanka","674646345",product2);
        customerList= Arrays.asList(customer1,customer2);
    }
    @AfterEach
    void tearDown(){
        customer1=null;
        customer2=null;
    }
    @Test
    public void givenCustomerToSaveReturnSavedCustomerSuccess() throws CustomerAlreadyExists {
        when(customersRepo.findById(customer1.getId())).thenReturn(Optional.ofNullable(null));
        when(customersRepo.save(any())).thenReturn(customer1);
        assertEquals(customer1,customerService.saveCustomer(customer1));
        verify(customersRepo,times(1)).save(any());
        verify(customersRepo,times(1)).findById(any());

    }
    @Test
    public void givenCustomerToSaveReturnCustomerFailure(){
        when(customersRepo.findById(customer1.getId())).thenReturn(Optional.ofNullable(customer1));
        assertThrows(CustomerAlreadyExists.class,()->customerService.saveCustomer(customer1));
        verify(customersRepo,times(0)).save(any());
        verify(customersRepo,times(1)).findById(any());
    }
    @Test
    public void givenCustomerToDeleteShouldDeleteSuccess() throws Exception {
        when(customersRepo.findById(customer1.getId())).thenReturn(Optional.ofNullable(customer1));
        boolean flag = customerService.deleteCustomer(customer1.getId());
        assertTrue(true, String.valueOf(flag));

        verify(customersRepo,times(1)).deleteById(any());
        verify(customersRepo,times(1)).findById(any());
    }



}
