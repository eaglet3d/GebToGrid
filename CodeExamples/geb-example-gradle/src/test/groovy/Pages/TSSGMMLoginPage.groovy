package Pages

import geb.Page
import Common.MenuModule

class TSSGMMLoginPage extends Page {
    static url = "http://technologynursery.org:81"

    static at = { 
        title == "TSSG Musicians Manager"
        $("div.panel-heading b", 0).text() == "Login"
    }

    static content = {
        username { $("input.form-control[name='username'") }
        password { $("input.form-control[name='password']") }
        loginButton { $("button.btn.btn-primary") }
    }
}
