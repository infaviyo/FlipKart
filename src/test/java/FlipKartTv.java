import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipKartTv {
static WebDriver driver;
@BeforeClass
public static void BrowserLunch() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\vetrivel\\eclipse-workspace\\FlipKart\\driver\\chromedriver.exe");
	driver= new ChromeDriver();
	driver.get("https://www.flipkart.com/");
	driver.manage().window().maximize();
	System.out.println("browserLunch");}
@Test
	public void m1() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("MiTv");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("click");}
	@Test
	public void m2() throws FileNotFoundException {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement MITV=driver.findElement(By.xpath("//div[@class='_4rR01T'][1]"));	
		String TV = MITV.getText();
		File file = new File(".//target/MITv.xlxs");
		FileOutputStream f =new FileOutputStream(file);
		HSSFWorkbook w=new HSSFWorkbook();
		HSSFSheet s = w.createSheet("Tvdetails");
		HSSFRow row = s.createRow(0);
		HSSFCell cell = row.createCell(0);
		cell.setCellValue(TV);
		System.out.println("GetText");}
	@Test
	public void m3() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='_4rR01T'][1]")).click();	
		String mi = driver.getWindowHandle();
		Set<String> mobile = driver.getWindowHandles();
		for(String x :mobile) {
			if(!x.equals(mi)) {
		driver.switchTo().window(x);}}
		System.out.println("Window");}
	@AfterClass
public static void ScreenShot() throws IOException {
			
		TakesScreenshot tk = (TakesScreenshot)driver;
		File s = tk.getScreenshotAs(OutputType.FILE);
		File t = new File("C:\\Users\\vetrivel\\eclipse-workspace\\FlipKart\\ScreenShot\\FlipKart.png");
		FileUtils.copyFile(s, t);
	System.out.println("ScreenShot");
	
		
		
		
		
		}
		
		

	
}

