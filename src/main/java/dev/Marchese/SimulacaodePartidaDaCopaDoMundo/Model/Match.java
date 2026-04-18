package dev.Marchese.SimulacaodePartidaDaCopaDoMundo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Match {

    private Team TeamA;
    private Team TeamB;

    private int GoalsA;
    private int GoalsB;

    // In case of knockout
    private int PenaltiesA;
    private int PenalstiesB;

}
