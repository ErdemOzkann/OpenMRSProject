package US_408;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TC_01 extends BaseDriver {

    @Test(dataProvider = "Data", groups = {"Regression", "PatientManagement"})
    public void TC_01(String username, String password) {
        TC_01_Elements elements = new TC_01_Elements();

        LogTutma.info("TC_01 Başladı");

        driver.get("https://o2.openmrs.org/openmrs/login.htm");
        MyFunc.Bekle(1);
        elements.userName.sendKeys(username);
        elements.password.sendKeys(password);
        elements.inpatientWard.click();
        elements.loginBTN.click();

        elements.findPatientRecord.click();
        String[] table = elements.dataTables.getText().split("of");
        int updtTable = Integer.parseInt(table[1].replaceAll("[^0-9]", ""));

        Assert.assertEquals(elements.table.size(), updtTable, "Bilgi ile satır sayısı uyuşmuyor");

        LogTutma.info("TC_01 Tamamlandı");

    }

    @DataProvider
    Object[] Data() {
        Object[][] data = {{"Admin", "Admin123"}};
        return data;
    }
}
