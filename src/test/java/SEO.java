import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.Command;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.Log;
import org.openqa.selenium.devtools.network.Network;

import java.util.Optional;

public class SEO {

    public static void main(String[] args) throws InterruptedException {
//        System.out.println();

        consoleLogs();
//        getstatus();
    }


    public static void consoleLogs() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\IntelliJ\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

//        FirefoxDriver driver = new FirefoxDriver();

        DevTools devTools = ((ChromeDriver) driver).getDevTools();

        devTools.createSession();
        System.out.println("HELLO");
        String message ="utag_data.seoPagetype";




        driver.get("https://www-qa2.autozone.com/batteries-starting-and-charging/battery");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        devTools.send(Log.enable());
        devTools.addListener(Log.entryAdded(), logEntry -> {
//            System.out.println("Request URL is : " + logEntry.asSeleniumLogEntry());
            System.out.println("Request URL is : " + logEntry.getSource().contains("utag_data.seoPageType"));
        });

    }

    public static void getstatus()
    {
        System.setProperty("webdriver.chrome.driver", "D:\\IntelliJ\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

//        FirefoxDriver driver = new FirefoxDriver();

        DevTools devTools = ((ChromeDriver)driver).getDevTools();

        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));

//        devTools.send(Network.getResponseBodyForInterception("https://qa-api.autozone.com/integrations/genesys/v1/StatLookup/stats/CurrentGroupAgentTargetState"));


        devTools.addListener(Network.requestWillBeSent(),
                entry ->{
                    System.out.println("Request URL is : " + entry.getRequest().getUrl());
                    System.out.println("Request Type is : " + entry.getRequest().getMethod());
//                    System.out.println("Request Response is : " + entry.getRedirectResponse().getStatus());
                }
        );
        driver.get("http://www.google.com/");
        driver.manage().window().maximize();
        driver.quit();
    }

}
