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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;
import java.util.Scanner;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.*;

/**
 * Created by jrAb on 10/24/14.
 */
public class CookieClicker {

    public static void main(String[] args) throws FileNotFoundException{
        CookieClickerAddresses addresses = new CookieClickerAddresses();

        String startNewGame = "";
        String fileName = "";
        String error2 = "";
        Boolean newSave = null;
        Boolean loadGame = null;
        Boolean retryLoad = true;
        Boolean retry = true;
        Boolean load = true;

        Scanner writeNewFile = new Scanner(System.in);
        Scanner loadFile = new Scanner(System.in);

        while(retry){
            retry = false;
            System.out.println("Do you want to start a new game 'y' or 'n'?");
            startNewGame = writeNewFile.next();
            try{
                if(startNewGame.equals("y")){
                   newSave = true;
                   retryLoad = false;
                   load = false;
                    System.out.println("Enter file name: ");
                    fileName = writeNewFile.next() + ".txt";
                }
                else if(startNewGame.equals("n")){
                    newSave = false;
                    loadGame = true;
                }
                else{
                    System.out.println("Please enter 'y' or 'n'");
                    retry = true;
                }
                }catch(NullPointerException e){
                    error2 = e.getMessage();
                }
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
        WebElement leftCanvas = firefox.findElement(By.id(addresses.leftPane));
        

      
        // String variables
        String count;
        String counter = "";
        String code = "";
        String codeImport = "";
        String cookieText = "";
        String loadGetOwnedTextCheck = "";
        String error = "";
        String allTimeCookiesBaked = "";
        String finalCookiesBaked = "";

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
        int[] coordinatesArrayX = {26, 31, 74, 83, 144, 229, 270 ,273, 224, 194};
        int[] coordinatesArrayY = {219, 300, 350, 143, 123, 154, 205, 300, 354, 382}; 
        int checkWrinklersCount = 0;
        

       // Boolean variables
        Boolean start = true;
        Boolean isPresent = true;
        Boolean changeNameOfBakery = true;
        Boolean clickTinyCookie = true;
        Boolean doResizeBrowser = true;
        Boolean sellGrandma = true;
        Boolean doDunkAchievement = true;
        Boolean checkWrinklers = true;

        while(retryLoad){
            if(loadGame){
            //Import File and load save
            retryLoad = false;
            System.out.println("Enter the file name you want to load: ");
            fileName = loadFile.next() + ".txt";   

            try{
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = null;
           
        
            while((line = reader.readLine()) != null){
                codeImport = line;
                }
            }catch(FileNotFoundException e){
                error = e.getMessage();
                System.out.println("File not found. Please try again");
                retryLoad = true;
            }catch(IOException a){
               error = a.getMessage();
             } 
            }
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
                saveGame = new File(fileName);
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

            System.out.println("Resizing browser....");
            firefox.manage().window().setSize(new Dimension(1024,768)); 

            //Checking previously save achievements
            System.out.println("Checking previously unlocked achievements....");
            stats.click();
            WebElement bakeryNameChange = firefox.findElement(By.xpath(addresses.changeBakeryNameAchievement));
            WebElement achievementTinyCookie = firefox.findElement(By.xpath(addresses.tinyCookieAchievement));
            WebElement achievementCookieDunker = firefox.findElement(By.xpath(addresses.cookieDunkerAchievement));
            WebElement achievementSellGrandma = firefox.findElement(By.xpath(addresses.sellGrandmaAchievement));


        if(bakeryNameChange.getAttribute("class").equals("crate achievement enabled")){
            System.out.println("The backery name change achievement is already unlocked");
              changeNameOfBakery = false;
        }

        if(achievementTinyCookie.getAttribute("class").equals("crate achievement enabled")){
            System.out.println("The tiny cookie achievement is already unlocked");
            clickTinyCookie = false;
        }

        if(achievementCookieDunker.getAttribute("class").equals("crate achievement enabled")){
            System.out.println("The cookie dunker Achievement is already unlocked");
            doDunkAchievement = false;
        }

        if(achievementSellGrandma.getAttribute("class").equals("crate achievement enabled")){
            System.out.println("The sell grandma achievement is already unlocked");
            sellGrandma = false;
        }
           
         if(changeNameOfBakery){
            System.out.println("Re-naming the bakery for achievement");
            nameOfBakery.click();
            WebElement randomButton = firefox.findElement(By.id(addresses.buttonRandom));
            WebElement allDone = firefox.findElement(By.id(addresses.allDoneButton));
            randomButton.click();
            allDone.click();
            }

        if(clickTinyCookie){
                System.out.println("Printing tiny cookie");
                WebElement tinyCookie = firefox.findElement(By.className(addresses.cookieTiny));
                tinyCookie.click();
        }

        stats.click();

        //Start Cookie Click
        while(start){

            cookie.click();
            cookieText = cookieCounter.getText();

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
            }

            totalUpgradesBought = upgradesBought[0] + upgradesBought[1]+ upgradesBought[2] + upgradesBought[3]+ upgradesBought[4]
                                    + upgradesBought[5] + upgradesBought[6] + upgradesBought[7] + upgradesBought[8]
                                    + upgradesBought[9] + upgradesBought[10];

            if(totalUpgradesBought == 80){
                round = 20;
            }

            if(totalUpgradesBought > 81 && totalUpgradesBought < 210){
                round = 20;
                round2 = 20;
            }

            if(totalUpgradesBought >= 210){
                round3 = 20;
                round = 50;
                round2 = 35;
            }

            if(isPresent = firefox.findElements(By.xpath
                    ("//div[@id='upgrades']/div[contains(@class, 'enabled')]")).size() > 0) {
                WebElement storeUpgrade = firefox.findElement
                        (By.xpath("//div[@id='upgrades']/div[contains(@class, 'enabled')]"));
                storeUpgrade.click();
                try{
                WebElement allDone = firefox.findElement(By.id(addresses.allDoneButton));
                allDone.click();
                }catch(ElementNotVisibleException s){
                    String message = s.getMessage();
                }
                System.out.println("store upgrade bought...");
            }


            // Save Game
            if(countSave == 530){
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
                  String skipError = e.getMessage();
                  System.out.println("There was an error saving...");
                }
                System.out.println(saveGame);
                allDone.click();
                countSave = 0;
                menu.click();
            }
            
            // Achievements
            if(checkAchievements == 250){

                stats.click();

                if(sellGrandma){
                    if(upgradesBought[1] > 1){
                    WebElement grandmaSell = firefox.findElement(By.xpath(addresses.sellOneGrandma));
                    Action sellGrandmaUpgrade = builder
                                .moveToElement(grandmaUpgrade)
                                .click(grandmaSell)
                                .build();
                    sellGrandmaUpgrade.perform();  
                    upgradesBought[1]--;          
                    sellGrandma = false;
                    }
                }

                if(doDunkAchievement){

                    if(doResizeBrowser){
                    System.out.println("Resizing browser....");
                    firefox.manage().window().setSize(new Dimension(1024,260));
                    doResizeBrowser = false;
                     }
                    else{
                    System.out.println("Resetting browser size....");
                    firefox.manage().window().setSize(new Dimension(1024,768));
                    doDunkAchievement = false;
                    }   
                }

                WebElement cookiesBaked = firefox.findElement(By.xpath(addresses.bakedCookies));
                allTimeCookiesBaked = cookiesBaked.getText();
                String[] splitCookiesBaked = allTimeCookiesBaked.split(" ");

                if(splitCookiesBaked[1].equals("octillion")){
                    System.out.println("Resetting the game...");
                    menu.click();
                    WebElement resetButton = firefox.findElement(By.linkText(addresses.buttonReset));
                    resetButton.click();
                    WebElement yesButton = firefox.findElement(By.xpath(addresses.buttonYes));
                    yesButton.click();
                    menu.click();
                    stats.click();
                    System.out.println("Resetting the amount of upgrades bought...");
                        for(int i = 0; i < upgradesOwned.length; i++){
                            upgradesBought[i] = 0;
                        }
                }

                checkAchievements = 1;
                stats.click();
            }
            try{
            WebElement close = firefox.findElement(By.xpath(addresses.notesClose));
             close.click();
            }catch(NoSuchElementException e){
                error = e.getMessage();
            }
            try{
            WebElement goldenCookie = firefox.findElement(By.xpath(addresses.cookieGolden));
            goldenCookie.click();
            System.out.println("golden cookie was clicked!");
            }catch(NoSuchElementException t){
                error = t.getMessage();
            }
            
            if(checkWrinklersCount == 1000){
                while(checkWrinklers){
                    try{
                        stats.click();
                        WebElement oneMind = firefox.findElement(By.xpath(addresses.oneMindUpgrade));
                        if(oneMind.getAttribute("class").equals("crate upgrade enabled")){
                            for(int i = 0; i < coordinatesArrayX.length; i++){
                                System.out.println("Clicking wrinklers...");
                                Action wrinklerClick = builder
                                    .moveToElement(leftCanvas, coordinatesArrayX[i], coordinatesArrayY[i])
                                    .click()
                                    .click()
                                    .click()
                                    .click()
                                    .click()
                                    .build();

                                wrinklerClick.perform();
                            }        
                        }
                    }catch(NoSuchElementException s){
                        String message = s.getMessage();
                    }
                    stats.click();
                    checkWrinklers = false;
                    checkWrinklersCount = 0;
                }
            }
            
            checkWrinklers = true;
            checkAchievements++;
            countSave++;
            checkWrinklersCount++;

        }
    }
}
