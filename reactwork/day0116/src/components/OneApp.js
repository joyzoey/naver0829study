import { Alert, Button } from '@mui/material';
import React, { useRef, useState } from 'react';

function OneApp(props) {
    //count 증가 - 1.state 2.ref
    const [count,setCount] = useState(0);
    const countRef = useRef(0);

    console.log("랜더링중..");

    return (
        <div>
            <Alert security='success'>
                <h3>One - useRef : 값이 변경되도 화면이 다시 랜더링 되지않음</h3>
                
            </Alert>
            <h1>
                state : {count} <br/>
                ref : {countRef.current} <br/>
            </h1>
            <hr/>
            <Button variant='outlined' color='success'
             onClick={()=>setCount(count+1)}
            >count 변수 증가</Button>
            <br/>
            <Button variant='outlined' color='primary' size='small'
             onClick={()=>{
                countRef.current=countRef.current+1;
                console.log("countRef.current="+countRef.current);
             }}
            >count 변수 증가</Button>
        </div>
    );
}

export default OneApp;