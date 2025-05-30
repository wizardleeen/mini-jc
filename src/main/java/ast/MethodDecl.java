package ast;

import lombok.AllArgsConstructor;
import lombok.Data;
import sym.Method;

import java.util.List;
import java.util.function.Consumer;

@Data
@AllArgsConstructor
public class MethodDecl extends DeclBase<Method> {
    private List<Modifier> mods;
    private TypeNode retType;
    private String name;
    private List<ParamDecl> params;
    private Block body;

    @Override
    public <R> R accept(NodeVisitor<R> visitor) {
        return visitor.visitMethodDecl(this);
    }

    @Override
    public void forEachChild(Consumer<? super Node> action) {
        action.accept(retType);
        params.forEach(action);
        action.accept(body);
    }
}
