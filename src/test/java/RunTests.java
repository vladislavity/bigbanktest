import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(
        features = "src/test/java/features",
        plugin = {"pretty", "html:target/cucumber.html"},
        glue = {"testdefs"}
)
@RunWith(Cucumber.class)
public class RunTests {
}