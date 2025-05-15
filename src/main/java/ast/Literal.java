package ast;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Literal implements Expr {
    private Object value;
}
