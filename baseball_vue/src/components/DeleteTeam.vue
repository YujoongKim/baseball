<template>
  
  <div>
    
  </div>

</template>

<script>
import TeamService from '../services/TeamService.js';

export default {

    name:"delete-team",
data() {
    return {
        team:{}
    }
},

methods: {
    deleteTeam(name){
        console.log("delete team?");
        const name = {
        };
        const config = {
            headers: { Authorization : 'Bearer ${this.$store.state.token}'},
        };
        TeamService.deleteTeam(name)
    }
        
    },


mounted() {
    TeamService.deleteTeam(name).then(
        (resp)=>{this.teams=resp.data}
    )
}


}
</script>

<style>

</style>