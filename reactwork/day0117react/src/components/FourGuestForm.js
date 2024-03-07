import { Button } from '@mui/material';
import axios from 'axios';
import React, { useRef, useState } from 'react';

const FourGuestForm = ({onSave}) => {
    const [photo,setPhoto]=useState('');
    const [nickname,setNickname]=useState('');
    //const [content,setContent]=useState('');

    //많은 내용 입력시 textarea는 state변수로 줄경우 입력시마다 랜더링이 일어남, ref 대체가 좋음
    const contentRef = useRef('');

    const imgUrl="https://kr.object.ncloudstorage.com/bitcamp-nhkim/bootmyshop/";
    
    //파일 업로드 이벤트
    const onUploadEvent=(e)=>{
        const uploadFile = new FormData();
        uploadFile.append("upload",e.target.files[0]);

        axios({
            method:'post',
            url:"/guest/upload",
            data:uploadFile,
            headers:{'Content-Type':'multipart/form-data'}
        }).then(res=>{
            setPhoto(res.data);//실제 스토리지에 올라간 사진파일명 반환
        })
    }

    //추가 버튼 이벤트
    const addButtonEvent=()=>{
        let content=contentRef.current.value;
        if(nickname.length===0){
            alert("닉네임을 입력해주세요");
            return;
        }
        if(content.length===0){
            alert("내용을 입력해주세요");
            return;
        }
        //부모 컴포넌트의 함수로 입력 데이터 보내기
        onSave({nickname,content});
        setNickname('');
        contentRef.current.value='';
        setPhoto('');
    }

    return (
        <div>
            <div>
                <input type='file' className='form-control'
                 onChange={onUploadEvent}/>
                <br></br>
                <img alt='' src={imgUrl+photo} width={130}/>
                <b>{photo}</b>
            </div><br></br>
            <div className='input-group' style={{width:'400px'}}>
                <input type='text' placeholder='닉네임' value={nickname}
                 onChange={(e)=>setNickname(e.target.value)}
                 className='form-control'/>
                <Button color='warning' variant='contained'
                 onClick={addButtonEvent}>추가</Button>
            </div>
            <textarea className='form-control' 
             onChange={(e)=>{
                contentRef.current.value=e.target.value;
             }}
             ref={contentRef}
             placeholder='방명록 내용 입력'></textarea>
        </div>
    );
};

export default FourGuestForm;