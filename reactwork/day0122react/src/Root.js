import React from 'react';
import { BrowserRouter } from 'react-router-dom';
import RouteMain from './RouteMain';

const root = () => {
    return (
        <BrowserRouter>
            <RouteMain/>
        </BrowserRouter>
    );
};

export default root;