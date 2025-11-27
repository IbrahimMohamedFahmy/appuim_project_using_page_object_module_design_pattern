package SetUp;

import PageObjects.P01_SignIn;
import PageObjects.P02_AddToCart;
import PageObjects.P03_Cart;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class SuperClass
{
    // Step 1: Create Global Variable From the Appium Service Builder Object
    public AppiumDriverLocalService service;

    // Step 2: Create Global Variable From the Android Driver Object
    public AndroidDriver driver;

    // Step 3: Create Global Variable From the Soft Assert Object
    public SoftAssert soft;

    // Step 4: Create Global Variable From the Web Driver Wait Object
    public static WebDriverWait wait;

    // Make The Pages As Global
    public P01_SignIn signIn;
    public P02_AddToCart addToCart;
    public P03_Cart cart;

    @BeforeMethod
    public void OpenSetUp () throws MalformedURLException, URISyntaxException
    {
        // Step 1: Create Object From Class Appium Service Builder
        service = new AppiumServiceBuilder().withAppiumJS(new File("//Users//essamfahmy//node_modules//appium//build//lib//main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();

        // Step 2: Start Server
        service.start();

        // Step 3: Create Object From Class "UiAutomator2Options" To Handle Emulator SetUp
        UiAutomator2Options setup = new UiAutomator2Options();

        // Step 4: Set The Emulator Name
        setup.setDeviceName("emulator-5554");

        // Step 5: Set The APK File Path
        setup.setApp("/Users/essamfahmy/IdeaProjects/appuim_project_using_page_object_module_design_pattern/src/main/resources/General-Store.apk");
        setup.setChromedriverExecutable("/Users/essamfahmy/IdeaProjects/appuim_project_using_page_object_module_design_pattern/src/main/resources/chromedriver_mac64/chromedriver");

        // Step 6: Create Object From Android Driver Class
        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),setup);

        // Step 7: Manage Unconditional Synchronisation "Implicit Wait"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // Step 8: Manage Unconditional Synchronisation "Explicit Wait"
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        // Step 9: Create Object From Class Soft Assert
        soft = new SoftAssert();

        //Step 10: Create Objects For All pages
        signIn = new P01_SignIn(driver);
        addToCart = new P02_AddToCart(driver);
        cart = new P03_Cart(driver);
    }

    @AfterMethod
    public void CloseSetUp () throws InterruptedException {
        // Step 1: Manage unconditional synchronization
        Thread.sleep(3000);

        // Step 2: Close Driver
        driver.quit();

        //  Step 3: Stop Service
        service.stop();
    }

}
