package Pages

import geb.Page
import Common.MenuModule

class GebishOrgHomePage extends Page {

    static at = { title == "Geb - Very Groovy Browser Automation" }

    static content = {
        manualsMenu { module(MenuModule) }
    }
}
