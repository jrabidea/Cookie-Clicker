
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
        WebElement cursorUpgrade;
        WebElement cursorUpgradePrice;
        WebElement grandmaUpgrade;
        WebElement grandmaUpgradePrice;
        WebElement farmUpgrade;
        WebElement farmUpgradePrice;
        // String variables
        String count;
        String countUpgradeThree = "";
        String upgradeOnePrice = "";
        String upgradeTwoPrice = "";
        String counter = "";
        String upgradeThreePrice ="";


        // Integer variables
        int cookieNum;
        int countNum;
        int upgradeOnePriceNum;
        int cursorUpgradesBought = 0;
        int upgradeTwoPriceNum;
        int grandmaUpgradesBought = 0;
        int upgradeThreePriceNum;
        int farmUpgradesBought = 0;

        // Boolean variables
        Boolean buyCursorUpgrade = true;
        Boolean buyGrandmaUpgrade = false;
        Boolean start = true;
        Boolean buyFarmUpgrade = false;

        for(int i = 0; i < 10; i ++){

            cookie.click();
        }
        while(start){

            cookie.click();
            count = cookieCounter.getText();
            String[] cookieSplit = count.split(" ");
            counter = cookieSplit[0].replace(",","");
            cookieNum = Integer.parseInt(counter);
            // Upgrades
            if (buyCursorUpgrade){
                 if(cookieNum > 18){

                    cursorUpgrade = firefox.findElement(By.id(addresses.productOne));
                    cursorUpgradePrice = firefox.findElement(By.id(addresses.productOnePrice));

                    upgradeOnePrice = cursorUpgradePrice.getText();
                    upgradeOnePriceNum = Integer.parseInt(upgradeOnePrice);

                     if(cookieNum > upgradeOnePriceNum){

                         cursorUpgrade.click();
                         cursorUpgradesBought++;
                     }

                     if(cursorUpgradesBought == 5){
                         buyCursorUpgrade = false;
                         buyGrandmaUpgrade = true;
                     }
                 }
            }

            else if(buyGrandmaUpgrade){

                if (cookieNum > 100){

                    grandmaUpgrade = firefox.findElement(By.id(addresses.productTwo));
                    grandmaUpgradePrice = firefox.findElement(By.id(addresses.productTwoPrice));

                    upgradeTwoPrice = grandmaUpgradePrice.getText();
                    upgradeTwoPriceNum = Integer.parseInt(upgradeTwoPrice);

                     if (cookieNum > upgradeTwoPriceNum){

                        grandmaUpgrade.click();
                        grandmaUpgradesBought++;

                        if(grandmaUpgradesBought == 5){

                            buyGrandmaUpgrade = false;
                            buyFarmUpgrade = true;
                        }
                     }
                }
            }

            else if (buyFarmUpgrade){

                if(cookieNum > 500){

                    farmUpgrade = firefox.findElement(By.id(addresses.productThree));
                    farmUpgradePrice = firefox.findElement(By.id(addresses.productThreePrice));

                    upgradeThreePrice = farmUpgradePrice.getText();
                    countUpgradeThree = upgradeThreePrice.replace(",", "");
                    upgradeThreePriceNum = Integer.parseInt(countUpgradeThree);

                    if(cookieNum > upgradeThreePriceNum){

                        farmUpgrade.click();
                        farmUpgradesBought++;
                            if(farmUpgradesBought == 5){
                                buyFarmUpgrade = false;
                            }
                    }
                }
            }
        }
    }
}
