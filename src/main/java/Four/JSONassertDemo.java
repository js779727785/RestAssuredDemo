package Four;

import org.json.JSONException;
import org.skyscreamer.jsonassert.Customization;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.comparator.CustomComparator;
import org.skyscreamer.jsonassert.comparator.JSONComparator;
import org.testng.annotations.Test;

import java.io.SyncFailedException;
/**
 * 引入JSONAssert
 * 1、可在内容一致的情况下比较顺序，大小写，类型
 * 2、LENIENT只有顺序不同，返回true
 * 3、JSON元素个数或filedName在比较项中不存在会抛异常
 * 4、自定义想忽略比较的元素用JSONComparator
 * **/
public class JSONassertDemo {
    @Test
    public void sameFieldsWithDifferentValues() throws JSONException {

        String jsoNobject1 = "{\r\n" +
                "  \"firstName\" : \"Amod\",\r\n" +
                "  \"lastName\": \"Mahajan\"\r\n" +
                "}";

        String jsonObject2 = "{\r\n" +
                "  \"lastName\": \"Mahajan\",\r\n" +
                "  \"firstName\": \"Rahul\"\r\n" +
                "}";

        JSONAssert.assertEquals(jsoNobject1, jsonObject2, JSONCompareMode.LENIENT);
        JSONAssert.assertEquals(jsoNobject1, jsonObject2, JSONCompareMode.STRICT);
        JSONAssert.assertEquals("Jsons are not equal", jsoNobject1, jsonObject2, false);
        try {
            JSONAssert.assertEquals(jsoNobject1,jsonObject2,true);
        }
        catch (Error e){
            System.out.println("Error occured as JSONs are not same.");
        }

//        JSONAssert.assertEquals(jsonObject1.getJSONObject("address"), jsonObject2.getJSONObject("communicationAddress"), JSONCompareMode.LENIENT);
//        JSONAssert.assertEquals(jSONArray1.getJSONObject(0), jSONArray2.getJSONObject(0), JSONCompareMode.LENIENT);

//        JSONComparator com = new CustomComparator(JSONCompareMode.STRICT,
//                new Customization("[0].mob[1].number",(o1, o2) -> true));
//
//        JSONAssert.assertEquals(s1, s2, com);




    }
}

