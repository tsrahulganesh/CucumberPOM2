package Stepdef;

import Pages.Darksky;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;
import org.junit.Assert;
import org.testng.reporters.jq.ResultsByClass;

import java.util.ArrayList;
import java.util.Collections;

import static Stepdef.sharedsd.getDriver;


public class darkskysd {
    Darksky darksky = new Darksky();

    @Given("^I am on Darksky   Home page$")
    public void i_am_on_darksky_home_page() throws Throwable {

        Assert.assertEquals("This is not the darksky home page",
                "Dark Sky - Sansad Marg, New Delhi, Delhi",
                getDriver().getTitle()

        );
    }


    @Then("^I verify current temp is equal to Temperature from Daily Timeline$")
    public void i_verify_current_temp_is_equal_to_temperature_from_daily_timeline()
    {
        String expected = darksky.getCurrentTemp();
        String actual = darksky.getTimelineTemp();
        System.out.println("Expected  =" + expected);
        System.out.println("Actual=" + actual);
        Assert.assertEquals("different temp", expected, actual);
    }


    //org.junit.ComparisonFailure: different temp
    //Expected :62
    //Actual   :61


    @Then("I verify timeline is displayed with two hours incremented")
    public void iVerifyTimelineIsDisplayedWithTwoHoursIncremented() {

        ArrayList<Integer> timeList = darksky.getTempListInt();
        System.out.println(timeList);


        ArrayList<Integer> timeDiffList = new ArrayList<>();
        for(int i =0;i<timeList.size()-1;i++) // 11
        {
            int time1 = timeList.get(i);
            int time2 = timeList.get(i+1);
            int timeDiff = 0;

            if(time2>time1)
                timeDiff = time2-time1;
            if(time2<time1)
                timeDiff = (time2 + 12)-time1;

            timeDiffList.add(timeDiff);
        }
        System.out.println(timeDiffList);


        int size = timeDiffList.size();

        int occurance = Collections.frequency(timeDiffList,2);

        boolean result = (size == occurance);

        Assert.assertTrue("all the differences are not 2",result);

    }
    // [4pm, 6pm, 8pm, 10pm, 12am, 2am, 4am, 6am, 8am, 10am, 12pm]
//[4, 6, 8, 10, 12, 2, 4, 6, 8, 10, 12]
//[2, 2, 2, 2, 2, 2, 2, 2, 2, 2]   -----> passed
    @Then("I verify today's lowest and highest temp is displayed correctly")
    public void iVerifyTodaySLowestAndHighestTempIsDisplayedCorrectly() {
        darksky.clickExpander();

        ArrayList<String> expected = darksky.getBarTempList();
        ArrayList<String> actual = darksky.getTimelineTempList();

        System.out.println(expected);
        System.out.println(actual);

        Assert.assertEquals(expected,actual);

    }
    //Results
    //[41, 63] -----> passed



    @Given("I am on Darksky Home Page")
    public void iAmOnDarkskyHomePage() {
    }
}




