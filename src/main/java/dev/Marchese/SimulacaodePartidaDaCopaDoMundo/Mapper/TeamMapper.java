package dev.Marchese.SimulacaodePartidaDaCopaDoMundo.Mapper;

import dev.Marchese.SimulacaodePartidaDaCopaDoMundo.DTO.TeamDTO;
import dev.Marchese.SimulacaodePartidaDaCopaDoMundo.Model.Team;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component//This Class can be used automatically and by another
public class TeamMapper {

    //convert DTO to Model
    public Team toModel(TeamDTO dto){
        if (dto == null) return null;

        Team team = new Team();
        team.setId(dto.getId());
        team.setName(dto.getName());

        //statistic start at zero in the model
        return team;
    }

    //convert Model to DTO
    public TeamDTO toDTO(Team team){
        if(team==null) return null;

        TeamDTO dto = new TeamDTO();
        dto.setId(team.getId());
        dto.setName(team.getName());

        return dto;
    }
    //convert Model List to DTO List
    public List<TeamDTO> toDTOList(List<Team> teams){
        return teams.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
    //Take a list of DTOs and turn each one into a Team
    public List<Team> toModelList(List<TeamDTO> dtos) {
        return dtos.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

}
