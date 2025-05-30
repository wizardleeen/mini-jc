package ast;

import sym.Sym;

// Declaration
public interface Decl<T extends Sym> extends Node {

    T getSym();

    void setSym(T sym);

}
