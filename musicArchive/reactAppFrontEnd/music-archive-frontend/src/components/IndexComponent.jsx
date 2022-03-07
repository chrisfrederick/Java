import React, { Component } from 'react';
import ReactPlayer from "react-player";
import SongServcie from '../services/SongServcie';

class IndexComponent extends Component {
    constructor(props){
        super(props)
        this.state = {
            songs : []
        }
    }

    componentDidMount(){
       SongServcie.getSongs()
       .then((res)=>{
           this.setState({songs: res.data})
       })
    }
    render() {
        return (
            <div>
                <h2 className="text-center">Song Catalog</h2>
                <div className='row'>
                    <table className='table table-striped table-bordered'>
                        <thead>
                            <tr>
                                <th>Track Title</th>
                                <th>Audio</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.songs.map(
                                    song => 
                                    <tr key = {song.id}>
                                        <td>{song.fileName}</td>
                                        <td></td>
                                    </tr>
                                )
                            }
                        </tbody>
                    </table>
                    <ReactPlayer
                        url="https://musicarchivebackend.nyc3.cdn.digitaloceanspaces.com/More%20In%20My%20Life%20%28Travis%20Scott%20and%20Daft%20Punk%20Remix%29.wav"
                        width="400px"
                        height="50px"
                        playing={false}
                        controls={true}
                                        />
                </div>
            </div>
        );
    }
}

export default IndexComponent;