import java.io.*;
import java.net.*;

public class Get{

    public static String Get(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL("https://docs.postman-echo.com");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
//        conn.setRequestMethod("POST");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();
    }

    public static void main(String[] args) throws Exception
    {
        System.out.println(Get("https://docs.postman-echo.com"));
    }
}

