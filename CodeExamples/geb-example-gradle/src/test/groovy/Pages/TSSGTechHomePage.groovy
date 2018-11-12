package Pages

import geb.Page

class TSSGTechHomePage extends Page {

    static at = {
        title == "TSSG"
    }

    static content = {
        myCarousel { $("#myCarousel") }

        // Menu
        generalMenu { $("a", text: "General Meeting") }
        scheduleMenu { $("a", text: "Schedule") }
        webMenu { $("a", text: "WEB") }
        mobileMenu { $("a", text: "MOBILE") }
        qaMenu { $("a", text: "QA") }
        dataMenu { $("a", text: "DATA") }
        devOpsMenu { $("a", text: "DEVOPS") }

        // Sections
        generalSection { $("#meetingId") }
        scheduleSection { $("#scheduleId") }
        webSection { $("#webId") }
        mobileSection { $("#mobileId") }
        qaSection { $("#qaId") }
        dataSection { $("#dataId") }
        devOpsSection { $("#devopsId") }
    }
}
