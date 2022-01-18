package Pages;

import org.openqa.selenium.By;

import java.util.ArrayList;

import static Stepdef.sharedsd.getDriver;

public class Hotelsearch extends Basepage {

    By starBlocks = By.xpath("//div[@data-testid='rating-stars']");
    By allStarsOnPage = By.xpath("//div[@data-testid='rating-stars']/span");
    By hotellist = By.xpath("//div[@data-testid='title']");
    static By distTextList = By.xpath("//section[@class='_2jyzVa']//li[1]");
    public static ArrayList<Integer> getdistanceList()
    {
         ArrayList<String> rawdistance = getElementTextList(distTextList);
        //13km to city center
        ArrayList<Integer> distList = new ArrayList<>();
        for(int i=0;i<rawdistance.size();i++)
        {
            String distStr = rawdistance.get(i).split(" ")[0];
            distList.add((int) Double.parseDouble(distStr));
        }

        return distList;
    }


    public ArrayList<String> gethotelList()
{
    return getElementTextList(hotellist);
}


    public void clickStarRating(String star)//3, 4, 5
    {
        //@FindBy(xpath = "//div[contains(text(),'2 stars')]") WebElement element;// Start rating box element
        //@FindBy(xpath = "//div[@data-filters-group='class']") WebElement element// particuar select star
        By StarRating =
        (By.xpath("//div[@data-filters-group='class']//div[contains(text(),'"+star+" stars')]"));
        webAction(StarRating).click();
    }

    public int countRealStarRatingonsearchpage()
    {
        int countStarBlocks = getDriver().findElements(starBlocks).size();
        int countAllStars = getDriver().findElements(allStarsOnPage).size();

        return (countAllStars/countStarBlocks);
    }
}
//Result -->INFO: Found CDP implementation for version 97 of 96
        //expected=4
        //actual=4

/*Result
Expected hotel=The Musafir Hostel
FabHotel Prime Sarala Crown Calangute Beach - Fully Vaccinated Staff
The Foothills - A Boutique Hotel
Siolim Holiday Apartments
De Aluizio
De Amour - A Dreamy Getaway
 */

/*
INFO: Found CDP implementation for version 97 of 96
[1, 0, 13, 1, 1, 6, 13, 14]
 */