package mini.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import mini.dao.BoardFileDao;
import mini.dto.BoardFileDto;

@Service @AllArgsConstructor
public class BoardFileService {
	private BoardFileDao boardFileDao;
	
	public void insertPhoto(BoardFileDto dto)
	{
		boardFileDao.insertPhoto(dto);
	}
	
	//num을 보내면 파일명들을 리스트형태로 반환
	public List<String> getPhotoByNum(int num)
	{
		return boardFileDao.getPhotoByNum(num);
	}
	
	public List<BoardFileDto> getFileDataByNum(int num)
	{
		return boardFileDao.getFileDataByNum(num);
	}
	
	public void deletePhoto(int idx)
	{
		boardFileDao.deletePhoto(idx);
	}
}
