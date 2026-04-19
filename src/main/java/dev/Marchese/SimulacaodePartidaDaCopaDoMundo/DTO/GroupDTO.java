package dev.Marchese.SimulacaodePartidaDaCopaDoMundo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupDTO {

    private String name;
    private List<String> teams;
}
