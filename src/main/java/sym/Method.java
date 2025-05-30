package sym;

import type.Type;

import java.util.ArrayList;
import java.util.List;

public class Method implements Sym {
    private Access access;
    private boolean static_;
    private Type retType;
    private String name;
    private final List<Param> params = new ArrayList<>();
    private final Clazz clazz;

    public Method(Access access, boolean static_, Type retType, String name, Clazz clazz) {
        this.access = access;
        this.static_ = static_;
        this.retType = retType;
        this.name = name;
        this.clazz = clazz;
        clazz.addMethod(this);
    }

    void addParam(Param param) {
        params.add(param);
    }

    public Type getRetType() {
        return retType;
    }

    public void setRetType(Type retType) {
        this.retType = retType;
    }

    public Access getAccess() {
        return access;
    }

    public void setAccess(Access access) {
        this.access = access;
    }

    public boolean isStatic_() {
        return static_;
    }

    public void setStatic_(boolean static_) {
        this.static_ = static_;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Param> getParams() {
        return params;
    }

    public Clazz getClazz() {
        return clazz;
    }
}
