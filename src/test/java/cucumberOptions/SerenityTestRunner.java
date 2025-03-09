package cucumberOptions;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features="src/test/resources/features",
		glue="stepDefinitions",
		monochrome=true,
		tags="",
		plugin={"utilities.MyCustomListener",
				"pretty"}
		
		)
public class SerenityTestRunner {

}
