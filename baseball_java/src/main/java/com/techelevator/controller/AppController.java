package com.techelevator.controller;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.techelevator.dao.ActiveBaseballTeamDao;
import com.techelevator.model.ActiveBaseballTeam;
import com.techelevator.model.NewBaseballTeamDTO;
import com.techelevator.model.TeamAlreadyExistsException;
import com.techelevator.service.ServiceActiveBaseballTeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin // enables cross-origin resource sharing only for this specific method
@PreAuthorize("isAuthenticated()") // checks the given expression before entering the method
@RestController // combines @Controller and @ResponseBody

public class AppController {

    @Autowired //dependency injection
    private ActiveBaseballTeamDao dao;

    public AppController(ActiveBaseballTeamDao dao) {
        this.dao = dao;
    }

    /** create baseball team object using a method in service active baseball team class
     *  and save it into DB
     */
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/oldTeam", method = RequestMethod.POST)
    public void newTeam() throws JsonProcessingException {

        ServiceActiveBaseballTeam serviceActiveBaseballTeam = new ServiceActiveBaseballTeam();

        for ( ActiveBaseballTeam activeBaseballTeam : serviceActiveBaseballTeam.listTeams()) {
         dao.create(activeBaseballTeam);
        }
       }

       /** create new team based on the information user input on the front end.
        * check if there is same team name or team key
     * @param newTeam
     */
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/registerNewTeam", method = RequestMethod.POST)
    public NewBaseballTeamDTO registerNewTeam(@Valid @RequestBody NewBaseballTeamDTO newTeam) {
               return dao.createNewTeam(newTeam);
    }

    /** get list of team information from DB
     */
    @RequestMapping(value = "/allTeam", method = RequestMethod.GET)
    List<NewBaseballTeamDTO> getAllTeam() {

        List<NewBaseballTeamDTO> teamList = new ArrayList<>();
        for (NewBaseballTeamDTO newBaseballTeamDTO : dao.findAll()) {
            teamList.add(newBaseballTeamDTO);
        }
        return teamList;

    }
    /** get team information depending on team ID
     * @param teamId
     */
    @RequestMapping(value = "/getTeamById/{teamId}", method = RequestMethod.GET)
    public NewBaseballTeamDTO findTeamById (@Valid @PathVariable int teamId) {
        return dao.getTeamById(teamId);
    }



    /** update team information in DB with new information user input
     * @param
     * @param updatedTeamInformation
     */
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/updateTeam")
    public void updateTeamInformation (@Valid @RequestBody NewBaseballTeamDTO updatedTeamInformation){
        dao.updateTeam(updatedTeamInformation);
    }

    /** delete team from DB finding by String name
     * @param name
     */
    @DeleteMapping("/deleteTeam")
    public void deleteTeam (@Valid @RequestParam String name){
        dao.deleteTeam(name);
    }


}
