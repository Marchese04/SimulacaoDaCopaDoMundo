package dev.Marchese.SimulacaodePartidaDaCopaDoMundo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Group {

    private String name; //The group A, B and others...

    private List<Team> teams;

    private List<Match> matches;


}
