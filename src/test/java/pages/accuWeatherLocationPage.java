package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
/*---------------------------------------------------------------------------------------
    Created By : Arun Ganesh
    Date : 24-10-2021
    page object model class for AccuWeather location page
 */
public class accuWeatherLocationPage {
    public accuWeatherLocationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(how = How.XPATH, using = ".//h1[@class='header-loc']")
    public WebElement locationName;

    @FindBy(how = How.XPATH, using = ".//div[@class='cur-con-weather-card__panel']/*//div[@class='temp']")
    public  WebElement currentTempElement;
}
