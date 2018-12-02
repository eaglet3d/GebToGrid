package Tests

import Common.TSSGTechBasePage
import Pages.TSSGTechHomePage
import Pages.TSSGTechMobilePage
import geb.spock.GebReportingSpec
import spock.lang.Ignore
import spock.lang.Unroll
import spock.lang.IgnoreRest

class TSSGTechSpec extends GebReportingSpec {

    def setupSpec() {
        println "baseUrl = ${baseUrl}"
    }

    def "can get to the home page"() {
        when:
            to TSSGTechHomePage

        then:
            at TSSGTechHomePage
    }

    def "can get to the mobile section"() {
        when:
            to TSSGTechHomePage
            mobileMenu.click()

        then:
            at TSSGTechMobilePage

    }

    @IgnoreRest
    @Unroll
    def "selecting #menuItem goes to #page"() {
        when:
            to TSSGTechHomePage
            "${menuItem}"().click()

        then:
            //waitFor { "${page}"().focused }
            //at Class.forName("Pages.${page}",  false, Thread.currentThread().contextClassLoader)
            at ("Pages.${page}" as Class)

        where:
            menuItem       | page
            "generalMenu"  | "TSSGTechHomePage"
//            "scheduleMenu" | "schedulePage"
//            "webMenu"      | "webPage"
            "mobileMenu"   | "TSSGTechMobilePage"
//            "qaMenu"       | "qaPage"
//            "dataMenu"     | "dataPage"
//            "devopsMenu"   | "devopsPage"

    }
}