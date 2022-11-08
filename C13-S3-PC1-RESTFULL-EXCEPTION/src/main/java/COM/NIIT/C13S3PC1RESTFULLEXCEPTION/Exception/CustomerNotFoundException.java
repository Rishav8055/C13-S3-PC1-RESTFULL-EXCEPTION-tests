package COM.NIIT.C13S3PC1RESTFULLEXCEPTION.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


    @ResponseStatus
            (code= HttpStatus.NOT_FOUND,reason="customer id is not found which is given by you")
    public class CustomerNotFoundException extends Exception{

    }


