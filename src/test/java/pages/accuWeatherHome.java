package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class accuWeatherHome {
    public accuWeatherHome(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(how = How.NAME, using = "query")
    public WebElement accuWeathersearchLocation;

    @FindBy(how = How.XPATH, using = ".//div[@class='results-container']/div[1]")
    public  WebElement searchResultFirstOption;



}
