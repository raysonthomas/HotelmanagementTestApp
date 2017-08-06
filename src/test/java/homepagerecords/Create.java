package homepagerecords;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class Create {
	
private WebDriver driver;

@Given("^user navigates to the login page$")
public void user_navigate_to_the_login_page() throws Throwable{
	System.setProperty("webdriver.chrome.driver",".\\libs\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("http://192.168.99.100:3003/");
	}

@And("^user clicks on '(.*)' button and enters username and password$")
public void user_clicks_on_button_and_enters_credentials(String name){
	driver.findElement(By.linkText(name)).click();
	
		Set<String> allWin = driver.getWindowHandles();
		for(int i=0;i<2;i++)
		{
			System.out.println(allWin);
		}
		if(!allWin.isEmpty()) {
			for(String winId:allWin) {
				driver.switchTo().window(winId);
				
					if(driver.getPageSource().contains("Login"))
					{
						try {
													
							driver.findElement(By.id("username")).sendKeys("admin");
							driver.findElement(By.id("password")).sendKeys("password");
							break;
							}
				
	catch(NoSuchWindowException e) {
		e.printStackTrace();
	}
					}
			}
		}
		
			
}

	
@And("^user clicks on Login Button$")
public void user_enters_correct_password(){
	driver.findElement(By.id("doLogin")).click();
		}

}



