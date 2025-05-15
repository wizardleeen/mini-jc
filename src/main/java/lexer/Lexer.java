package lexer;

public class Lexer {

    private final char[] buf;
    private int pos;

    public Lexer(char[] buf) {
        this.buf = buf;
    }

    public Token nextToken() {
        if (isEof())
            return new Token(TokenKind.EOF, "");
        return switch (get()) {
          // Whitespace
          case ' ', '\t', '\n', '\r' -> {
              skipWhitespaces();
              yield nextToken();
          }
          // Keywords or identifier
            case 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's','t','u','v','w','x','y','z', '_', '$' ->
                nextKeywordOrIdentifier();
          // String literal
            case '\"' ->
                nextStringLiteral();
            case '(' -> {
                pos++;
                yield new Token(TokenKind.LPAREN, "(");
            }
            case ')' -> {
                pos++;
                yield new Token(TokenKind.RPAREN, ")");
            }
            case '{' -> {
                pos++;
                yield new Token(TokenKind.LBRACE, "{");
            }
            case '}' -> {
                pos++;
                yield new Token(TokenKind.RBRACE, "}");
            }
            case '[' -> {
                pos++;
                yield new Token(TokenKind.LBRACKET, "[");
            }
            case ']' -> {
                pos++;
                yield new Token(TokenKind.RBRACKET, "]");
            }
            case '.' -> {
                pos++;
                yield new Token(TokenKind.DOT, ".");
            }
            case ',' -> {
                pos++;
                yield new Token(TokenKind.COMMA, ",");
            }
            case ';' -> {
                pos++;
                yield new Token(TokenKind.SEMICOLON, ";");
            }
            default -> throw new RuntimeException("Unexpected character: " + get());
        };
    }

    private Token nextStringLiteral() {
        var sb = new StringBuilder();
        accept('\"');
        while (!isEof() && get() != '\"') {
            sb.append(get());
            pos++;
        }
        accept('\"');
        return new Token(TokenKind.STRING_LITERAL, sb.toString());
    }

    private Token nextKeywordOrIdentifier() {
        var sb = new StringBuilder();
        while (!isEof() && Character.isJavaIdentifierPart(get())) {
            sb.append(get());
            pos++;
        }
        var text = sb.toString();
        var tk = switch (text) {
            case "public" -> TokenKind.PUBLIC;
            case "class" -> TokenKind.CLASS;
            case "static" -> TokenKind.STATIC;
            case "void" -> TokenKind.VOID;
            case "extends" -> TokenKind.EXTENDS;
            case "implements" -> TokenKind.IMPLEMENTS;
            default -> TokenKind.IDENTIFIER;
        };
        return new Token(tk, text);
    }

    private void skipWhitespaces() {
        while (!isEof() && Character.isWhitespace(get()))
            pos++;
    }

    private char get() {
        return buf[pos];
    }

    private void accept(char c) {
        if (get() == c)
            pos++;
        else
            throw new RuntimeException("Expected " + c + " but found " + get());
    }

    private boolean isEof() {
        return pos >= buf.length;
    }

}
