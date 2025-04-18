package US_407;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_01_Login_Negative extends BaseDriver {

    // Burada ki Test te Kullanici adini buyuk kucuk fark etmeksizin yazdigimizda login oldugunu gordum.
    // Sonuc olarak bu sekil de giris yapmamasi gerek. Ama sonuc basarili bir sekilde sisteme giris yapildi.
    @Test(dataProvider = "Data4", groups = {"Smoke", "PatientManagement"})
    public void Test(String username, String password) {

        As_a_Admin_Login_Accaount(username, password);
    }
    @DataProvider
    Object[] Data4() {
        Object[][] data1 = {{"aDmIn", "Admin123"}}; // burada bir buyuk bir kucuk harfle kullanici adini girdim
        return data1;
    }
    public void As_a_Admin_Login_Accaount(String username, String password) {
        TC_01_Elements elements = new TC_01_Elements();
        driver.get("https://o2.openmrs.org/openmrs/login.htm");
        MyFunc.Bekle(1);
        elements.userName.sendKeys(username);
        elements.password.sendKeys(password);
        elements.inpatientWard.click();
        elements.loginBTN.click();
    }
}
