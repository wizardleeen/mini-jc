package ast;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class File implements Node {
    private List<ClassDecl> classes;
}
