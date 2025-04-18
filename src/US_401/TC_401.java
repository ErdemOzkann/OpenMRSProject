package US_401;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TC_401 extends BaseDriver {

    @Test(dataProvider = "Data", groups = {"Smoke", "Login"})
    public void Test1(String username, String password) {
        TC_401_Elements elements = new TC_401_Elements();
        LogTutma.info("TC_01 Başladı");

        driver.get("https://openmrs.org");
        elements.demo.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,600)");

        MyFunc.Bekle(2);
        elements.explore.click();
        MyFunc.Bekle(2);

        elements.explore2.click();
        MyFunc.Bekle(2);
        elements.username.sendKeys(username);
        elements.password.sendKeys(password);
        elements.login.click();

        Assert.assertTrue(elements.location.getText().contains("You must choose a location!"));

        elements.inpatient.click();
        elements.username.clear();
        elements.password.clear();
        MyFunc.Bekle(2);

        elements.username.sendKeys(username);
        elements.password.sendKeys(password);
        elements.login.click();

        Assert.assertTrue(elements.error.getText().contains("Invalid username/password. Please try again."));

        LogTutma.info("TC_01 Tamamlandı");

    }

    @DataProvider
    Object[] Data() {
        Object[][] data = {{"Gamze", "1234"}, {"Gmze", "2s321"}, {"", ""}, {"", ""}, {"", ""}};
        return data;
    }
}
