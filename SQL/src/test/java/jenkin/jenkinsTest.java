package jenkin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import junit.framework.Assert;

public class jenkinsTest {
	WebDriver driver = null;
  @Test
  public void jk() {
	  ChromeDriverManager.getInstance().setup();
	  driver = new ChromeDriver();
	  driver.get("https://online.citi.com/US/login.do");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  String ActualTitle = driver.getTitle();
	  String ExpectedTitle = "Banking with Citi | Citi.com";
	  Assert.assertEquals(ActualTitle, ExpectedTitle);
	  System.out.println(ActualTitle);
	  driver.quit()
  }
}
