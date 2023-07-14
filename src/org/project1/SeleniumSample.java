package org.project1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumSample {
	public static Robot r;

	public static void main(String[] args) {
		// 1.configuration
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\jayaselvamjai\\eclipse-workspace\\VishnuSelenium\\Drivers\\chromedriver.exe");
		// 2.instanticiation
		WebDriver driver = new ChromeDriver();
		// 3.launch url
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("iphone 14" + Keys.ENTER);
		WebElement iphone = driver.findElement(By.xpath("//span[contains(text(),'Apple iPhone')]"));
		Actions a = new Actions(driver);
		a.moveToElement(iphone).contextClick().perform();
		try {
			r = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < 6; i++) {
			r.keyPress(KeyEvent.VK_UP);

			r.keyRelease(KeyEvent.VK_UP);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		String parentID = driver.getWindowHandle();
		System.out.println("Parent WIndow ID....\n" + parentID);
		Set<String> allids = driver.getWindowHandles();
		System.out.println("All WIndow ID....\n" + allids);
		/*
		 * for (String id : allids) { if (!parentID.equals(allids)) {
		 * driver.switchTo().window(id); } }
		 */
		List<String> ids = new ArrayList<>();
		ids.addAll(allids);
		System.out.println(ids.addAll(allids));
		String childWindow = ids.get(1);
		System.out.println(childWindow);
		driver.switchTo().window(childWindow);
		WebElement iphoneText = driver.findElement(By.xpath("//span[contains(text(),' Apple iPhone 12, 64GB, Black')]"));
		String text = iphoneText.getText();
		System.out.println("IphoneText....\n"+text);
		
		

	}

}
