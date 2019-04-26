import java.net.HttpURLConnection;
import java.net.URL;
import java.io.*;
import javax.net.ssl.HttpsURLConnection;

public class Main
{

    public static void main(String[] args) throws Exception {
        // GET
        String httpsURL = "https://docs.postman-echo.com";
        URL myUrl = new URL(httpsURL);
        HttpsURLConnection conn = (HttpsURLConnection)myUrl.openConnection();
        InputStream is = conn.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        String inputLine;

        while ((inputLine = br.readLine()) != null) {
            System.out.println(inputLine);
        }
        br.close();
        //PUT
        URL url_put = new URL("https://docs.postman-echo.com");
        HttpURLConnection httpConPUT = (HttpURLConnection) url_put.openConnection();
        httpConPUT.setDoOutput(true);
        httpConPUT.getRequestMethod();
        httpConPUT.setRequestMethod("PUT");
        OutputStreamWriter out = new OutputStreamWriter(
                httpConPUT.getOutputStream());
        out.write("Resource content");
        out.close();
        System.out.println("Response PUT is " + httpConPUT.getResponseCode());
        //To perform an HTTP DELETE:
        URL url_delete = new URL("http://www.appdomain.com/users/123");
        HttpURLConnection httpCon_DELETE = (HttpURLConnection) url_delete.openConnection();
        httpCon_DELETE.setDoOutput(true);

        httpCon_DELETE.setRequestMethod("DELETE");
        httpCon_DELETE.connect();
        System.out.println("Response PUT is " + httpCon_DELETE.getResponseCode());
    }

}

