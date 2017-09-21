package pages

import geb.Page
import pages.common.BostonSpinBasePage

class AboutUsPage extends BostonSpinBasePage {
    static url = "/index.php/about-us"

    static at = {
        title == "About Us – Boston SPIN"
        aboutUsHeader.text() == "About Us"
        signUpAnnouncementsLink.displayed
    }

    static content = {
        aboutUs { $("#content article") }
        aboutUsHeader { aboutUs.$("h1") }
        signUpAnnouncementsLink { $("a", text:"Sign up for our monthly meeting announcements") }
    }
}
