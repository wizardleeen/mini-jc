package sym;

import type.Type;

public class Param implements Sym {
    private Type type;
    public String name;
    private final Method method;

    public Param(Type type, String name, Method method) {
        this.type = type;
        this.name = name;
        this.method = method;
        method.addParam(this);
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Method getMethod() {
        return method;
    }
}
