package ar.steps;

import ar.validator.ProjectValidator;
import com.crowdar.api.rest.APIManager;
import com.crowdar.core.PageSteps;
import com.crowdar.core.PropertyManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import services.BaseService;
import services.ProjectService;

public class ProjectSteps extends PageSteps {
    ProjectValidator validator = new ProjectValidator();

    @Given("Un api-key valido")
    public void unApiKeyValido() {
        BaseService.API_KEY.set(PropertyManager.getProperty("api-key"));
    }

    @And("un workspace-id")
    public void unWorkspaceId() {
        BaseService.W_SPACE.set(PropertyManager.getProperty("w-space"));
    }

    @Then("se muestran los project del perfil")
    public void seMuestranLosProjectDelPerfil() {
        validator.printProject();
    }

    @And("un workspace-id '(.*)'")
    public void unWorkspaceId(String w_space_id) {
        BaseService.W_SPACE.set(w_space_id);
    }

    @Then("se obtuvo una respuesta vacía")
    public void seObtuvoUnaRespuestaVacía() {
        validator.validateResponseNull();
    }

    @And("se valida que el project '(.*)' fue creado")
    public void seValidaQueElProjectNameFueCreado(String name) {
        validator.validateNombre(name);
    }
}
