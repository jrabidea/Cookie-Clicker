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

    //Menu;
    String menuButton = "//*[@id='prefsButton']";
    String exportButton = "/html/body/div/div[2]/div[14]/div[4]/div[3]/div[3]/a[1]";
    String importButton = "/html/body/div/div[2]/div[14]/div[4]/div[3]/div[3]/a[2]";
    String exportTextArea = "textareaPrompt";
    String allDoneButton = "promptOption0";

}
