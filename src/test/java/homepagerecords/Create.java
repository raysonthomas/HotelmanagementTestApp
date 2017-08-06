package homepagerecords;

import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.jsoup.Jsoup;
import org.jsoup.helper.*;
import org.jsoup.nodes.Document;

//import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebElement;

public class Create {
	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 10);

	}

	@Given("^user navigates to the login page$")
	public void user_navigate_to_the_login_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", ".\\libs\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://192.168.99.100:3003/");
	}

	@And("^user clicks on '(.*)' link and enters username and password$")
	public void user_clicks_on_button_and_enters_credentials(String name) {
		driver.findElement(By.linkText(name)).click();
		String parentwin = driver.getWindowHandle();
		Set<String> allWin = driver.getWindowHandles();
		for (int i = 0; i < 2; i++) {
			System.out.println(allWin);
		}
		if (!allWin.isEmpty()) {
			for (String winId : allWin) {
				driver.switchTo().window(winId);

				if (driver.getPageSource().contains("Login")) {
					try {

						driver.findElement(By.id("username")).sendKeys("admin");
						driver.findElement(By.id("password")).sendKeys("password");
						break;
					}

					catch (NoSuchWindowException e) {
						e.printStackTrace();
					}
				}
			}
		}
		driver.switchTo().window(parentwin);

	}

	@And("^user clicks on Login Button$")
	public void user_enters_correct_password() {
		driver.findElement(By.id("doLogin")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hotelName")));

	}

	@Given("^user navigates to the home page$")
	public void user_navigates_to_the_home_page() {
		Assert.assertTrue(driver.getPageSource().contains("Logout"));
		System.out.println("User is on the home page as expected");
	}

	@Then("^user enters the values in '(.*)', '(.*)', '(.*)', '(.*)', '(.*)'$")
	public void user_enters_the_values(String hn, String adr, String own, int phn, String eml) {

		driver.findElement(By.id("hotelName")).sendKeys(hn);
		driver.findElement(By.id("address")).sendKeys(adr);
		driver.findElement(By.id("owner")).sendKeys(own);
		driver.findElement(By.id("phone")).sendKeys(String.valueOf(phn));
		driver.findElement(By.id("email")).sendKeys(eml);

	}

	@And("^user clicks on Create Button$")
	public void user_clicks_create_button() {
		driver.findElement(By.id("createHotel")).click();
	}
	

	@Then("^user clicks on X button to delete Hotel1 record$")
	public void user_deletes_record() {
		
//		List<WebElement> lsts = driver.findElemnts(By.className("glyphicon glyphicon-remove hotelDelete"));
//		for (WebElement lst:lsts) {
//			System.out.println(lst.getAttribute("id"));
		
//		String html = driver.getPageSource();
//		Document doc = Jsoup.parse(html);
//		String text = doc.body().text();  
		
		//driver.findElement(By.cssSelector("span[class='glyphicon glyphicon-remove hotelDelete'][id='15']")).click();
		driver.findElement(By.cssSelector("div:contains('abc@abc.com')+div>class:contains('glyphicon glyphicon-remove hotelDelete'))")).click();
		
		
		}
		
		
		
		

	}


