package Base_redbus;
	/// this is base class foe inizalization and environment variables
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Properties;
	import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class Base_class {
		
		
		public static WebDriver  wd;
		public static Properties  p;
		
		
		public Base_class(){
			
		
			try {
				 p = new Properties();
				
				
				FileInputStream 	fi = new FileInputStream("C:\\Users\\jithe\\Desktop\\avali\\selenium test\\REDBUS-POM\\src\\main\\java\\properties\\config.properties");
				p.load(fi);
				
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}}
		
		 public static  void initialization() {

	String	Browsername= p.getProperty("browser");

	if(Browsername.equals("chrome")) {
		

		 System.setProperty("webdriver.chrome.driver","C:\\Users\\jithe\\Desktop\\avali\\chromedriver_win32\\chromedriver.exe" );
		 ChromeOptions options = new ChromeOptions();
		   options.addArguments("--disable-notifications");
		   /// give options instance in driver 
		 wd=new ChromeDriver(options);

	}

	// we can initisalze this load time outs in utilll class 
	wd.manage().deleteAllCookies();
	wd.manage().timeouts().implicitlyWait(Util.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	wd.manage().timeouts().implicitlyWait(Util.IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);

	wd.manage().window().maximize();


			wd.get(p.getProperty("url"));
	}
	}





