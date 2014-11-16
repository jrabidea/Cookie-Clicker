
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import java.nio.charset.StandardCharsets;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import org.openqa.selenium.NoSuchElementException;


/**
 * Created by jrAb on 10/24/14.
 */
public class CookieClicker {

    public static void main(String[] args) throws FileNotFoundException{
        CookieClickerAddresses addresses = new CookieClickerAddresses();

        // Launch Firefox and go to cookie cutter site
        WebDriver firefox = addresses.driver;

        firefox.get(addresses.baseURL);
        System.out.println("Loading Cookie Clicker.......");


        //Cookie elements
        WebElement cookie = firefox.findElement(By.id(addresses.cookieLocation));
        WebElement cookieCounter = firefox.findElement(By.id(addresses.cookieCounterLocation));
        WebElement cursorUpgrade = firefox.findElement(By.id(addresses.productOne));
        WebElement grandmaUpgrade = firefox.findElement(By.id(addresses.productTwo));
        WebElement farmUpgrade = firefox.findElement(By.id(addresses.productThree));
        WebElement factoryUpgrade = firefox.findElement(By.id(addresses.productFour));
        WebElement mineUpgrade = firefox.findElement(By.id(addresses.productFive));
        WebElement shipmentUpgrade = firefox.findElement(By.id(addresses.productSix));
        WebElement alchemyLabUpgrade =firefox.findElement(By.id(addresses.productSeven));
        WebElement portalUpgrade = firefox.findElement(By.id(addresses.productEight));
        WebElement timeMachineUpgrade = firefox.findElement(By.id(addresses.productNine));
        WebElement menu = firefox.findElement(By.xpath(addresses.menuButton));
        WebElement cursorUpgradesOwned = firefox.findElement(By.id(addresses.productOneOwned));
        WebElement grandmaUpgradesOwned = firefox.findElement(By.id(addresses.productTwoOwned));
        WebElement farmUpgradesOwned = firefox.findElement(By.id(addresses.productThreeOwned));
        WebElement factoryUpgradesOwned = firefox.findElement(By.id(addresses.productFourOwned));
        WebElement mineUpgradesOwned = firefox.findElement(By.id(addresses.productFiveOwned));
        WebElement shipmentUpgradesOwned = firefox.findElement(By.id(addresses.productSixOwned));
        WebElement alchemyUpgradesOwned = firefox.findElement(By.id(addresses.productSevenOwned));
        WebElement portalUpgradesOwned = firefox.findElement(By.id(addresses.productEightOwned));
        WebElement timeMachineUpgradesOwned = firefox.findElement(By.id(addresses.productNineOwned));
        WebElement stats = firefox.findElement(By.id(addresses.statsButton));
        WebElement nameOfBakery = firefox.findElement(By.id(addresses.bakeryName));

      
        // String variables
        String count;
        String counter = "";
        String code = "";
        String codeImport = "";
        String cookieText = "";
        String loadGetOwnedTextCheck = "";
      


        // Integer variables
        int cursorUpgradesBought = 0;
        int grandmaUpgradesBought = 0;
        int farmUpgradesBought = 0;
        int factoryUpgradesBought = 0;
        int mineUpgradesBought = 0;
        int shipmentUpgradesBought = 0;
        int alchemyLabUpgradesBought = 0;
        int portalUpgradesBought = 0;
        int timeMachineUpgradesBought = 0;
        int countSave = 1;
        int checkAchievements = 1;
        

       // Boolean variables
        Boolean start = true;
        Boolean isPresent = true;
        Boolean changeNameOfBakery = null;
        

        //File varibale
        File saveGame = new File("CookieClickerSave.txt");

        
        //Import File and load save
        BufferedReader reader = new BufferedReader(new FileReader(saveGame));
        String line = null;
       
        try{
        while((line = reader.readLine()) != null){
            codeImport = line;
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException a){
            a.printStackTrace();
        }    
        System.out.println("Importing save.....");  

        menu.click();

        WebElement importSaveButton = firefox.findElement(By.xpath(addresses.importButton));
        importSaveButton.click();
        WebElement importText = firefox.findElement(By.id(addresses.textArea));
        WebElement importLoadButton = firefox.findElement(By.xpath(addresses.loadButton));
        importText.sendKeys(codeImport);
        importLoadButton.click();
        menu.click();
        // Checks upgrades from save and set the amount for each upgrade
        WebElement[] upgradesOwned = {cursorUpgradesOwned, grandmaUpgradesOwned, farmUpgradesOwned, factoryUpgradesOwned,
                                        mineUpgradesOwned, shipmentUpgradesOwned, alchemyUpgradesOwned,portalUpgradesOwned,
                                        timeMachineUpgradesOwned};

        int[] upgradesBought =  {cursorUpgradesBought, grandmaUpgradesBought, farmUpgradesBought, factoryUpgradesBought,
                                    mineUpgradesBought, shipmentUpgradesBought, alchemyLabUpgradesBought, 
                                    portalUpgradesBought, timeMachineUpgradesBought};

        for(int i = 0; i < upgradesOwned.length;i++){
            loadGetOwnedTextCheck = upgradesOwned[i].getText();
            if(loadGetOwnedTextCheck.equals("")){
                System.out.println("Upgrade not purchased from previous save");
                upgradesBought[i] = 0;
            }
            else{
                upgradesBought[i] = Integer.parseInt(loadGetOwnedTextCheck);
        }
    }   
    //Checking previously save achievements
    System.out.println("Checking previously unlocked achievements....");
    stats.click();
    WebElement bakeryNameChange = firefox.findElement(By.xpath(addresses.changeBakeryNameAchievement));
    if(bakeryNameChange.getAttribute("class").equals("crate achievement enabled")){
          changeNameOfBakery = false;
    }
    stats.click();

    if(changeNameOfBakery = true){
            System.out.println("Re-naming Bakery for achievement");
            nameOfBakery.click();
            WebElement randomButton = firefox.findElement(By.id(addresses.buttonRandom));
            WebElement allDone = firefox.findElement(By.id(addresses.allDoneButton));
            randomButton.click();
            allDone.click();
    }

        //Start Cookie Click
        while(start){

            cookie.click();
            cookieText = cookieCounter.getText();
        
            System.out.println(cookieText);


             // Upgrades
            if(cursorUpgrade.getAttribute("class").equals("product unlocked enabled") && upgradesBought[0] < 10){
                System.out.println("Buying cursor...");
                cursorUpgrade.click();
                upgradesBought[0]++;
            }

            if(grandmaUpgrade.getAttribute("class").equals("product unlocked enabled") && upgradesBought[1] < 10){
                System.out.println("Buying grandma...");
                grandmaUpgrade.click();
                upgradesBought[1]++;
            }

            if(farmUpgrade.getAttribute("class").equals("product unlocked enabled") && upgradesBought[2] < 10){
                System.out.println("Buying farm...");
                farmUpgrade.click();
                upgradesBought[2]++;
            }

            if(factoryUpgrade.getAttribute("class").equals("product unlocked enabled") && upgradesBought[3] < 10){
                System.out.println("Buying factory...");
                factoryUpgrade.click();
                upgradesBought[3]++;
            }

            if(mineUpgrade.getAttribute("class").equals("product unlocked enabled") && upgradesBought[4] < 10 ){
                System.out.println("Buying mine..");
                mineUpgrade.click();
                upgradesBought[4]++;

            }

            if(shipmentUpgrade.getAttribute("class").equals("product unlocked enabled")&& upgradesBought[5] < 10){
                System.out.println("Buying shipment...");
                shipmentUpgrade.click();
                upgradesBought[5]++;

            }

            if(alchemyLabUpgrade.getAttribute("class").equals("product unlocked enabled") && upgradesBought[6] < 10){
                System.out.println("Buying alchemy lab...");
                alchemyLabUpgrade.click();
                upgradesBought[6]++;
            }

            if(portalUpgrade.getAttribute("class").equals("product unlocked enabled") && upgradesBought[7] < 10){
                System.out.println("Buying portal...");
                portalUpgrade.click();
                upgradesBought[7]++;
            }

            if(timeMachineUpgrade.getAttribute("class").equals("product unlocked enabled") && upgradesBought[8] < 10){
                System.out.println("Buying time machine...");
                timeMachineUpgrade.click();
                upgradesBought[8]++;
            }

            if(isPresent = firefox.findElements(By.xpath
                    ("//div[@id='upgrades']/div[contains(@class, 'enabled')]")).size() > 0) {
                WebElement storeUpgrade = firefox.findElement
                        (By.xpath("//div[@id='upgrades']/div[contains(@class, 'enabled')]"));
                storeUpgrade.click();
                System.out.println("store upgrade bought...");
            }

            // Save Game
            if(countSave == 500){
                menu.click();
                WebElement saveExport = firefox.findElement(By.xpath(addresses.exportButton));
                WebElement importSave = firefox.findElement(By.xpath(addresses.importButton));
                System.out.println("Saving game.....");
                saveExport.click();
                WebElement saveCode = firefox.findElement(By.id(addresses.textArea));
                WebElement allDone = firefox.findElement(By.id(addresses.allDoneButton));
                code = saveCode.getText();
                try{
                    FileUtils.write(saveGame, code);
                }catch(IOException e){
                    e.printStackTrace();
                }
                allDone.click();
                countSave = 0;
                menu.click();
            }
            
            // Check achievements
            if(checkAchievements == 1000){
                System.out.println("Checking achievements.....");
                stats.click();
                WebElement achievementCount = firefox.findElement(By.xpath(addresses.achievementsUnlocked));
                System.out.println(achievementCount.getText());
                checkAchievements = 1;
                stats.click();

            }

            //Achievements

           checkAchievements++;
            countSave++;

        }
    }
}
