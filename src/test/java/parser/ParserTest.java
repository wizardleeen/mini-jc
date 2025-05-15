package parser;

import ast.*;
import junit.framework.TestCase;
import lexer.Lexer;
import org.junit.Assert;
import testcode.TestCode;

import java.util.List;

public class ParserTest extends TestCase {

    public void test() {
        /*
            public class HelloWorld {
                public static void main(String[] args) {
                    System.out.println("Hello, World!");
                }
            }
         */
        var expectedFile = new File(List.of(
                // public class HelloWorld { ... }
                new ClassDecl(
                        List.of(Modifier.PUBLIC),
                        "HelloWorld",
                        List.of(
                                 // public static void main(String[] args) { ... }
                                new MethodDecl(
                                        List.of(Modifier.PUBLIC, Modifier.STATIC),
                                        // void
                                        new TypeNode(
                                                new Ident("void")
                                        ),
                                        "main",
                                        List.of(
                                                // String[] args
                                                new ParamDecl(
                                                        // String[]
                                                        new TypeNode(
                                                                // String[]
                                                                new ArrayTypeExpr(
                                                                        // String
                                                                        new Ident("String")
                                                                )
                                                        ),
                                                        "args"
                                                )
                                        ),
                                        // { ... }
                                        new Block(List.of(
                                                // System.out.println("Hello, World!");
                                                new ExprStat(
                                                        // System.out.println("Hello, World!")
                                                        new CallExpr(
                                                           // System.out.println
                                                           new SelectorExpr(
                                                                   // System.out
                                                                   new SelectorExpr(
                                                                           // System
                                                                           new Ident("System"),
                                                                           "out"
                                                                   ),
                                                                   "println"
                                                           ),
                                                            List.of(
                                                                    // "Hello, World!"
                                                                    new Literal("Hello, World!")
                                                            )
                                                        )
                                                )
                                        ))
                                )
                        )
                )
        ));
        var parser = new Parser(new Lexer(TestCode.HELLO_WORLD.toCharArray()));
        var actualFile = parser.parse();
        Assert.assertEquals(expectedFile, actualFile);
    }

}