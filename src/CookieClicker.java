
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






        // String variables
        String count;
        String upgradeOnePrice = "";
        String upgradeTwoPrice = "";
        String counter = "";


        // Integer variables
        int cookieNum;
        int countNum;
        int upgradeOnePriceNum;
        int cursorUpgradesBought = 0;
        int upgradeTwoPriceNum;
        int grandmaUpgradesBought = 0;


        // Boolean variables
        Boolean buyCursorUpgrade = true;
        Boolean buyGrandmaUpgrade = false;
        Boolean start = true;


        for(int i = 0; i < 10; i ++){

            cookie.click();
        }


        while(start){

            cookie.click();
            count = cookieCounter.getText();
            countNum = count.length();

              switch (countNum){
                  case 25: counter = count.substring(0,0);
                      break;
                  case 26: counter = count.substring(0,1);
                  break;
                  case 27: counter = count.substring(0,2);
                      break;
                  case 28: counter = count.substring(0,3);
                      break;
                  case 29: counter = count.substring(0,4);
                      break;
                  case 30:  counter = count.substring(0,5);
                      break;
                  default:
                      System.out.println("No cookies available");
                      break;
              }

            cookieNum  = Integer.parseInt(counter);


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
                        }

                     }


                }


            }



        }

    }
}
