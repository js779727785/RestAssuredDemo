package Second;

import java.util.Iterator;
import java.util.Map;

import jdk.internal.org.objectweb.asm.TypeReference;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;

public class GetAllKeysFromJsonObject {

    @Test
    public void getAllKeysFromNestedJsonObjectUsingJsonNode() throws JsonMappingException, JsonProcessingException
    {
        String jsonObject = "{\r\n" +
                "  \"firstName\": \"Animesh\",\r\n" +
                "  \"lastName\": \"Prashant\",\r\n" +
                "  \"address\": {\r\n" +
                "    \"city\": \"Katihar\",\r\n" +
                "    \"State\": \"Bihar\"\r\n" +
                "  }\r\n" +
                "}";
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode parsedJsonObject = objectMapper.readTree(jsonObject);
        Iterator<String> allKeys= parsedJsonObject.fieldNames();
        allKeys.forEachRemaining(k -> {
            Object value = parsedJsonObject.get(k);
            // TextNode can be related to String from previous example
            // You may need to add IntNode or BooleanNode for different types of values
            if(value instanceof TextNode)
                System.out.println(k);
                // ObjectNode can be related to LinkedHashMap from previous example
            else if(value instanceof ObjectNode)
            {
                Iterator<String> keyss = ((ObjectNode)value).fieldNames();
                keyss.forEachRemaining(ke -> System.out.println(ke));
            }

        });


    }

}

