package fitness;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;
import java.nio.file.Path;

public class DataSetStepDefs {
    private String input;
    private String result;
    private Set set ;
    private DataSet dataset ;

    // New set
    @Given("^Create a new Dataset(.*)$")
    public void createNewDataSet(String input) {
        Path filePath = Path.of("C:\\Users\\a194679\\Ubuntu\\code\\FitnessTest\\src\\test\\resources\\file_empty.csv");
        DataSet datasetWrite ;
        String[] tmp = input.split(";");
        this.set = new Set(tmp[0].trim(),Integer.parseInt(tmp[1]),Float.parseFloat(tmp[2]));
        datasetWrite = new DataSet(filePath);
        datasetWrite.add(this.set);
    }

    @When("^Get size$")
    public void getSize() {
        Path filePath = Path.of("C:\\Users\\a194679\\Ubuntu\\code\\FitnessTest\\src\\test\\resources\\file_empty.csv");
        DataSet datasetRead ;
        datasetRead = new DataSet(filePath);
        result =  String.valueOf(datasetRead.size());
    }

    @Then("^Check the size (.*)$")
    public void checkTheSize(String expectedOutput) {
        Assertions.assertThat(this.result).isEqualTo(expectedOutput);
    }

    // Stat One
    @Given("^Set exercise(.*)$")
    public void setExericse(String input) {
        Path filePath = Path.of("/home/bnp-renault-011/IdeaProjects/FitnessTest/src/test/resources/exemple.csv");
        dataset = new DataSet(filePath);
        this.input = input ;
    }

    @When("^Calculate state one$")
    public void getStatOne() {
        result =  dataset.statOne(this.input);
    }

    @Then("^Check state one (.*)$")
    public void checkStatOne(String expectedOutput) {
        Assertions.assertThat(this.result).isEqualTo(expectedOutput);
    }

    @When("^Calculate state two$")
    public void getStatTwo() {
        result =  dataset.statTwo (this.input);
    }

    @Then("^Check state two (.*)$")
    public void checkStatTwo(String expectedOutput) {
        Assertions.assertThat(this.result).isEqualTo(expectedOutput);
    }

    @When("^Calculate state three$")
    public void getStatThree() {
        result =  dataset.statThree (this.input);
    }

    @Then("^Check state three (.*)$")
    public void checkStatThree(String expectedOutput) {
        Assertions.assertThat(this.result).isEqualTo(expectedOutput);
    }

}
