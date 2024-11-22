import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import example.StaticProvider;

public class TestNG {

    String url;

    //Satu tempat untuk running scenario

    // scenario 20
    // 1.1.1.1 

    /*
     * scenario 20/5 = 4
     * 4.4.4.4
     */
    String fruits;

    @Test
    public void scenarioTest1(){
        //Drop your code
        System.out.println("Ini adalah scenario test 1");
        // Assert.assertEquals("accusamus ea aliquid et amet sequi nemo", "accusamus");
        System.out.println("Thread 1 " + Thread.currentThread().getId());
        System.out.println("url" +url);

    }

    @Test
    public void scenarioTest2(){
        //Drop your code
        System.out.println("Ini adalah scenario test 2");
        System.out.println("Thread 2 " + Thread.currentThread().getId());
        fruits = "apple";
        System.out.println("url" +url); 
    }

    @Test
    public void scenarioTest3(){
        //Drop your code
        System.out.println("Ini adalah scenario test 3");
        System.out.println("Thread 3 " + Thread.currentThread().getId());
        System.out.println("ini adalah buah" + fruits);
        System.out.println("url" +url);
    }

    /*
     * Parallel ini untuk menjalankan scenario di thread yang berbeda
     */

    @BeforeClass
    public void setUpClass(){
        System.out.println("Ini adalah setup class");
        url = "https://instagram.com";
    }

    @AfterClass
    public void setAfterClass(){
        System.out.println("Ini adalah setup after class");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Ini adalah setup before method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("Ini adalah setup after method");
    }

    //Parameter
    @Parameters({"program"})
    @Test
    public void scenarioParam(String params){
        System.out.println("Ini adalah sebuah parameter "+ params);
        Assert.assertEquals(params, "Api Automation");
    }
    

     //Parameter
     @Test(dataProvider = "test1", dataProviderClass = StaticProvider.class)
     public void scenarioParam(String name, int age){
         System.out.println("Namanya adalah:" + name);
         System.out.println("Umurnya adalah" + age);
     }

    
    /*
     * Retry ini berguna untuk program kita di execute sebayak yang kita pengen
     * Tujuaan semisal ada internet connection/ db down kita masih bisa retry
     */

    
}
