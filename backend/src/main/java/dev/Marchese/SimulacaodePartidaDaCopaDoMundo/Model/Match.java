package dev.Marchese.SimulacaodePartidaDaCopaDoMundo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Match {

    private Team teamA;
    private Team teamB;

    private int goalsA;
    private int goalsB;

    // In case of knockout
    private int penaltiesA;
    private int penalstiesB;

}
