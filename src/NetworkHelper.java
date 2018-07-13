import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by salamon on 11.07.18.
 */
public class NetworkHelper {
private static  final  String avalUrl = "https://tickets.fifa.com/API/WCachedL1/en/Availability/GetAvailability";


    public static void getRequest() throws Exception{
        URLConnection connection = new URL(avalUrl).openConnection();

        InputStream is = connection.getInputStream();
        InputStreamReader reader = new InputStreamReader(is);
        char[] buffer = new char[256];
        int rc;

        StringBuilder sb = new StringBuilder();

        while ((rc = reader.read(buffer)) != -1)
            sb.append(buffer, 0, rc);

        reader.close();

        JsonParser.parseJson(sb.toString());
    }
}
