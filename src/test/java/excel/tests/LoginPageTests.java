package excel.tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.excel.lib.util.Xls_Reader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageTests {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.crmpro.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		
		WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
		WebElement password=driver.findElement(By.name("password"));
		//WebElement LoginBtn=driver.findElement(By.xpath("//input[@type='submit' and @value='Login' and @class='btn btn-small']"));
		
		
		
		Xls_Reader reader= new Xls_Reader("./src/main/java/com/excel/lib/util/Excel Worksheet.xlsx");
	    String sheetname="login1";
	    
	    int rowcount=reader.getRowCount(sheetname);
	    for(int rowNum=2; rowNum<=rowcount; rowNum++) {
	        String userid=reader.getCellData(sheetname, "UserName", rowNum);
	        String pwd=reader.getCellData(sheetname, "Password", rowNum);
	        
	        System.out.println(userid+ "      "+pwd);
	       
	        username.sendKeys(userid);
	        username.clear();
	        Thread.sleep(400);
	        
	        password.sendKeys(pwd);
	        password.clear();
	        
	        //clickElementByJs(LoginBtn,driver);
//			String homepagetitle=driver.getTitle();
//			System.out.println(homepagetitle);
//		    Assert.assertEquals("CRMPRO", homepagetitle);
			
	    	
	    }

	 	

		
	    driver.quit();

	}
	public static void clickElementByJs(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();",element);
	}


}
