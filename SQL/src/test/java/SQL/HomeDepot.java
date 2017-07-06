package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class HomeDepot {
  @Test
  public void test() throws InterruptedException, SQLException {
	  ChromeDriverManager.getInstance().setup();
	  WebDriver driver = new ChromeDriver();
	  driver.get("http://www.homedepot.com/");
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  
	  driver.findElement(By.id("headerMyAccountTitle")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath(".//*[@id='authSignIn']/span/a")).click();
	  Thread.sleep(3000);
	  boolean TestPresent = driver.findElement(By.id("dual-signin__headerText")).isDisplayed();
	  Assert.assertTrue(TestPresent);
	  
	  String data = null;
	  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/justtest","root","root");
	  Statement stmt = conn.createStatement();
	  ResultSet rs = stmt.executeQuery("select * from homedepot_signin");
	  while(rs.next()){
		 data = rs.getString(1);
	  }
	  conn.close();
	  }
	  

}
