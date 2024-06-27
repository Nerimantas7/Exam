package lt.techin.exam.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AdvertCategoryNotSet extends RuntimeException {

    public AdvertCategoryNotSet(String message){
        super(message);
    }

}

