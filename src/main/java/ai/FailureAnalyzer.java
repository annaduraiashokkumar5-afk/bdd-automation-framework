package ai;

public class FailureAnalyzer {

    public static void analyzeFailure(String error){

        String prompt =
                "Explain the root cause of this selenium failure: "
                        + error;

        String result = GPTService.askGPT(prompt);

        System.out.println("AI Failure Analysis:");
        System.out.println(result);
    }

}
