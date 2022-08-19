<template>
  <div>
  <h2>Team Information</h2>
    <div class="team" v-for = "team in teams" v-bind:key="team.id" >

   Team Name : {{team.name}}<br>
   Team City : {{team.city}}<br>
   Team Key : {{team.key}}<br>
   Team league : {{team.league}}<br>
   Team Division : {{team.division}}<br>
   
    <router-link :to="{name: 'update-team', params:{ id:team.id } }">Update Team?</router-link>
  
    </div>
  

  </div>
</template>

<script>
import TeamService from '../services/TeamService.js';


export default {

 data() {
     return {
       
        teams: [],
     };
 },
 created() {
    TeamService.getAllRegisteredTeamData()
    .then((resp) => {
       this.teams=resp.data 
       })
 },

}

</script>

<style>
.team{
   background-color: white;
  width: 50vh;
  height: 30vh;
  margin-top: 1rem;
  margin-bottom: 1rem;
  border: 1px solid  #BF9270;
  border-radius: 2px;
  align-content: center;
  display: inline-flex;
  justify-content: space-around;
  align-content: center;
  flex-direction: row;
  flex-wrap: wrap;
  flex-direction: row;
  
};
.update-team{
width: 40px;
height: 20px;

}
</style>