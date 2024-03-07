import { Alert } from '@mui/material';
import React from 'react';
import { useParams } from 'react-router-dom';
import simg from '../images/s1.JPG';
import gimg from '../images/s10.JPG';

const About = () => {
    const {emp} = useParams();
    //console.log({emp}); //{"emp":"Samsung"}
    //console.log({emp}.emp);//Samsung

    return (
        <div>
            <Alert variant='filled' severity='warning'>
                    About 컴포넌트입니다
            </Alert> 
            {
                //emp값 넘어오지 않을때 실행
                emp==null?
                <div>
                    <h1>저는 취업준비생입니다.</h1>
                    <img alt='' src={require(`../images/s6.JPG`)}/>
                </div>
                :
                //emp값 넘어올때 실행
                <div>
                    <h1>저는 {emp}에 다니고 있습니다.</h1>
                    <img alt='' src={(emp==='Samsung'?simg:gimg)}/>
                </div>
                
            }
           
        </div>
    );
};

export default About;