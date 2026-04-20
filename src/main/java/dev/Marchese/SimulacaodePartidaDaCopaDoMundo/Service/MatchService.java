package dev.Marchese.SimulacaodePartidaDaCopaDoMundo.Service;

import dev.Marchese.SimulacaodePartidaDaCopaDoMundo.Model.Match;
import dev.Marchese.SimulacaodePartidaDaCopaDoMundo.Model.Team;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MatchService {//this is the factory that knows how to make football games

    private final Random random = new Random();//it chooses random numbers(draw type)

    public void playMatch(Match match){//take a game and make it happen
        int goalsA= random.nextInt(5);
        int goalsB = random.nextInt(5);//draws how many goals each team scored(0 to 4)

        match.setGoalsA(goalsA);//keeps the result in game
        match.setGoalsB(goalsB);

        Team teamA= match.getTeamA();//take the teams that are playing
        Team teamB = match.getTeamB();

        teamA.setGoalsFor(teamA.getGoalsFor() + goalsA);//team A scored goals -> sum in total
        teamA.setGoalsAgainst(teamA.getGoalsAgainst() + goalsB);//team A concede goals -> their total

        teamB.setGoalsFor(teamB.getGoalsFor() + goalsB);//team B scored goals -> sum in total
        teamB.setGoalsAgainst(teamB.getGoalsAgainst() + goalsA);//team B concede goals -> their total

        if(goalsA > goalsB){//if team A scored more goals -> won
            teamA.setPoints(teamA.getGoalsFor() + 3);//won nore 3 points
        } else if (goalsB > goalsA) {// if team B won
            teamB.setPoints(teamB.getPoints() + 3);// +3 points
        } else{//if it tied
            teamA.setPoints(teamA.getPoints() + 1);// each one earns 1 point
            teamB.setPoints(teamB.getPoints() + 1);
        }
    }

    public Team decideWinner(Match match){

        if (match.getGoalsA() == match.getGoalsB()){//if it tied

            int penaltiesA = random.nextInt(5);//draw penalties
            int penaltiesB = random.nextInt(5);

            match.setPenaltiesA(penaltiesA);//keeps the penalties
            match.setPenalstiesB(penaltiesB);

            if(penaltiesA > penaltiesB){//whoever scored the most penalties wins
                return match.getTeamA();//returns the winner
            }else{
                return match.getTeamB();
            }
        }
        if(match.getGoalsA() > match.getGoalsB()){
            return match.getTeamA();
        }else {
            return match.getTeamB();
        }
    }

}
