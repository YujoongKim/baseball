import axios from "axios";

export default {

    getAllRegisteredTeamData(){
        console.log('hi?');
        return axios.get('/allTeam');
    },

    getTeamById(id){
        console.log('making call')
        return axios.get('/getTeamById/'+id)
    },

    addTeam(team){
        console.log('add?')
        return axios.post('/registerNewTeam', team)
    },

    updateTeam(team) {
        console.log('update?')
        return axios.put('/updateTeam', team)
    },

    deleteTeam(name){
        console.log('delete?')
        return axios.delete('/deleteTeam', name)
    }

}