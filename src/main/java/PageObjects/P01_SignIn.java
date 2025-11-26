package PageObjects;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P01_SignIn
{
    // Create constructor to call factory page class to declare Android driver
    public AndroidDriver driver;

    public P01_SignIn (AndroidDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Data Members
    @FindBy ( id = "com.androidsample.generalstore:id/toolbar_title")
    private WebElement SignInPageTitle;

    @FindBy (id = "com.androidsample.generalstore:id/spinnerCountry")
    private WebElement CountryDropDownMenu;

    @FindBy (id = "com.androidsample.generalstore:id/nameField")
    private WebElement NameTextFiled;

    @FindBy (id = "com.androidsample.generalstore:id/radioMale")
    private WebElement MaleCheckBox;

    @FindBy (id = "com.androidsample.generalstore:id/radioFemale")
    private WebElement FemaleCheckBox;

    @FindBy (id = "com.androidsample.generalstore:id/btnLetsShop")
    private WebElement SubmitButton;

    @FindBy (xpath = "//android.widget.TextView[@text= 'Egypt']")
    private WebElement EgyptChoice;

    @FindBy (xpath = "//android.widget.TextView[@text= 'Armenia']")
    private WebElement ArmeniaChoice;

    @FindBy(xpath = "//android.widget.Toast")
    private WebElement ToastMessage;

    @FindBy (xpath = "//android.widget.TextView[@text=\"Your Name\"]")
    private WebElement LabelNameTextFiled;

    // Methods
    public void Scroll(String country)
    {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().text(\"" + country + "\"));"
        ));
    }

    public String GetPageTitle() throws InterruptedException {
        Thread.sleep(1000);
        String Title = SignInPageTitle.getAttribute("text");
        return Title;
    };

    public void OpenCountryMenu()
    {
        CountryDropDownMenu.click();
    };

    public void TypeName(String name)
    {
        NameTextFiled.sendKeys(name);
    };

    public void CheckMale()
    {
        MaleCheckBox.click();
    };

    public void CheckFemale()
    {
        FemaleCheckBox.click();
    };

    public void HidekeyBoard()
    {
        driver.hideKeyboard();
    };

    public String GetToastMessage()
    {
        String Message =  ToastMessage.getAttribute("name");
        return Message;
    };

    public void GetEgypt()
    {
        EgyptChoice.click();
    };

    public void GetArmenia()
    {
        ArmeniaChoice.click();
    };

    public String GetLabelNameFiled()
    {
        String Text = LabelNameTextFiled.getText();
        return Text;
    };

    public String GetFemaleCheckBoxStatus()
    {
        String status = FemaleCheckBox.getAttribute("checked");
        return status;
    };

    public String GetMelaCheckBoxStatus()
    {
        String status = MaleCheckBox.getAttribute("checked");
        return status;
    };

    public void OpenProductPage()
    {
        SubmitButton.click();
    };

    public boolean scrollToCountryIfExists(String country) {
        try {
            driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
                            + "new UiSelector().text(\"" + country + "\"));"
            ));
            return true; // Found
        } catch (Exception e) {
            return false; // Not Found
        }
    }

}
