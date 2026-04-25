package dev.Marchese.SimulacaodePartidaDaCopaDoMundo.DTO;

import dev.Marchese.SimulacaodePartidaDaCopaDoMundo.Model.Group;
import dev.Marchese.SimulacaodePartidaDaCopaDoMundo.Model.Match;
import dev.Marchese.SimulacaodePartidaDaCopaDoMundo.Model.Team;

import java.util.List;

public class WorldCupResponseDTO {

    private List<Group> groups;
    private List<Match> roundOf16;
    private List<Match> quarterFinals;
    private List<Match> semiFinals;
    private Match finalMatch;
    private Team champion;

    public WorldCupResponseDTO(
            List<Group> groups,
            List<Match> roundOf16,
            List<Match> quarterFinals,
            List<Match> semiFinals,
            Match finalMatch,
            Team champion
    ) {
        this.groups = groups;
        this.roundOf16 = roundOf16;
        this.quarterFinals = quarterFinals;
        this.semiFinals = semiFinals;
        this.finalMatch = finalMatch;
        this.champion = champion;
    }

    public List<Group> getGroups() { return groups; }
    public List<Match> getRoundOf16() { return roundOf16; }
    public List<Match> getQuarterFinals() { return quarterFinals; }
    public List<Match> getSemiFinals() { return semiFinals; }
    public Match getFinalMatch() { return finalMatch; }
    public Team getChampion() { return champion; }
}