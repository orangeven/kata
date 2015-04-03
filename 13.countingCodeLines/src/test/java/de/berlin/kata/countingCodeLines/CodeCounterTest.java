package de.berlin.kata.countingCodeLines;

import org.junit.Assert;
import org.junit.Test;

public class CodeCounterTest {

    @Test
    public void codeBetweenBlockCommentsShouldBeCounted(){
        // block comment match should not be greedy!
        String code = " /* block comment */ int i= 1; /* another block comment */";
        Assert.assertEquals(1,  CodeCounter.countLines(code));
    }

    @Test
    public void multipleLineCodesShouldBeCounted(){
        String code= "public interface Dave {\n " +
                "\n" +
                "   int countLines(File inFile); " +
                "\n" +
                "}" ;
        Assert.assertEquals(3, CodeCounter.countLines(code));
    }

    @Test
    public void sinlgeLineCommentInsideTextShouldBeCounted(){
        String code = "String s= \"// single comment line \" ";
        Assert.assertEquals(1, CodeCounter.countLines(code));
    }
    @Test
    public void codeWithBlockCommentShouldBeCounted(){
        String code = "System./*wait*/out./*for*/println/*it*/(\"Hello/*\")";
        Assert.assertEquals(1, CodeCounter.countLines(code));
    }

    @Test
    public void codeLineWithSingleCommentAtTheEndShouldBeCounted(){
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
        Assert.assertEquals(0,  CodeCounter.countLines(code));
    }

    @Test
    public void blockCommentInMultipleLinesShouldNotBeCountedAsCode() {
        String code = "   /*\n" +
                "     block comment in mutiple lines\n" +
                "    */\n";
        Assert.assertEquals(0,  CodeCounter.countLines(code));
    }

    @Test
    public void javaDocInSingleLineShouldNotBeCountedAsCode() {
        String code = " /** javadoc comment */  ";
        Assert.assertEquals(0,  CodeCounter.countLines(code));
    }

    @Test
    public void javaDocInMultipleLinesShouldNotBeCountedAsCode() {
        String code = "   /**\n" +
                "    * javadoc in mutiple lines\n" +
                "    */\n";
        Assert.assertEquals(0,  CodeCounter.countLines(code));
    }

    @Test
    public void complexCodeExample(){
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

}
