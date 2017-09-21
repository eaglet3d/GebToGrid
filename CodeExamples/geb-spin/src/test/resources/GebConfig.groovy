/*
	This is the Geb configuration file.
	
	See: http://www.gebish.org/manual/current/#configuration
*/


import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver

waiting {
	timeout = 2
}

environments {

	// Grid default URL
	System.properties['browser.location.default'] = "http://192.168.99.100:4444/wd/hub"

	// Use Grid default URL if browser.location is not set
	def browserLocation = System.properties['browser.location'] ?: System.properties['browser.location.default']
	println "browser.location = ${browserLocation}"
	// run via “./gradlew chromeTest”
	// See: http://code.google.com/p/selenium/wiki/ChromeDriver
	chrome {
		atCheckWaiting = 10

		if (browserLocation == 'local') {  // use local browser (not grid)
			//println "browser.location: Using local chrome browser."
			driver = { new ChromeDriver() }
		} else {  // use remote grid URL as default
			//println "browser.location: Using remote grid as browser location: ${browserLocation}"
			driver = {
				DesiredCapabilities capabilities = DesiredCapabilities.chrome()
				//capabilities.setVersion("45.4.0esr")
				//capabilities.setPlatform(Platform.LINUX)
				new RemoteWebDriver( new URL(browserLocation), capabilities )
			}
		}
	}

	// run via “./gradlew firefoxTest”
	// See: http://code.google.com/p/selenium/wiki/FirefoxDriver
	firefox {
		atCheckWaiting = 10

		if (browserLocation == 'local') {  // use local browser (not grid)
			//println "browser.location: Using local firefox browser."
			driver = { new FirefoxDriver() }
		} else {  // use remote grid URL as default
			//println "browser.location: Using remote grid browser location: ${browserLocation}"
			driver = {
				DesiredCapabilities capabilities = DesiredCapabilities.firefox()
				//capabilities.setVersion("45.4.0esr")
				//capabilities.setPlatform(Platform.LINUX)
				new RemoteWebDriver(new URL(browserLocation), capabilities)

				// This code shows how to modify the Firefox profile settings
				//FirefoxProfile profile = new FirefoxProfile()
				//profile.setPreference("intl.accept_languages", "en-us")
				//def driverInstance = new FirefoxDriver(profile)
				//driverInstance
			}
		}
	}

//	println "*** START - All System Properties settings seen by GebConfig ***"
//	def tmgc = System.properties as TreeMap
//	tmgc.each { println it }
//    println "*** END - All System Properties settings seen by GebConfig *****"

}

// To run the tests with all browsers just run “./gradlew test”

// Set or get the baseUrl of the system to be tested
baseUrl = System.properties['geb.build.baseUrl'] ?: 'http://boston-spin.org'
println "geb.build.baseUrl: Testing qa environment ${baseUrl}"