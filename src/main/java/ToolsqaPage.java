import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ToolsqaPage {
    protected WebDriver driver;

    public ToolsqaPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}