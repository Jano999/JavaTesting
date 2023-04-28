package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.lang.*;
import org.openqa.selenium.JavascriptExecutor;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SeleniumTestNG {


    WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void DragAndDrop() {
        driver.get("https://testpages.herokuapp.com/styled/drag-drop-javascript.html");
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        WebElement source = driver.findElement(By.id("draggable1"));
        WebElement destination = driver.findElement(By.id("droppable1"));
        actions.dragAndDrop(source, destination).build().perform();
        Assert.assertTrue(destination.getText().contains("Dropped!"));
    }
    @Test
    public void PageRefreshAndDynamicText(){
        driver.get("https://testpages.herokuapp.com/styled/refresh");
        String initialText = driver.findElement(By.xpath("/html/body/div/h1")).getText();
        driver.navigate().refresh();
        try {
            Thread.sleep(5000); // Wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String newText = driver.findElement(By.xpath("/html/body/div/h1")).getText();
        Assert.assertNotEquals(initialText, newText);

    }
    @Test
    public void Hover(){
        driver.get("https://testpages.herokuapp.com/styled/csspseudo/css-hover.html");

        // find the button element
        WebElement button = driver.findElement(By.id("hoverdiv"));

        // create an instance of the Actions class
        Actions actions = new Actions(driver);

        // hover over the button
        actions.moveToElement(button).perform();
        WebElement link = driver.findElement(By.id("hoverlink"));
        actions.moveToElement(link).click().perform();

    }
    @Test
    public void UploadFile (){
        driver.get("https://testpages.herokuapp.com/styled/file-upload-test.html");
        WebElement inputFiled = driver.findElement(By.id("fileinput"));
        inputFiled.sendKeys("C:\\Users\\Marek.Jan\\Downloads\\img.png");
        WebElement typeButton = driver.findElement(By.id("itsanimage"));
        WebElement submitButton = driver.findElement(By.xpath("/html/body/div/div[3]/form/div[3]/input"));
        typeButton.click();
        submitButton.click();
        WebElement title = driver.findElement(By.xpath("/html/body/div/h1"));
        Assert.assertEquals(title.getText(), "Uploaded File");

    }
    @Test
    public void LoginSendKeys(){
        driver.get("https://testpages.herokuapp.com/styled/cookies/adminlogin.html");
        WebElement usernameField = driver.findElement(By.xpath("/html/body/div/div[3]/section/form/div/input[1]"));
        WebElement passwordField = driver.findElement(By.xpath("/html/body/div/div[3]/section/form/div/input[2]"));
        WebElement loginButton = driver.findElement(By.id("login"));

        usernameField.sendKeys("Admin");
        passwordField.sendKeys("AdminPass");

        loginButton.click();
    }
    @Test
    public void htmlForm() {
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
        // Finding elements
        WebElement userName = driver.findElement(By.xpath("/html/body/div/div[3]/form/table/tbody/tr[1]/td/input"));
        WebElement password = driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[2]/td/input"));
        WebElement textArea = driver.findElement(By.xpath("/html/body/div/div[3]/form/table/tbody/tr[3]/td/textarea"));
        WebElement inputField = driver.findElement(By.xpath("/html/body/div/div[3]/form/table/tbody/tr[3]/td/textarea"));
        WebElement checkBox = driver.findElement(By.xpath("/html/body/div/div[3]/form/table/tbody/tr[5]/td/input[1]"));
        WebElement radioItems = driver.findElement(By.xpath("/html/body/div/div[3]/form/table/tbody/tr[6]/td/input[1]"));
        WebElement multipleSelection = driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[7]/td/select/option[1]"));
        WebElement dropdownElement = driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[7]/td/select"));
        WebElement submit = driver.findElement(By.xpath("/html/body/div/div[3]/form/table/tbody/tr[9]/td/input[2]"));
        // filling elements
        userName.sendKeys("Jan");
        password.sendKeys("Marek");
        textArea.sendKeys("Hello world");
        inputField.click();
        checkBox.click();
        radioItems.click();
        multipleSelection.click();

        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("Selection Item 1");

        submit.click();
    }
    @Test
    public void dynamicButtons(){
        driver.get("https://testpages.herokuapp.com/styled/dynamic-buttons-simple.html");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement firstButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button00")));
        firstButton.click();

        WebElement secondButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button01")));
        secondButton.click();

        WebElement thirdButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button02")));
        thirdButton.click();

        WebElement fourthButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button03")));
        fourthButton.click();
    }
    @Test
    public void Iframe(){
        /*driver.get("https://www.telekom.com/en");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement firstButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("/html/body/div[3]/div/div[2]/div/div/div/div/div/div/div[2]/div[1]/button[1]")));
        firstButton.click();

            */
    }
    @Test
    public void string(){

        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

        // generate a random string with one uppercase character, one number, and one special character
        String randomString = RandomStringGenerator.generateRandomString(10);

        // find the input field and set its value to the random string
        WebElement userName = driver.findElement(By.cssSelector("input[name=\"username\"]"));
        userName.sendKeys(randomString);

    }
    @Test
    public void Cookie(){
        driver.get("https://www.telekom.com/en");
        WebElement Cookie = driver.findElement(By.cssSelector("#top > div.lightbox.cookie-optin-layer.width-m.fade.done > div > div.lightbox-dialog > div > div > div > div > div > div > div:nth-child(2) > div.form-flex-btn-set__wrapper.form-flex-btn-set__wrapper--left > button:nth-child(1)"));
        Cookie.click();
    }

     @AfterClass
     public void tearDown(){
    driver.quit();
     }
}
