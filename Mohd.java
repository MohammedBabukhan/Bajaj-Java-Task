import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Mohd {
    public static void main(String[] args) {
        try {
            String urlString = "https://bfhldevapigw.healthrx.co.in/hiring/generateWebhook/JAVA";
            URL url = new URL(urlString);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setDoOutput(true);

            String jsonInputString = "{"
                    + "\"name\": \"Mohammed Babukhanwala\","
                    + "\"regNo\": \"0827CS221164\","
                    + "\"email\": \"mohammedbabukhanwala220290@acropolis.in\""
                    + "}";


            // Send request
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                os.write(input);
            }

            // Read response
            int statusCode = conn.getResponseCode();
            System.out.println("Status Code: " + statusCode);

            try (BufferedReader br = new BufferedReader(new InputStreamReader(
                    conn.getInputStream(), StandardCharsets.UTF_8))) {
                StringBuilder response = new StringBuilder();
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println("Response Body: " + response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
