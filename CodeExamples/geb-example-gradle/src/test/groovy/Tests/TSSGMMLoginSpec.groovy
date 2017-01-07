package Tests

import Pages.TSSGMMLoginPage
import Pages.TSSGMMGreetingsPage
import geb.spock.GebReportingSpec

class TSSGMMLoginSpec extends GebReportingSpec {

    def "User can login to Musicians Manager"() {
        when: "User enters valid login credentials"
            to TSSGMMLoginPage
            username = "pscheid"
            password = "Passw0rd"
            loginButton.click()

        then: "User is taken to Musicians Manager Greeting page"
            at TSSGMMGreetingsPage
    }
}
