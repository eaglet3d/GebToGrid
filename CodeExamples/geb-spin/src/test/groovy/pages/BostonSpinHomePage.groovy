package pages

import geb.Page
import pages.MembershipPage
import pages.common.BostonSpinBasePage

/*
 * Home page for the Boston SPIN web site.
 */
class BostonSpinHomePage extends BostonSpinBasePage {

    static at = {
        title == "Boston SPIN – Software Process Improvement Network"
        nextMeetingHeader.displayed

        becomeAMemberHeader.displayed
        memberJoinNowButton.displayed
        recentMeetingsHeader.displayed
        sponsorsHeader.displayed

        searchInputField.displayed
        searchInputButton.displayed
    }

    static content = {
        nextMeetingHeader { $("#content h1") }
        speakerLink { $("td.meeting a") }
        aboutTheSpeakerHeader { $("#bio")}

        becomeAMemberHeader { $("p.wtitle", text:"BECOME A MEMBER") }
        memberJoinNowButton { $("a", text:"Join Now") }

        recentMeetingsHeader { $("p.wtitle", text:"RECENT MEETINGS") }

        sponsorsHeader { $("p.wtitle", text:"SPONSORS") }

        searchInputField { $("#search-2 form input.s") }
        searchInputButton { $("input.submit.search_submit") }
    }
}
