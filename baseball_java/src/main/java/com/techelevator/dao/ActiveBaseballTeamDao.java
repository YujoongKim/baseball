package com.techelevator.dao;

import com.techelevator.model.ActiveBaseballTeam;
import com.techelevator.model.NewBaseballTeamDTO;

import java.util.List;

public interface ActiveBaseballTeamDao {

    void create(ActiveBaseballTeam activeBaseballTeam);
    List<NewBaseballTeamDTO> findAll();
    NewBaseballTeamDTO getTeamById(int teamId);
    NewBaseballTeamDTO createNewTeam(NewBaseballTeamDTO newBaseballTeamDTO);
    void deleteTeam(String name);
    void updateTeam(NewBaseballTeamDTO newBaseballTeamDTO);
    NewBaseballTeamDTO getTeamByName(String name);
    NewBaseballTeamDTO getTeamByKey (String key);
}
