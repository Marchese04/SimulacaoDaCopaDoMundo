package dev.Marchese.SimulacaodePartidaDaCopaDoMundo.Cliente;

import dev.Marchese.SimulacaodePartidaDaCopaDoMundo.DTO.FinalResultDTO;
import dev.Marchese.SimulacaodePartidaDaCopaDoMundo.DTO.TeamDTO;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class WorldCupClient {

    private final RestTemplate restTemplate = new RestTemplate();

    private static final String BASE_URL = "https://development-internship-api.geopostenergy.com/WorldCup";

    private static final String GIT_USER = "Marchese04";


    public List<TeamDTO> getAllTeams(){//Declares a public method that: receives nothing, returns a list of TeamDTO.

        HttpHeaders headers = new HttpHeaders();//Creates an HTTP headers objected
        headers.set("git-user", GIT_USER);//adds the required API header

        HttpEntity<Void> entity = new HttpEntity<>(headers);//creates the "packet" of the request. headers(information), body(content)

        ResponseEntity<TeamDTO[]> response = restTemplate.exchange(//here the http call begins
                BASE_URL + "/GetAllTeams",//full request url
                HttpMethod.GET,//type of the requisition
                entity,// sends along the heads you created
                TeamDTO[].class// say to spring: "the response will come as an array from TeamDTO"
        );

        return Arrays.asList(response.getBody());//get the response body (array) and turn it into list
    }


    public void sendFinalResult(FinalResultDTO dto){//method that: receives the final result(dto), returns nothing(void). it only sends data to API

        HttpHeaders headers = new HttpHeaders();//creates the headers again
        headers.set("git-user", GIT_USER);//Same mandatory header
        headers.setContentType(MediaType.APPLICATION_JSON);//say "I'm sending data in JSON format"

        HttpEntity<FinalResultDTO> entity = new HttpEntity<>(dto, headers);//creat the packet of request. npw contains:body and dto(final result), headers.

        restTemplate.postForEntity(// makes a Post request
                BASE_URL + "/FinalResult",//endpoint of API
                entity,//send: headers, body(final result).
                String.class//expected type of response
        );
    }
}
