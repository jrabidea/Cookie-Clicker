import org.omg.PortableServer._ServantLocatorStub;
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
        WebElement grandmaUpgrade;
        WebElement grandmaUpgradePrice;

        // String variables
        String count;
        String upgradeOnePrice;
        String countNum;
        String upgradeTwoPrice;


        // Integer variables
        int cookieNum;
        int upgradeOnePriceNum;
        int cursorUpgradesBought = 0;
        int upgradeTwoPriceNum;
        int grandmaUpgradesBought = 0;

        // Boolean variables
        Boolean buyCursorUpgrade = true;
        Boolean buyGrandmaUpgrade = true;
        Boolean start = true;



        // Clicks to unlock the cursor upgrade
        for (int t = 0; t < 19; t++){

            cookie.click();

        }


        WebElement cursorUpgrade = firefox.findElement(By.id(addresses.productOne));
        WebElement cursorUpgradePrice = firefox.findElement(By.id(addresses.productOnePrice));

          while(start){

            cookie.click();
            count = cookieCounter.getText();
            count.length();
            upgradeOnePrice = cursorUpgradePrice.getText();
            upgradeOnePriceNum = Integer.parseInt(upgradeOnePrice);


                if(count.length() == 26){

                  countNum = count.substring(0, 1);
                  cookieNum = Integer.parseInt(countNum);

                }

                else if(count.length() == 27){
                  countNum = count.substring(0, 2);
                  cookieNum = Integer.parseInt(countNum);

                  if (buyCursorUpgrade){
                    if (cookieNum >= upgradeOnePriceNum ){
                      cursorUpgrade.click();
                      cursorUpgradesBought++;
                    }
                    if(cursorUpgradesBought == 5){

                        buyCursorUpgrade = false;
                    }
                  }



                }

                else if(count.length() == 28){
                  countNum = count.substring(0, 3);

                  cookieNum = Integer.parseInt(countNum);

                  grandmaUpgrade = firefox.findElement(By.id(addresses.productTwo));
                  grandmaUpgradePrice = firefox.findElement(By.id(addresses.productTwoPrice));

                  upgradeTwoPrice = grandmaUpgradePrice.getText();
                  upgradeTwoPriceNum = Integer.parseInt(upgradeTwoPrice);


                // Buy Cursor Upgrade
                  if(buyCursorUpgrade){

                    if (cookieNum >= upgradeOnePriceNum ){
                      cursorUpgrade.click();
                      cursorUpgradesBought++;
                    }

                  }

                    if(cursorUpgradesBought == 5){
                        buyCursorUpgrade = false;


                    }


                //Buy Grandma Update
                  if (buyGrandmaUpgrade){

                     if(cookieNum >= upgradeTwoPriceNum ){
                            grandmaUpgrade.click();
                            grandmaUpgradesBought++;

                        if(grandmaUpgradesBought == 5){
                                buyGrandmaUpgrade = false;
                        }

                     }

                  }

                }






            }

    }
}
