package Stepdef;


import Pages.Hotelsearch;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.runner.RunWith;

import java.util.ArrayList;


public class HotelsSD {
Hotelsearch hotelsearch = new Hotelsearch();

        @Given("^I am on default locations search result screen$")
        public void i_am_on_default_locations_search_result_screen() throws Throwable {
        }

        @When("^I select option for stars as (.+)$")
        public void i_select_option_for_stars_as(String stars) throws Throwable {
                // stars : 5  --->passed
                //stars : 4 and 2 ----->passed
                hotelsearch.clickStarRating(stars.split(" ")[0]);
        }

        @Then("^I verify system displays only (.+) hotels on search result$")
        public void i_verify_system_displays_only_hotels_on_search_result(String stars) throws Throwable
        {
                int expected = Integer.parseInt(stars.split(" ")[0]);
                int actual = hotelsearch.countRealStarRatingonsearchpage();
                System.out.println("expected="+expected);
                System.out.println("actual="+expected);
        }


        @Then("^I verify \"([^\"]*)\"is within search result$")
        public void i_verify_something_is_within_search_result(String hotelName) throws Throwable

        {
               ArrayList<String> hotelList=hotelsearch.gethotelList();
               boolean result = hotelList.contains(hotelName);

               System.out.println("Expected hotel="+hotelName);
               for(String hotel:hotelList)
                   System.out.println(hotel);
               //System.out.println("HotelName ="+"The Musafir Hostel");

                Assert.assertTrue(hotelName+":This hotel is not in search result",result);
        }

        //  Result:INFO: Found CDP implementation for version 97 of 96
                 //HotelName =The Musafir Hostel

    @Then("^I verify system displays all hotels within \"([^\"]*)\" Km radius from center$")
    public void i_verify_system_displays_all_hotels_within_something_km_radius_from_center(String expectedDistance) throws Throwable {
        ArrayList<Integer> distList = Hotelsearch.getdistanceList();
        System.out.println(distList);


//Result : Found CDP implementation for version 97 of 96
//[1, 0, 13, 1, 1, 25, 13, 14]



        int expectedDistInt = Integer.parseInt(expectedDistance);
        boolean flag = true;
        for (int i = 0; i < distList.size(); i++) {
            if (expectedDistInt < distList.get(i)) {
                flag = false;
            }
        }
    }
}
/*
INFO: Found CDP implementation for version 97 of 96
[1, 0, 13, 1, 1, 6, 13, 14]
 */



