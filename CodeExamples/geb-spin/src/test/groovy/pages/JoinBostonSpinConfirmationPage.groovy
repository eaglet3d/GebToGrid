package pages

import geb.Page

class JoinBostonSpinConfirmationPage extends Page {

    static at = {
        title == "Boston SPIN : Registration Confirmation"
        topHeader.displayed
        optInSuccess.displayed
    }

    static content = {
        topHeader { $("#optin h1", text: "Join Boston SPIN today!") }
        optInSuccess(required:false) { $("#optinSuccess") }
    }
}
