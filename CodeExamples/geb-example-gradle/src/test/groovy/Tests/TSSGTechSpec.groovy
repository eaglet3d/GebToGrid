package Tests

import Common.TSSGTechBasePage
import Pages.TSSGTechHomePage
import Pages.TSSGTechMobilePage
import geb.spock.GebReportingSpec
import spock.lang.Unroll
import spock.lang.IgnoreRest

class TSSGTechSpec extends GebReportingSpec {

    def "can get to the tssg.tech home page"() {
        when:
            to TSSGTechBasePage

        then:
            at TSSGTechBasePage
    }

    @IgnoreRest
    def "can get to the mobile section"() {
        when:
            to TSSGTechHomePage
            mobileMenu.click()

        then:
            at TSSGTechMobilePage

    }

    @Unroll
    def "selecting #menuItem goes to #page"() {
        when:
            to TSSGTechHomePage
            "${menuItem}"().click()

        then:
            waitFor { "${page}"().focused }

        where:
            menuItem       | page
            "generalMenu"  | "generalPage"
            "scheduleMenu" | "schedulePage"
            "webMenu"      | "webPage"
            "mobileMenu"   | "mobilePage"
            "qaMenu"       | "qaPage"
            "dataMenu"     | "dataPage"
            "devopsMenu"   | "devopsPage"

    }
}