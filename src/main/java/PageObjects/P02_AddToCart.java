package PageObjects;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P02_AddToCart
{
    // Create constructor to call factory page class to declare Android driver
    public AndroidDriver driver;

    public P02_AddToCart (AndroidDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Data Members
    @FindBy (id = "com.androidsample.generalstore:id/productName")
    private List<WebElement> ProductsName;

    @FindBy (id = "com.androidsample.generalstore:id/productAddCart")
    private List<WebElement> AddToCartButton;

    @FindBy (id = "com.androidsample.generalstore:id/productPrice")
    private List<WebElement> ProductsPrice;

    @FindBy (id = "com.androidsample.generalstore:id/appbar_btn_cart")
    private WebElement CartPage;

    // Methods
    public String GetProductName(int i)
    {
        String name = ProductsName.get(i).getText();
        return name;
    };

    public double GetProductPrice(int i)
    {
        String stringPrice = ProductsPrice.get(i).getText();
        double  price = Double.parseDouble(stringPrice.substring(1));
        return price;
    };

    public void ClickAddToCartButton(int i)
    {
        AddToCartButton.get(i).click();
    };

    public String GetAddButtonStatus(int i)
    {
        String status = AddToCartButton.get(i).getAttribute("text");
        return status;
    };

    public void OpenCartPage()
    {
        CartPage.click();
    };

    public boolean scrollToProductIfExists(String product) {
        try {
            driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
                            + "new UiSelector().text(\"" + product + "\"));"
            ));
            return true; // Found
        } catch (Exception e) {
            return false; // Not Found
        }
    }
}
