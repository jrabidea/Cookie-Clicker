
import org.openqa.jetty.jetty.servlet.jmx.WebApplicationContextMBean;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by jrAb on 10/24/14.
 */
public class CookieClicker {

    public static void main(String[] args){
        CookieClickerAddresses addresses = new CookieClickerAddresses();

        // Launch Firefox and go to cookie cutter site
        WebDriver firefox = addresses.driver;

        firefox.get(addresses.baseURL);
        System.out.println("Loading Cookie Clicker.......");


        //Cookie elements
        WebElement cookie = firefox.findElement(By.id(addresses.cookieLocation));
        WebElement cookieCounter = firefox.findElement(By.id(addresses.cookieCounterLocation));
<<<<<<< HEAD
        WebElement cursorUpgrade = firefox.findElement(By.id(addresses.productOne));
        WebElement grandmaUpgrade = firefox.findElement(By.id(addresses.productTwo));
        WebElement farmUpgrade = firefox.findElement(By.id(addresses.productThree));
        WebElement factoryUpgrade = firefox.findElement(By.id(addresses.productFour));
        WebElement mineUpgrade = firefox.findElement(By.id(addresses.productFive));
        WebElement shipmentUpgrade = firefox.findElement(By.id(addresses.productSix));
        WebElement alchemyLabUpgrade =firefox.findElement(By.id(addresses.productSeven));
        WebElement portalUpgrade = firefox.findElement(By.id(addresses.productEight));



        // String variables
=======
        WebElement[] storeUpgrades = new WebElement[216];
          // String variables
>>>>>>> FETCH_HEAD
        String count;
        String counter = "";
        // Integer variables
        int cookieNum;
<<<<<<< HEAD
        int cursorUpgradesBought = 0;
        int grandmaUpgradesBought = 0;
        int farmUpgradesBought = 0;
        int factoryUpgradesBought = 0;
        int mineUpgradesBought = 0;
        int shipmentUpgradesBought = 0;
        int alchemyLabUpgradesBought = 0;
        int portalUpgradesBought = 0;

=======
        int checkUpgrades = 0;
        int cursorUpgradesBought = 0;
        int grandmaUpgradesBought = 0;
        int farmUpgradesBought = 0;
>>>>>>> FETCH_HEAD
       // Boolean variables
        Boolean start = true;
        Boolean isPresent = true;

        for(int i = 0; i < 20; i ++){

            cookie.click();
        }
        while(start){

            cookie.click();
            count = cookieCounter.getText();
            String[] cookieSplit = count.split(" ");
            counter = cookieSplit[0].replace(",","");
            cookieNum = Integer.parseInt(counter);
            // Upgrades
<<<<<<< HEAD
            System.out.println(cookieNum);



            if(cursorUpgrade.getAttribute("class").equals("product unlocked enabled") && cursorUpgradesBought < 10){
                System.out.println("Buying cursor...");
=======

           WebElement cursorUpgrade = firefox.findElement(By.id(addresses.productOne));
           WebElement grandmaUpgrade = firefox.findElement(By.id(addresses.productTwo));
           WebElement farmUpgrade = firefox.findElement(By.id(addresses.productThree));



            if(cursorUpgrade.getAttribute("class").equals("product unlocked enabled") && cursorUpgradesBought < 10){
>>>>>>> FETCH_HEAD
                cursorUpgrade.click();
                cursorUpgradesBought++;
            }

            if(grandmaUpgrade.getAttribute("class").equals("product unlocked enabled") && grandmaUpgradesBought < 10){
<<<<<<< HEAD
                System.out.println("Buying grandma...");
                grandmaUpgrade.click();
                grandmaUpgradesBought++;
            }

            if(farmUpgrade.getAttribute("class").equals("product unlocked enabled") && farmUpgradesBought < 10){
                System.out.println("Buying farm...");
                farmUpgrade.click();
                farmUpgradesBought++;
            }

            if(factoryUpgrade.getAttribute("class").equals("product unlocked enabled") && factoryUpgradesBought <10){
                System.out.println("Buying factory...");
                factoryUpgrade.click();
                factoryUpgradesBought++;
            }

            if(mineUpgrade.getAttribute("class").equals("product unlocked enabled") && mineUpgradesBought < 10 ){
                System.out.println("Buying mine..");
                mineUpgrade.click();
                mineUpgradesBought++;

            }

            if(shipmentUpgrade.getAttribute("class").equals("product unlocked enabled")&& shipmentUpgradesBought < 10){
                System.out.println("Buying shipment...");
                shipmentUpgrade.click();
                shipmentUpgradesBought++;

            }

            if(alchemyLabUpgrade.getAttribute("class").equals("product unlocked enabled")
                    && alchemyLabUpgradesBought < 10){
                System.out.println("Buying alchemy lab...");
                alchemyLabUpgrade.click();
                alchemyLabUpgradesBought++;
            }

            if(portalUpgrade.getAttribute("class").equals("product unlocked enabled") && portalUpgradesBought < 10){
                System.out.println("Buying portal...");
                portalUpgrade.click();
                portalUpgradesBought++;
            }

            if(isPresent = firefox.findElements(By.xpath
                    ("//div[@id='upgrades']/div[contains(@class, 'enabled')]")).size() > 0) {
                WebElement storeUpgrade = firefox.findElement
                        (By.xpath("//div[@id='upgrades']/div[contains(@class, 'enabled')]"));
                storeUpgrade.click();
                System.out.println("store upgrade bought...");
            }


=======
                grandmaUpgrade.click();
                grandmaUpgradesBought++;
            }

            if(farmUpgrade.getAttribute("class").equals("product unlocked enabled") && farmUpgradesBought < 10){
                farmUpgrade.click();
                farmUpgradesBought++;
            }
>>>>>>> FETCH_HEAD
        }
    }
}
