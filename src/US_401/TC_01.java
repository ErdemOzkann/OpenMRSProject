package US_401;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.print.DocFlavor;


public class TC_01 extends BaseDriver {

    @Test
    public void Test1() {
        TC_01_Elements elements = new TC_01_Elements();
        driver.get("https://openmrs.org/");
        elements.demo.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,600)");

        MyFunc.Bekle(2);
        elements.explore.click();
        MyFunc.Bekle(2);

        elements.explore2.click();
        MyFunc.Bekle(2);
        elements.username.sendKeys("Gamze");
        elements.password.sendKeys("1234");
        elements.login.click();

        Assert.assertTrue(elements.location.getText().contains("You must choose a location!"));

        elements.inpatient.click();
        elements.username.clear();
        elements.password.clear();
        MyFunc.Bekle(2);


        elements.username.sendKeys("Gamze");
        elements.password.sendKeys("1234");
        elements.login.click();


        Assert.assertTrue(elements.error.getText().contains("Invalid username/password. Please try again."));


    }
}
