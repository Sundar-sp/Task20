package task20;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q1Calender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://jqueryui.com/datepicker/");
		driver.switchTo().frame(0);

		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		driver.findElement(By.xpath("//span[text()='Next']")).click();

		String expectedDate = "22";
		WebElement table = driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//child::tbody"));
		List<WebElement> data = table.findElements(By.tagName("td"));
		for (WebElement temp : data) {
			if (expectedDate.equals(temp.getText())) {
				System.out.println("Selected date is " + temp.getText());
				temp.click();
			}
		}
		driver.quit();
	}

}

Output:
May 26, 2024 11:21:21 PM org.openqa.selenium.devtools.CdpVersionFinder findNearestMatch
WARNING: Unable to find an exact match for CDP version 125, returning the closest version; found: 122; Please update to a Selenium version that supports CDP version 125
Selected date is 22

