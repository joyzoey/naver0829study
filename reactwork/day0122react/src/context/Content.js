import React, { useContext } from 'react';
import { ThemaContext } from './ThemaContext';

const Content = () => {
    const {isDark,doll}=useContext(ThemaContext);
    return (
        <div className='content' style={{backgroundColor:isDark?'gray':'white'}}>
            컨텐츠
            <img alt='' src={require(`../image/${doll}`)} width={'50'}/>
        </div>
    );
};

export default Content;