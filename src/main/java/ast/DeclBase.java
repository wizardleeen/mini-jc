package ast;

import sym.Sym;

public abstract class DeclBase<T extends Sym> implements Decl<T> {

    private T sym;

    @Override
    public T getSym() {
        return sym;
    }

    @Override
    public void setSym(T sym) {
        this.sym = sym;
    }
}
