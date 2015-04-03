package de.berlin.kata.countingCodeLines;

import java.util.regex.Pattern;

/**
 * Created by quan on 02.04.15.
 */
public class CodeCounter {

    public int countLines(String code) {
        String effectiveCode= removeBlockComment(code);
        effectiveCode = removeSingleComment(effectiveCode);
        effectiveCode = removeEmptyLine(effectiveCode);
        return getCodeLines(effectiveCode);
    }

    private int getCodeLines(String code) {
        String trimmedcode = code.trim();
        if(trimmedcode.equals("")) {
            return 0;
        }else {
            return trimmedcode.split("[\r\n]").length;
        }
    }

    private String removeEmptyLine(String code) {
        return code.replaceAll("(?m)^\\s*","");
    }

    private String removeSingleComment(String code) {
        return code.replaceAll("\\s*//.*","");
    }

    private String removeBlockComment(String code) {
        return code.replaceAll("(?s)/\\*.+?\\*/", "");
    }

}
