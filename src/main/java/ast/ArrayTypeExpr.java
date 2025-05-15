package ast;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArrayTypeExpr implements Expr {
    private Expr elemType;
}
