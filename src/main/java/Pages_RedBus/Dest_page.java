package Pages_RedBus;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base_redbus.Base_class;

public class Dest_page extends Base_class{
	
	@FindBy(xpath="//*[@id=\"search_btn\"])")
	WebElement search;
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div/p")
	WebElement text;
	
	public    Dest_page(){

	PageFactory.initElements(wd, this);

	} 
	
	public void destination( String mon, String day) throws InterruptedException {

		wd.findElement(By.xpath("//*[@id=\"search\"]/div/div[4]/span")).click();
		Thread.sleep(5000);
		while(true) {  
			String date1= wd.findElement(By.xpath("//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr[1]/td[2]")).getText();
			if(date1.equals(mon)) {
				break;
			}else 
			{
				wd.findElement(By.xpath("//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr[1]/td[3]")).click();
			}
			
		}
		
		String before_xpath= "//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr[";
		String after_xpath="]/td[";

		final int totalweekday= 7;  /// total weeks

		boolean flag=false; /// to close outer loop

		String dayVal=null;
		for(int rowNum=3;rowNum<=7;rowNum++) {
			for(int colNum=1;colNum<=totalweekday;colNum++) {

			try {
				dayVal=wd.findElement(By.xpath(before_xpath+rowNum+after_xpath+colNum+"]")).getText();}
			
			catch(NoSuchElementException e){
				System.out.println("please enter correct date");
				/// in some months 31 day is not available in that case it will display to enter correct date.
				
				flag= false;
				break;
				
			}
			System.out.println(dayVal);
			if(dayVal.equals(day)) {
				wd.findElement(By.xpath(before_xpath+rowNum+after_xpath+colNum+"]")).click();
			flag=true;
			break;

			}

			
		}

		if(flag) {
			break;
		}
			}
	}
		public void search() {
			
			search.click();
		}
			public String tittle() {
				
			return	wd.getTitle();
			
			}
			public String contain() {
				
			return	text.getText();
			}
		}
	




