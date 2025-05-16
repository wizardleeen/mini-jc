package ast;

import junit.framework.TestCase;
import lexer.Lexer;
import parser.Parser;
import testcode.TestCode;

public class StructuralNodeVisitorTest extends TestCase {

    public void test() {
        var parser = new Parser(new Lexer(TestCode.HELLO_WORLD.toCharArray()));
        var file = parser.parse();
        var ref = new Object() {
            int totalCnt;
            int declCnt;
            int statCnt;
            int exprCnt;
            int typeCnt;
        };
        file.accept(new StructuralNodeVisitor() {

            @Override
            public Void visitNode(Node node) {
                ref.totalCnt++;
                return super.visitNode(node);
            }

            @Override
            public Void visitDecl(Decl decl) {
                ref.declCnt++;
                return super.visitDecl(decl);
            }

            @Override
            public Void visitStat(Stat stat) {
                ref.statCnt++;
                return super.visitStat(stat);
            }

            @Override
            public Void visitTypeNode(TypeNode typeNode) {
                ref.typeCnt++;
                return super.visitTypeNode(typeNode);
            }

            @Override
            public Void visitExpr(Expr expr) {
                ref.exprCnt++;
                return super.visitExpr(expr);
            }
        });
        assertEquals(16, ref.totalCnt);
        assertEquals(3, ref.declCnt);
        assertEquals(1, ref.statCnt);
        assertEquals(2, ref.typeCnt);
        assertEquals(8, ref.exprCnt);
    }


}