package pages

import geb.Page

class JoinBostonSpinPage extends Page {

    static at = {
        title == "Boston SPIN : Sign Up to Stay in Touch"
        topHeader.displayed
    }

    static content = {
        topHeader { $("#optin h1", text: "Join Boston SPIN today!") }
        emailAddressField { $("#inputProp0", 'data-input':"Email Address") }
        firstNameField { $("#inputProp1", 'data-input':"First Name") }
        lastNameField { $("#inputProp2", 'data-input':"Last name") }
        jobTitleField { $("#inputProp3", 'data-input':"Job Title") }
        companyField { $("#inputProp4", 'data-input':"Company") }

        emailListMonthlyMeetings { $("label", 'for':"checkBoxIntCat0", text:"SPIN Monthly Meetings") }
        emailListSpinPlus { $("label", 'for':"checkBoxIntCat1", text:"SPIN-Plus") }
        emailListSignUpButton { $("#update-provile-submit-btn") }
    }
}
