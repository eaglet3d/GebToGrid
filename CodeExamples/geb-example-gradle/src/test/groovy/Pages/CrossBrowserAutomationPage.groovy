package Pages

import Common.MenuModule
import geb.Page

class CrossBrowserAutomationPage extends Page {
    static url = "/crossbrowser"

    static at = {
        title == "Geb - Very Groovy Browser Automation" &
        $("#main h1", 0).text() == "Cross Browser Automation"
    }

    static content = {
        manualsMenu { module MenuModule, $("#header-content ul li", 0) }

        sideMenu { $("#sidebar ul.sidemenu li") }

        sideMenuCrossBrowser { $("#sidebar ul.sidemenu li.crossbrowser a") }
        sideMenuJQueryLikeAPI { $("#sidebar ul.sidemenu li.content a") }
        sideMenuPageObjects { $("#sidebar ul.sidemenu li.pages a") }
        sideMenuAsyncPages { $("#sidebar ul.sidemenu li.async a") }
        sideMenuTesting { $("#sidebar ul.sidemenu li.testing a") }
        sideMenuBuildIntegration { $("#sidebar ul.sidemenu li.integration a") }
    }
}
