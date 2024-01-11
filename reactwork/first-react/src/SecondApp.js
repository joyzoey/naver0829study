import React, { useState } from 'react';
import './MyStyle.css';

function SecondApp(props) {
    //let msg="건훈쨩 사랑행";

    //변경도 가능
    //msg는 변수명 setMsg는 setter 함수명
    const [msg,setMsg]=useState('거누니안뇽!!!');

    return (
        <div className="box2">
            <h3 className="alert alert-success">SecondApp 컴포넌트</h3>
            <h6>메세지를 입력하세요</h6>
            <input type='text' className='form-control'
             style={{fontFamily: 'Jua'}}
             value={msg} onChange={(e)=>{
                //setter 함수를 통해서 입력값을 msg에 넣는다
                setMsg(e.target.value);
             }}/>
            <h1>{msg}</h1>
        </div>
    );
}

export default SecondApp;