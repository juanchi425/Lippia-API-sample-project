package ar.validator;

import com.crowdar.api.rest.APIManager;
import org.testng.Assert;

public class BaseValidator {
    public void validateResponseNull(){
        Object actualJsonResponse = APIManager.getLastResponse().getResponse();
        Assert.assertNull(actualJsonResponse, "La reponse es distitna de null");
    }
}
