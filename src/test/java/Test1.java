import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 {


    @Test
    public void test1()
    {
        System.out.println("Hello");
        System.setProperty("webdriver.chrome.driver", "D:\\IntelliJ\\drivers\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();

            WebDriver driver = new ChromeDriver();
            driver.get("https://www.google.com/");
            driver.manage().window().maximize();
            String url = driver.getTitle();
        Assert.assertEquals(url,url);
        System.out.println("Title of the Page : " + url);
        driver.quit();
    }


}
