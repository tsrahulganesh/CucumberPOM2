import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features="features",glue ="Stepdef",tags="@DistList"/*,dryRun = true
        ,plugin={"pretty","html:Target1/report.html"}*/ )

public class TestRunner {

    }


