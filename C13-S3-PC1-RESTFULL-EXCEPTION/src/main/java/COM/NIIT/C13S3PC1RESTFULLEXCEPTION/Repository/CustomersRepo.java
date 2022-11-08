package COM.NIIT.C13S3PC1RESTFULLEXCEPTION.Repository;

import COM.NIIT.C13S3PC1RESTFULLEXCEPTION.Domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomersRepo extends MongoRepository<Customer ,Integer> {
    @Query("{'product.name':{$in:[?0]}}")
    public List<Customer> findAllCustomerFromName(String name);
}
