package Pages

import Common.TSSGTechBasePage

class TSSGTechMobilePage extends TSSGTechBasePage {

    static url = "http://technologynursery.org/tssgTech/mobileGroup.html#top"

    static at = {
        titleText
        titleIcon
    }

    static content = {
        titleText { $("strong", text: "MOBILE APPLICATION DEVELOPMENT TEAM") }
        titleIcon { $("#mobile-icon", src: "Images/icon_mobile_v2.png") }
    }
}
