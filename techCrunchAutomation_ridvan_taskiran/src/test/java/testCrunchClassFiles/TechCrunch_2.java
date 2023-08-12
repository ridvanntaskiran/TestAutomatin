package testCrunchClassFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TechCrunch_2 {
    private WebDriver driver;
    public TechCrunch_2(WebDriver driver) {
        this.driver = driver;
    }
    public String getTitle() {
        return this.driver.getTitle();
    }

    private void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", element);
    }

    public boolean findHeader() {
        WebElement header = driver.findElement(By.cssSelector("div:nth-child(3) > div > div > div > article:nth-child(1) > header > h2 > a"));
        scrollToElement(driver, header);
        driver.findElement(By.cssSelector("div:nth-child(3) > div > div > div > article:nth-child(1) > header > h2 > a")).click();
        String title = getTitle();

        String[] parts = title.split("\\|");
        String first_section = parts[0].trim();
        //System.out.println("article header is:"+title);
        //System.out.println("webPage header is:"+first_section);
        return first_section.equals(title.trim());
    }

        public List<String> getLinksInNewsContent() {
            List<String> listOfLinks = new ArrayList<>();

            List<WebElement> elementsWithHref = driver.findElements(By.xpath("//div[@class='article-content']/p/*[@href]"));

            for (WebElement element : elementsWithHref) {
                String href = element.getAttribute("href");
                listOfLinks.add(href);
            }
            return listOfLinks;
        }

    public boolean verifyLinksInNewsContent() {
        List<String> listOfLinks = getLinksInNewsContent();
        int expectedLinkCount=5;
        //System.out.println("link sayısı:"+listOfLinks.size());
        return listOfLinks.size() == expectedLinkCount;
    }
}




