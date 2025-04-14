package US_408;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TC_01_Elements {
    public TC_01_Elements() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(id = "username")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "Inpatient Ward")
    public WebElement inpatientWard;

    @FindBy(id = "loginButton")
    public WebElement loginBTN;

    @FindBy(id = "coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension")
    public WebElement findPatientRecord;

    @FindBy(id = "patient-search-results-table_info")
    public WebElement dataTables;

    @FindBy(css = "[aria-live='polite'] tr")
    public List<WebElement> table;
}
