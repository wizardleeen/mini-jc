package ast;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.function.Consumer;

@Data
@AllArgsConstructor
public class Literal implements Expr {
    private Object value;

    @Override
    public <R> R accept(NodeVisitor<R> visitor) {
        return visitor.visitLiteral(this);
    }

    @Override
    public void forEachChild(Consumer<? super Node> action) {
    }
}
