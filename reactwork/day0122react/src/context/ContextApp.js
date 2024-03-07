import React, { useState } from 'react';
import Page from './Page';
import { UserContext } from './UserContext';
import { ThemaContext } from './ThemaContext';


const ContextApp = () => {
    const [isDark,setIsDark] = useState(false);

    return (
        <div>
            {/* 이 경우는 page 를 거쳐서 header content footer컴포넌트로 각 값이나 이벤트를 전달해야함 */}
            {/* <Page isDark={isDark} setIsDark={setIsDark}/> */}

            {/* context를 이용해서 모든 하위 컴포넌트에서 값을 공유할 수 있다 */}
            
            <UserContext.Provider value={"네이버클라우드"}>
                <ThemaContext.Provider value={{isDark,setIsDark,doll:'s6.JPG'}}>
                    <Page/>
                </ThemaContext.Provider>
            </UserContext.Provider>
        </div>
    );
};

export default ContextApp;