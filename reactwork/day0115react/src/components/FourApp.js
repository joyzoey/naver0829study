import React from 'react';
import img1 from '../images/K-036.png';
import img2 from '../images/K-039.png';
import img3 from '../images/K-041.png';
import img4 from '../images/K-049.png';
import './MyStyle.css';

function FourApp(props) {
    
    //4개의 import된 이미지를 배열에 저장
    const myImage=[img1,img2,img3,img4];
    const data=[
        {"name":"꿰엑","addr":"서울","hp":"010-2222-3333","photo":"c1"},
        {"name":"뿌앵","addr":"부산","hp":"010-1234-2689","photo":"c3"},
        {"name":"공격","addr":"제주도","hp":"010-5667-1368","photo":"c5"},
        {"name":"수비","addr":"경기도","hp":"010-1680-2137","photo":"c7"}
    ];

    return (
        <div>
            <h3 className='alert alert-warning'>FourApp-map으로 이미지 배열 출력</h3>
            {
                myImage.map((img,idx)=>(<img alt='' src={img} width='200'/>))
            }
            <hr/>
            {
                data.map((ele,i)=>(
                    <div className='box' key={i}>
                        <h5>이름 : {ele.name}</h5>
                        <h5>주소 : {ele.addr}</h5>
                        <h5>핸드폰 : {ele.hp}</h5>
                        <img alt='프로필사진' src={require(`../images/${ele.photo}.png`)} width='120'></img>
                    </div>
                ))
            }
            <hr/>
            <table>
                <thead>
                    <td width='50'>번호</td>
                    <td width='100'>사진</td>
                    <td width='100'>이름</td>
                    <td width='150'>핸드폰</td>
                    <td>주소</td>
                </thead>
                <tbody>
                    {
                        data.map((ele,idx)=>(
                        <tr key={idx}>
                            <td>{idx+1}</td>
                            <td>
                                <img alt='' src={require(`../images/${ele.photo}.png`)}
                                width='80'/>
                            </td>
                            <td>{ele.name}</td>
                            <td>{ele.hp}</td>
                            <td>{ele.addr}</td>
                        </tr>
                        ))                        
                    }
                </tbody>

            </table>
        </div>
    );
}

export default FourApp;