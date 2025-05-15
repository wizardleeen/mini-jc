package lexer;

import junit.framework.TestCase;
import org.junit.Assert;
import testcode.TestCode;

import java.util.List;

public class LexerTest extends TestCase {

    public void test() {
        var expectedTokens = List.of(
                new Token(TokenKind.PUBLIC, "public"),
                new Token(TokenKind.CLASS, "class"),
                new Token(TokenKind.IDENTIFIER, "HelloWorld"),
                new Token(TokenKind.LBRACE, "{"),
                new Token(TokenKind.PUBLIC, "public"),
                new Token(TokenKind.STATIC, "static"),
                new Token(TokenKind.VOID, "void"),
                new Token(TokenKind.IDENTIFIER, "main"),
                new Token(TokenKind.LPAREN, "("),
                new Token(TokenKind.IDENTIFIER, "String"),
                new Token(TokenKind.LBRACKET, "["),
                new Token(TokenKind.RBRACKET, "]"),
                new Token(TokenKind.IDENTIFIER, "args"),
                new Token(TokenKind.RPAREN, ")"),
                new Token(TokenKind.LBRACE, "{"),
                new Token(TokenKind.IDENTIFIER, "System"),
                new Token(TokenKind.DOT, "."),
                new Token(TokenKind.IDENTIFIER, "out"),
                new Token(TokenKind.DOT, "."),
                new Token(TokenKind.IDENTIFIER, "println"),
                new Token(TokenKind.LPAREN, "("),
                new Token(TokenKind.STRING_LITERAL, "Hello, World!"),
                new Token(TokenKind.RPAREN, ")"),
                new Token(TokenKind.SEMICOLON, ";"),
                new Token(TokenKind.RBRACE, "}"),
                new Token(TokenKind.RBRACE, "}"),
                new Token(TokenKind.EOF, "")
        );
        var lexer = new Lexer(TestCode.HELLO_WORLD.toCharArray());
        for (Token expectedToken : expectedTokens) {
            Assert.assertEquals(expectedToken, lexer.nextToken());
        }
    }

}