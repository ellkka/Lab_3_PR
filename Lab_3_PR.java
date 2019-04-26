
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Lab_3_PR {

    public static void main(String[] args) throws Exception {
        Lab_3_PR http = new Lab_3_PR();

        System.out.println("Send Http GET request");
        http.sendGet();
        System.out.println( );
        System.out.println("Send Http POST request");
        http.sendPost();
        System.out.println();
        System.out.println("Send Http PUT request");
        http.sendPut();
        System.out.println();
        System.out.println("Send Http DELETE request");
        http.sendDelete();
    }
    // HTTPS GET request
    private void sendGet() throws  Exception{
            URL url = new URL("https://postman-echo.com/get");
            HttpURLConnection connectionGET = (HttpURLConnection) url.openConnection();
            connectionGET.setRequestMethod("GET");

            String bodyGet = connectionGET.getResponseMessage();
            int responseCode = connectionGET.getResponseCode();
            System.out.println();
            System.out.println("Sending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);
            System.out.println("Body - " + bodyGet);
        StringBuilder result = new StringBuilder();
        BufferedReader rd = new BufferedReader(new InputStreamReader(connectionGET.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        System.out.println("Result text is : " + result.toString());
    }

        // HTTPS POST request
        private void sendPost() throws Exception {
            //            URL url = new URL("https://postman-echo.com/post");
            URL url = new URL("https://jsonplaceholder.typicode.com/posts");
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
            httpCon.setDoOutput(true);
            httpCon.setRequestMethod("POST");
            String parametr, argument;
            Scanner S1 =new Scanner(System.in);
            parametr= S1.next();
            Scanner S2 =new Scanner(System.in);
            argument= S2.next();
            httpCon.setRequestProperty(parametr,argument);
            httpCon.setRequestProperty("Content-Type", "application/json");
            OutputStream os = httpCon.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
//            osw.write("userId", "id");
            osw.flush();
            osw.close();
            os.close();
            httpCon.connect();
            //don't forget to close the OutputStream
            int responseCode = httpCon.getResponseCode();
            System.out.println("\nSending 'POST' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);

            StringBuilder result = new StringBuilder();
            BufferedReader rd = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();
            System.out.println("Result text is : " + result.toString());


        }

    // HTTPS PUT request
    private void sendDelete() throws Exception{
        URL url = new URL("https://postman-echo.com/delete");
        HttpURLConnection connectionDelete = (HttpURLConnection) url.openConnection();
        connectionDelete.setRequestMethod("DELETE");
        int responseCode = connectionDelete.getResponseCode();
        System.out.println("\nSending 'DELETE' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        StringBuilder result = new StringBuilder();
        BufferedReader rd = new BufferedReader(new InputStreamReader(connectionDelete.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        System.out.println("Result text is : " + result.toString());
    }

    // HTTPS DELETE request
    private void sendPut() throws Exception{
        URL url = new URL("https://postman-echo.com/put");
        HttpURLConnection connectionPUT = (HttpURLConnection) url.openConnection();
        connectionPUT.setRequestMethod("PUT");
        int responseCode = connectionPUT.getResponseCode();
        System.out.println("\nSending 'PUT' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        StringBuilder result = new StringBuilder();
        BufferedReader rd = new BufferedReader(new InputStreamReader(connectionPUT.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        System.out.println("Result text is : " + result.toString());
    }
}