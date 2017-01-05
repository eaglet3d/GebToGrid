package Tests

import Pages.GebishOrgHomePage
import Pages.CrossBrowserAutomationPage
import geb.spock.GebReportingSpec
import spock.lang.Unroll

class GebishOrgHighlightsSpec extends GebReportingSpec {

    def "User is shown Highlights section"() {
        when: "User navigates to home page"
            to GebishOrgHomePage

        then: "Highlights section links are displayed"
            sideMenuCrossBrowser.text().contains('Cross Browser')
            sideMenuJQueryLikeAPI.text().contains('jQuery-like API')
            sideMenuPageObjects.text().contains('Page Objects')
            sideMenuAsyncPages.text().contains('Asynchronous Pages')
            sideMenuTesting.text().contains('Testing')
            sideMenuBuildIntegration.text().contains('Build Integration')
    }

    @Unroll
    def "User is shown Highlights section #highlight == #txt"() {
        when: "User navigates to home page"
            to GebishOrgHomePage

        then:
            sideMenu.$("." + highlight + " a").text().contains( txt )

        where:
            highlight      | txt
            'crossbrowser' | 'Cross Browser'
            'content'      | 'jQuery-like API'
            'pages'        | 'Page Objects'
            'async'        | 'Asynchronous Pages'
            'testing'      | 'Testing'
            'integration'  | 'Build Integration'
    }

    def "User can display Cross Browser Automation information"() {
        when: "User navigates to home page"
            to GebishOrgHomePage

        and: "User selects Cross Browser in Highlights section"
            sideMenuCrossBrowser.click()

        then: "User is shown Cross Browser Automation information"
            sleep 2000
            at CrossBrowserAutomationPage
    }
}