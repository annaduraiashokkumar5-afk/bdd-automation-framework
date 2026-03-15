package ai;

public class AIDataGenerator {

    public static String generateEmail(){

        String prompt = "Generate a random test email for login testing.";

        return GPTService.askGPT(prompt);
    }
}
