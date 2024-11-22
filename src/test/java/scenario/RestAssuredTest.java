package scenario;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredTest {

    public static void main(String[] args) {
        // GetAllObjects();
        // GetAllObjectsByIds();
        // AddObject();
        // DeleteObject("ff808181932badb601934eeb6aed5bfd");
    }

    //Api =  https://api.restful-api.dev/objects
    public static void GetAllObjects(){
        RestAssured.baseURI = "https://api.restful-api.dev/objects";
        RequestSpecification requestSpecification = RestAssured.given();

        //Get response
        Response response = requestSpecification.get();

        System.out.println("The response is" + response.asPrettyString());
        System.out.println("Status code" + response.getStatusCode());
    }

    public static void GetAllObjectsByIds(){
        RestAssured.baseURI = "https://api.restful-api.dev/objects/3";
        RequestSpecification requestSpecification = RestAssured.given();

        Response response = requestSpecification
                            .queryParam("id", 3)
                            .get();

        System.out.println("Response nya adalah" +  response.asPrettyString());
        /*
        expected result:
         [
                {
                    "id": "3",
                    "name": "Apple iPhone 12 Pro Max",
                    "data": {
                        "color": "Cloudy White",
                        "capacity GB": 512
                    }
                },
                {
                    "id": "10",
                    "name": "Apple iPad Mini 5th Gen",
                    "data": {
                        "Capacity": "64 GB",
                        "Screen size": 7.9
                    }
                },
                {
                    "id": "5",
                    "name": "Samsung Galaxy Z Fold2",
                    "data": {
                        "price": 689.99,
                        "color": "Brown"
                    }
                }
            ]
         */
        /*
         * Kita perlu extract get value dari response API
         */

         JsonPath jsonPath = response.jsonPath();

         System.out.println("Id:" + jsonPath.getString("id"));
         System.out.println("Name:" + jsonPath.getString("name"));
         System.out.println("Data:" + jsonPath.getString("data"));

        // Serialize dan deserialize

        /*
         * class Object{
         *  String id;
         *  String name;
         *  Data data;
         *  
         * class Data{
         *  String color;
         *  String capacity_GB;
         * }
         *  
         *  
         * }
         * 
         * Object object = new Object();
         * id = object.id;
         * name = object.name;
         * data = object.data.color;
         * capacityGB = object.data.capacity_GB
         * 
         * if object.id == 3{
         *  do something
         * }
         * 
         * 
         */

        /*
         * {
                    "id": "3",
                    "name": "Apple iPhone 12 Pro Max",
                    "data": {
                        "color": "Cloudy White",
                        "capacity GB": 512
                    }
                },
         */

    }

    public static void AddObject(){
        RestAssured.baseURI = "https://api.restful-api.dev/objects";
        RequestSpecification requestSpecification = RestAssured.given();

        String json ="{\n" + //
                        "   \"name\": \"Apple MacBook Pro 16\",\n" + //
                        "   \"data\": {\n" + //
                        "      \"year\": 2024 ,\n" + //
                        "      \"price\": 15000 ,\n" + //
                        "      \"CPU model\": \"Intel Core i9\",\n" + //
                        "      \"Hard disk size\": \"1 TB\"\n" + //
                        "   }\n" + //
                        "}";

        /*
          {
                "id": "ff808181932badb601934ede64485bc6",
                "name": "Apple MacBook Pro 16",
                "createdAt": "2024-11-21T13:16:57.800+00:00",
                "data": {
                    "year": 2019,
                    "price": 20000,
                    "CPU model": "Intel Core i9",
                    "Hard disk size": "1 TB"
                }
            }

            setelah update
            {
                "id": "ff808181932badb601934ede64485bc6",
                "name": "Apple MacBook Pro 16",
                "updatedAt": "2024-11-21T13:17:44.587+00:00",
                "data": {
                    "year": 2024,
                    "price": 15000,
                    "CPU model": "Intel Core i9",
                    "Hard disk size": "1 TB"
                }
            }
         */
        Response response = requestSpecification
                            .body(json)
                            .contentType("application/json")
                            .post();
        System.out.println("Response nya adalah : " + response.asPrettyString());
    }

    public static void DeleteObject(String idObject){
        RestAssured.baseURI = "https://api.restful-api.dev/objects";
        RequestSpecification requestSpecification = RestAssured.given();

        // String idObject = "3";

        Response response = requestSpecification
                            .pathParams("id", idObject)
                            .contentType("application/json")
                            .delete("{id}");
        
        System.out.println("hasil delete" +  response.asPrettyString());                                           
    }
}
