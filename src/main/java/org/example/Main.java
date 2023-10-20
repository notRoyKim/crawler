package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Main selTest = new Main();

        selTest.crawl();
    }

    private WebDriver driver;
    //private WebDriver driver1;

    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "C:\\Users\\상우\\IdeaProjects\\untitled/chromedriver.exe";

    private String base_url;

    public Main() {
        super();

        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

        driver = new ChromeDriver();

        base_url = "https://esg.krx.co.kr/contents/02/02020000/ESG02020000.jsp";
    }

    public void crawl() {

        try {
            driver.get(base_url);

                driver.manage().timeouts().implicitlyWait(100000, TimeUnit.MILLISECONDS);

                String url = "https://esg.krx.co.kr/contents/02/02020000/ESG02020000.jsp";
                driver.navigate().to(url);

                Select year = new Select(driver.findElement(By.name("sch_yy")));

                year.selectByVisibleText("2023");

                driver.findElement(By.id("btnid8f14e45fceea167a5a36dedd4bea2543")).click();

                Thread.sleep(3000);

                for(int i=0 ; i<8 ; i++) {
                    for(int j = 0 ; j < 10 ; j++){
                        List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"gridtable6512bd43d9caa6e02c990b0a82652dca\"]/tbody/tr[1]"));
                        int n = 1;
                        for(WebElement e : elements) {
                            System.out.println((i*10 + j)*10 + n + "|");
                            System.out.print(e.findElement(By.xpath(".//td[1]")).getText() + "|");
                            System.out.print(e.findElement(By.xpath(".//td[2]/span")).getText() + "|");
                            System.out.print(e.findElement(By.xpath(".//td[3]/span")).getText() + "|");
                            System.out.print(e.findElement(By.xpath(".//td[4]/span")).getText() + "|");
                            System.out.print(e.findElement(By.xpath(".//td[5]/span")).getText() + "|");

                            System.out.print(e.findElement(By.xpath(".//td[6]/span")).getText() + "|");
                            System.out.print(e.findElement(By.xpath(".//td[7]/span")).getText() + "|");
                            System.out.print(e.findElement(By.xpath(".//td[8]/span")).getText() + "|");
                            System.out.print(e.findElement(By.xpath(".//td[9]/span")).getText() + "|");
                            System.out.print(e.findElement(By.xpath(".//td[10]/span")).getText() + "|");

                            n++;
                        }

                        System.out.println();
                    }
                }

                List<WebElement> elements = driver.findElements(By.cssSelector("body > div.fixed_bn > div.sub_business > div.business_view > div.rating-wrap > div.business_board > table > tbody > tr"));

                for(WebElement e : elements) {
                    System.out.print(e.findElement(By.xpath(".//td[1]/em")).getText() + "|");
                    System.out.print(e.findElement(By.xpath(".//td[2]")).getText() + "|");
                    System.out.print(e.findElement(By.xpath(".//td[3]")).getText() + "|");
                    System.out.print(e.findElement(By.xpath(".//td[4]")).getText() + "|");
                    System.out.print(e.findElement(By.xpath(".//td[5]")).getText() + "|");
                    System.out.print(e.findElement(By.xpath(".//td[6]")).getText() + "|");
                    System.out.print(e.findElement(By.xpath(".//td[7]")).getText() + "|");
                    System.out.print(e.findElement(By.xpath(".//td[8]")).getText() + "|");
                    System.out.print(e.findElement(By.xpath(".//td[9]")).getText() + "|/n");
                }







            //}


        } catch (Exception e) {

            e.printStackTrace();

        } finally {
        }

    }

}