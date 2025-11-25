package PageObjects;

import io.appium.java_client.android.AndroidDriver;
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

    // Methods
}
