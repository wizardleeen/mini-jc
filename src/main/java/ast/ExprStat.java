package ast;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExprStat implements Stat {
    private Expr expr;
}
