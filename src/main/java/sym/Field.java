package sym;

import type.Type;

public class Field implements Sym {
    private Access access;
    private boolean static_;
    private Type type;
    private String name;
    private final Clazz clazz;

    public Field(Access access, boolean static_, Type type, String name, Clazz clazz) {
        this.access = access;
        this.static_ = static_;
        this.type = type;
        this.name = name;
        this.clazz = clazz;
        clazz.addField(this);
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

    public Clazz getClazz() {
        return clazz;
    }
}
