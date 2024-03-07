import { DeleteForeverOutlined } from '@mui/icons-material';
import React from 'react';

function FiveRowItem({row,idx,onDelete}) {
    const deletData = () => {
        // onDelete 함수를 현재 행의 인덱스 또는 필요한 식별자와 함께 호출합니다.
        onDelete(idx);
    };

    return (
        <tr>
            <td>{idx+1}</td>
            <td>
                <img alt=''
                 src={require(`../images/${row.fphoto}`)}
                 width='70' height='70' border='1' hspace='10'/>
                 {row.fname}
            </td>
            <td valign='middle'>{row.fprice}원</td>
            <td valign='middle'>
                {row.fdate.toLocaleDateString('ko-KR')}
            </td>
            <td valign='middle'>
                <DeleteForeverOutlined onClick={deletData}
                 style={{cursor:'pointer'}}/>
            </td>
        </tr>
    );
}

export default FiveRowItem;