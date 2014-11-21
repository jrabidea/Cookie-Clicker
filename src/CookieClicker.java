
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
<<<<<<< HEAD
=======
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;
import java.util.Scanner;
>>>>>>> Save-Game


/**
 * Created by jrAb on 10/24/14.
 */
public class CookieClicker {

    public static void main(String[] args) throws FileNotFoundException{
        CookieClickerAddresses addresses = new CookieClickerAddresses();

        String startNewGame = "";
        String fileName = "";
        Boolean newSave = null;
        Boolean loadGame = null;

        Scanner writeNewFile = new Scanner(System.in);
        Scanner loadFile = new Scanner(System.in);
        System.out.println("Do you want to start a new game?");
        startNewGame = writeNewFile.next();

        if(startNewGame.equals("yes")){
           newSave = true;
            System.out.println("Enter file name: ");
            fileName = writeNewFile.next();
        }
        else if(startNewGame.equals("no")){
            newSave = false;
            loadGame = true;
        }
        else{
            System.out.println("Please enter 'yes' or 'no'");
        }

        File saveGame = new File(fileName);

        if(newSave){
               try{
                    FileUtils.write(saveGame, "");
                }catch(IOException e){
                    e.printStackTrace();
                }
          loadGame = false;
        }

        // Launch Firefox and go to cookie cutter site
        WebDriver firefox = addresses.driver;

        Actions builder = new Actions(firefox);

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
        WebElement antiMatterUpgrade = firefox.findElement(By.id(addresses.productTen));
        WebElement antiMatterUpgradesOwned = firefox.findElement(By.id(addresses.productTenOwned));
        WebElement prismUpgrade = firefox.findElement(By.id(addresses.productEleven));
        WebElement prismUpgradesOwned = firefox.findElement(By.id(addresses.productElevenOwned));
        WebElement stats = firefox.findElement(By.id(addresses.statsButton));
        WebElement nameOfBakery = firefox.findElement(By.id(addresses.bakeryName));

      
        // String variables
        String count;
        String counter = "";
        String code = "";
        String codeImport = "";
        String cookieText = "";
        String loadGetOwnedTextCheck = "";
        String error = "";

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
        int antiMatterUpgradesBought = 0;
        int prismUpgradesBought = 0;
        int countSave = 1;
        int checkAchievements = 1;
        int round = 10;
        int round2 = 10;
        int round3 = 10;
        int totalUpgradesBought = 0;
        

       // Boolean variables
        Boolean start = true;
        Boolean isPresent = true;
        Boolean changeNameOfBakery = true;
        Boolean clickTinyCookie = true;
<<<<<<< HEAD
        

        //File varibale
        File saveGame = new File("CookieClickerSave.txt");

        
        //Import File and load save
        BufferedReader reader = new BufferedReader(new FileReader(saveGame));
=======
        Boolean doResizeBrowser = true;
        Boolean resetBrowser = false;
        Boolean sellGrandma = true;

        

        if(loadGame){
        //Import File and load save
        System.out.println("Enter the file name you want to load: ");
        fileName = loadFile.next();   

        BufferedReader reader = new BufferedReader(new FileReader(fileName));
>>>>>>> Save-Game
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
<<<<<<< HEAD
=======
        }
>>>>>>> Save-Game
        // Checks upgrades from save and set the amount for each upgrade
        WebElement[] upgradesOwned = {cursorUpgradesOwned, grandmaUpgradesOwned, farmUpgradesOwned, factoryUpgradesOwned,
                                        mineUpgradesOwned, shipmentUpgradesOwned, alchemyUpgradesOwned,portalUpgradesOwned,
                                        timeMachineUpgradesOwned, antiMatterUpgradesOwned, prismUpgradesOwned};

        int[] upgradesBought =  {cursorUpgradesBought, grandmaUpgradesBought, farmUpgradesBought, factoryUpgradesBought,
                                    mineUpgradesBought, shipmentUpgradesBought, alchemyLabUpgradesBought, 
                                    portalUpgradesBought, timeMachineUpgradesBought, 
                                    antiMatterUpgradesBought, prismUpgradesBought};

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
<<<<<<< HEAD
=======
    WebElement achievementTinyCookie = firefox.findElement(By.xpath(addresses.tinyCookieAchievement));
    WebElement achievementCookieDunker = firefox.findElement(By.xpath(addresses.cookieDunkerAchievement));
    WebElement achievementSellGrandma = firefox.findElement(By.xpath(addresses.sellGrandmaAchievement));

>>>>>>> Save-Game

    if(bakeryNameChange.getAttribute("class").equals("crate achievement enabled")){
          changeNameOfBakery = false;
    }
<<<<<<< HEAD
   
    stats.click();

=======

    if(achievementTinyCookie.getAttribute("class").equals("crate achievement enabled")){
        clickTinyCookie = false;
    }

    if(achievementCookieDunker.getAttribute("class").equals("crate achievement enabled")){
        System.out.println("Cookie Dunker Achievement is unlocked");
        doResizeBrowser = false;
    }

    if(achievementSellGrandma.getAttribute("class").equals("crate achievement enabled")){
        System.out.println("Sell grandma achievement already unlocked");
        sellGrandma = false;
    }
   
>>>>>>> Save-Game
    if(changeNameOfBakery){
            System.out.println("Re-naming Bakery for achievement");
            nameOfBakery.click();
            WebElement randomButton = firefox.findElement(By.id(addresses.buttonRandom));
            WebElement allDone = firefox.findElement(By.id(addresses.allDoneButton));
            randomButton.click();
            allDone.click();
    }

<<<<<<< HEAD
=======
    if(clickTinyCookie){
        System.out.println("Printing tiny cookie");
        WebElement tinyCookie = firefox.findElement(By.className(addresses.cookieTiny));
        tinyCookie.click();
    }

    stats.click();

>>>>>>> Save-Game
        //Start Cookie Click
        while(start){

            cookie.click();
            cookieText = cookieCounter.getText();
        
            System.out.println(cookieText);


             // Upgrades
            if(cursorUpgrade.getAttribute("class").equals("product unlocked enabled") && upgradesBought[0] < round){
                System.out.println("Buying cursor...");
                cursorUpgrade.click();
                upgradesBought[0]++;
            }

            if(grandmaUpgrade.getAttribute("class").equals("product unlocked enabled") && upgradesBought[1] < round){
                System.out.println("Buying grandma...");
                grandmaUpgrade.click();
                upgradesBought[1]++;
            }

            if(farmUpgrade.getAttribute("class").equals("product unlocked enabled") && upgradesBought[2] < round){
                System.out.println("Buying farm...");
                farmUpgrade.click();
                upgradesBought[2]++;
            }

            if(factoryUpgrade.getAttribute("class").equals("product unlocked enabled") && upgradesBought[3] < round){
                System.out.println("Buying factory...");
                factoryUpgrade.click();
                upgradesBought[3]++;
            }

            if(mineUpgrade.getAttribute("class").equals("product unlocked enabled") && upgradesBought[4] < round){
                System.out.println("Buying mine..");
                mineUpgrade.click();
                upgradesBought[4]++;

            }

            if(shipmentUpgrade.getAttribute("class").equals("product unlocked enabled")&& upgradesBought[5] < round){
                System.out.println("Buying shipment...");
                shipmentUpgrade.click();
                upgradesBought[5]++;

            }

            if(alchemyLabUpgrade.getAttribute("class").equals("product unlocked enabled") && upgradesBought[6] < round){
                System.out.println("Buying alchemy lab...");
                alchemyLabUpgrade.click();
                upgradesBought[6]++;
            }

            if(portalUpgrade.getAttribute("class").equals("product unlocked enabled") && upgradesBought[7] < round){
                System.out.println("Buying portal...");
                portalUpgrade.click();
                upgradesBought[7]++;
            }
            
            if(timeMachineUpgrade.getAttribute("class").equals("product unlocked enabled") && upgradesBought[8] < round2){
                System.out.println("Buying time machine...");
                timeMachineUpgrade.click();
                upgradesBought[8]++;
            }

            if(antiMatterUpgrade.getAttribute("class").equals("product unlocked enabled") && upgradesBought[9] < round2){
                System.out.println("Buying anit-matter condenser.....");
                antiMatterUpgrade.click();
                upgradesBought[9]++;
            }

            if(prismUpgrade.getAttribute("class").equals("product unlocked enabled") && upgradesBought[10] < round3){
                System.out.println("Buying prism upgrade.....");
                prismUpgrade.click();
                upgradesBought[10]++;
<<<<<<< HEAD
=======
            }

            totalUpgradesBought = upgradesBought[0] + upgradesBought[1]+ upgradesBought[2] + upgradesBought[3]+ upgradesBought[4]
                                    + upgradesBought[5] + upgradesBought[6] + upgradesBought[7] + upgradesBought[8]
                                    + upgradesBought[9] + upgradesBought[10];

            if(totalUpgradesBought == 80){
                round = 20;
            }

            if(totalUpgradesBought > 81 && totalUpgradesBought < 220){
                round = 20;
                round2 = 20;
            }

            if(totalUpgradesBought > 221){
                round3 = 20;
                round = 50;
                round2 = 35;
>>>>>>> Save-Game
            }

            totalUpgradesBought = upgradesBought[0] + upgradesBought[1]+ upgradesBought[2] + upgradesBought[3]+ upgradesBought[4]
                                    + upgradesBought[5] + upgradesBought[6] + upgradesBought[7] + upgradesBought[8]
                                    + upgradesBought[9];
                    
            switch(totalUpgradesBought){
                case 80:
                round = 20;
                    break;
                case 180:
                round2 = 20;
                    break;
                case 220:
                round3 = 20;
                round = 50;
                round2 = 35;
                    break;
                default:
                    break;   
            }

            

            if(isPresent = firefox.findElements(By.xpath
                    ("//div[@id='upgrades']/div[contains(@class, 'enabled')]")).size() > 0) {
                WebElement storeUpgrade = firefox.findElement
                        (By.xpath("//div[@id='upgrades']/div[contains(@class, 'enabled')]"));
                storeUpgrade.click();
                System.out.println("store upgrade bought...");
            }

            // Save Game
<<<<<<< HEAD
            if(countSave == 500){
=======
            if(countSave == 530){
>>>>>>> Save-Game
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
            
            // Achievements
<<<<<<< HEAD
            if(checkAchievements == 200){
                System.out.println("Checking achievements.....");
                stats.click();
                WebElement achievementCount = firefox.findElement(By.xpath(addresses.achievementsUnlocked));
                System.out.println(achievementCount.getText());
=======
            if(checkAchievements == 250){
>>>>>>> Save-Game
                try{
                WebElement close = firefox.findElement(By.xpath(addresses.achievementClose));
                if(close.getAttribute("class").equals("close")){
                    close.click();
                }
            }catch (NoSuchElementException e){
                error = e.getMessage();
                System.out.println("There's no achievements to close....");
            }

<<<<<<< HEAD
=======
                if(sellGrandma){
                    if(upgradesBought[1] > 1){
                    WebElement grandmaSell = firefox.findElement(By.xpath(addresses.sellOneGrandma));
                    Action sellGrandmaUpgrade = builder
                                .moveToElement(grandmaUpgrade)
                                .click(grandmaSell)
                                .build();
                    sellGrandmaUpgrade.perform();            
                    sellGrandma = false;
                    }
                }

                if(doResizeBrowser){
                    System.out.println("Resizing browser....");
                    firefox.manage().window().setSize(new Dimension(1024,260));
                    doResizeBrowser = false;
                    resetBrowser = true;
                }
                if(resetBrowser){
                    System.out.println("Resetting browser size....");
                    firefox.manage().window().setSize(new Dimension(1024,768));
                    doResizeBrowser = false;
                }
>>>>>>> Save-Game
                checkAchievements = 1;
                stats.click();
            }

           
           checkAchievements++;
            countSave++;
<<<<<<< HEAD
=======

>>>>>>> Save-Game

        }
    }
}
