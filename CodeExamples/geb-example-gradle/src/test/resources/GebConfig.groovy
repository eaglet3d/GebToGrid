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
    firefoxLinux {
        //driver = { new FirefoxDriver() }
        driver = {
            DesiredCapabilities capabilities = DesiredCapabilities.firefox()
            capabilities.setVersion("45.4.0esr")
            capabilities.setPlatform(Platform.LINUX)
            new RemoteWebDriver( new URL("http://hub:4433/wd/hub"), capabilities )

            //FirefoxProfile profile = new FirefoxProfile()
            //profile.setPreference("intl.accept_languages", "en-us")
            //def driverInstance = new FirefoxDriver(profile)
            //driverInstance
        }
    }

    firefox {
        driver = { new FirefoxDriver() }
    }

}

// To run the tests with all browsers just run “./gradlew test”

baseUrl = System.properties['geb.build.baseUrl']
switch (baseUrl) {
    case ["dev", "multipage"]:
        baseUrl = "https://technologynursery.org/tssgTechMultipage/"
        break
    case ["qa", "stagedMaster"]:
        baseUrl = "https://technologynursery.org/tssgTechStagedMaster/"
        break
    case ["prod", "tssgTech"]:
        baseUrl = "https://technologynursery.org/tssgTech/"
        break
    default:
        baseUrl = "https://technologynursery.org/tssgTechMultipage/"
        break
}

