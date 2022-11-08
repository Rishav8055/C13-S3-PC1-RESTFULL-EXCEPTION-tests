package COM.NIIT.C13S3PC1RESTFULLEXCEPTION.Service;

import COM.NIIT.C13S3PC1RESTFULLEXCEPTION.Domain.Customer;
import COM.NIIT.C13S3PC1RESTFULLEXCEPTION.Exception.CustomerNotFoundException;
import COM.NIIT.C13S3PC1RESTFULLEXCEPTION.Repository.CustomersRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService{
    CustomersRepo customersRepo;

    public CustomerServiceImpl(CustomersRepo customersRepo) {
        this.customersRepo = customersRepo;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customersRepo.save(customer);
    }

    @Override
    public List<Customer> getAllCustomerData() throws Exception {
        return customersRepo.findAll();
    }

    @Override
    public boolean deleteCustomer(int id) throws Exception {
        boolean result = false;
        if (customersRepo.findById(id).isEmpty()){
            throw new CustomerNotFoundException();

        }
        else {
            customersRepo.deleteById(id);
            result= true;
        }
        return result;
    }

    @Override
    public List<Customer> getCustomerByName(String name) throws CustomerNotFoundException {
        if (customersRepo.findAllCustomerFromName(name).isEmpty()){
            throw new CustomerNotFoundException();
        }
        return customersRepo.findAllCustomerFromName(name);
    }
}
