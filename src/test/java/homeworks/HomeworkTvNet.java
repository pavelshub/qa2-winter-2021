package homeworks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomeworkTvNet {
    private WebDriver browser;
    private Assertions Assert;
    private final String HOME_PAGE_URL = "http://tvnet.lv";
    private final By ARTICLE_TITLE = By.xpath(".//span[@itemprop = 'headline name']");
    private final By PAGE_ARTICAL_TITLE = By.xpath(".//h1[@itemprop = 'headline name']");
    private final By ACCEPT_COOKIES_BTN = By.xpath(".//button[@mode = 'primary']");
    private final By PAGE_COMMENTS = By.xpath(".//span[@class = 'article-share__item--count']");
    private final By COMMENTS = By.xpath(".//div[@class = 'article-comment-content']");
    private final By COMMENTS_MAIN_PAGE = By.xpath(".//span[@class = 'list-article__comment section-font-color']");
    private int titleIndex = 8;

    @Test
    public void titlePrint (){

        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        browser = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        browser.manage().window().maximize();
        browser.get(HOME_PAGE_URL);
        // 1 uzdevums

        List<WebElement> titles = browser.findElements(ARTICLE_TITLE);
        System.out.println(titles.get(titleIndex).getText());
        String actualTitle = titles.get(titleIndex).getText();

        wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIES_BTN));
        browser.findElement(ACCEPT_COOKIES_BTN).click();

        String pageComments = titles.get(titleIndex).findElement(COMMENTS_MAIN_PAGE).getText();

        //pageComments.click();
        // page comments in title
        String b = pageComments.replace("(","");
        b = b.replace(")","");

        int a =  Integer.parseInt(b);
        System.out.println(a);

        titles.get(titleIndex).click();

        WebElement secondTitle = browser.findElement(PAGE_ARTICAL_TITLE);
        System.out.println(secondTitle.getText());
        String expectedTitle = secondTitle.getText();
        //Assert.assertEquals(actualTitle, expectedTitle,"Title is not correct!!!");

        //2 uzdevums, strada ar titles ar komentariem

        Assert.assertTrue(actualTitle.contains(expectedTitle),"Title is not correct!!");

        //wait.until(ExpectedConditions.invisibilityOfElementLocated(".//div[@class='fc-dialog-container']"));


        browser.findElement(PAGE_COMMENTS).click();

        List<WebElement> comments = browser.findElements(COMMENTS);
        int i =0;
        for (WebElement comment : comments) {
            i++;
        }
        System.out.println(i);

        if (a==i) {
            System.out.println("Comments quantity is equal!");
        }

        browser.get("http://inbox.lv");

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//div[@class='fc-dialog-container']")));







    }
//    @AfterEach
//    public void closeBrowser() {
//        browser.close();
//    }
}
