package analyze;

import ast.*;
import sym.*;
import type.NoType;

import java.util.LinkedList;
import java.util.List;

public class Enter extends StructuralNodeVisitor {
    private final SymTab symTab;
    private final LinkedList<Sym> symStack = new LinkedList<>();

    public Enter(SymTab symTab) {
        this.symTab = symTab;
    }

    @Override
    public Void visitClassDecl(ClassDecl classDecl) {
        var mods = parseMods(classDecl.getMods());
        var cls = new Clazz(
                mods.access,
                classDecl.getName(),
                List.of(symTab.getObjectCls()),
                symTab.getRootPkg()
        );
        classDecl.setSym(cls);
        symStack.push(cls);
        super.visitClassDecl(classDecl);
        symStack.pop();
        return null;
    }

    @Override
    public Void visitMethodDecl(MethodDecl methodDecl) {
        var mods = parseMods(methodDecl.getMods());
        var meth = new Method(
                mods.access,
                mods.static_(),
                NoType.instance,
                methodDecl.getName(),
                findEnclosingSym(Clazz.class)
        );
        methodDecl.setSym(meth);
        symStack.push(meth);
        super.visitMethodDecl(methodDecl);
        symStack.pop();
        return null;
    }

    @Override
    public Void visitParamDecl(ParamDecl paramDecl) {
        var param = new Param(
                NoType.instance,

                paramDecl.getName(),
                findEnclosingSym(Method.class)
        );
        paramDecl.setSym(param);
        return super.visitParamDecl(paramDecl);
    }

    private ParsedMods parseMods(List<Modifier> mods) {
        var acc = Access.PACkAGE;
        var static_ = false;
        for (Modifier mod : mods) {
            switch (mod) {
                case PUBLIC -> acc = Access.PUBLIC;
                case STATIC -> static_ = true;
            }
        }
        return new ParsedMods(acc, static_);
    }

    private record ParsedMods(
            Access access,
            boolean static_
    ) {}

    private <T extends Sym> T findEnclosingSym(Class<T> cls) {
        for (Sym sym : symStack) {
            if (cls.isInstance(sym))
                return (T) sym;
        }
        throw new IllegalStateException(
            "No enclosing symbol of type " + cls.getSimpleName() + " found in the stack: " + symStack);
    }

}
