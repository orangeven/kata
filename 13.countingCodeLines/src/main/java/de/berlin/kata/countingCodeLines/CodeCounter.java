package de.berlin.kata.countingCodeLines;

public class CodeCounter {

    public static int countLines(String code) {
        String effectiveCode = removeBlockComments(code);
        effectiveCode = removeSingleComments(effectiveCode);
        effectiveCode = removeEmptyLines(effectiveCode);
        return getCodeLines(effectiveCode);
    }

    private static int getCodeLines(String code) {
        String trimmedCode = code.trim();
        if (trimmedCode.equals("")) {
            return 0;
        } else {
            return trimmedCode.split("[\r\n]").length;
        }
    }

    private static String removeEmptyLines(String code) {
        return code.replaceAll("(?m)^\\s*", "");
    }

    private static String removeSingleComments(String code) {
        return code.replaceAll("\\s*//.*", "");
    }

    private static String removeBlockComments(String code) {
        return code.replaceAll("(?s)/\\*.+?\\*/", "");
    }

}
