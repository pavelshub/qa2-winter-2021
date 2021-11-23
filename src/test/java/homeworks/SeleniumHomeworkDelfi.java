package homeworks;

import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SeleniumHomeworkDelfi {
    private Actions actions;
    private Assertions Assert;
    private WebDriver driver;
    private WebDriver browser;
    private final String HOME_PAGE_URL = "http://delfi.lv";
    private final By ACCEPT_COOKIES_BTN = By.xpath(".//button[@mode = 'primary']");
    private final By CLOSE_ADD = By.id("closeButton");
    private final By ARTICLE_TITLE = By.xpath(".//h1[@class = 'text-size-19 text-size-md-22 mb-0 mt-2 headline__title']");
    private final By PAGE_ARTICAL_TITLE = By.xpath(".//h1[@class = 'text-size-22 text-size-md-30 d-inline']");
    private final By ARTICAL_COMMENTS = By.xpath(".//a[@class = 'text-size-19 text-size-md-28 text-red-ribbon d-print-none']");
    private final By COMMENTS_TITLE = By.xpath(".//h1[@class = 'article-title']");
    //private final By ALL_MAIN_TITLES = By.xpath(".//h1[@class = 'headline__title']");

    @Test
    public void titleCompare() {

        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        browser = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        browser.manage().window().maximize();

        browser.get(HOME_PAGE_URL);
        wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIES_BTN));
        browser.findElement(ACCEPT_COOKIES_BTN).click();

/*
        browser.switchTo().frame(0);
        browser.findElement(CLOSE_ADD).click();
        browser.switchTo().defaultContent();
        */



        wait.until(ExpectedConditions.elementToBeClickable(ARTICLE_TITLE));

        WebElement firstTitle = browser.findElement(ARTICLE_TITLE);
        System.out.println(firstTitle.getText());
        String actualTitle = firstTitle.getText();
/*
        Actions actions = new Actions(browser);
        actions.moveToElement(firstTitle).click().build().perform();

 */



       wait.until(ExpectedConditions.elementToBeClickable(ARTICLE_TITLE));
       browser.findElement(ARTICLE_TITLE).click();


        WebElement secondTitle = browser.findElement(PAGE_ARTICAL_TITLE);
        System.out.println(secondTitle.getText());
        String expectedTitle = secondTitle.getText();
        Assert.assertEquals(actualTitle, expectedTitle);

        //WebElement pageComments = browser.findElement(ARTICAL_COMMENTS);
        wait.until(ExpectedConditions.elementToBeClickable(ARTICAL_COMMENTS));
        browser.findElement(ARTICAL_COMMENTS).click();
        WebElement thirdTitle = browser.findElement(COMMENTS_TITLE);
        System.out.println(thirdTitle.getText());
        String commentsTitle = thirdTitle.getText();
        Assert.assertEquals(actualTitle, expectedTitle, commentsTitle);

        browser.get(HOME_PAGE_URL);

/*
        browser.switchTo().frame(0);
        browser.findElement(CLOSE_ADD).click();
        browser.switchTo().defaultContent();

        wait.until(ExpectedConditions.elementToBeClickable(ALL_MAIN_TITLES));

 */


        List<WebElement> allTitles = browser.findElements(By.xpath(".//h1[contains(@class,'headline__title')]"));

        for (WebElement title : allTitles) {
             System.out.println(title.getText());
        }
    }

    @AfterEach
    public void closeBrowser() {
        browser.close();
    }

}