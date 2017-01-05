package Pages

import geb.Page

class TSSGMMGreetingsPage extends Page {
    static url = "http://technologynursery.org:81"

    static at = { 
        title == "TSSG Musicians Manager"
        $("h4 b", 0).text() == "Welcome to the Musicians\' Manager Website"
    }

    static content = {}
}
