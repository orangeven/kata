package de.berlin.kata.countingCodeLines;

public class CodeCounter {

    public static int countLines(String code) {
        String effectiveCode= removeBlockComment(code);
        effectiveCode = removeSingleComment(effectiveCode);
        effectiveCode = removeEmptyLine(effectiveCode);
        return getCodeLines(effectiveCode);
    }

    private static int getCodeLines(String code) {
        String trimmedcode = code.trim();
        if(trimmedcode.equals("")) {
            return 0;
        }else {
            return trimmedcode.split("[\r\n]").length;
        }
    }

    private static String removeEmptyLine(String code) {
        return code.replaceAll("(?m)^\\s*","");
    }

    private static String removeSingleComment(String code) {
        return code.replaceAll("\\s*//.*","");
    }

    private static String removeBlockComment(String code) {
        return code.replaceAll("(?s)/\\*.+?\\*/", "");
    }

}
