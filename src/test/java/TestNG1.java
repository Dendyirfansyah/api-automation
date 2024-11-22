import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import example.RetryTest;
import example.StaticProvider;

public class TestNG1 {


    // @DataProvider(name = "test1")
    // public Object[][] personObjects(){
    //     return new Object[][]{
    //         {"Rudy", 30},
    //         {"Isabella", 20}
    //     };
    // }

    // Parameter
    @Parameters({"program"})
    @Test
    public void scenarioParam(String params){
        System.out.println("Ini adalah sebuah parameter "+ params);
        Assert.assertEquals(params, "Api Automation");
    }

    //Parameter
    @Test(dataProvider = "test1", dataProviderClass = StaticProvider.class)
    public void scenarioParam(String name, int age){
        System.out.println("Namanya adalah testng1:" + name);
        System.out.println("Umurnya adalah testng1" + age);
    }

    @Test(retryAnalyzer = RetryTest.class)
    public void testRetry(){
        System.out.println("Ini adalah retry test");
        assert false;
    }
}
