package dev.Marchese.SimulacaodePartidaDaCopaDoMundo.Service;

import dev.Marchese.SimulacaodePartidaDaCopaDoMundo.Model.Match;
import dev.Marchese.SimulacaodePartidaDaCopaDoMundo.Model.Team;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KnockoutService {//This class controls the elimination tournament

    private final MatchService matchService;//uses matchSerci to, play matches, decide winners

    public KnockoutService(MatchService matchService){//spring gives you matchService automatically
        this.matchService = matchService;
    }

    public List<Team> playRound(List<Team> teams){//take teams and make them figth in pairs

        List<Team> winners = new ArrayList<>();//empty box winners

        for (int i = 0; i < teams.size(); i+=2) {//take teams 2 by 2

            Match match = new Match();// create a new game
            match.setTeamA(teams.get(i));
            match.setTeamB(teams.get(i + 1));// put 2 teams in matche

            matchService.playMatch(match);// play the game(generate goals)

            Team winner = matchService.decideWinner(match);// if draw-> penalties, get the winner

            winners.add(winner);//save the winner
        }
        return winners;// return all winners of this round
    }

    public Team playKnockout(List<Team> qualifiedTeams){// run the entire tournament until we have a champion

        List<Team> quarterFinalists = playRound(qualifiedTeams);//16 teams -> 8 winners

        List<Team> semiFinalists = playRound(quarterFinalists);//8 -> 4

        List<Team> finalists = playRound(semiFinalists);//4 -> 2

        List<Team> championList = playRound(finalists);//2 -> 1

        return championList.get(0);//return the champion
    }

}
