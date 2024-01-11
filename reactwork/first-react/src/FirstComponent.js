import React from "react";
import './MyStyle.css';
import jin from './jin.jpg';
import jin2 from './jin2.jpg';

let FirstComponent=()=>{

    return(
        <div className="box">
            <h3 className="alert alert-danger">FirstComponent 컴포넌트</h3>
            <h6>public의 이미지 나타내기</h6>
            {/* public 이미지는 직접 경로로 지정해야함 - 권장x */}
            <img alt="" src="./기욤둥이.png"
             style={{border:'3px solid pink',width:'300px'}} />
            <h6>src의 이미지 나타내기</h6>
            <img alt="" src={jin}
             style={{border:'3px solid pink',width:'300px'}} />
            <img alt="" src={jin2}
             style={{border:'3px solid pink',width:'300px'}} />
        </div>

    )
}

export default FirstComponent;