package dev.Marchese.SimulacaodePartidaDaCopaDoMundo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchDTO {

    private String teamA;
    private String teamB;

    private int goalsA;
    private int goalsB;

    private int penaltiesA;
    private int penaltiesB;

}
