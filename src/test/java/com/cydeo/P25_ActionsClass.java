package com.cydeo;

import com.utility.Driver;
import com.utility.Sleep;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class P25_ActionsClass {

   @Test
   public void hoverOver() {

      WebDriver driver = Driver.getDriver();

      Actions actions = new Actions(driver);

      driver.get("http://practice.cybertekschool.com/hovers");

      WebElement pic1 = driver.findElement(By.xpath("(//div[@class='figure'])[1]"));
      WebElement pic2 = driver.findElement(By.xpath("(//div[@class='figure'])[2]"));
      WebElement pic3 = driver.findElement(By.xpath("(//div[@class='figure'])[3]"));

      WebElement user1 = driver.findElement(By.xpath("//h5[.='name: user1']"));
      WebElement user2 = driver.findElement(By.xpath("//h5[.='name: user2']"));
      WebElement user3 = driver.findElement(By.xpath("//h5[.='name: user3']"));

      actions.moveToElement(pic1).perform();

      System.out.println("user1.isDisplayed = " + user1.isDisplayed());

      actions.moveToElement(pic2).pause(2000).moveToElement(pic3).pause(3000).perform();

      System.out.println("user2.isDisplayed() = " + user2.isDisplayed());

      System.out.println("user3.isDisplayed() = " + user3.isDisplayed());

      Driver.closeBrowser();

   }

   @Test
   public void dragAndDrop() {

      WebDriver driver = Driver.getDriver();

      Actions actions = new Actions(driver);

      driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

      WebElement smallCircle = driver.findElement(By.xpath("//div[@id='draggable']"));
      WebElement bigCircle = driver.findElement(By.xpath("//div[@id='droptarget']"));

      //actions.dragAndDrop(smallCircle, bigCircle).perform();

      /*
         actions.clickAndHold(smallCircle).perform();
         actions.release(bigCircle).perform();
      */

      actions.moveToElement(smallCircle)
              .clickAndHold().pause(2000)
              .moveToElement(bigCircle).pause(2000)
              .release().pause(2000)
              .perform();

      WebElement message = driver.findElement(By.xpath("//div[.='You did great!']"));
      System.out.println("message.isDisplayed() = " + message.isDisplayed());

   }

   @Test
   public void keyboardActions() {

      WebDriver driver = Driver.getDriver();

      Actions actions = new Actions(driver);

      driver.get("https://google.com");

      WebElement searchBox = driver.findElement(By.name("q"));

      actions.click(searchBox).pause(2000)
              .keyDown(Keys.SHIFT)
              .sendKeys("typing by holding down shift").pause(2000)
              .keyUp(Keys.SHIFT)
              .sendKeys("typing after releasing shift").pause(2000)
              .keyDown(Keys.CONTROL).sendKeys("A").pause(2000)
              .keyUp(Keys.CONTROL).pause(2000)
              .sendKeys(Keys.BACK_SPACE)
              .perform();

   }

   @Test
   public void doubleClick() {

      WebDriver driver = Driver.getDriver();

      Actions actions = new Actions(driver);

      driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_ondblclick");

      driver.switchTo().frame("iframeResult");

      WebElement paragraph = driver.findElement(By.xpath("//p[.='Double-click this paragraph to trigger a function.']"));

      actions.doubleClick(paragraph).perform();

      WebElement resultParagraph = driver.findElement(By.xpath("//p[.='Hello World']"));

      Assert.assertTrue(resultParagraph.isDisplayed());
      System.out.println("resultParagraph.isDisplayed() = " + resultParagraph.isDisplayed());

   }

   @Test
   public void rightClick() {

      WebDriver driver = Driver.getDriver();

      Actions actions = new Actions(driver);

      driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_oncontextmenu");

      driver.switchTo().frame("iframeResult");

      WebElement area = driver.findElement(By.xpath("//div[@contextmenu='mymenu']"));

      //actions.moveToElement(area).contextClick().perform();
      actions.contextClick(area).perform();

      Sleep.sleep(2);
      driver.switchTo().alert().accept();

   }
}
