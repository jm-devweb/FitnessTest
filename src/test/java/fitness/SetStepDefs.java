package fitness;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;

public class SetStepDefs {
    private String input;
    private String result;
    private Set set ;

    //  Check list of set
    @Given("^the list of type set(.*)$")
    public void theListOfTypeSet(String input) {
        this.input = input;
    }

    @When("^the list in the class is$")
    public void theListInTheClass() {
        StringBuilder listOfTypeInString = new StringBuilder();
        Set set = new Set();
        String[] listOfTypeSet = set.theListOfTypeSet();
        for(int i = 0 ; i < listOfTypeSet.length ; i++) {
            listOfTypeInString.append(listOfTypeSet[i]) ;
        }
        result = listOfTypeInString.toString();
    }

    @Then("^Check the list (.*)$")
    public void checkTheList(String expectedOutput) {
        Assertions.assertThat(this.result).isEqualTo(expectedOutput);
    }

    // New set
    @Given("^Create a new set(.*)$")
    public void createNewSet(String input) {
        String[] tmp = input.split(";");
        this.set = new Set(tmp[0].trim(),Integer.parseInt(tmp[1]),Float.parseFloat(tmp[2]));
    }

    // Check type
    @When("^Get type$")
    public void getType() {
        result = set.getType();
    }

    @Then("^Check the type (.*)$")
    public void checkTheSet(String expectedOutput) {
        Assertions.assertThat(this.result).isEqualTo(expectedOutput);
    }

    // Check repetition
    @When("^Get repetition$")
    public void getRepetition() {
        result = Integer.toString(set.getRepetition());
    }

    @Then("^Check the repetition (.*)$")
    public void checkTheRepetition(String expectedOutput) {
        Assertions.assertThat(this.result).isEqualTo(expectedOutput);
    }

    // Check weight
    @When("^Get weight$")
    public void getWeight() {
        result = Float.toString(set.getWeight());
    }

    @Then("^Check the weight (.*)$")
    public void checkTheWeight(String expectedOutput) {
        Assertions.assertThat(this.result).isEqualTo(expectedOutput);
    }
}
