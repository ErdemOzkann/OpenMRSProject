package US_407;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_01_Negative extends BaseDriver {

    @Test(dataProvider = "Data1", groups = {"Smoke", "PatientManagement"})
    public void Test(String username, String password) {

        As_a_Admin_Login_Accaount(username, password);
        Find_And_Delete_User();

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
    @DataProvider
    Object[] Data1() {
        Object[][] data1 = {{"Admin", "Admin123"}};
        return data1;
    }

    public void Find_And_Delete_User() {
        TC_01_Elements elements = new TC_01_Elements();
        elements.findPatientRecord.click();
        elements.searchBtn.sendKeys("test1");
        elements.firstPatient.click();
        elements.deletePatiens.click();
        wait.until(ExpectedConditions.visibilityOf(elements.deleteReason));
        elements.deleteReason.sendKeys("?!1"); // burada rakam veya ozel isaret girdigimizde de ayni sekilde hastayi silebiliyoruz.
        //Örnek Silme Sebepleri:
        //Gizlilik
        //Hatalı Bilgi
        //İlişkilendirme Hatası
        //Vefat: Decease
        //Hasta Talebi
        //Hukuki Gerekçe
        //Güvenlik İhlali
        //Veritabanı Sorunu

        //  Yukarida da belirtildigi gibi ornek silme sebepleri bulunmaktadir.
        // Fakat herhangi ozel karakter veya integer girdi dahi olsa hasta basari ile silinmektedir.

        wait.until(ExpectedConditions.elementToBeClickable(elements.confirmDelete));
        elements.confirmDelete.click();

        Assert.assertEquals(elements.successfulDelete.getText(), "Patient has been deleted successfully");

        // Sonuc olarak bu test basarisiz olmasi gerek ama hasta basarili bir sekilde silindi
    }
}
