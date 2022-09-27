package Second;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * 如果 JSON Object 或 JSON Array 嵌套比较深，那采用上面的语句就比较长且复杂了。
 * 我们可以用 at() 来代替，传入目标 node 的 path，类似文件 path
 * **/
public class ParseNestedJsonArrayToReadValues {

    @Test
    public void parseJsonArrayToReadValues() throws JsonMappingException, JsonProcessingException
    {
        String jsonArray = "[\r\n" +
                "  {\r\n" +
                "    \"firstName\": \"Amod\",\r\n" +
                "    \"lastName\": \"Mahajan\",\r\n" +
                "    \"address\": [\r\n" +
                "      {\r\n" +
                "        \"type\": \"Permanent\",\r\n" +
                "        \"city\": \"Bengaluru\",\r\n" +
                "        \"state\": \"Karnataka\"\r\n" +
                "      },\r\n" +
                "      {\r\n" +
                "        \"type\": \"Communication\",\r\n" +
                "        \"city\": \"Katihar\",\r\n" +
                "        \"state\": \"Bihar\"\r\n" +
                "      }\r\n" +
                "    ]\r\n" +
                "  },\r\n" +
                "  {\r\n" +
                "    \"firstName\": \"Animesh\",\r\n" +
                "    \"lastName\": \"Prashant\",\r\n" +
                "    \"address\": [\r\n" +
                "      {\r\n" +
                "        \"type\": \"Permanent\",\r\n" +
                "        \"city\": \"Delhi\",\r\n" +
                "        \"state\": \"Delhi\"\r\n" +
                "      },\r\n" +
                "      {\r\n" +
                "        \"type\": \"Communication\",\r\n" +
                "        \"city\": \"Indore\",\r\n" +
                "        \"state\": \"MP\"\r\n" +
                "      }\r\n" +
                "    ]\r\n" +
                "  }\r\n" +
                "]";


        // Creating an instance of ObjectMapper class
        ObjectMapper objectMapper = new ObjectMapper();
        // Get tree representation of json
        JsonNode jsonTree = objectMapper.readTree(jsonArray);

        // Using get method
        System.out.println(jsonTree.get(0).get("firstName").asText());
        System.out.println(jsonTree.get(0).get("address").get(0).get("type").asText());

        // Using at() method
        // Printing details of first indexed node
        System.out.println(jsonTree.at("/0/firstName").asText());
        System.out.println(jsonTree.at("/0/address/0/type").asText());
        System.out.println(jsonTree.at("/0/address/1/type").asText());

        // Printing details of second indexed node
        System.out.println(jsonTree.at("/1/firstName").asText());
        System.out.println(jsonTree.at("/1/address/0/type").asText());
        System.out.println(jsonTree.at("/1/address/1/type").asText());

    }

}

