package ast;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

// Call expression
@Data
@AllArgsConstructor
public class CallExpr implements Expr {
    private Expr func;
    private List<Expr> args;
}
