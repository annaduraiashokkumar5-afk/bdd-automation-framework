package ai.selfhealing;

import ai.GPTService;

public class XPathHealer {

    public static String healXpath(String failedLocator, String pageSource) {

        try {

            // Extract pure XPath from Selenium By locator
            String failedXpath = extractXpath(failedLocator);

            // Limit HTML size to avoid token limits
            String htmlSnippet = pageSource.substring(
                    0,
                    Math.min(pageSource.length(), 4000)
            );

            String prompt =
                    "A Selenium XPath locator failed.\n\n" +
                            "Failed XPath:\n" + failedXpath +
                            "\n\nBelow is the HTML of the page.\n" +
                            "Generate a stable XPath for the same element.\n" +
                            "Return ONLY the XPath.\n\nHTML:\n" +
                            htmlSnippet;

            String aiResponse = GPTService.askGPT(prompt);

            String healedXpath = extractXpath(aiResponse);

            if (healedXpath != null && healedXpath.startsWith("//")) {
                return healedXpath;
            }

            // fallback if AI fails
            return failedXpath;

        } catch (Exception e) {

            e.printStackTrace();

            return extractXpath(failedLocator);
        }
    }

    private static String extractXpath(String text) {

        if (text == null) return null;

        if (text.contains("xpath:")) {
            return text.substring(text.indexOf("xpath:") + 6).trim();
        }

        if (text.contains("//")) {
            return text.substring(text.indexOf("//")).trim();
        }

        return text;
    }
}