package com.techelevator.model;

public class ActiveBaseballTeam {

    private int teamId;
    private String key;
    private boolean active;
    private String city;
    private String name;
    private int stadiumId;
    private String league;
    private String division;
    private String primaryColor;
    private String secondaryColor;
    private String tertiaryColor;
    private String quaternaryColor;
    private String wikipediaLogoUrl;
    private String wikipediaWordMarkUrl;
    private int globalTeamId;

    public ActiveBaseballTeam() {
    }

    public ActiveBaseballTeam(int teamId, String key, boolean active, String city, String name, int stadiumId, String league, String division, String primaryColor, String secondaryColor, String tertiaryColor, String quaternaryColor, String wikipediaLogoUrl, String wikipediaWordMarkUrl, int globalTeamId) {
        this.teamId = teamId;
        this.key = key;
        this.active = active;
        this.city = city;
        this.name = name;
        this.stadiumId = stadiumId;
        this.league = league;
        this.division = division;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.tertiaryColor = tertiaryColor;
        this.quaternaryColor = quaternaryColor;
        this.wikipediaLogoUrl = wikipediaLogoUrl;
        this.wikipediaWordMarkUrl = wikipediaWordMarkUrl;
        this.globalTeamId = globalTeamId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
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

    public int getStadiumId() {
        return stadiumId;
    }

    public void setStadiumId(int stadiumId) {
        this.stadiumId = stadiumId;
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

    public String getPrimaryColor() {
        return primaryColor;
    }

    public void setPrimaryColor(String primaryColor) {
        this.primaryColor = primaryColor;
    }

    public String getSecondaryColor() {
        return secondaryColor;
    }

    public void setSecondaryColor(String secondaryColor) {
        this.secondaryColor = secondaryColor;
    }

    public String getTertiaryColor() {
        return tertiaryColor;
    }

    public void setTertiaryColor(String tertiaryColor) {
        this.tertiaryColor = tertiaryColor;
    }

    public String getQuaternaryColor() {
        return quaternaryColor;
    }

    public void setQuaternaryColor(String quaternaryColor) {
        this.quaternaryColor = quaternaryColor;
    }

    public String getWikipediaLogoUrl() {
        return wikipediaLogoUrl;
    }

    public void setWikipediaLogoUrl(String wikipediaLogoUrl) {
        this.wikipediaLogoUrl = wikipediaLogoUrl;
    }

    public String getWikipediaWordMarkUrl() {
        return wikipediaWordMarkUrl;
    }

    public void setWikipediaWordMarkUrl(String wikipediaWordMarkUrl) {
        this.wikipediaWordMarkUrl = wikipediaWordMarkUrl;
    }

    public int getGlobalTeamId() {
        return globalTeamId;
    }

    public void setGlobalTeamId(int globalTeamId) {
        this.globalTeamId = globalTeamId;
    }

    @Override
    public String toString() {
        return "ActiveBaseballTeam{" +
                "teamId=" + teamId +
                ", key='" + key + '\'' +
                ", active=" + active +
                ", city='" + city + '\'' +
                ", name='" + name + '\'' +
                ", stadiumId=" + stadiumId +
                ", league='" + league + '\'' +
                ", division='" + division + '\'' +
                ", primaryColor='" + primaryColor + '\'' +
                ", secondaryColor='" + secondaryColor + '\'' +
                ", tertiaryColor='" + tertiaryColor + '\'' +
                ", quaternaryColor='" + quaternaryColor + '\'' +
                ", wikipediaLogoUrl='" + wikipediaLogoUrl + '\'' +
                ", wikipediaWordMarkUrl='" + wikipediaWordMarkUrl + '\'' +
                ", globalTeamId=" + globalTeamId +
                '}';
    }
}
