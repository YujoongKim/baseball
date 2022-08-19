package com.techelevator.dao;

import com.techelevator.model.NewBaseballTeamDTO;
import com.techelevator.model.ActiveBaseballTeam;
import com.techelevator.model.TeamAlreadyExistsException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class JdbcActiveBaseballTeamDao implements ActiveBaseballTeamDao {

    private JdbcTemplate jdbcTemplate;

    /**
     * communicating with Database using Jdbc Template
     *
     * @param dataSource
     */
    public JdbcActiveBaseballTeamDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * Create new object on DB. this is for information from MLB API
     *
     * @param activeBaseballTeam
     */
    @Override
    public void create(ActiveBaseballTeam activeBaseballTeam) {

        String sql = "insert into activebaseballteams (team_id, key, active, city, name, stadium_id, league, division, primary_color, secondary_color, tertiary_color, quaternary_color, wikipedia_logo_url, wikipedia_word_mark_url, global_team_id) Values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, activeBaseballTeam.getTeamId(), activeBaseballTeam.getKey(), activeBaseballTeam.isActive(),
                activeBaseballTeam.getCity(), activeBaseballTeam.getName(), activeBaseballTeam.getStadiumId(),
                activeBaseballTeam.getLeague(), activeBaseballTeam.getDivision(), activeBaseballTeam.getPrimaryColor(),
                activeBaseballTeam.getSecondaryColor(), activeBaseballTeam.getTertiaryColor(), activeBaseballTeam.getQuaternaryColor(),
                activeBaseballTeam.getWikipediaLogoUrl(), activeBaseballTeam.getWikipediaWordMarkUrl(), activeBaseballTeam.getGlobalTeamId());

    }

    /**
     * Get all the baseball team object
     *
     * @return Object list
     */
    @Override
    public List<NewBaseballTeamDTO> findAll() {

        List<NewBaseballTeamDTO> teamList = new ArrayList<>();
        String sql = "select * from activebaseballteams";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            NewBaseballTeamDTO newBaseballTeamDTO = mapRowToNewTeams(results);
            teamList.add(newBaseballTeamDTO);
        }
        return teamList;
    }

    /**
     * Get team information by team ID
     *
     * @param teamId
     * @return newTeamDTO
     */
    @Override
    public NewBaseballTeamDTO getTeamById(int teamId) {
        String sql = "SELECT * from activebaseballteams WHERE team_id =?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, teamId);
        if (results.next()) {
            return  mapRowToNewTeams(results);
        }else{
            throw new RuntimeException("Id " + teamId + " was not found." );
        }

    }

//            throw new NoSuchElementException("teamId " + teamId + " was not found." );
//        }


    /**
     * find team by key
     * @param key
     * @return
     */
    @Override
    public NewBaseballTeamDTO getTeamByKey (String key) throws NoSuchElementException{
        String sql = "SELECT * from activebaseballteams WHERE key =?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, key);
        if(results.next()) {
            return mapRowToNewTeams(results);
        }else {
            throw new NoSuchElementException("Team Key " + key + " was not found.");
        }
    }
    /**
     * find team by name
     * @param name
     * @return
     */
    @Override
    public NewBaseballTeamDTO getTeamByName(String name) throws NoSuchElementException {
        String sql = "SELECT * from activebaseballteams WHERE name=?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name) ;
        if(results.next()) {
            return mapRowToNewTeams(results);
        }else{
            throw new NoSuchElementException("Team Name " + name + " was not found.");
        }
    }

    /**
     * Create new team with information from the user
     * @param newBaseballTeamDTO
     * @return created team
     */
    @Override
    public NewBaseballTeamDTO createNewTeam(NewBaseballTeamDTO newBaseballTeamDTO) throws TeamAlreadyExistsException {
        List<NewBaseballTeamDTO> newBaseballTeamDTOList = new ArrayList<>();
        String sql = "INSERT into activebaseballteams(key, active, city, " +
                "name, league, division) VALUES (?,?,?,?,?,?) RETURNING team_id";
        for (NewBaseballTeamDTO teams : this.findAll()) {
            newBaseballTeamDTOList.add(teams);
            if (newBaseballTeamDTOList.size() == 0) {
                Integer temp = 0;
                temp = jdbcTemplate.queryForObject(sql, Integer.class, newBaseballTeamDTO.getKey(), newBaseballTeamDTO.isActive(),
                        newBaseballTeamDTO.getCity(), newBaseballTeamDTO.getName(), newBaseballTeamDTO.getLeague(),
                        newBaseballTeamDTO.getDivision());
                newBaseballTeamDTO.setId(temp);
                return newBaseballTeamDTO;

            } else if ( (teams.getKey() != newBaseballTeamDTO.getKey()) && (teams.getName() != newBaseballTeamDTO.getName()) ) {
                    Integer temp = 0;
                    temp = jdbcTemplate.queryForObject(sql, Integer.class, newBaseballTeamDTO.getKey(), newBaseballTeamDTO.isActive(),
                            newBaseballTeamDTO.getCity(), newBaseballTeamDTO.getName(), newBaseballTeamDTO.getLeague(),
                            newBaseballTeamDTO.getDivision());
                    newBaseballTeamDTO.setId(temp);
                    return newBaseballTeamDTO;
            }

            throw new TeamAlreadyExistsException("Team already exist.");
        }
        return newBaseballTeamDTO;
    }




    /**
     * update team information
     * @param newBaseballTeamDTO
     */
    @Override
    public void updateTeam(NewBaseballTeamDTO newBaseballTeamDTO) throws TeamAlreadyExistsException{
        String sql = "Update activebaseballteams SET key = ?, active = ?, city =?, name=?, league=?, division =? where team_id=?";
        for (NewBaseballTeamDTO teams : this.findAll()) {
            if ((teams.getKey() != newBaseballTeamDTO.getKey()) && (teams.getName() != newBaseballTeamDTO.getName())) {
                jdbcTemplate.update(sql, newBaseballTeamDTO.getKey(), newBaseballTeamDTO.isActive(), newBaseballTeamDTO.getCity(),
                        newBaseballTeamDTO.getName(), newBaseballTeamDTO.getLeague(), newBaseballTeamDTO.getDivision(), newBaseballTeamDTO.getId());
            }
        }
          throw new TeamAlreadyExistsException("Team already is exist." );

    }

    /**
     * Delete team information on DB
     * @param name
     */
    @Override
    public void deleteTeam(String name) {
        String sql = "Delete from activebaseballteams where team_name =?";
        jdbcTemplate.update(sql, name);
    }


    /** help mapper method to store selected information of team object from DB for user
     */
    private NewBaseballTeamDTO mapRowToNewTeams(SqlRowSet rs){
        NewBaseballTeamDTO newTeam = new NewBaseballTeamDTO();
        newTeam.setId(rs.getInt("team_id"));
        newTeam.setKey(rs.getString("key"));
        newTeam.setActive(rs.getBoolean("active"));
        newTeam.setCity(rs.getString("city"));
        newTeam.setName(rs.getString("name"));
        newTeam.setLeague(rs.getString("league"));
        newTeam.setDivision(rs.getString("division"));
        return newTeam;
    }
}
