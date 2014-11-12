
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


        //Cookie elements
        WebElement cookie = firefox.findElement(By.id(addresses.cookieLocation));
        WebElement cookieCounter = firefox.findElement(By.id(addresses.cookieCounterLocation));
        WebElement[] storeUpgrades = new WebElement[216];
          // String variables
        String count;
        String counter = "";
        // Integer variables
        int cookieNum;
        int checkUpgrades = 0;
        int cursorUpgradesBought = 0;
        int grandmaUpgradesBought = 0;
        int farmUpgradesBought = 0;
       // Boolean variables
        Boolean start = true;

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

           WebElement cursorUpgrade = firefox.findElement(By.id(addresses.productOne));
           WebElement grandmaUpgrade = firefox.findElement(By.id(addresses.productTwo));
           WebElement farmUpgrade = firefox.findElement(By.id(addresses.productThree));



            if(cursorUpgrade.getAttribute("class").equals("product unlocked enabled") && cursorUpgradesBought < 10){
                cursorUpgrade.click();
                cursorUpgradesBought++;
            }

            if(grandmaUpgrade.getAttribute("class").equals("product unlocked enabled") && grandmaUpgradesBought < 10){
                grandmaUpgrade.click();
                grandmaUpgradesBought++;
            }

            if(farmUpgrade.getAttribute("class").equals("product unlocked enabled") && farmUpgradesBought < 10){
                farmUpgrade.click();
                farmUpgradesBought++;
            }
        }
    }
}
