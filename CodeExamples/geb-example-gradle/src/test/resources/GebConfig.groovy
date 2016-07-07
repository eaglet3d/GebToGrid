/*
	This is the Geb configuration file.
	
	See: http://www.gebish.org/manual/current/#configuration
*/


import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxProfile
import org.openqa.selenium.Platform
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
//import org.openqa.selenium.phantomjs.PhantomJSDriver

waiting {
	timeout = 2
}

environments {
	
    // run via “./gradlew chromeTest”
    // See: http://code.google.com/p/selenium/wiki/ChromeDriver
    chrome {
        driver = { new ChromeDriver() }
    }
	
    // run via “./gradlew firefoxTest”
    // See: http://code.google.com/p/selenium/wiki/FirefoxDriver
    firefox {
        //driver = { new FirefoxDriver() }
        driver = {
            DesiredCapabilities capabilities = DesiredCapabilities.firefox()
            capabilities.setVersion("47.0.1")
            capabilities.setPlatform(Platform.LINUX)
            new RemoteWebDriver( new URL("http://172.18.0.1:4444/wd/hub"), capabilities )

            //FirefoxProfile profile = new FirefoxProfile()
            //profile.setPreference("intl.accept_languages", "en-us")
            //def driverInstance = new FirefoxDriver(profile)
            //driverInstance
        }
    }

    //phantomJs {
    //    driver = { new PhantomJSDriver() }
    //}

}

// To run the tests with all browsers just run “./gradlew test”

baseUrl = "http://gebish.org"
