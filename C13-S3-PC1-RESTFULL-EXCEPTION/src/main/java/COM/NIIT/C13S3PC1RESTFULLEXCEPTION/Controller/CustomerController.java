package COM.NIIT.C13S3PC1RESTFULLEXCEPTION.Controller;

import COM.NIIT.C13S3PC1RESTFULLEXCEPTION.Domain.Customer;
import COM.NIIT.C13S3PC1RESTFULLEXCEPTION.Exception.CustomerAlreadyExists;
import COM.NIIT.C13S3PC1RESTFULLEXCEPTION.Exception.CustomerNotFoundException;
import COM.NIIT.C13S3PC1RESTFULLEXCEPTION.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/custdata/api")
public class CustomerController {
     CustomerService customerService;
@Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @PostMapping("/post")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer) throws CustomerAlreadyExists {
    ResponseEntity responseEntity=null;
    try {
        customerService.saveCustomer(customer);
        responseEntity = new ResponseEntity(customer, HttpStatus.CREATED);
    } catch (CustomerAlreadyExists e) {
        throw new CustomerAlreadyExists();
    }catch (Exception e){
        responseEntity=new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);

    }


        return responseEntity;
    }
    @GetMapping("/get")
    public ResponseEntity<?> getAllData(){
    ResponseEntity responseEntity =null;
    try {
        responseEntity = new ResponseEntity<>(customerService.getAllCustomerData(),HttpStatus.OK);
    } catch (Exception e) {
        responseEntity = new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return responseEntity;
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") int id) throws Exception{
    ResponseEntity responseEntity= null;
    try {
        customerService.deleteCustomer(id);
        responseEntity=new ResponseEntity<>("successfully delete the 1 record",HttpStatus.OK);


    } catch (CustomerNotFoundException e){
        throw new CustomerNotFoundException();
    }  catch (Exception e) {
        responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
        return responseEntity;
    }

}
