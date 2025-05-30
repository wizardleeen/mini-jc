package sym;

import java.util.List;

public class SymTab {
    private final Pkg rootPkg = new Pkg("", null);
    private final Pkg javaPkg = new Pkg("java", rootPkg);
    private final Pkg langPkg = new Pkg("lang", javaPkg);
    private final Clazz objectCls = new Clazz(Access.PUBLIC, "Object", List.of(), langPkg);

    public Pkg getRootPkg() {
        return rootPkg;
    }

    public Pkg getJavaPkg() {
        return javaPkg;
    }

    public Pkg getLangPkg() {
        return langPkg;
    }

    public Clazz getObjectCls() {
        return objectCls;
    }
}
