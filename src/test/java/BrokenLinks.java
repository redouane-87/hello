
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

    public class BrokenLinks {
        WebDriver driver;
        @Test
        public void findLinks() {
            System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
            String URL="http://demo.guru99.com/test/newtours/";
            driver.manage().window().maximize();
            String underConsTitle = "Under Construction: Mercury Tours";
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            driver.get(URL);
            List<WebElement> links = driver.findElements(By.tagName("a"));
            System.out.println(links.size());
            String[] linkTexts = new String[links.size()];
            int					i = 0;
            System.out.println("hello");
            //extract the link texts of each link element
            for (WebElement e : links) {
                linkTexts[i] = e.getText();
                i++;
            }
            System.out.println(linkTexts);
            //test each link
            for (String t : linkTexts) {
                if (t.length() > 0) {
                    driver.findElement(By.partialLinkText(t)).click();
                    if (driver.getTitle().equals(underConsTitle)) {
                        System.out.println("\"" + t + "\""
                                + " is under construction.");

                    } else {
                        System.out.println("\"" + t + "\""
                                + " is working.");

                    }


                }

            }


            driver.quit();


        }

    }




