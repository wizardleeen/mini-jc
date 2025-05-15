package ast;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TypeNode implements Node {
    private Expr expr;
}
