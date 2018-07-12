import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.*;

/**
 * Created by salamon on 11.07.18.
 */
public class JsonParser {
    private static final JSONParser jsonParser = new JSONParser();
    private static final String semiFianl = "IMT62";
    private static final String place3 = "IMT63";
    private static final String final1 = "IMT64";

    private static final Map<String, String> catMap = new HashMap<String, String>();
    private static List<String> gameList = new ArrayList<String>();

    static {
        catMap.put("14", "1");
        catMap.put("15", "2");
        catMap.put("16", "3");
        catMap.put("17", "4");
        gameList = Arrays.asList(semiFianl,place3,final1);
    }


    public static void parseJson(String json) throws Exception {

        Object obj = jsonParser.parse(json);

        JSONObject jsonObject = (JSONObject) obj;
        // loop array
        JSONArray msg = (JSONArray) jsonObject.get("Data");


        for (Object o : msg) {
            JSONObject item = (JSONObject) o;
            String playNumber = (String) item.get("p");
            String category = String.valueOf(item.get("c"));
            String available = String.valueOf(item.get("a"));
            boolean av = Integer.valueOf(available) > 0;
            if (av && gameList.contains(playNumber)) {
                Date date = new Date(System.currentTimeMillis());
                System.out.println(date);
                print(playNumber,category,available);
            } //else {
                //System.out.println("No avaliable tickcets");
            //}
        }
    }

    private static void print(String playNumber, String category, String available) {
        if((category = catMap.get(category))!=null) {
        if (playNumber.equals(semiFianl)) {
            System.out.println("Полуфинал - категория " + category + " количество " + available);
        } else if (playNumber.equals(place3)) {
            System.out.println("Матч за 3 - категория " + category + " количество " + available);
        } else if (playNumber.equals(final1)) {
            System.out.println("Финал - категория " + category + " количество " + available);
        }
    }
    }
}

