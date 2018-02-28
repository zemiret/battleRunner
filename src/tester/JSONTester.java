package tester;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonValue;

import java.io.File;
import java.io.FileReader;
import java.net.URL;

public class JSONTester {

    public static void main(String[] args) {
        System.out.println("JSON Tester");


/*
        String jsonString = "{\n" +
                "  \"order\": 4711,\n" +
                "  \"items\": [\n" +
                "    {\n" +
                "      \"name\": \"NE555 Timer IC\",\n" +
                "      \"cat-id\": \"645723\",\n" +
                "      \"quantity\": 10\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"LM358N OpAmp IC\",\n" +
                "      \"cat-id\": \"764525\",\n" +
                "      \"quantity\": 2\n" +
                "    }\n" +
                "  ]\n" +
                "}";
*/


//        JsonArray items = Json.parse(jsonString).asObject().get("items").asArray();

//        URL url = getClass().getResource("test.json");
//        FileReader reader = new FileReader(new File("\/home\/amleczko\/dev\/learning\/java\/beginnings\/battleRunner\/src\/tester\/test.json"));
//        FileReader reader

        File file = new File("/home/amleczko/dev/learning/java/beginnings/battleRunner/src/tester/test.json");
        try {
            FileReader reader = new FileReader(file);

            JsonArray items = Json.parse(reader).asObject().get("items").asArray();
            for (JsonValue item : items) {
                String name = item.asObject().getString("name", "Unknown Item");
                int quantity = item.asObject().getInt("quantity", 1);

                System.out.println(name);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
