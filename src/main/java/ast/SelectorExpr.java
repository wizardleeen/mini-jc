package ast;

import lombok.AllArgsConstructor;
import lombok.Data;

// Selector expression
@Data
@AllArgsConstructor
public class SelectorExpr implements Expr {
    private Expr selected;
    private String name;
}
