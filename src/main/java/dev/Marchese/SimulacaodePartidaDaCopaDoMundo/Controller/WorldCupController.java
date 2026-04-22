package dev.Marchese.SimulacaodePartidaDaCopaDoMundo.Controller;


import dev.Marchese.SimulacaodePartidaDaCopaDoMundo.Cliente.WorldCupClient;
import dev.Marchese.SimulacaodePartidaDaCopaDoMundo.Mapper.TeamMapper;
import dev.Marchese.SimulacaodePartidaDaCopaDoMundo.Model.Group;
import dev.Marchese.SimulacaodePartidaDaCopaDoMundo.Model.Team;
import dev.Marchese.SimulacaodePartidaDaCopaDoMundo.Service.GroupStageService;
import dev.Marchese.SimulacaodePartidaDaCopaDoMundo.Service.KnockoutService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/worldcup")
public class WorldCupController {

    private final WorldCupClient client;
    private final TeamMapper mapper;
    private final GroupStageService groupService;
    private final KnockoutService knockoutService;

    public WorldCupController(
            WorldCupClient client,
            TeamMapper mapper,
            GroupStageService groupService,
            KnockoutService knockoutService
    ){
        this.client = client;
        this.mapper = mapper;
        this.groupService = groupService;
        this.knockoutService = knockoutService;
    }

    @GetMapping("/simulate")
    public Team SimulateWorldCup(){

        // 1. Get teams from API
        List<Team> teams = mapper.toModelList(client.getAllTeams());

        // 2. Create groups
        List<Group> groups = groupService.createGroups(teams);

        // 3. Play group stage
        List<Team> qualifiedTeams = new ArrayList<>();

        for (Group group : groups) {
            groupService.generateMatches(group);
            groupService.playGroup(group);

            qualifiedTeams.addAll(groupService.getQualifiedTeams(group));
        }

        // 4. Play knockout
        Team champion = knockoutService.playKnockout(qualifiedTeams);

        return champion;
    }
}
