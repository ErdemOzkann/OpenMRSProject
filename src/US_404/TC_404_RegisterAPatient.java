package US_404;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class TC_404_RegisterAPatient extends BaseDriver {

    @Test
    public void test1()
    {
        driver.get("https://o2.openmrs.org/openmrs/login.htm");

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("Admin");



        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Admin123");

        WebElement ip = driver.findElement(By.id("Inpatient Ward"));
        ip.click();

        WebElement login = driver.findElement(By.id("loginButton"));
        login.click();

        WebElement registerPatient=driver.findElement(By.xpath("(//*[@class='icon-user'])[2]"));
        registerPatient.click();

        WebElement firstName = driver.findElement(By.cssSelector("[name='givenName']"));
        firstName.sendKeys("Johan");


        WebElement familyName = driver.findElement(By.cssSelector("[name='familyName']"));
        familyName.sendKeys("Cruijff");

        WebElement nextBttn= driver.findElement(By.cssSelector("[id='next-button'] icon"));
        nextBttn.click();

        WebElement gender= driver.findElement(By.cssSelector("[id='gender-field']> :nth-child(1)"));
        gender.click();

        WebElement nextBttn2= driver.findElement(By.cssSelector("[id='next-button'] icon"));
        nextBttn2.click();

        WebElement birthDay= driver.findElement(By.id("birthdateDay-field"));
        birthDay.sendKeys("01");

        WebElement birthMonth= driver.findElement(By.cssSelector("[name='birthdateMonth']> :nth-child(2)"));
        birthMonth.click();

        WebElement birthYear= driver.findElement(By.cssSelector("[name='birthdateYear']"));
        birthYear.sendKeys("1950");

        WebElement nextBttn3= driver.findElement(By.cssSelector("[id='next-button'] icon"));
        nextBttn3.click();

        WebElement address= driver.findElement(By.id("address1"));
        address.sendKeys("Dam Square");

        WebElement city= driver.findElement(By.id("cityVillage"));
        city.sendKeys("Amsterdam");

        WebElement country= driver.findElement(By.id("country"));
        country.sendKeys("Netherlands");

        WebElement nextBttn4= driver.findElement(By.cssSelector("[id='next-button'] icon"));
        nextBttn4.click();

        WebElement patientPhoneNumber= driver.findElement(By.cssSelector("[name='phoneNumber']"));
        patientPhoneNumber.sendKeys("020123456");

        WebElement nextBttn5= driver.findElement(By.cssSelector("[id='next-button'] icon"));
        nextBttn5.click();

        WebElement relationType= driver.findElement(By.cssSelector("[id='relationship_type']> :nth-child(2)"));
        relationType.click();

        WebElement personName= driver.findElement(By.cssSelector("[placeholder='Person Name']"));
        personName.sendKeys("Nistelrooy");

        WebElement nextBttn6= driver.findElement(By.cssSelector("[id='next-button'] icon"));
        nextBttn6.click();

        WebElement confirm= driver.findElement(By.id("submit"));
        confirm.click();

//        WebElement ekranYazi=driver.findElements(By.xpath(""));
//        System.out.println("ekranYazi.getText() = " + ekranYazi.getText());
//        Assert.assertTrue("Boyle bir isim ve ID ile bir kayit yok" , ekranYazi.getText());

    }

}
