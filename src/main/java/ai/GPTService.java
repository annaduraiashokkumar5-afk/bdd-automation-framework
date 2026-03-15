package ai;


import okhttp3.*;
import org.json.JSONObject;

public class GPTService {

    private static final String API_KEY = System.getenv("OPENAI_API_KEY");

    public static String askGPT(String prompt) {

        try {

            OkHttpClient client = new OkHttpClient();

            JSONObject json = new JSONObject();
            json.put("model", "gpt-4.1-mini");
            json.put("input", prompt);

            RequestBody body = RequestBody.create(json.toString(), MediaType.parse("application/json"));

            Request request = new Request.Builder()
                    .url("https://api.openai.com/v1/responses")
                    .post(body)
                    .addHeader("Authorization", "Bearer " + API_KEY)
                    .addHeader("Content-Type", "application/json")
                    .build();

            Response response = client.newCall(request).execute();

            String responseBody = response.body().string();

            JSONObject obj = new JSONObject(responseBody);

            return obj.toString();

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }
}