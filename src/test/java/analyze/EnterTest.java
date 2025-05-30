package analyze;

import junit.framework.TestCase;
import lexer.Lexer;
import parser.Parser;
import sym.Access;
import sym.SymTab;
import testcode.TestCode;

import java.util.List;

public class EnterTest extends TestCase {

    public void test() {
        /*
            public class HelloWorld {
                public static void main(String[] args) {
                    System.out.println("Hello, World!");
                }
            }
         */
        var parser = new Parser(new Lexer(TestCode.HELLO_WORLD.toCharArray()));
        var file = parser.parse();
        var symTab = new SymTab();
        file.accept(new Enter(symTab));
        var rootPkg = symTab.getRootPkg();
        assertEquals(1, rootPkg.getClasses().size());
        var cls = rootPkg.getClasses().getFirst();
        assertEquals("HelloWorld", cls.getName());
        assertSame(Access.PUBLIC, cls.getAccess());
        assertEquals(1, cls.getMethods().size());
        var meth = cls.getMethods().getFirst();
        assertEquals("main", meth.getName());
        assertSame(Access.PUBLIC, meth.getAccess());
        assertTrue(meth.isStatic_());
        assertEquals(1, meth.getParams().size());
        var param = meth.getParams().getFirst();
        assertEquals("args", param.getName());
        assertEquals(List.of(symTab.getObjectCls()), cls.getSuperTypes());
    }

}