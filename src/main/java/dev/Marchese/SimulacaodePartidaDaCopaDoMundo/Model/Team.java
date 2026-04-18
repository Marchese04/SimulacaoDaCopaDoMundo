package dev.Marchese.SimulacaodePartidaDaCopaDoMundo.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Team {

    private String id;
    private String Name;

    // Statistic
    private int points = 0;
    private int goalsFor = 0;
    private  int goalsAgainst= 0;

}
