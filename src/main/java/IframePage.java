import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IframePage extends ToolsqaPage {
    public IframePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#content > h1")
    private WebElement textOrigin;

    @FindBy(css = "#content > div.vc_row.wpb_row.vc_row-fluid.dt-default > div > div > div > div.wpb_text_column.wpb_content_element > div > h1")
    private WebElement textOrigin2;

    @FindBy(css = "#post-9 > header > h1")
    private WebElement textOrigin3;

    public boolean assertH1(String linkText) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(textOrigin));
        return textOrigin.getText().equals(linkText);
    }

    public boolean assertIframe1H1(String linkText) {
        driver.switchTo().defaultContent();
        driver.switchTo().frame("iframe1");
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(textOrigin2));
        return textOrigin2.getText().equals(linkText);
    }

    public boolean assertIframe2H1(String linkText) {
        driver.switchTo().defaultContent();
        driver.switchTo().frame("iframe2");
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(textOrigin3));
        return textOrigin3.getText().equals(linkText);
    }
}
