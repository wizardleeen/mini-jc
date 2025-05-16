package ast;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.function.Consumer;

@Data
@AllArgsConstructor
public class ParamDecl implements Decl {
    private TypeNode type;
    private String name;

    @Override
    public <R> R accept(NodeVisitor<R> visitor) {
        return visitor.visitParamDecl(this);
    }

    @Override
    public void forEachChild(Consumer<? super Node> action) {
        action.accept(type);
    }
}
