package pages

import geb.Page
import pages.common.BostonSpinBasePage

class MembershipPage extends BostonSpinBasePage {

    static at = {
        title == "Membership - Boston SPIN"
        membershipHeader.displayed
        becomeAMemberHeader.displayed
    }

    static content = {
        membershipHeader { $("h1", text:"Membership") }
        becomeAMemberHeader { $("h2", text:"Become a Member") }
        becomeAMemberButton { $("a", text:"Become a Member") }
    }
}
