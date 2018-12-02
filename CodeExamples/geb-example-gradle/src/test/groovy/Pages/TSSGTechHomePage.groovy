package Pages

import Common.TSSGTechBasePage

class TSSGTechHomePage extends TSSGTechBasePage {

    static url = "index.html#top"

    static content = {
        myCarousel { $("#myCarousel") }
        scheduleIcon { $("a img", src: "Images/icon-calendar5.png") }
    }
}
