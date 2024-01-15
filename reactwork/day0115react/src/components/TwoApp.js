import React, { useEffect, useState } from 'react';
import c1 from '../images/c1.png';
import c2 from '../images/c2.png';

function TwoApp(props) {
    const [show,setShow]=useState(true);
    const [count,setCount]=useState(1);

    const clickButtonEvent=()=>{
        setCount(count+1);
        //비동기처리라 아래코드가 먼저 호출될 수도 있다 :순차적처리를 하고싶을때 쓰는게 useEffect
        //setShow(count%3===0?true:false);
    }

    useEffect(()=>{
        setShow(count%3===0?true:false);
    },[count]);//count 변경시 자동호출

    return (
        <div>
            <h3 className='alert alert-danger'>TwoApp-3의 배수마다 이미지 보이기/안보이기</h3>
            <button type='button' className='btn btn-danger'
             onClick={clickButtonEvent}>숫자증가</button>
            <b style={{fontSize:'4em',color:'red',marginLeft:'50px'}}>{count}</b>
            <br/><br/>
            {
                //show=true 일때
                show &&
                <img alt="" src={c1}/>
            }

            {   
                //show=false 일때 
                !show &&
                <img alt="" src={c2}/>
            }

            {/* src이미지를 import없이 출력하는 방법 */}
            <img alt='' src={require('../images/c7.png')}/>
        </div>
    );
}

export default TwoApp;