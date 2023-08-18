package testCrunchClassFiles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.NoSuchElementException;
public class TechCrunch_1 {
    private WebDriver driver;
    public TechCrunch_1(WebDriver driver) {
        this.driver = driver;
    }
    public int articleCount() {
        try {
            List<WebElement> listOfArticles = driver.findElements(By.xpath("//article[@class='post-block post-block--image post-block--unread']"));
            List<WebElement> listOfArticles_2 = driver.findElements(By.xpath("//article[@class='post-block post-block--featured post-block--unread']"));
            List<WebElement> listOfArticles_3 = driver.findElements(By.xpath("//article[@class='post-block post-block--featured post-block--unread post-block--premium-content']"));
            List<WebElement> listOfArticles_4 = driver.findElements(By.xpath("//article[@class='post-block post-block--image post-block--unread post-block--premium-content']"));
            //int countOfArticles = listOfArticles.size();
            return listOfArticles.size() + listOfArticles_2.size() + listOfArticles_3.size() + listOfArticles_4.size();
        } catch (NoSuchElementException e) {
            System.out.println("Articles cannot found on the page!");
            return 0;
        }
    }
    public int authorCount() {
        try {
            List<WebElement> listOfAuthors = driver.findElements(By.className("river-byline__authors"));
            //int countOfAuthors= listOfAuthors.size();
            return listOfAuthors.size();
        } catch (NoSuchElementException e) {
            System.out.println("Authors cannot found on the page!");
            return 0;
        }
    }
    public int imageCount() {
        try {
            List<WebElement> listOfImages = driver.findElements(By.className("post-block__footer"));
            // int countOfImages= listOfImages.size();
            return listOfImages.size();
        } catch (NoSuchElementException e) {
            System.out.println("Images cannot found on the page!");
            return 0;
        }
    }
}