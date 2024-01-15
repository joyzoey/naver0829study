import { AddAlarmRounded, AddPhotoAlternateRounded, CameraAltOutlined, ImageAspectRatioOutlined, PhotoCameraBack } from '@mui/icons-material';
import React from 'react';

function EightApp(props) {
    return (
        <div>
            <h3 className='alert alert-light'>EightApp</h3>
        
            <AddPhotoAlternateRounded/>
            <AddAlarmRounded/>
            <CameraAltOutlined/>
            <ImageAspectRatioOutlined/>
            <PhotoCameraBack/>
        </div>
    );
}

export default EightApp;