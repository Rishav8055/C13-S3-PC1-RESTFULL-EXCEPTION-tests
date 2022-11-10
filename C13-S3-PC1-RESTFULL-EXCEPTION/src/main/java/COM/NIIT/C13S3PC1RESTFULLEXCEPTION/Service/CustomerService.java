package COM.NIIT.C13S3PC1RESTFULLEXCEPTION.Service;

import COM.NIIT.C13S3PC1RESTFULLEXCEPTION.Domain.Customer;
import COM.NIIT.C13S3PC1RESTFULLEXCEPTION.Exception.CustomerAlreadyExists;
import COM.NIIT.C13S3PC1RESTFULLEXCEPTION.Exception.CustomerNotFoundException;

import java.util.List;

public interface CustomerService {
    Customer saveCustomer(Customer customer) throws CustomerAlreadyExists;
    List<Customer> getAllCustomerData() throws Exception;
    boolean deleteCustomer(int id) throws Exception;
    List<Customer> getCustomerByName(String name) throws CustomerNotFoundException;

}
