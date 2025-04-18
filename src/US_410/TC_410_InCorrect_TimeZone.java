package US_410;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_410_InCorrect_TimeZone extends BaseDriver {


    @Test
    public void test1(){

        driver.get("https://o2.openmrs.org/openmrs/login.htm");

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Admin123");

        WebElement ip = driver.findElement(By.id("Inpatient Ward"));
        ip.click();

        WebElement login = driver.findElement(By.id("loginButton"));
        login.click();

        WebElement appointmentScheduling = driver.findElement(By.xpath("(//*[@class='icon-calendar'])[2]"));
        appointmentScheduling.click();

        WebElement manageAppointments = driver.findElement(By.cssSelector("[id='appointmentschedulingui-manageAppointments-app']"));
        manageAppointments.click();

        WebElement searchName = driver.findElement(By.cssSelector("[id='patient-search']"));
        searchName.sendKeys("Johan Cruijff");

        WebElement selectPatient= driver.findElement(By.xpath("//*[text()='Johan Cruijff']"));
        selectPatient.click();

        WebElement timeZoneMsg=driver.findElement(By.cssSelector("[id='time-zone-warning']>:nth-child(1)>:nth-child(1)>:nth-child(2)"));
        Assert.assertTrue(timeZoneMsg.getText().contains("Your computer is not set to the right time zone. Please change to Coordinated Universal Time and then close and restart your browser to assure proper scheduling functionality."),"Boyle Bir Mesaj Bulunamadi");








    }

}
