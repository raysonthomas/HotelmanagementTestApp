package homepagerecords;

import java.util.Set;
import cucumber.api.java.en.Given;

public class quitBrowser extends Ready {

	@Given("^user closes all browsers$")
	public void user_closes_all_browsers() throws Throwable {
		Set<String> allWin = driver.getWindowHandles();
		for (String winId : allWin) {
			driver.switchTo().window(winId).close();

		}

	}

}
