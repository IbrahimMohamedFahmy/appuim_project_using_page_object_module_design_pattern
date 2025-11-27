package TestCases;

import SetUp.SuperClass;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class T02_AddToCart extends SuperClass
{
    @Test(groups = {"Happy Scenarios", "All Scenarios"}, priority = 1, dataProvider = "TestData")
    public void AddAProductToCartSuccessful(HashMap<String, String> input) throws InterruptedException {
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
    }

    @Test(groups = {"Happy Scenarios", "All Scenarios"}, priority = 2, dataProvider = "TestData")
    public void AddTowProductsToCartSuccessful(HashMap<String, String> input) throws InterruptedException {
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
    }

    @Test(groups = {"Happy Scenarios", "All Scenarios"}, priority = 3, dataProvider = "TestData")
    public void ScrollToAddAProductToCartSuccessful(HashMap<String, String> input) throws InterruptedException {
        // Step 1: Sign In Successful
        signIn.SignIn(input.get("MaleName"));

        // Step 2: Check The User Reach to The Products Page
        soft.assertEquals(signIn.GetPageTitle(), input.get("ProductsPage"));

        // Step 3: Scroll to Get The Target Product
        signIn.Scroll(input.get("TargetProduct"));

        // Step 4: Get A Product Status
        String StatusBeforeAdd = addToCart.GetAddButtonStatus(0);

        // Step 5: Check The Product Status Before Add is "ADD TO CART"
        soft.assertEquals(StatusBeforeAdd, "ADD TO CART");

        // Step 6: Add that Product to Cart
        addToCart.ClickAddToCartButton(0);

        // Step 7: Get A Product Name
        String ProductNameInProducts = addToCart.GetProductName(0);

        // Step 8: Get A Product Price
        double ProductPriceInProducts = addToCart.GetProductPrice(0);

        // Step 9: Get The Add Button Status After Add the Product To The Cart
        String StatusAfterAdd = addToCart.GetAddButtonStatus(0);

        // Step 10: Check The Product Status After Add is "ADDED TO CART"
        soft.assertEquals(StatusAfterAdd, "ADDED TO CART");

        // Step 11: Open The Cart Page
        addToCart.OpenCartPage();

        // Step 12: Check The Cart Page's Title
        soft.assertEquals(signIn.GetPageTitle(), input.get("CartPage"));

        // Step 13: Get A Product Name
        String ProductNameInCart = addToCart.GetProductName(0);

        // Step 14: Check The Product Name Is Match Between Products And Cart Page
        soft.assertEquals(ProductNameInProducts, ProductNameInCart);

        // Step 15: Get A Product Price
        double ProductPriceInCart = addToCart.GetProductPrice(0);

        // Step 16: Check The Product Price Is Match Between Products And Cart Page
        soft.assertEquals(ProductPriceInProducts, ProductPriceInCart);
    }

    @Test(groups = {"Sad Scenarios", "All Scenarios"}, priority = 4, dataProvider = "TestData")
    public void UserWithoutAddAProductToCanNotReachTheCartPage(HashMap<String, String> input) throws InterruptedException {
        // Step 1: Sign In Successful
        signIn.SignIn(input.get("MaleName"));

        // Step 2: Check The User Reach to The Products Page
        soft.assertEquals(signIn.GetPageTitle(), input.get("ProductsPage"));

        // Step 3: Open The Cart Page
        addToCart.OpenCartPage();

        // Step 4: Check The System Behave
        soft.assertEquals(signIn.GetToastMessage(), input.get("ProductsValidation"));

        // Step 11: Check The Cart Page's Title
        soft.assertEquals(signIn.GetPageTitle(), input.get("SignInPage"));

            }

    @Test(groups = {"Sad Scenarios", "All Scenarios"}, priority = 5, dataProvider = "TestData")
    public void ScrollWithProductNameNotExist(HashMap<String, String> input) throws InterruptedException {

        // Step 1: Sign In Successful
        signIn.SignIn(input.get("MaleName"));

        // Step 2: Check The User Reach to The Products Page
        soft.assertEquals(signIn.GetPageTitle(), input.get("ProductsPage"));

        // Step 3: Try to Scroll for a product that doesn't exist
        boolean isFound = addToCart.scrollToProductIfExists(input.get("ProductNotExist"));

        // Step 4: Assert That the Product Is NOT Found
        soft.assertFalse(isFound, "The product should not be found in the page");

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
