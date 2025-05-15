package ast;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Block implements Node {
    private List<Stat> stats;
}
