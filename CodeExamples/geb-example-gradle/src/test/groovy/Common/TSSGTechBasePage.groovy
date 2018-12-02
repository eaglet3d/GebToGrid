package Common

import geb.Page

class TSSGTechBasePage extends Page {

    static at = {
        //title == "Technical Skills Share Group (TSSG)"
        $("strong", text:"GENERAL MEETING INFORMATION")
    }

    static content = {
        // Header
        homeLinkImage { $("a img", src: "Images/Logo_TSSG.png") }

        // Header Menu
        generalMenu { $("a", text: "Home") }
        scheduleMenu { $("a", text: "Schedule") }
        webMenu { $("a", text: "WEB") }
        mobileMenu { $("a", text: "MOBILE") }
        qaMenu { $("a", text: "QA") }
        dataMenu { $("a", text: "DATA") }
        devOpsMenu { $("a", text: "DEVOPS") }

        // Header Pages
        generalPage { $("index.html#top") }
        schedulePage { $("schedule.html#top") }
        webPage { $("webGroup.html#top") }
        //mobilePage { $("mobileGroup.html#top") }
        qaPage { $("qaGroup.html#top") }
        dataPage { $("dataGroup.html#top") }
        devopsPage { $("devopsGroup.html#top") }

        // Footer icon links
        webFooter { $("#webGroup").parent() }
        mobileFooter { $("#mobileGroup").parent() }
        qaFooter { $("qaGroup").parent() }
        dataFooter { $("dataGroup").parent() }
        devopsFooter { $("devopsGroup").parent() }

    }
}
