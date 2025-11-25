package PageObjects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.PageFactory;

public class P03_Cart
{
    // Create constructor to call factory page class to declare Android driver
    public AndroidDriver driver;

    public P03_Cart (AndroidDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Data Members

    // Methods
}
