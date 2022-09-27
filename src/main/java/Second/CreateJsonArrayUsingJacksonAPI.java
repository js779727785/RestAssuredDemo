package Second;

import java.util.Arrays;
import java.util.Iterator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Test;
import sun.jvm.hotspot.oops.ObjArray;

/*
 * [
   {
      "firstname":"Jim",
      "lastname":"Brown",
      "totalprice":111,
      "depositpaid":true,
      "additionalneeds":"Breakfast",
      "bookingdates":{
         "checkin":"2021-07-01",
         "checkout":"2021-07-01"
      }
   },
   {
      "firstname":"Amod",
      "lastname":"Mahajan",
      "totalprice":222,
      "depositpaid":true,
      "additionalneeds":"Lunch",
      "bookingdates":{
         "checkin":"2022-07-01",
         "checkout":"2022-07-01"
      }
   }
]
 *
 */

public class CreateJsonArrayUsingJacksonAPI {
    @Test
    public void Demo() throws JsonProcessingException{
        ObjectMapper obm=new ObjectMapper();
        ObjectNode obn=obm.createObjectNode();
        obn.put("a",1);
        obn.put("b",2);
        ObjectNode obn2=obm.createObjectNode();
        obn2.set("other",obn);
        obn2.put("c",4);
        String res=obm.writerWithDefaultPrettyPrinter().writeValueAsString(obn2);
//        System.out.print(res);
        ArrayNode oblis=obm.createArrayNode();
        oblis.add(obn2);
        oblis.add(obn);
//        oblis.addAll(Arrays.asList(obn2,obn));
        System.out.println(obm.writerWithDefaultPrettyPrinter().writeValueAsString(oblis));
        System.out.println(oblis.get(0));
        System.out.println(oblis.size());
        Iterator<JsonNode> v=oblis.elements();
        while (v.hasNext()){
            System.out.println(v.next());
        }
        Iterator<String> k =oblis.fieldNames();
        while (k.hasNext()){
            System.out.println(k.next());
        }
    }

    public static void main(String[] args) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        // Create an array which will hold two JSON objects
        ArrayNode parentArray =  objectMapper.createArrayNode();

        // Creating Node that maps to JSON Object structures in JSON content
        ObjectNode firstBookingDetails = objectMapper.createObjectNode();

        // It is similar to map put method. put method is overloaded to accept different types of data
        // String as field value
        firstBookingDetails.put("firstname", "Jim");
        firstBookingDetails.put("lastname", "Brown");
        // integer as field value
        firstBookingDetails.put("totalprice", 111);
        // boolean as field value
        firstBookingDetails.put("depositpaid", true);
        firstBookingDetails.put("additionalneeds", "Breakfast");

        // Since requirement is to create a nested JSON Object
        ObjectNode firstBookingDateDetails = objectMapper.createObjectNode();
        firstBookingDateDetails.put("checkin", "2021-07-01");
        firstBookingDateDetails.put("checkout", "2021-07-01");

        // Since 2.4 , put(String fieldName, JsonNode value) is deprecated. So use either set(String fieldName, JsonNode value) or replace(String fieldName, JsonNode value)
        firstBookingDetails.set("bookingdates", firstBookingDateDetails);


        // Creating Node that maps to JSON Object structures in JSON content
        ObjectNode secondBookingDetails = objectMapper.createObjectNode();

        // It is similar to map put method. put method is overloaded to accept different types of data
        // String as field value
        secondBookingDetails.put("firstname", "Amod");
        secondBookingDetails.put("lastname", "Mahajan");
        // integer as field value
        secondBookingDetails.put("totalprice", 222);
        // boolean as field value
        secondBookingDetails.put("depositpaid", true);
        secondBookingDetails.put("additionalneeds", "Breakfast");

        // Since requirement is to create a nested JSON Object
        ObjectNode secondBookingDateDetails = objectMapper.createObjectNode();
        secondBookingDateDetails.put("checkin", "2022-07-01");
        secondBookingDateDetails.put("checkout", "2022-07-01");

        // Since 2.4 , put(String fieldName, JsonNode value) is deprecated. So use either set(String fieldName, JsonNode value) or replace(String fieldName, JsonNode value)
        secondBookingDetails.set("bookingdates", secondBookingDateDetails);


        parentArray.add(firstBookingDetails);
        parentArray.add(secondBookingDetails);

        // OR
        parentArray.addAll(Arrays.asList(firstBookingDetails,secondBookingDetails));

        String jsonArrayAsString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(parentArray);
        System.out.println("Created Json Array is : ");
        System.out.println(jsonArrayAsString);
        System.out.println("=======================================================================================");
        // To get json array element using index
        JsonNode firstElement = parentArray.get(0);
        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(firstElement));
        System.out.println("=======================================================================================");
        // To get size of JSON array
        int sizeOfArray = parentArray.size();
        System.out.println("Size of array is "+sizeOfArray);
        System.out.println("=======================================================================================");
        // To iterate JSON Array
        Iterator<JsonNode> iteraor = parentArray.iterator();
        System.out.println("Prining Json Node using iterator : ");
        while(iteraor.hasNext())
        {
            JsonNode currentJsonNode = iteraor.next();
            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(currentJsonNode));
        }
        System.out.println("=======================================================================================");
        // To remove an element from array
        parentArray.remove(0);
        System.out.println("After removing first element from array : "+ objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(parentArray));
        System.out.println("=======================================================================================");
        // To empty JSON Array
        parentArray.removeAll();
        System.out.println("After removing all elements from array : "+ objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(parentArray));

    }



}
