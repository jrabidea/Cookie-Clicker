import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by jrAb on 10/24/14.
 */
public class CookieClickerAddresses {

    WebDriver driver = new FirefoxDriver();
    String baseURL  = "http://orteil.dashnet.org/cookieclicker/";

    //Left column addresses

    String cookieLocation = "bigCookie";
    String cookieCounterLocation = "cookies";
    String bakeryName = "bakeryName";
    String buttonRandom = "promptOption1";
   

    //Products
    String productOne = "product0";
    String productTwo = "product1";
    String productThree = "product2";
    String productFour = "product3";
    String productFive = "product4";
    String productSix = "product5";
    String productSeven = "product6";
    String productEight = "product7";
    String productNine = "product8";
    String productTen = "product9";
    String productEleven = "product10";
    String productOneOwned = "productOwned0";
    String productTwoOwned = "productOwned1";
    String productThreeOwned = "productOwned2";
    String productFourOwned = "productOwned3";
    String productFiveOwned = "productOwned4";
    String productSixOwned = "productOwned5";
    String productSevenOwned = "productOwned6";
    String productEightOwned = "productOwned7";
    String productNineOwned = "productOwned8";
    String productTenOwned = "productOwned9";
    String productElevenOwned = "productOwned10";


    //Menu;
    String menuButton = "//*[@id='prefsButton']";
    String exportButton = "/html/body/div/div[2]/div[14]/div[4]/div[3]/div[3]/a[1]";
    String importButton = "/html/body/div/div[2]/div[14]/div[4]/div[3]/div[3]/a[2]";
    String textArea = "textareaPrompt";
    String allDoneButton = "promptOption0";
    String loadButton = "/html/body/div/div[2]/div[8]/div/div[1]/div[3]/a[1]";

    //Achievements
    String closeNotification = "framed close sidenote";
    String changeBakeryNameAchievement = "//div[@id='menu']/div[5]/div[4]/div[127]";
    String achievementClose = "//div[contains(@class, 'note')]/div[contains(@class, close')]";
    

    //Stats
    String achievementsUnlocked = "//div[@id='menu']/div[5]/div[2]/b";
    String statsButton = "statsButton";

}
