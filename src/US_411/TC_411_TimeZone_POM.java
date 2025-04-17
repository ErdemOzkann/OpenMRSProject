package US_411;

import US_410.TC_410_InCorrect_TimeZone_Elementleri;
import Utility.BaseDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_411_TimeZone_POM extends BaseDriver {


    @Test(dataProvider = "datalarim", groups = {"Regression", "Appointment"})
    public void TimeZone(String username, String password, String patientname){

        LogTutma.info("TimeZone testi basladi");
        TC_410_InCorrect_TimeZone_Elementleri tz = new TC_410_InCorrect_TimeZone_Elementleri();

        driver.get("https://o2.openmrs.org/openmrs/login.htm");

        tz.username.sendKeys(username);
        tz.password.sendKeys(password);
        tz.inpatientWard.click();
        tz.loginButton.click();
        tz.appointmentScheduling.click();
        tz.manageAppointments.click();
        tz.searchName.sendKeys(patientname);
        tz.selectPatient.click();

        Assert.assertFalse(tz.timeZoneMsg.getText().contains("Your computer is not set to the right time zone. "),"Saat dilimi hatasi alindi!");

        LogTutma.info("TimeZone testi bitti");
    }

    @DataProvider
    Object[] datalarim(){
        Object[][] bilgiler={{"Admin","Admin123","Johan Cruijff"}};

        return bilgiler;
    }
}
