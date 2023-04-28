import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.telekom.com/en");
        driver.manage().window().maximize();
        WebElement element = (WebElement) driver.findElements(By.xpath("/html/body/div[3]/div/div[2]/div/div/div/div/div/div/div[2]/div[1]/button[1]"));
        element.click();

        driver.quit();
    }
}
