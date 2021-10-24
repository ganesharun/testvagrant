package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
/*---------------------------------------------------------------------------------------
    Created By : Arun Ganesh
    Date : 24-10-2021
    page object model class for AccuWeather home
 */
public class accuWeatherHome {
    public accuWeatherHome(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(how = How.NAME, using = "query")
    public WebElement accuWeathersearchLocation;

    @FindBy(how = How.XPATH, using = ".//div[@class='results-container']/div[1]")
    public  WebElement searchResultFirstOption;



}
