package com.techelevator.dao;

import com.techelevator.model.NewBaseballTeamDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class JdbcActiveBaseballTeamDaoTest extends BaseDaoTests {

    private static final NewBaseballTeamDTO TEAM_1 = new NewBaseballTeamDTO(1,"LAD",true,"LA","Bad","NATIONAL","WEST");
    private static final NewBaseballTeamDTO TEAM_2 = new NewBaseballTeamDTO(2,"BBB",true,"SEOUL","KOREA","AMERICAN","WEST");
    private static final NewBaseballTeamDTO TEAM_3 = new NewBaseballTeamDTO(3,"CCC",true,"CACA","CAS", "NATIONAL", "EAST");

    private NewBaseballTeamDTO testTeam;

    private JdbcActiveBaseballTeamDao sut;

    @Before
    public void setup() {
        sut = new JdbcActiveBaseballTeamDao(dataSource);
        sut.createNewTeam(TEAM_1);
        sut.createNewTeam(TEAM_2);
        sut.createNewTeam(TEAM_3);

    }

    @Test
    public void createTeam_returns_team_with_id_and_expected_values(){
        NewBaseballTeamDTO team1 = sut.createNewTeam(TEAM_1);
        NewBaseballTeamDTO team2 = sut.createNewTeam(TEAM_2);
        NewBaseballTeamDTO team3 = sut.createNewTeam(TEAM_3);

        int newId1 = team1.getId();
        Assert.assertTrue(newId1 == 1);
        assertTeamMatch(TEAM_1, team1);

        int newId2 = team2.getId();
        Assert.assertTrue(newId2 == 2);
        assertTeamMatch(TEAM_2, team2);

        int newId3 = team3.getId();
        Assert.assertTrue(newId3 == 3);
        assertTeamMatch(TEAM_3, team3);
    }

    @Test
    public void getTeam_returns_correct_team_for_id() {

        NewBaseballTeamDTO teamOne = sut.getTeamById(1);
        assertTeamMatch(teamOne, TEAM_1);

    }

//    @Test
    public void getTeam_returns_null_when_id_is_not_fount() {

        NewBaseballTeamDTO team = sut.getTeamById(1);
        Assert.assertNull(team);
    }

//    @Test
    public void getAllTeams_returns_all_teams() {
        sut.createNewTeam(TEAM_1);
        sut.createNewTeam(TEAM_2);
        sut.createNewTeam(TEAM_3);

        List<NewBaseballTeamDTO> teams = sut.findAll();

        assertTeamMatch(TEAM_1, teams.get(0));
        assertTeamMatch(TEAM_2, teams.get(1));
        assertTeamMatch(TEAM_3, teams.get(2));
    }



//    @Test
    public void updated_city_has_expected_values_when_retrieved(){
        NewBaseballTeamDTO teamToUpdate = sut.getTeamById(1);

        teamToUpdate.setName("Updated");
        teamToUpdate.setKey("!!!");
        teamToUpdate.setCity("Updated");
        teamToUpdate.setActive(false);
        teamToUpdate.setDivision("Updated");
        teamToUpdate.setLeague("updated");

        sut.updateTeam(teamToUpdate);

        NewBaseballTeamDTO retrievedTeam = sut.getTeamById(1);
        assertTeamMatch(teamToUpdate, retrievedTeam);
    }

    private void assertTeamMatch(NewBaseballTeamDTO expected, NewBaseballTeamDTO actual){
        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.isActive(), actual.isActive());
        Assert.assertEquals(expected.getCity(), actual.getCity());
        Assert.assertEquals(expected.getDivision(), actual.getDivision());
        Assert.assertEquals(expected.getName(), actual.getName());
        Assert.assertEquals(expected.getKey(), actual.getKey());
        Assert.assertEquals(expected.getLeague(), actual.getLeague());

    }

}
