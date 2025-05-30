package sym;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Pkg implements Sym {
    private String name;
    private @Nullable Pkg parent;
    private final List<Pkg> pkgs = new ArrayList<>();
    private final List<Clazz> classes = new ArrayList<>();

    public Pkg(String name, @Nullable Pkg parent) {
        this.name = name;
        this.parent = parent;
        if (parent != null)
            parent.pkgs.add(this);
    }

    void addClazz(Clazz clazz) {
        classes.add(clazz);
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pkg getParent() {
        return parent;
    }

    public void setParent(Pkg parent) {
        this.parent = parent;
    }

    public List<Pkg> getPkgs() {
        return pkgs;
    }

    public List<Clazz> getClasses() {
        return classes;
    }
}
