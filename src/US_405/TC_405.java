package US_405;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class TC_405 extends BaseDriver {

    @Test(dataProvider = "data" , groups = {"Smoke"})
    public void MyAccount(String username, String password) {
        TC_405_Elements elements = new TC_405_Elements();
        LogTutma.info("TC_01 MyAccount Test Basladi.");

        driver.get("https://o2.openmrs.org/openmrs/login.htm");
        MyFunc.Bekle(2);

        elements.UserName.sendKeys(username);
        elements.Password.sendKeys(password);

        List<WebElement> loc = elements.Locations;
        int rnd = (int) (Math.random() * loc.size());

        elements.Locations.get(rnd).click();
        elements.Login.click();
        new Actions(driver).moveToElement(elements.AccountIcon).build().perform();

        elements.MyAccount.click();
        elements.ChangePassword.click();
        new Actions(driver).moveToElement(elements.AccountIcon).build().perform();

        elements.MyAccount.click();
        elements.MyLanguages.click();

        LogTutma.info("TC_01 MyAccount Test Bitti.");

    }
    @DataProvider
    Object[] data(){
        Object[][] data = {{"Admin", "Admin123"}};
        return data;
    }
}
