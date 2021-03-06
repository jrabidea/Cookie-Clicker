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
    String cookieGolden = "goldenCookie";
    String leftPane = "backgroundLeftCanvas";
    String reindeerPopup = "seasonPopup";
   

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
    String sellOneGrandma = "//*[@id='buttonSell-1']";


    //Menu;
    String menuButton = "//*[@id='prefsButton']";
    String exportButton = "/html/body/div/div[2]/div[14]/div[4]/div[3]/div[3]/a[1]";
    String importButton = "/html/body/div/div[2]/div[14]/div[4]/div[3]/div[3]/a[2]";
    String textArea = "textareaPrompt";
    String allDoneButton = "promptOption0";
    String loadButton = "/html/body/div/div[2]/div[8]/div/div[1]/div[3]/a[1]";
    String buttonReset = "Reset";
    String buttonYes = "//*[@id='promptOption0']";
    String buttonFancy = "fancyButton";
    String buttonParticle = "particlesButton";
    String buttonMilk = "milkButton";
    String buttonCursors = "cursorsButton";


    //Achievements
    String notesClose = "//div[@onclick='Game.CloseNotes();']";
    String changeBakeryNameAchievement = "//div[@id='menu']//div[contains(@class, 'achievement')][127]";
    String tinyCookieAchievement = "//div[@id='menu']//div[contains(@class, 'achievement')][126]";
    String cookieDunkerAchievement = "//div[@id='menu']//div[contains(@class, 'achievement')][125]";
    String sellGrandmaAchievement = "//div[@id='menu']//div[contains(@class, 'achievement')][42]";

    //Upgrades
    String oneMindUpgrade = "//div[@id='menu']//div[contains(@class, 'upgrade')][47]";
    

    //Stats
    String statsButton = "statsButton";
    String cookieTiny = "tinyCookie";
    String bakedCookies = "//div[@id='menu']//div[contains(@class,'subsection')][1]//div[contains(@class,'listing')][2]//div[contains(@class,  'price plain')]";
    String seasonCheck = "//div[@id='menu']/div[4]/div[2]";
}
