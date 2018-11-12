package Tests


import Pages.TSSGTechHomePage
import geb.spock.GebReportingSpec
import spock.lang.Unroll

class TSSGTechSpec extends GebReportingSpec {

    def "can get to the tssg.tech home page"() {
        when:
            to TSSGTechHomePage

        then:
            myCarousel
    }

    def "can get to the mobile section"() {
        when:
            to TSSGTechHomePage
            mobileMenu.click()

        then:
            waitFor { mobileSection.focused }

    }

    @Unroll
    def "selecting #menuItem goes to #section"() {
        when:
            to TSSGTechHomePage
            "${menuItem}"().click()

        then:
            waitFor { "${section}"().focused }

        where:
            menuItem       | section
            "generalMenu"  | "generalSection"
            "scheduleMenu" | "scheduleSection"
            "webMenu"      | "webSection"
            "mobileMenu"   | "mobileSection"
            "qaMenu"       | "qaSection"
            "dataMenu"     | "dataSection"
            "devOpsMenu"   | "devOpsSection"

    }
}