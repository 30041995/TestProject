package AutoMateCase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjectModel.PageClass;

public class Tests {
	
	

	WebDriver driver;
	PagesClass pgc;
	@BeforeSuite
	public void Browserlonch() {
		 System.setProperty("webdriver.chrome.driver", "D:\\driver\\chromedriver_win32\\chromedriver.exe");
		  
			driver=new ChromeDriver();
			  
			  driver.navigate().to("http://practice.automationtesting.in/test-cases/");
			  driver.manage().window().maximize();
			  pgc=new PagesClass(driver);
			  
			  /*Dimension di=new Dimension(700, 700);
			  
			  driver.manage().window().setSize(di);
			  
			  System.out.println(di.getHeight());
			  System.out.println(di.getWidth());
			
			 Point p=new Point(100, 100);
			 
			  driver.manage().window().setPosition(p);*/
	}

	@Test(dataProvider="data",priority=1)
	  public void login(String value,String value1) {
		
		WebElement myaccount=driver.findElement(By.linkText("My Account"));
		myaccount.click();
		
		//System.out.println(myaccount.isSelected());
		
		WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
		username.sendKeys(value);
		
		WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys(value1);
		
		WebElement button=driver.findElement(By.xpath("//input[@name='login']"));
				button.click();
				
				driver.findElement(By.linkText("Sign out")).click();
				
		  System.out.println("paramter pass through data provider  "+ value+" "+value1);
	  }
	
	@Test(priority=2)
	public void back() {
		driver.navigate().back();
		driver.findElement(By.xpath("//img[@title='Automation Practice Site']")).click();
		driver.quit();
	}
	
	
	 @DataProvider (name="data")
	 public String[][] getdata() throws IOException {
		 String path=System.getProperty("user.dir")+ "\\"+"\\data.xlsx";
			
			File files=new File(path);
			
			FileInputStream fis=new FileInputStream(files);
			
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			
			XSSFSheet sheet=wb.getSheetAt(1);
			int row=sheet.getPhysicalNumberOfRows();
			
			System.out.println(row);
			String[][]data=new String[row][2];
			
				for (int i=0; i<row;i++) {
					for(int j=0;j<2;j++) {
						
					
					String excelValue=sheet.getRow(i).getCell(j).getStringCellValue();
					data[i][j]=excelValue;
				}}
				return data;
			
	 }
	
}
