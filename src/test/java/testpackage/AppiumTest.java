package testpackage;


import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AppiumTest {

String appiumURL = "http://0.0.0.0:4723/wd/hub";


  @Test
  public void test01() throws InterruptedException, MalformedURLException {
 
DesiredCapabilities capabilities = new DesiredCapabilities();

capabilities.setCapability("platformName", "Android");
capabilities.setCapability("platformVersion", "12");
capabilities.setCapability("deviceName", "R52R705HLTA");
capabilities.setCapability("appPackage", "net.tecnotopia.SimpleCalculator");
capabilities.setCapability("appActivity", "net.tecnotopia.SimpleCalculator.SimpleCalculatorActivity");

AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL(appiumURL), capabilities);

Thread.sleep(2000);
AndroidElement ele0 = driver.findElement(By.xpath("//*[@text='OK']"));
ele0.click();
Thread.sleep(2000);
AndroidElement ele1 = driver.findElement(By.id("net.tecnotopia.SimpleCalculator:id/button1"));
ele1.click();

Thread.sleep(2000);

String expectedText = "1";
String actualText = driver.findElement(By.id("net.tecnotopia.SimpleCalculator:id/display")).getText();
Assert.assertEquals(expectedText, actualText);
System.out.println(actualText);

Thread.sleep(2000);
driver.closeApp();

 
  }
}
