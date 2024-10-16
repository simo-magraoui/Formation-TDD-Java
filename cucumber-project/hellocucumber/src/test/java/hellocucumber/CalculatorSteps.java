package hellocucumber;

import io.cucumber.java.en.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorSteps {
    private Calculator calculator;
    private int result;


    @Given("I have a calculator")
    public void i_have_a_calculator() {
        calculator = new Calculator();
    }

    @When("I substract {int} and {int}")
    public void i_substract_and(int a, int b) {
        result = calculator.subtract(a, b);
    }

    @When("I add {int} and {int}")
    public void i_add_and(int a, int b) {
        result = calculator.add(a, b);
    }

    @When("I multiply {int} and {int}")
    public void i_multiply_and(int a, int b) {
        result = calculator.multiply(a, b);
    }

    @When("I divide {int} and {int}")
    public void i_divide_and(int a, int b) {
        result = calculator.divide(a, b);
    }

    @Then("the result should be {int}")
    public void the_result_should_be(int expected) {
        assertEquals(expected, result);
    }

}

class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
    public int subtract(int a, int b) {
        return a - b;
    }
    public int multiply(int a, int b) {
        return a * b;
    }
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Divide by zero");
        }
        return a / b;
    }
}