import React, { useState } from 'react';
import ShowState from './ShowState';

const MemoApp = () => {
    const [number,setNumber]=useState(0);
    const [text,setText]=useState('');

    const increNumber=()=>{
        setNumber(number+1);
    }
    const decreNumber=()=>{
        setNumber(number-1);
    }
    const onChangeTextHandler=(e)=>{
        setText(e.target.value);
    }

    return (
        <div>
            <button className='btn btn-info btn-sm'
             onClick={increNumber}>증가</button> &nbsp;
            <button className='btn btn-info btn-sm'
             onClick={decreNumber}>감소</button>
            <br/><br/>
            <input type='text' placeholder='input name'
             onChange={onChangeTextHandler}/>
            <br/><br/>
            <hr/>
            <ShowState number={number} text={text}/>
        </div>
    );
};

export default MemoApp;