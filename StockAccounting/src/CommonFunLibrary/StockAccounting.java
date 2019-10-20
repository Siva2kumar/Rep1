package CommonFunLibrary;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class StockAccounting
{
	WebDriver driver;
String res;
	//appLaunch
	
	public String appLaunch(String url)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sivakumar.y\\StockAccounting\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		//validation
		if (driver.findElement(By.id("username")).isDisplayed()) 
		{
			
			res="Pass";
		}else
		{
			
			res="Fail";
		}
		
		return res;
		
	}
	
	//appLogin
	public String appLogin(String username,String password)
	{
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("btnsubmit")).click();
		//validation
		if(driver.findElement(By.id("logout")).isDisplayed())
		{
			
			res="Pass";
		}else
		{
			
			res="Fail";
		}
		
		return res;
		
	}
	
	public String supplierCreation(String sName, String add, String city, String country, String cperson, String pno, String email, String monbno, String Notes) throws Throwable
	{
		
		driver.findElement(By.id("mi_a_suppliers")).click();
		driver.findElement(By.xpath("//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a/span")).click();
		String actual =driver.findElement(By.id("x_Supplier_Number")).getAttribute("value");
		System.out.println("actual:"+actual);
		driver.findElement(By.id("x_Supplier_Name")).sendKeys(sName);
		driver.findElement(By.id("x_Address")).sendKeys(add);
		driver.findElement(By.id("x_City")).sendKeys(city);
		driver.findElement(By.id("x_Country")).sendKeys(country);
		driver.findElement(By.id("x_Contact_Person")).sendKeys(cperson);
		driver.findElement(By.id("x_Phone_Number")).sendKeys(pno);
		driver.findElement(By.id("x__Email")).sendKeys(email);
		driver.findElement(By.id("x_Mobile_Number")).sendKeys(monbno);
		driver.findElement(By.id("x_Notes")).sendKeys(Notes);
		Actions actions =new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='btnAction']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='OK!']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[text()='OK'])[6]")).click();
		
		if(driver.findElement(By.xpath("//*[@id='ewContentColumn']/div[2]/div[2]/div/button")).isDisplayed())
			                            
		{
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id='ewContentColumn']/div[2]/div[2]/div/button/span")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("psearch")).clear();
			driver.findElement(By.id("psearch")).sendKeys(actual);
			Thread.sleep(3000);
			driver.findElement(By.id("btnsubmit")).click();
			
		}
		else
		{   Thread.sleep(3000);
		driver.findElement(By.id("psearch")).clear();
		driver.findElement(By.id("psearch")).sendKeys(actual);
		Thread.sleep(3000);
		driver.findElement(By.id("btnsubmit")).click();
		}
		
		driver.findElement(By.xpath("//*[@id='ewContentColumn']/div[2]/div[2]/div/button/span")).click();
		
		String exp = driver.findElement(By.xpath("//*[@id='el1_a_suppliers_Supplier_Number']/span")).getText();
		System.out.println("expected :"+ exp);
	if(exp.equals(actual))
	{
		res="Pass";
	}
	else
	{
		res="Fail";
	}
	return res;
		
	}
	
	//appLogout
	public void appLogout() throws Throwable
	{
		Thread.sleep(2000);
		driver.findElement(By.id("logout")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='OK!']")).click();
		Thread.sleep(2000);
		//validation
		if (driver.findElement(By.id("username")).isDisplayed()) 
		{
			
			res="Pass";
		}else
		{
			
			res="Fail";
		}
		
		System.out.println(res);
	}
	//appClose
	public void appClose()
	{
		driver.close();
	}
	
	public static void main(String[] args) throws Throwable
	{
		
		StockAccounting sa=new StockAccounting();
		sa.appLaunch("http://webapp.qedge.com");
		sa.appLogin("admin", "master");
		sa.supplierCreation("Samsung", "Ameerpet", "Hyd", "india", "Siva", "123456", "siva.kumar@gmail.com", "123456789", "Notes");
		sa.appLogout();
		sa.appClose();
		
		
		
	}
}

