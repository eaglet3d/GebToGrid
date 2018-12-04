package Common

import geb.Page

class TSSGTechBasePage extends Page {

    static at = {
        //title == "Technical Skills Share Group (TSSG)"
        $("strong", text:"GENERAL MEETING INFORMATION")
    }

    static content = {
        // Header
        homeLinkIcon { $("a img", src: "Images/Logo_TSSG.png").parent() }

        // Header Menu
        generalMenu { $("a", text: "Home") }
        scheduleMenu { $("a", text: "Schedule") }
        webMenu { $("a", text: "WEB") }
        mobileMenu { $("a", text: "MOBILE") }
        qaMenu { $("a", text: "QA") }
        dataMenu { $("a", text: "DATA") }
        devopsMenu { $("a", text: "DEVOPS") }

        // Footer icon links
        webFooterIcon { $("#webGroup").parent() }
        mobileFooterIcon { $("#mobileGroup").parent() }
        qaFooterIcon { $("#qaGroup").parent() }
        dataFooterIcon { $("#dataGroup").parent() }
        devopsFooterIcon { $("#devopsGroup").parent() }

    }
}
