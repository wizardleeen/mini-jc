package ast;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.function.Consumer;

@Data
@AllArgsConstructor
public class ExprStat implements Stat {
    private Expr expr;

    @Override
    public <R> R accept(NodeVisitor<R> visitor) {
        return visitor.visitExprStat(this);
    }

    @Override
    public void forEachChild(Consumer<? super Node> action) {
        action.accept(expr);
    }
}
