package specs

import geb.spock.GebReportingSpec
import pages.BostonSpinHomePage
import pages.BostonSpinSearchResultsPage
import pages.AboutUsPage
import pages.JoinBostonSpinConfirmationPage
import pages.JoinBostonSpinPage

//@Stepwise
class BostonSpinHomeSpec extends GebReportingSpec {
    def testKey
    def testResult

    def cleanup() {
        //testResult = () ? "PASS" : "FAIL"
        println "cleanup(): ${testKey} ${specificationContext.currentIteration.name} "
    }

    def "01 shows Next Meeting content"() {
        testKey = "SPIN-2"
        given:
            to BostonSpinHomePage
        expect:
            at BostonSpinHomePage
            nextMeetingHeader.text() == "Next Meeting"
    }

    def "02 shows speaker bio"() {
        testKey = "SPIN-11"
        given:
            to BostonSpinHomePage

        when: "Speaker name is clicked"
            speakerLink.click()
        then: "Speaker bio is shown"
            currentUrl.endsWith( "#bio" )
            aboutTheSpeakerHeader.text() == "About the Speaker"
    }

    def "03 can show About Us page"() {
        testKey = "SPIN-13"
        given:
            to BostonSpinHomePage
            waitFor(5) { at BostonSpinHomePage }

        when: "About Us menu is clicked"
            aboutUsMenu.click()
        then: "about-us page is shown"
            at AboutUsPage
    }

    //@Ignore
    def "04 can sign-up for Boston SPIN membership"() {
        testKey = "SPIN-15"
        given:
            to BostonSpinHomePage

        when: "user fills out form and registers"
            withNewWindow({ memberJoinNowButton.click() }) {
                at JoinBostonSpinPage
                emailAddressField = "ralph@navarrocomputing.com"
                emailListMonthlyMeetings.click()
                emailListSpinPlus(to: JoinBostonSpinConfirmationPage).click()
            }
        then: "after successful registration geb returns to originating page"
            at BostonSpinHomePage
    }

    def "05 can search for text in site"() {
        testKey = "SPIN-17"
        given:
            to BostonSpinHomePage

        when: "user searches for 'Ralph Navarro'"
            searchInputField = "Ralph Navarro"
            searchInputButton.click()
        then: "three search results are displayed"
            at BostonSpinSearchResultsPage
            searchResults.size() >= 3
    }

    def "06 can return to home page through footer"() {
        testKey = "SPIN-19"
        given:
            to BostonSpinHomePage

        when:
            footerBostonSpinLink.click()
        then:
            at BostonSpinHomePage
    }

    def "07 can show the theme site"() {
        testKey = "SPIN-21"
        given:
            to BostonSpinHomePage

        when: "user clicks on theme link to open the theme's site"
            withNewWindow({ footerThemeLink.click() }) {
                currentUrl == "https://wp-puzzle.com/"
            }
        then: "after successfully going to the theme's site, geb returns to the originating page"
            at BostonSpinHomePage
    }
}