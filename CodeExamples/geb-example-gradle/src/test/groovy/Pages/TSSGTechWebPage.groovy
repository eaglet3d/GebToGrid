package Pages

import Common.TSSGTechBasePage

class TSSGTechWebPage extends TSSGTechBasePage {

    static url = "webGroup.html#top"

    static at = {
        titleText
        titleIcon
    }

    static content = {
        titleText { $("strong", text: "WEBSITE APPLICATION DEVELOPMENT TEAM") }
        titleIcon { $("#web-icon", src: "Images/icon_web.png") }
    }
}
