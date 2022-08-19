package com.techelevator.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.model.ActiveBaseballTeam;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.List;

public class ServiceActiveBaseballTeam {
    private static final String API_BASE_URL = "https://api.sportsdata.io/v3/mlb/scores/json/teams?key=03551aa21c7d492c9bbc2e39ecdf0b76";
    private final RestTemplate restTemplate = new RestTemplate();

    public String makeRequest(){
        String response = restTemplate.exchange(API_BASE_URL, HttpMethod.GET, new HttpEntity<>(new HttpHeaders()), String.class).getBody();
        System.out.println(response);
        return response;
    }

    public List<ActiveBaseballTeam> createListActiveBaseballTeams(String responseString) throws JsonProcessingException{
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node = objectMapper.readTree(responseString);
        List<ActiveBaseballTeam> testList = new ArrayList<>();

        for(int i=0; i<node.path(i).size(); i++){
            JsonNode teamRoot = node.path(i);

            int teamId = Integer.parseInt(teamRoot.path("TeamID").asText());
            String key = teamRoot.path("Key").asText();
            boolean active = Boolean.parseBoolean(teamRoot.path("Active").asText());
            String city =teamRoot.path("City").asText();
            String name = teamRoot.path("Name").asText();
            int stadiumId = Integer.parseInt(teamRoot.path("StadiumID").asText());
            String league = teamRoot.path("League").asText();
            String division = teamRoot.path("Division").asText();
            String primaryColor = teamRoot.path("PrimaryColor").asText();
            String secondaryColor = teamRoot.path("SecondaryColor").asText();
            String tertiaryColor = teamRoot.path("TertiaryColor").asText();
            String quaternaryColor = teamRoot.path("QuaternaryColor").asText();
            String wikipediaLogoUrl = teamRoot.path("wikipediaLogoUrl").asText();
            String wikipediaWordMarkUrl = teamRoot.path("WikipediaWordMarkUrl").asText();
            int globalTeamId = Integer.parseInt(teamRoot.path("GlobalTeamID").asText());

            ActiveBaseballTeam activeBaseballTeam = new ActiveBaseballTeam();
            activeBaseballTeam.setTeamId(teamId);
            activeBaseballTeam.setKey(key);
            activeBaseballTeam.setActive(active);
            activeBaseballTeam.setCity(city);
            activeBaseballTeam.setName(name);
            activeBaseballTeam.setStadiumId(stadiumId);
            activeBaseballTeam.setLeague(league);
            activeBaseballTeam.setDivision(division);
            activeBaseballTeam.setPrimaryColor(primaryColor);
            activeBaseballTeam.setSecondaryColor(secondaryColor);
            activeBaseballTeam.setTertiaryColor(tertiaryColor);
            activeBaseballTeam.setQuaternaryColor(quaternaryColor);
            activeBaseballTeam.setWikipediaLogoUrl(wikipediaLogoUrl);
            activeBaseballTeam.setWikipediaWordMarkUrl(wikipediaWordMarkUrl);
            activeBaseballTeam.setGlobalTeamId(globalTeamId);
            testList.add(activeBaseballTeam);

        }
        return testList;

    }
    public List<ActiveBaseballTeam> listTeams() throws JsonProcessingException {
        String response = makeRequest();
        return createListActiveBaseballTeams(response);
    }


}
