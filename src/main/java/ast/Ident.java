package ast;

import lombok.AllArgsConstructor;
import lombok.Data;


// Identifier
@Data
@AllArgsConstructor
public class Ident implements Expr {
    private String name;
}
