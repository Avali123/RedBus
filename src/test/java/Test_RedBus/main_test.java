package Test_RedBus;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base_redbus.Base_class;
import Pages_RedBus.Dest_page;
import Pages_RedBus.MAIN_page;


public class main_test extends Base_class {
	
	static MAIN_page main;
	static Dest_page dest;
	public main_test () {
				super();
			}
			
			@BeforeClass
			public static void setup() {
				initialization();
				main=new MAIN_page();
				dest= new Dest_page();

					}
			
			
			@Test
			public void enter() {
			String tittle=	main.checktittle();
			System.out.println("Tittle is :::"+tittle);
			}
			
			
	@Test
	public void credentials() throws InterruptedException {
		main.destination(p.getProperty("from"), p.getProperty("to"));
		
	}
	
	@Test
	public void main() throws InterruptedException {
		
		main.calender(p.getProperty("date"), p.getProperty("val"));
	}
	
	@Test(enabled=false)
	public void dest() throws InterruptedException {
		dest.destination(p.getProperty("destdate"), p.getProperty("destval"));
			}
	
	@Test

	public void nextpage() {
String nextpage=	dest.tittle();
System.out.println("nextpage tittle :::"+nextpage);
	}
			@AfterClass
			public void tear() {
				wd.getCurrentUrl();
			}
	

}
