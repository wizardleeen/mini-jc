package ast;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ParamDecl {
    private TypeNode type;
    private String name;
}
