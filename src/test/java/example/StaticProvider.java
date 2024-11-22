package example;

import org.testng.annotations.DataProvider;

public class StaticProvider {
@DataProvider(name = "test1")
    public static Object[][] createData() {
        return new Object[][]{
            {"Rudy", 30},
            {"Isabella", 20}
        };
    };
  }

