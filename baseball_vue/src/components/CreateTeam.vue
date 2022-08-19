<template>
  <div id = "create-team">
      
      <form id = "myForm" class = "create-team" v-on:submit.prevent>
          <h1 id = "create-header">Create New Team</h1>
          <br />
          <label for ="Team"> New Team Name : </label>
          <input
          type="text"
          id="team-name"
          class = "form-control"
          placeholder="new team Name"
          required
          v-model = "team.name"
          />
          <br />
          <label for ="Team"> New Team City : </label>
          <input
          type="text"
          id=""
          class = "form-control"
          placeholder="new team City"
          required
          v-model = "team.city"
          />
          <br />
          <label for ="Team"> New Team Key : </label>
          <input
          type="text"
          id=""
          class = "form-control"
          placeholder="new Key max 3 charactor"
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

          <button v-on:click='addNewTeam'>Submit</button>
      </form>
  </div>
</template>

<script>
import  TeamService from "../services/TeamService";



export default {

name:"create-team",
data() {
    return {
        team: {
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
    addNewTeam(){
        console.log("new Team?");
        const newTeam = {
            key:this.team.key,
            active:this.team.active,
            city:this.team.city,
            name:this.team.name,
            league:this.team.league,
            division:this.team.division
        };
        console.log(newTeam);
        const config = {
        headers: { Authorization: `Bearer ${this.$store.state.token}` },
      };
      TeamService.addTeam(newTeam, config).then((response) => {
        if (response.status == 201) {
          alert("team added!");
          this.$router.push("/team-list");
          document.getElementById("myForm").reset();
        }

        if(response.status == 400) {
          alert("team already exsist!");
          document.getElementById("myForm").reset();
        }
      });
    }
},

mounted() {
    TeamService.addTeam().then(
      (resp)=>{this.teams=resp.data }
      )
}

}
</script>

<style>

</style>