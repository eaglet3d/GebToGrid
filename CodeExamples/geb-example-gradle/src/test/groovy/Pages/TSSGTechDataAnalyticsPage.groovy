package Pages

import Common.TSSGTechBasePage

class TSSGTechDataAnalyticsPage extends TSSGTechBasePage {

    static url = "dataGroup.html#top"

    static at = {
        titleText
        titleIcon
    }

    static content = {
        titleText { $("strong", text: "DATA ANALYTICS DEVELOPMENT TEAM") }
        titleIcon { $("#data-icon", src: "Images/icon_data_v2.png") }
    }
}
