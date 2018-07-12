import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends ToolsqaPage{

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#primary-menu > li.menu-item.menu-item-type-custom.menu-item-object-custom.menu-item-has-children.menu-item-17611.has-children > a > span.text-wrap > span > span")
    private WebElement demoSites;

    @FindBy(css = "#primary-menu > li.menu-item.menu-item-type-custom.menu-item-object-custom.menu-item-has-children.menu-item-17611.has-children > ul > li.menu-item.menu-item-type-post_type.menu-item-object-page.menu-item-23300 > a > span.text-wrap > span > span")
    private WebElement iframePracticePage;

    public IframePage openIframeDemoPage(String linkText) {
        Actions action = new Actions(driver);
        action.moveToElement(demoSites).perform();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(iframePracticePage));
        driver.findElement(By.linkText(linkText)).click();
        return new IframePage(driver);
    }


}
