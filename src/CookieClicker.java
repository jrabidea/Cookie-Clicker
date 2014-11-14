
import org.openqa.jetty.jetty.servlet.jmx.WebApplicationContextMBean;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import java.nio.charset.StandardCharsets;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;



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
        WebElement timeMachineUpgrade = firefox.findElement(By.id(addresses.productTen));
        WebElement menu = firefox.findElement(By.xpath(addresses.menuButton));
        

        // String variables
        String count;
        String counter = "";
        String code = "";
        String codeImport = "";
        String cookieText = "";
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

       // Boolean variables
        Boolean start = true;
        Boolean isPresent = true;
        

        //File varibale
        File saveGame = new File("CookieClickerSave.txt");

        
        //Import File
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
        

        //Start Cookie Click
        while(start){

            cookie.click();
            cookieText = cookieCounter.getText();
        
            System.out.println(cookieText);


             // Upgrades
            if(cursorUpgrade.getAttribute("class").equals("product unlocked enabled") && cursorUpgradesBought < 10){
                System.out.println("Buying cursor...");
                cursorUpgrade.click();
                cursorUpgradesBought++;
            }

            if(grandmaUpgrade.getAttribute("class").equals("product unlocked enabled") && grandmaUpgradesBought < 10){
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

            if(timeMachineUpgrade.getAttribute("class").equals("product unlocked enabled") && timeMachineUpgradesBought < 10){
                System.out.println("Buying time machine...");
                timeMachineUpgrade.click();
                timeMachineUpgradesBought++;
            }

            if(isPresent = firefox.findElements(By.xpath
                    ("//div[@id='upgrades']/div[contains(@class, 'enabled')]")).size() > 0) {
                WebElement storeUpgrade = firefox.findElement
                        (By.xpath("//div[@id='upgrades']/div[contains(@class, 'enabled')]"));
                storeUpgrade.click();
                System.out.println("store upgrade bought...");
            }

            if(countSave == 1000){
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

            countSave++;

        }
    }
}
