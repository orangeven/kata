package de.berlin.kata.countingCodeLines;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by quan on 02.04.15.
 */
public class CodeCounterTest {


    //TODO
    @Test
    public void countInterface(){
        String code="// This file contains 3 lines of code\n" +
                "public interface Dave {\n" +
                "   /**\n" +
                "    * count the number of lines in a file\n" +
                "    */\n" +
                "   int countLines(File inFile); // not the real signature!\n" +
                "}" ;
        Assert.assertEquals(3, CodeCounter.countLines(code));
    }

    //TODO add test for block comment greedy
    @Test
    public void countClass(){
        String code ="/*****\n" +
                "   * This is a test program with 5 lines of code\n" +
                "   *  \\/* no nesting allowed!\n" +
                "   //*****//***/// Slightly pathological comment ending...\n" +
                "  \n" +
                "   public class Hello {\n" +
                "       public static final void main(String [] args) { // gotta love Java\n" +
                "           // Say hello\n" +
                "           System./*wait*/out./*for*/println/*it*/(\"Hello/*\");\n" +
                "       }\n" +
                "  \n" +
                "  }";
        Assert.assertEquals(5, CodeCounter.countLines(code));
    }

    @Test
    public void codeLineWithSingleCommentAtTheEndShouldBeCountedAsCode(){
        String code = "  int i = 0; // single comment line  ";
        Assert.assertEquals(1, CodeCounter.countLines(code));
    }

    @Test
    public void singleLineCommentShouldNotBeCountedAsCode() {
        String code = "   // single comment line  ";

        Assert.assertEquals(0, CodeCounter.countLines(code));

        code = "/////single comment line";

        Assert.assertEquals(0, CodeCounter.countLines(code));
    }

    @Test
    public void blockCommentInSingleLineShouldNotBeCountedAsCode() {
        String code = " /* block comment */  ";
        Assert.assertEquals(0, new CodeCounter().countLines(code));
    }

    @Test
    public void blockCommentInMultipleLinesShouldNotBeCountedAsCode() {
        String code = "   /*\n" +
                "     block comment in mutiple lines\n" +
                "    */\n";
        Assert.assertEquals(0, new CodeCounter().countLines(code));
    }

    @Test
    public void javaDocInSingleLineShouldNotBeCountedAsCode() {
        String code = " /** javadoc comment */  ";
        Assert.assertEquals(0, new CodeCounter().countLines(code));
    }

    @Test
    public void javaDocInMultipleLinesShouldNotBeCountedAsCode() {
        String code = "   /**\n" +
                "    * javadoc in mutiple lines\n" +
                "    */\n";
        Assert.assertEquals(0, new CodeCounter().countLines(code));
    }

}
