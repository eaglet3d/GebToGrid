package Tests

import Pages.TSSGTechHomePage
import Pages.TSSGTechMobilePage
import Pages.TSSGTechSchedulePage
import Pages.TSSGTechWebPage
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
            //at Class.forName("Pages.${page}",  false, Thread.currentThread().contextClassLoader) // page must be a string
            //at ("Pages.${page}" as Class)  // page must be a string
            at page

        where:
            menuItem       | page
            "generalMenu"  | TSSGTechHomePage
            "scheduleMenu" | TSSGTechSchedulePage
            "webMenu"      | TSSGTechWebPage
            "mobileMenu"   | TSSGTechMobilePage
            "qaMenu"       | TSSGTechQAPage
//            "dataMenu"     | "dataPage"
//            "devopsMenu"   | "devopsPage"

    }
}
