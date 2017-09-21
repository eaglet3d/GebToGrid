package pages.common

import geb.Page
import pages.BostonSpinHomePage
import pages.MembershipPage
import pages.SteeringCommitteePage

/*
 * Base page for the Boston SPIN web site.
 * Includes the common Title and Menu bar.
 */

class BostonSpinBasePage extends Page {
    static at = {
        title == "Boston SPIN – Software Process Improvement Network"
        logo.text() == "Boston SPIN"
        footerBostonSpinLink.displayed
        copyRightNotice.text() == "© 2017"
        footerTheme.displayed
        aboutUsMenu
    }

    static content = {
        logo { $("#logo") }

        // Main Menu Bar
        nextMeetingMenu { $("#menu-item-42") }
        aboutUsMenu { $("#menu-item-43") }
            membershipMenu { $("#menu-item-46") }
            steeringCommitteeMenu { $("#menu-item-49") }
        resourcesMenu { $("#menu-item-44") }

        // Footer
        footerBostonSpinLink(to: BostonSpinHomePage) { $("#copy a", text:"Boston SPIN") }
        copyRightNotice { $("#copy") }
        footerTheme { $("#designedby", text:"Theme by") }
        footerThemeLink { $("#designedby a", text:"WP Puzzle") }
        footerToTopButton { $("#toTop") }
    }
}
