package dev.Marchese.SimulacaodePartidaDaCopaDoMundo.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FinalResultDTO {

    @JsonProperty("equipeA")//This serves to avoid bugs by kepping JSON in Portuguese
    private String teamA;

    @JsonProperty("equipeB")
    private String teamB;

    @JsonProperty("golsEquipeA")
    private int goalsTeamA;

    @JsonProperty("golsEquipeB")
    private int goalsTeamB;

    @JsonProperty("golsPenaltyTimeA")
    private int PenaltiesTeamA;

    @JsonProperty("golsPenaltyTimeB")
    private int PenaltiesTeamB;

}
