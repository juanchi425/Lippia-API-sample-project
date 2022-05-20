package ar.validator;

import api.model.Project.ProjectResponse;
import com.crowdar.api.rest.APIManager;
import org.testng.Assert;

public class ProjectValidator extends BaseValidator{
    public void printProject(){
        ProjectResponse[] responses = (ProjectResponse[]) APIManager.getLastResponse().getResponse();
        for (ProjectResponse project :responses) {
            System.out.print(project.getName());
        }
    }

    public void validateNombre(String name){
        ProjectResponse response = (ProjectResponse) APIManager.getLastResponse().getResponse();
        Assert.assertEquals(name,response.getName(),"El proyecto no tiene el nombre esperado");
    }
}
