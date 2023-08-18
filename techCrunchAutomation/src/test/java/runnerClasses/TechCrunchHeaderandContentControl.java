package runnerClasses;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import testCrunchClassFiles.TechCrunch_2;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

public class TechCrunchHeaderandContentControl {

    private static TechCrunch_2 tCrunch_2;
    private static WebDriver driver;
    public static String url = "https://techcrunch.com/";


    @BeforeClass
    public static void start() {
        System.setProperty("webdriver.chrome.driver","/Users/ridvantaskiran/Downloads/chromedriver_mac64/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        tCrunch_2  = new TechCrunch_2(driver);
    }

    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }
    @Test
    public void checkHeaders() {
        boolean Dnm= tCrunch_2.findHeader();
    }

    @Test
      public void checkLinks() {
        boolean isEqual = tCrunch_2.verifyLinksInNewsContent();
        assertEquals(true, isEqual);
    }
  }

