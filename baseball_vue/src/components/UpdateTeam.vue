<template>
  <div id = "update-team">
      <form id = "update" class = "update-team" v-on:submit.prevent>
          <h1 id = "create-header">Update Team</h1>
            <br>
          <label for ="Team"> Update Team Name </label>
         <input
          type="text"
          id="team-name"
          class = "form-control"
          placeholder="Please enter your new team Name"
          required
          v-model = "team.name"
          />
          <br />
          <label for ="Team"> Update Team City</label>
          <input
          type="text"
          id=""
          class = "form-control"
          placeholder="Please enter your new team City "
          required
          v-model = "team.city"
          />
          <br />
          <label for ="Team"> Update Team Key</label>
          <input
          type="text"
          id=""
          class = "form-control"
          placeholder="Please enter your new Key "
          required
          v-model = "team.key"
          />
          <br>
         <label for ="Team"> New Team League : </label>
          <select name ="league" v-model = "team.league">
          <option value="AL">American League</option>
          <option value="NL">National League</option>
          </select>
          <br>
          <label for ="Team"> New Team Division : </label>
          <select name = "division" v-model = "team.division">
          <option value="West">WEST </option>
          <option value="East">EAST </option>
          <option value="Central">CENTRAL </option>
          </select>
          <br>
        
        <button v-on:click='updateTeam'>Submit</button>
      </form>
      
  </div>
</template>

<script>
import TeamService from '../services/TeamService.js';

export default {
name:"update-team",

data() {
    return {
        team: {
        id:"",
        key:"",
        active:"",
        city:"",
        name:"", 
        league:"",
        division:""
        },

    };
},

methods: {
     
    updateTeam() {
        const updateTeam = { 
            id:this.team.id,
            key:this.team.key,
            active:this.team.active,
            city:this.team.city,
            name:this.team.name,
            league:this.team.league,
            division:this.team.division
        };
        
        const config = {
            headers: { Authorization: `Bearer ${this.$store.state.token}` },
        };
        
        TeamService.updateTeam(updateTeam, config).then(
            (resp) => {
                if(resp.status == 202){
                    console.log("Update completed!")
                    this.$router.push("/team-list");
                    document.getElementById("update").reset();
                }
            }
        );
    }

    },

    created() {
        TeamService.getTeamById(this.$route.params.id).then(
            (resp) => {console.log(resp.data);this.team=resp.data }
        )
    }

}

</script>

<style>

</style>