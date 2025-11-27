package TestCases;

import SetUp.SuperClass;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class T01_SignIn extends SuperClass
{
    @Test(groups = {"Happy Scenarios", "All Scenarios"}, priority = 1, dataProvider = "TestData")
    public void SignInWithValidFemaleData(HashMap<String, String> input) throws InterruptedException {
        // Step 1: Check The SignIn Page, Title
        soft.assertEquals(signIn.GetPageTitle(), input.get("SignInTitle"));

        // Step 2: Open The Country Drop Down Menu
        signIn.OpenCountryMenu();

        // Step 3: Scroll To Get Egypt
        signIn.Scroll(input.get("CountryE"));

        // Step 4: Choice Egypt From The Menu
        signIn.GetEgypt();

        // Step 5: Check The Name Of Label Name Filed
        soft.assertEquals(signIn.GetLabelNameFiled(), input.get("LabelNameFiled"));

        // Step 6: Get The Name Text Filed And Type a Valid Name
        signIn.TypeName(input.get("FemaleName"));

        // Step 7: Hide The KeYBoard
        signIn.HidekeyBoard();

        // Step 8: Check The Mela Check Box Status Is True
        soft.assertEquals(signIn.GetMelaCheckBoxStatus(), input.get("MelaTrue"));

        // Step 9: Check The Female Check Box Status is False
        soft.assertEquals(signIn.GetFemaleCheckBoxStatus(), input.get("FemaleFalse"));

        // Step 10: Check The Female Check Box
        signIn.CheckFemale();

        // Step 11: Check The Female Check Box Status is True
        soft.assertEquals(signIn.GetFemaleCheckBoxStatus(), input.get("FemaleTrue"));

        // Step 12: Check The Mela Check Box Status Is False
        soft.assertEquals(signIn.GetMelaCheckBoxStatus(), input.get("MelaFalse"));

        // Step 13: Get The Submit Button And Click On it
        signIn.OpenProductPage();

        // Step 14: Check The User Reach to The Products Page
        soft.assertEquals(signIn.GetPageTitle(), input.get("ProductsPage"));
    }

    @Test(groups = {"Happy Scenarios", "All Scenarios"}, priority = 2, dataProvider = "TestData")
    public void SignInWithValidMelaData(HashMap<String, String> input) throws InterruptedException {
        // Step 1: Check The SignIn Page, Title
        soft.assertEquals(signIn.GetPageTitle(), input.get("SignInTitle"));

        // Step 2: Open The Country Drop Down Menu
        signIn.OpenCountryMenu();

        // Step 3: Scroll To Get Egypt
        signIn.Scroll(input.get("CountryE"));

        // Step 4: Choice Egypt From The Menu
        signIn.GetEgypt();

        // Step 5: Check The Name Of Label Name Filed
        soft.assertEquals(signIn.GetLabelNameFiled(), input.get("LabelNameFiled"));

        // Step 6: Get The Name Text Filed And Type a Valid Name
        signIn.TypeName(input.get("MaleName"));

        // Step 7: Hide The KeYBoard
        signIn.HidekeyBoard();

        // Step 8: Check The Mela Check Box Status Is True
        soft.assertEquals(signIn.GetMelaCheckBoxStatus(), input.get("MelaTrue"));

        // Step 9: Check The Female Check Box Status is False
        soft.assertEquals(signIn.GetFemaleCheckBoxStatus(), input.get("FemaleFalse"));

        // Step 10: Get The Submit Button And Click On it
        signIn.OpenProductPage();

        // Step 11: Check The User Reach to The Products Page
        soft.assertEquals(signIn.GetPageTitle(), input.get("ProductsPage"));
    }

    @Test(groups = {"Happy Scenarios", "All Scenarios"}, priority = 3, dataProvider = "TestData")
    public void SignInWithValidFemaleDataAndAnotherCountry(HashMap<String, String> input) throws InterruptedException {
        // Step 1: Check The SignIn Page, Title
        soft.assertEquals(signIn.GetPageTitle(), input.get("SignInTitle"));

        // Step 2: Open The Country Drop Down Menu
        signIn.OpenCountryMenu();

        // Step 3: Scroll To Get Egypt
        signIn.Scroll(input.get("CountryA"));

        // Step 4: Choice Egypt From The Menu
        signIn.GetArmenia();

        // Step 5: Check The Name Of Label Name Filed
        soft.assertEquals(signIn.GetLabelNameFiled(), input.get("LabelNameFiled"));

        // Step 6: Get The Name Text Filed And Type a Valid Name
        signIn.TypeName(input.get("FemaleName"));

        // Step 7: Hide The KeYBoard
        signIn.HidekeyBoard();

        // Step 8: Check The Mela Check Box Status Is True
        soft.assertEquals(signIn.GetMelaCheckBoxStatus(), input.get("MelaTrue"));

        // Step 9: Check The Female Check Box Status is False
        soft.assertEquals(signIn.GetFemaleCheckBoxStatus(), input.get("FemaleFalse"));

        // Step 10: Check The Female Check Box
        signIn.CheckFemale();

        // Step 11: Check The Female Check Box Status is True
        soft.assertEquals(signIn.GetFemaleCheckBoxStatus(), input.get("FemaleTrue"));

        // Step 12: Check The Mela Check Box Status Is False
        soft.assertEquals(signIn.GetMelaCheckBoxStatus(), input.get("MelaFalse"));

        // Step 13: Get The Submit Button And Click On it
        signIn.OpenProductPage();

        // Step 14: Check The User Reach to The Products Page
        soft.assertEquals(signIn.GetPageTitle(), input.get("ProductsPage"));
    }

    @Test(groups = {"Sad Scenarios", "All Scenarios"}, priority = 4, dataProvider = "TestData")
    public void SignInWithoutName(HashMap<String, String> input) throws InterruptedException {
        // Step 1: Check The SignIn Page, Title
        soft.assertEquals(signIn.GetPageTitle(), input.get("SignInTitle"));

        // Step 2: Open The Country Drop Down Menu
        signIn.OpenCountryMenu();

        // Step 3: Scroll To Get Egypt
        signIn.Scroll(input.get("CountryE"));

        // Step 4: Choice Egypt From The Menu
        signIn.GetEgypt();

        // Step 5: Check The Name Of Label Name Filed
        soft.assertEquals(signIn.GetLabelNameFiled(), input.get("LabelNameFiled"));

        // Step 6: Check The Mela Check Box Status Is True
        soft.assertEquals(signIn.GetMelaCheckBoxStatus(), input.get("MelaTrue"));

        // Step 7: Check The Female Check Box Status is False
        soft.assertEquals(signIn.GetFemaleCheckBoxStatus(), input.get("FemaleFalse"));

        // Step 8: Check The Female Check Box
        signIn.CheckFemale();

        // Step 9: Check The Female Check Box Status is True
        soft.assertEquals(signIn.GetFemaleCheckBoxStatus(), input.get("FemaleTrue"));

        // Step 10: Check The Mela Check Box Status Is False
        soft.assertEquals(signIn.GetMelaCheckBoxStatus(), input.get("MelaFalse"));

        // Step 11: Get The Submit Button And Click On it
        signIn.OpenProductPage();

        // Step 12: Get The Validation Message
        soft.assertEquals(signIn.GetToastMessage(), input.get("SignInValidation"));

        // Step 13: Check The User Reach to The Products Page
        soft.assertEquals(signIn.GetPageTitle(), input.get("SignInPage"));
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
