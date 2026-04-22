package dev.Marchese.SimulacaodePartidaDaCopaDoMundo.Service;

import dev.Marchese.SimulacaodePartidaDaCopaDoMundo.Model.Group;
import dev.Marchese.SimulacaodePartidaDaCopaDoMundo.Model.Match;
import dev.Marchese.SimulacaodePartidaDaCopaDoMundo.Model.Team;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class GroupStageService {

    private final MatchService matchService;

    public GroupStageService(MatchService matchService){
        this.matchService = matchService;
    }

    //create A-H groups
    public List<Group> createGroups(List<Team> teams){

        Collections.shuffle(teams);

        List<Group> groups = new ArrayList<>();

        char letter = 'A';

        for (int i = 0; i < teams.size(); i +=4){
            Group group = new Group();
            group.setName("Group" + letter++);

            List<Team> groupTeams = teams.subList(i, i + 4);
            group.setTeams(new ArrayList<>(groupTeams));

            groups.add(group);
        }
        return groups;
    }

    public void generateMatches(Group group) {

        List<Match> matches = new ArrayList<>();
        List<Team> teams = group.getTeams();

        for (int i = 0; i < teams.size(); i++){
            for (int j = i + 1; j < teams.size();j++){

                Match match = new Match();
                match.setTeamA(teams.get(i));
                match.setTeamB(teams.get(j));

                matches.add(match);
            }
        }
        group.setMatches(matches);
    }

    public void playGroup(Group group){

        for (Match match : group.getMatches()){
            matchService.playMatch(match);
        }
    }

    public List<Team> getQualifiedTeams(Group group){

        List<Team> teams = new ArrayList<>(group.getTeams());

        teams.sort((a, b) -> {

            if (b.getPoints() != a.getPoints()) {
                return b.getPoints() - a.getPoints();
            }
            int goalDiffA = a.getGoalsFor() - a.getGoalsAgainst();
            int goalDiffB = b.getGoalsFor() - b.getGoalsAgainst();

            if (goalDiffB != goalDiffA){
                return goalDiffB - goalDiffA;
            }
            return new Random().nextInt(2)-1;
        });
        return teams.subList(0, 2);
    }

}
