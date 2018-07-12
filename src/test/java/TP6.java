import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static net.bytebuddy.matcher.ElementMatchers.is;

public class TP6 {

    WebDriver driver;

    @Before
    public void init()
    {
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.get("http://toolsqa.com");
    }

    @After
    public void teardown()
    {
        driver.quit();
    }

    @Test
    public void testIframe()
    {
        HomePage homePage = new HomePage(driver);
        IframePage iframePage = homePage.openIframeDemoPage("IFrame practice page");
        Assert.assertTrue(iframePage.assertH1("Sample Iframe page"));
        Assert.assertTrue(iframePage.assertIframe1H1("Practice Automation Form"));
        Assert.assertTrue(iframePage.assertIframe2H1("Home"));
    }
}
