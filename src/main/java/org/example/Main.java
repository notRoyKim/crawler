package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Main selTest = new Main();

        selTest.crawl();
    }

    private WebDriver driver;
    //private WebDriver driver1;

    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "C:\\Users\\22012\\IdeaProjects\\crawler\\chromedriver.exe";

    private String base_url;

    public Main() {
        super();

        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

        driver = new ChromeDriver();

        base_url = "https://www.hometax.go.kr/websquare/websquare.html?w2xPath=/ui/pp/index_pp.xml";
    }

    public void crawl() {

        try {
            driver.get(base_url);

            String defaultWindow = driver.getWindowHandle();

            driver.manage().timeouts().implicitlyWait(100000, TimeUnit.MILLISECONDS);
            driver.manage().window().maximize();

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,350)", "");

            driver.switchTo().frame("txppIframe");
            Thread.sleep(1000);

            /* 계산페이지 이동 */
            driver.findElement(By.xpath("//*[@id=\"prcpSrvcMenuA7\"]")).click();
            Thread.sleep(2000);

            driver.switchTo().frame("txppIframe");
            Thread.sleep(1000);

            driver.findElement(By.xpath("//*[@id=\"textbox1033\"]")).click();
            Thread.sleep(1000);
            /* 23년 계산페이지 이동 */
            driver.findElement(By.xpath("//*[@id=\"a_1905100000\"]")).click();
            Thread.sleep(5000);

            driver.findElement(By.xpath("//*[@id=\"btnTotaSnwAmt\"]")).click();
            Thread.sleep(1000);

            Set<String> s1= driver.getWindowHandles();
            for(String hwnd : s1) {
                driver.switchTo().window(hwnd);
            }

            Thread.sleep(1000);

            int pay_all = 26400000;
            int tax_already = 0;

            driver.findElement(By.xpath("//*[@id=\"input7001\"]")).sendKeys(String.valueOf(pay_all));
            Thread.sleep(10);
            driver.findElement(By.xpath("//*[@id=\"btnAmt\"]")).click();
            Thread.sleep(10);
            driver.findElement(By.xpath("//*[@id=\"input7507\"]")).sendKeys(String.valueOf(tax_already));
            driver.findElement(By.xpath("//*[@id=\"trigger52\"]")).click();
            Thread.sleep(500);

            driver.switchTo().window(defaultWindow);


        } catch (Exception e) {

            e.printStackTrace();

        } finally {
        }

    }

}