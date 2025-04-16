package US_405;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class TC_01 extends BaseDriver {

    @Test(groups = {"Smoke"})
    public void MyAccount() {
        TC_01_Elements elements = new TC_01_Elements();
        LogTutma.info("TC_01 MyAccount Test Basladi.");

        driver.get("https://o2.openmrs.org/openmrs/login.htm");
        MyFunc.Bekle(2);

        elements.UserName.sendKeys("admin");
        elements.Password.sendKeys("Admin123");

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
}
