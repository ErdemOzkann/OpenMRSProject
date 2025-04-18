package US_403;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_403 extends BaseDriver {

    @Test(dataProvider = "Logout", groups = {"Logout", "Smoke"})
    public void TC_01(String username, String password) {
        TC_403_Elements elements = new TC_403_Elements();

        LogTutma.info("TC_01 Başladı");

        driver.get("https://o2.openmrs.org/openmrs/login.htm");
        MyFunc.Bekle(1);
        elements.userName.sendKeys("admin");
        elements.password.sendKeys("Admin123");
        elements.inpatientWard.click();
        elements.loginBTN.click();
        MyFunc.Bekle(1);
        elements.logoutBtn.click();
    }

    @DataProvider
    Object[] Logout() {
        Object[][] Logout = {{"admin", "Admin123"}};
        return Logout;
    }


}
