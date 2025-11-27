package PageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

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
    @FindBy (id = "com.androidsample.generalstore:id/totalAmountLbl")
    private WebElement TotalPrice;

    @FindBy (xpath = "//android.widget.TextView[@text=\"Total Purchase Amount: \"]")
    private WebElement TotalPriceLabel;

    @FindBy (className = "android.widget.CheckBox")
    private WebElement TermsCheckBox;

    @FindBy (id = "com.androidsample.generalstore:id/btnProceed")
    private WebElement WebView;

    @FindBy (name = "q")
    private WebElement searchBox;

    // Methods
    public double GetTotalPrice()
    {
        String stringPrice = TotalPrice.getText();
        double  price = Double.parseDouble(stringPrice.substring(1));
        return price;
    };

    public String GetTotalPriceLabel()
    {
        String label = TotalPrice.getAttribute("text");
        return label;
    };

    public void CheckNotification()
    {
        TermsCheckBox.click();
    };

    public void OpenTheWebView() throws InterruptedException {
        WebView.click();
        Thread.sleep(5000);
    };

    public void printAvailableContexts()
    {
        Set<String> contexts = driver.getContextHandles();
        for (String c : contexts) {
            System.out.println("Context Found: " + c);
        }
    }

    public void switchToWebView()
    {
        driver.context("WEBVIEW_com.androidsample.generalstore");
    }

    public void googleSearch(String text) throws InterruptedException {
        searchBox.sendKeys(text);
        searchBox.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }

    public void switchToNative() throws InterruptedException {
        driver.context("NATIVE_APP");
        Thread.sleep(2000);
    }
}
