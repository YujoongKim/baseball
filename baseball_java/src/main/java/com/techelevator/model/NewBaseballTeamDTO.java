package com.techelevator.model;

import javax.validation.constraints.NotEmpty;

public class NewBaseballTeamDTO {
    private int id;
    @NotEmpty
    private String key;
    private boolean active;
    @NotEmpty
    private String city;
    @NotEmpty
    private String name;
    @NotEmpty
    private String league;
    @NotEmpty
    private String division;

    public NewBaseballTeamDTO(int id, String key, boolean active, String city, String name, String league, String division) {
        this.id = id;
        this.key = key;
        this.active = active;
        this.city = city;
        this.name = name;
        this.league = league;
        this.division = division;
    }

    public NewBaseballTeamDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    @Override
    public String toString() {
        return "NewBaseballTeamDTO{" +
                "id=" + id +
                ", key='" + key + '\'' +
                ", active=" + active +
                ", city='" + city + '\'' +
                ", name='" + name + '\'' +
                ", league='" + league + '\'' +
                ", division='" + division + '\'' +
                '}';
    }
}
