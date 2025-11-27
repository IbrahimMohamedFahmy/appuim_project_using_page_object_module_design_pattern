package TestCases;

import SetUp.SuperClass;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class T03_Cart extends SuperClass
{
    @Test(groups = {"Happy Scenarios", "All Scenarios"}, priority = 1, dataProvider = "TestData")
    public void PassCartFlowSuccessfulWithOneProduct(HashMap<String, String> input) throws InterruptedException {
        // Step 1: Sign In Successful
        signIn.SignIn(input.get("MaleName"));

        // Step 2: Check The User Reach to The Products Page
        soft.assertEquals(signIn.GetPageTitle(), input.get("ProductsPage"));

        // Step 3: Get A Product Status
        String StatusBeforeAdd = addToCart.GetAddButtonStatus(0);

        // Step 4: Check The Product Status Before Add is "ADD TO CART"
        soft.assertEquals(StatusBeforeAdd, "ADD TO CART");

        // Step 5: Add that Product to Cart
        addToCart.ClickAddToCartButton(0);

        // Step 6: Get A Product Name
        String ProductNameInProducts = addToCart.GetProductName(0);

        // Step 7: Get A Product Price
        double ProductPriceInProducts = addToCart.GetProductPrice(0);

        // Step 8: Get The Add Button Status After Add the Product To The Cart
        String StatusAfterAdd = addToCart.GetAddButtonStatus(0);

        // Step 9: Check The Product Status After Add is "ADDED TO CART"
        soft.assertEquals(StatusAfterAdd, "ADDED TO CART");

        // Step 10: Open The Cart Page
        addToCart.OpenCartPage();

        // Step 11: Check The Cart Page's Title
        soft.assertEquals(signIn.GetPageTitle(), input.get("CartPage"));

        // Step 12: Get A Product Name
        String ProductNameInCart = addToCart.GetProductName(0);

        // Step 13: Check The Product Name Is Match Between Products And Cart Page
        soft.assertEquals(ProductNameInProducts, ProductNameInCart);

        // Step 14: Get A Product Price
        double ProductPriceInCart = addToCart.GetProductPrice(0);

        // Step 15: Check The Product Price Is Match Between Products And Cart Page
        soft.assertEquals(ProductPriceInProducts, ProductPriceInCart);

        // Step 16: Check the Total Price Label
        soft.assertEquals(cart.GetTotalPriceLabel(), input.get("LabelTotalPrice"));

        // Step 17: Check The Total Price with The Product Price in the Cart
        soft.assertEquals(cart.GetTotalPrice(), ProductPriceInCart);

        // Step 18: Check The Notification Check Box
        cart.CheckNotification();
    }

    @Test(groups = {"Happy Scenarios", "All Scenarios"}, priority = 2, dataProvider = "TestData")
    public void PassCartFlowSuccessfulWithTwoProduct(HashMap<String, String> input) throws InterruptedException {
        // Step 1: Sign In Successful
        signIn.SignIn(input.get("MaleName"));

        // Step 2: Check The User Reach to The Products Page
        soft.assertEquals(signIn.GetPageTitle(), input.get("ProductsPage"));

        // Step 3: Get A Product Status "Product Number 1"
        String StatusBeforeAdd1 = addToCart.GetAddButtonStatus(0);

        // Step 4: Check The Product Status Before Add is "ADD TO CART" "Product Number 1"
        soft.assertEquals(StatusBeforeAdd1, "ADD TO CART");

        // Step 5: Get A Product Name "Product Number 1"
        String ProductNameInProducts1 = addToCart.GetProductName(0);

        // Step 6: Get A Product Price "Product Number 1"
        double ProductPriceInProducts1 = addToCart.GetProductPrice(0);

        // Step 7: Add that Product to Cart "Product Number 1"
        addToCart.ClickAddToCartButton(0);

        // Step 8: Get The Add Button Status After Add the Product To The Cart "Product Number 1"
        String StatusAfterAdd1 = addToCart.GetAddButtonStatus(0);

        // Step 9: Check The Product Status After Add is "ADDED TO CART" - "Product Number 1"
        soft.assertEquals(StatusAfterAdd1, "ADDED TO CART");

        // Step 10: Get A Product Status "Product Number 2"
        String StatusBeforeAdd2 = addToCart.GetAddButtonStatus(1);

        // Step 11: Check The Product Status Before Add is "ADD TO CART" - "Product Number 2"
        soft.assertEquals(StatusBeforeAdd2, "ADD TO CART");

        // Step 12: Get A Product Name "Product Number 2"
        String ProductNameInProducts2 = addToCart.GetProductName(1);

        // Step 13: Get A Product Price "Product Number 2"
        double ProductPriceInProducts2 = addToCart.GetProductPrice(1);

        // Step 14: Add that Product to Cart "Product Number 2"
        addToCart.ClickAddToCartButton(1);

        // Step 15: Get The Add Button Status After Add the Product To The Cart "Product Number 2"
        String StatusAfterAdd2 = addToCart.GetAddButtonStatus(1);

        // Step 16: Check The Product Status After Add is "ADDED TO CART" - "Product Number 2"
        soft.assertEquals(StatusAfterAdd2, "ADDED TO CART");

        // Step 17: Open The Cart Page
        addToCart.OpenCartPage();

        // Step 18: Check The Cart Page's Title
        soft.assertEquals(signIn.GetPageTitle(), input.get("CartPage"));

        // Step 19: Get A Product Name "Product Number 1"
        String ProductNameInCart1 = addToCart.GetProductName(0);

        // Step 20: Check The Product Name Is Match Between Products And Cart Page "Product Number 1"
        soft.assertEquals(ProductNameInProducts1, ProductNameInCart1);

        // Step 21: Get A Product Price "Product Number 1"
        double ProductPriceInCart1 = addToCart.GetProductPrice(0);

        // Step 22: Check The Product Price Is Match Between Products And Cart Page "Product Number 1"
        soft.assertEquals(ProductPriceInProducts1, ProductPriceInCart1);

        // Step 23: Get A Product Name "Product Number 2"
        String ProductNameInCart2 = addToCart.GetProductName(0);

        // Step 24: Check The Product Name Is Match Between Products And Cart Page "Product Number 2"
        soft.assertEquals(ProductNameInProducts2, ProductNameInCart2);

        // Step 25: Get A Product Price
        double ProductPriceInCart2 = addToCart.GetProductPrice(0);

        // Step 26: Check The Product Price Is Match Between Products And Cart Page "Product Number 2"
        soft.assertEquals(ProductPriceInProducts2, ProductPriceInCart2);

        // Step 27: Check the Total Price Label
        soft.assertEquals(cart.GetTotalPriceLabel(), input.get("LabelTotalPrice"));

        // Step 28: Check The Total Price with The Product Price in the Cart
        soft.assertEquals(cart.GetTotalPrice(), (ProductPriceInCart1+ProductPriceInCart2));

        // Step 29: Check The Notification Check Box
        cart.CheckNotification();
    }

    @Test(groups = {"Happy Scenarios", "All Scenarios"}, priority = 3, dataProvider = "TestData")
    public void PassCartFlowWithOneProductContinueWebView(HashMap<String, String> input) throws InterruptedException {
        // Step 1: Sign In Successful
        signIn.SignIn(input.get("MaleName"));

        // Step 2: Check The User Reach to The Products Page
        soft.assertEquals(signIn.GetPageTitle(), input.get("ProductsPage"));

        // Step 3: Get A Product Status
        String StatusBeforeAdd = addToCart.GetAddButtonStatus(0);

        // Step 4: Check The Product Status Before Add is "ADD TO CART"
        soft.assertEquals(StatusBeforeAdd, "ADD TO CART");

        // Step 5: Add that Product to Cart
        addToCart.ClickAddToCartButton(0);

        // Step 6: Get A Product Name
        String ProductNameInProducts = addToCart.GetProductName(0);

        // Step 7: Get A Product Price
        double ProductPriceInProducts = addToCart.GetProductPrice(0);

        // Step 8: Get The Add Button Status After Add the Product To The Cart
        String StatusAfterAdd = addToCart.GetAddButtonStatus(0);

        // Step 9: Check The Product Status After Add is "ADDED TO CART"
        soft.assertEquals(StatusAfterAdd, "ADDED TO CART");

        // Step 10: Open The Cart Page
        addToCart.OpenCartPage();

        // Step 11: Check The Cart Page's Title
        soft.assertEquals(signIn.GetPageTitle(), input.get("CartPage"));

        // Step 12: Get A Product Name
        String ProductNameInCart = addToCart.GetProductName(0);

        // Step 13: Check The Product Name Is Match Between Products And Cart Page
        soft.assertEquals(ProductNameInProducts, ProductNameInCart);

        // Step 14: Get A Product Price
        double ProductPriceInCart = addToCart.GetProductPrice(0);

        // Step 15: Check The Product Price Is Match Between Products And Cart Page
        soft.assertEquals(ProductPriceInProducts, ProductPriceInCart);

        // Step 16: Check the Total Price Label
        soft.assertEquals(cart.GetTotalPriceLabel(), input.get("LabelTotalPrice"));

        // Step 17: Check The Total Price with The Product Price in the Cart
        soft.assertEquals(cart.GetTotalPrice(), ProductPriceInCart);

        // Step 18: Check The Notification Check Box
        cart.CheckNotification();

        // Step 19: Open Web View
        cart.OpenTheWebView();

        // Step 20: Print all Contexts
        cart.printAvailableContexts();

        // Step 21: Switch To The Web View
        cart.switchToWebView();

        // Step 22: Search With Appium Word
        cart.googleSearch(input.get("Appium"));

        // Step 23: Switch Back To The App
        cart.switchToNative();
    }

    @DataProvider
    public Object[][] TestData() throws IOException
    {
        String jsonFile = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"//src//main//resources//TestData.json"), StandardCharsets.UTF_8);

        ObjectMapper objectMapper = new ObjectMapper();
        List<HashMap<String, String>> DataList = objectMapper.readValue(jsonFile, new TypeReference<List<HashMap<String, String>>>() {});

        Object[][] Data = new Object[DataList.size()][1];
        for(int i = 0 ; i < DataList.size() ; i++)
        {
            Data[i][0] = DataList.get(i);
        }
        return Data;

    }
}
