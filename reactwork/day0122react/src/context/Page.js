import React from 'react';
import Header from './Header';
import Content from './Content';
import Footer from './Footer';
import './ContextStyle.css';
const Page = () => {
    return (
        <div>
            <Header/>
            <Content/>
            <Footer/>
        </div>
    );
};

export default Page;