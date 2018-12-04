package Pages

import Common.TSSGTechBasePage

class TSSGTechDevOpsPage extends TSSGTechBasePage {

    static url = "devopsGroup.html#top"

    static at = {
        titleText
        titleIcon
    }

    static content = {
        titleText { $("strong", text: "DEVOPS TEAM") }
        titleIcon { $("#devops-icon", src: "Images/icon_devops_v2.png") }
    }
}
