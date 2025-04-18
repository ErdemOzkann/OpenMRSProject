package US_409;

import US_407.TC_407;
import Utility.BaseDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TC_409 extends BaseDriver {


    @Test(dataProvider = "Data3", groups = {"Smoke", "PatientManagement"})
    public void Test(String username, String password) {

        TC_407 login = new TC_407();

        login.As_a_Admin_Login_Accaount(username, password);
        registerPatient_And_Merge_Patient();

    }
    @DataProvider
    Object[] Data3() {
        Object[][] data1 = {{"Admin", "Admin123"}};
        return data1;
    }
    public void registerPatient_And_Merge_Patient () {
        TC_409_Elements elements = new TC_409_Elements();

        List<String> patientIDs = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            elements.registerPatient.click();
            elements.givenName.sendKeys("test1" + Keys.TAB + Keys.TAB + "test1");
            elements.nextBtn.click();
            wait.until(ExpectedConditions.visibilityOf(elements.gender));
            Select select = new Select(elements.gender);
            select.selectByValue("M");
            elements.nextBtn.click();
            elements.birthDay.sendKeys("22");
            Select select1 = new Select(elements.birthMonth);
            select1.selectByValue("4");
            elements.birthYear.sendKeys("1968");
            elements.nextBtn.click();
            elements.address1.sendKeys("asd" + Keys.TAB + "dff" + Keys.TAB + "asds" + Keys.TAB + "dffaf" + Keys.TAB + "Mars" + Keys.TAB + "153");
            elements.nextBtn.click();
            elements.nextBtn.click();
            elements.nextBtn.click();
            elements.confirmBtn.click();

            String patientID = elements.patientID.getText();
            patientIDs.add(patientID);
            System.out.println("Patient " + (i + 1) + " ID = " + patientID);
            System.out.println("patientIDs = " + patientIDs);

            driver.get("https://o2.openmrs.org/openmrs/index.htm");
        }
        elements.dataMngBtn.click();
        elements.mergePatientBtn.click();
        elements.firstIDWrite.sendKeys(patientIDs.get(0));
        elements.secondIDWrite.sendKeys(patientIDs.get(1));
        elements.forContinue.click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.continueBtn));
        elements.continueBtn.click();
        elements.firstPatient.click();
        elements.continueBtn.click();

        String firstID = elements.firstPatientID.getText().trim();
        String secondID = elements.secondPatientID.getText().trim();

        Assert.assertEquals(firstID,patientIDs.get(1));
        Assert.assertEquals(secondID,patientIDs.get(0));
    }
}
