package Pages

import geb.Page
import Common.MenuModule

class GebishOrgHomePage extends Page {

    static at = { title == "Geb - Very Groovy Browser Automation" }

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
