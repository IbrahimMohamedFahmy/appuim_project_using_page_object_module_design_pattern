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

public class T01_SignIn extends SuperClass
{
    @Test
    public void Test()
    {

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
