import axios from 'axios'
const SONG_API_BASE_URL = "http://localhost:8080/api/songs"

class SongService{

    getSongs(){
    return axios.get(SONG_API_BASE_URL);
    }
}

export default new SongService()