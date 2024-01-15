import React, {useState} from 'react';

function SixApp(props) {
    const [mycar,setMycar]=useState(["2","7"]);
    const [carno,setCarNo]=useState('');
    const showAlert = () => {
        alert('자동차 번호는 1부터 15까지의 값을 가져야 합니다!');
      };
      const delAlert = (deletedCarNo) => {
        alert(`${deletedCarNo}번이 삭제됩니다`);
      };
    return (
        <div>
            <h3 className='alert alert-primary'>SixApp-문제</h3>
            <input type='text' placeholder='자동차번호입력후엔터'
             className='form-control'
             style={{width:'300px'}}
             value={carno}
             onChange={(e)=>setCarNo(e.target.value)}
             onKeyUp={(e)=>{
                if(e.key==='Enter')
                {
                    //1~15가 아니면 경고 후 종료
                    const parsedCarNo = parseInt(carno, 10);
                        if (isNaN(parsedCarNo) || parsedCarNo < 1 || parsedCarNo > 15) {
                        showAlert();
                        return;
                        }
                    //배열 mycar 에 car no 값 추가
                    setMycar(mycar.concat(e.target.value));
                    //car no 값 초기화
                    setCarNo('');
                }
             }}/>

             {/* 1~15사이 번호 입력 후 엔터를 누르면 해당 자동차 이미지 출력 
                 해당 자동차 이미지에서 더블클릭하면 자동차 삭제하기*/}

            {
                //mycar 배열 이미지로 출력 
                mycar.map((m,i)=>(<h6 key={i} className='select'
                onDoubleClick={(e)=>{
                    setMycar(mycar.filter((item,idx)=>i!==idx));
                    delAlert(m);
                }}>{i+1}:{m}<img alt='' src={require(`../images/mycar${m}.png`)}
                width='80'/></h6>))
            }
        </div>
    );
}

export default SixApp;