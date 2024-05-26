package task20;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Q2SignUpAndLoginForGuvi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.guvi.in/");

		driver.findElement(By.xpath("//div[@id='accountGroup']//child::a[text()='Sign up']")).click();
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("User");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("sptest@test1.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Test@123");
		driver.findElement(By.xpath("//input[@id='mobileNumber']")).sendKeys("9876543211");
		driver.findElement(By.id("signup-btn")).click();

		WebElement profile = driver.findElement(By.xpath("//select[@id='profileDrpDwn']"));
		Select profileSelect = new Select(profile);
		profileSelect.selectByVisibleText("Student");

		WebElement degree = driver.findElement(By.xpath("//select[@id='degreeDrpDwn']"));
		Select degreeSelect = new Select(degree);
		degreeSelect.selectByValue("B.E. / B.Tech. Computer Science");

		driver.findElement(By.xpath("//input[@id='year']")).sendKeys("2015");
		driver.findElement(By.xpath("//a[text()='Submit']")).click();
		driver.findElement(By.xpath("//a[@class='navbar-guvilogo-black']")).click();
		driver.findElement(By.xpath("//div[@id='accountGroup']//child::a[text()='Login']")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("sptest@test1.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Test@123");
		driver.findElement(By.xpath("//a[@id='login-btn']")).click();

		String expectedTitle = "GUVI | courses";
		String actualTitle = driver.getTitle();
		if (expectedTitle.contentEquals(actualTitle)) {
			System.out.println("User is logged in successfully");
		} else {
			System.out.println("email activation pending");
		}
		driver.quit();
	}

}

Output:
May 26, 2024 11:17:53 PM org.openqa.selenium.devtools.CdpVersionFinder findNearestMatch
WARNING: Unable to find an exact match for CDP version 125, returning the closest version; found: 122; Please update to a Selenium version that supports CDP version 125
email activation pending
