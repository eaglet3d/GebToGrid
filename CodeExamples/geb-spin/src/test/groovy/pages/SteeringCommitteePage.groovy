package pages

import geb.Page
import pages.common.BostonSpinBasePage

class SteeringCommitteePage extends BostonSpinBasePage {
    static url = "/memberhip"

    static at = { title == "Membership - Boston SPIN" }

    static content = {
        steeringCommitteeHeader { $("#content h1") }
    }
}
