import React from 'react';
import img1 from '../image/01.png';
import img2 from '../image/02.png';
import img3 from '../image/03.png';
import img4 from '../image/04.png';
import img5 from '../image/05.png';
import { Button } from '@mui/material';
import Swal from 'sweetalert2';

const SweetApp = () => {
    return (
        <div>
            <h3 className='alert alert-warning'>sweetAlert 사용법</h3>
            <hr></hr>
            <Button variant='outlined' color='warning'
             onClick={()=>{
                Swal.fire('안녕하세요');
             }}>기본Alert</Button>
            <br/>
            <Button variant='outlined' color='error'
             onClick={()=>{
                Swal.fire({
                    title:'Swal Test',
                    html:"오늘은 즐겁지않은<br/>월요일<br/>아침부터 하늘에서 이쁜 쓰레기가 내려요<br/>우산없는디....",
                    icon:"warning",
                    confirmButtonText:"확인",
                    confirmButtonColor:'#3085d6',
                    cancelButtonText:"취소",
                    cancelButtonColor:'pink',
                    showCancelButton:true
                }).then(result=>{
                    if(result.isConfirmed){
                        Swal.fire("시키는대로 처리함");
                    }else{
                        Swal.fire("취소함");
                    }
                });
             }}>확인,취소Alert</Button>
            <br/>
            <button type='button' className='btn btn-warning'
             onClick={()=>{
                Swal.fire({
                    title : "사진넣기",
                    html:`<h5>사진을 넣어볼까요</h5>`,
                    imageUrl:img3,
                    imageWidth:70,
                    imageHeight:80,
                    showCancelButton:true,
                    confirmButtonText:"삭제",
                    cancelButtonText:"삭제취소"
                })
             }}>사진넣기</button>
        </div>
    );
};

export default SweetApp;