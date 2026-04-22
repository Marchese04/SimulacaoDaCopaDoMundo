package dev.Marchese.SimulacaodePartidaDaCopaDoMundo.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamStats {

    private int points;
    private int goalsFor;
    private int goalsAgainst;

}
