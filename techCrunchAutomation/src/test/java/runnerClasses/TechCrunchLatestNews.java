package runnerClasses;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import testCrunchClassFiles.TechCrunch_1;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;
public class TechCrunchLatestNews {
    private static TechCrunch_1 tCrunch_1;
    private static WebDriver driver;
    public static String url = "https://techcrunch.com/";
    int expectedElementNumber = 20;
    @BeforeClass
    public static void start() {
        //System.setProperty("webdriver.chrome.driver", "/Users/ridvantaskiran/Downloads/chromedriver_mac64/chromedriver");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        tCrunch_1 = new TechCrunch_1(driver);
    }
    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }
    @Test
    public void articleNumberVerification() {
        int articleNumbers = tCrunch_1.articleCount();
        assertEquals(expectedElementNumber, articleNumbers);
    }
    @Test
    public void authorNumberVerification() {
        int authorNumbers = tCrunch_1.authorCount();
        assertEquals(expectedElementNumber, authorNumbers);
    }
    @Test
    public void imageNumberVerification() {
        int imageNumbers = tCrunch_1.imageCount();
        assertEquals(expectedElementNumber, imageNumbers);
    }
}