package Third;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

//嵌套时with的使用
public class EditJsonObjectOnFly4 {

    @Test
    public void quickEditToJsonObject() throws JsonMappingException, JsonProcessingException {
        String jsonObject = "{\r\n" +
                "  \"firstname\" : \"Kevin\",\r\n" +
                "  \"lastname\" : \"Zhang\",\r\n" +
                "  \"bookingDetails\" : {\r\n" +
                "    \"firstname\" : \"Jim\",\r\n" +
                "    \"lastname\" : \"Brown\"\r\n" +
                "  }\r\n" +
                "}";

        // Creating an instance of ObjectMapper class
        ObjectMapper objectMapper = new ObjectMapper();
        // Get ObjectNode representation of json as json is an Object
        ObjectNode objectNode = objectMapper.readValue(jsonObject, ObjectNode.class);

        objectNode.put("firstname", "Peter");
        objectNode.with("bookingDetails").put("firstname", "Rahul");
//        objectNode.with("bookingDetails").remove("firstname");
        System.out.println(objectNode.toPrettyString());
    }

}

