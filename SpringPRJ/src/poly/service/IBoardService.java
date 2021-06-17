package poly.service;

import java.util.HashMap;
import java.util.List;

import poly.dto.B_CommentDTO;
import poly.dto.BoardDTO;

public interface IBoardService {

	// 공지사항 목록
	List<BoardDTO> getBoardList(HashMap<String, Integer> hMap) throws Exception;

	int getBoardCnt()throws Exception;

	// 공지사항 등록
	int insertBoardInfo(BoardDTO bDTO) throws Exception;

	// 공지사항 상세보기
	BoardDTO getBoardDetail(String seq) throws Exception;

	// 공지사항 수정
	int updateBoardInfo(BoardDTO bDTO) throws Exception;

	// 공지사항 삭제
	int deleteBoardInfo(String seq) throws Exception;

	
	  List<BoardDTO> getUserBoardList(String user_id)throws Exception;
	 

}
