package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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

        //System Property SetUp
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

        //Driver SetUp
        driver = new ChromeDriver();
        //driver1 = new ChromeDriver();

        base_url = "https://www.cgs.or.kr/business/esg_tab04.jsp";
        //base_url = "http://esg.cgs.or.kr/login/login.jsp";
    }

    public void crawl() {

        try {
            driver.get(base_url);
            /*
            driver.findElement(By.xpath("//*[@id=\"loginID\"]")).sendKeys("fstc");
            driver.findElement(By.xpath("//*[@id=\"loginPW\"]")).sendKeys("fst23841!@");

            driver.findElement(By.xpath("//*[@id=\"loginform\"]/button")).click();

            System.out.println("1 로그인 성공" + driver.getCurrentUrl());

            driver1.get(base_url);
            driver1.findElement(By.xpath("//*[@id=\"loginID\"]")).sendKeys("fstc");
            driver1.findElement(By.xpath("//*[@id=\"loginPW\"]")).sendKeys("fst23841!@");

            driver1.findElement(By.xpath("//*[@id=\"loginform\"]/button")).click();

            System.out.println("2 로그인 성공" + driver1.getCurrentUrl());

            driver.get("http://esg.cgs.or.kr/result/result_tab01.jsp?sel_esgCode=E&sel_regYear=2023");
            */





            //List<WebElement> elementList = driver.findElements(By.className("guide_btn"));

            //for(WebElement element : elementList) {
                driver.manage().timeouts().implicitlyWait(100000, TimeUnit.MILLISECONDS);
                /*
                String viewguide = element.getAttribute("onclick");
                String scd = viewguide.split("\'")[1];
                String vnum = viewguide.split("\'")[3];
                 */

                String url = "https://www.cgs.or.kr/business/esg_tab04.jsp?pg=1&pp=1035&skey=&svalue=&sfyear=2022&styear=2022&sgtype=&sgrade=#ui_contents";
                driver.navigate().to(url);
                //Thread.sleep(500);

                List<WebElement> elements = driver.findElements(By.cssSelector("body > div.fixed_bn > div.sub_business > div.business_view > div.rating-wrap > div.business_board > table > tbody > tr"));

                for(WebElement e : elements) {
                    /*System.out.print(driver1.findElement(By.xpath("/html/body/div/ol/li/em")).getText() + "|");
                    System.out.print(driver1.findElement(By.xpath("/html/body/div/ol/li")).getText().split("\n")[1] + "|");
                    System.out.print(" |");
                    System.out.print(" |");
                    System.out.print(" |");
                    System.out.print(driver1.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr[1]/td[1]")).getText() + "|");
                    System.out.print(driver1.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr[1]/td[2]")).getText() + "|");
                    System.out.print(driver1.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr[2]/td")).getText() + "|");
                    System.out.print(e.findElement(By.xpath(".//td[1]")).getText() + "|");
                    System.out.print(e.findElement(By.xpath(".//td[2]")).getText() + "|");
                    System.out.print(e.findElement(By.xpath(".//td[3]")).getText() + "|");
                    System.out.print(e.findElement(By.xpath(".//td[4]")).getText() + "|");
                    System.out.print(e.findElement(By.xpath(".//td[5]")).getText() + "|/n");
                     */
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