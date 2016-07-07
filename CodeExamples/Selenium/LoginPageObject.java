package com.example.test.pageobjects;

import static com.example.test.Constants.loginUrl;  //URL definitions

import com.example.test.UserCredentials; //username and password

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/* Using PageFactory to inject WebElements, defined by annotations. */
public class LoginPageObject {

    private final WebDriver driver;

    @FindBy(id = "d-name")
    private WebElement name;

    @FindBy(id = "d-pass")
    private WebElement pass;

    /* This one is not always there! */
    @FindBy(id = "d-error-message")
    private WebElement message;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

        /* Make sure the Login Page has rendered as expected. LIKE THE GEB "at" assertions */
        if (!name.isDisplayed()) {
            throw new RuntimeException("LoginPageObject name field not displayed");
         }
         if (!pass.isDisplayed()) {
             throw new RuntimeException("LoginPageObject pass field not displayed");
         }
    }

    /**
     * Example:
     * <pre>
     *  WebDriver driver = // details elided
     *  LoginPageObject loginPage = LoginPageObject.browse(driver, "#optional");
     *  // do some work ...
     *  loginPage.logout();
     * </pre>
     */
    public static LoginPage browse(WebDriver driver, String ... suffix) {
        final String url =
                (0 < suffix.length) ?
                        loginUrl + "/" + suffix[0] :
                        loginUrl;
        driver.get(url);
        return new LoginPage(driver);
    }

    public AnotherPageObject login(UserCredentials user) {
        name.clear();
        name.sendKeys(user.getUsername());
        pass.clear();
        pass.sendKeys(user.getPassword() + "\n");
        return new AnotherPageObject(driver);  // LIKE THE GEB "to" NAVIGATION
    }

    public LoginPageObject loginWithoutPermissions(UserCredentials user) {
        name.clear();
        name.sendKeys(user.getUsername());
        pass.clear();
        pass.sendKeys(user.getPassword() + "\n");

        LoginPageObject result = new LoginPageObject(driver);
        if (!result.getMessage().contains("Access Denied")) {
            throw new RuntimeException("Access Denied message expected but not seen.");
        }
        return result;
    }

    public String getMessage() {
        return message.getText();
    }

    //.... More elided
}
