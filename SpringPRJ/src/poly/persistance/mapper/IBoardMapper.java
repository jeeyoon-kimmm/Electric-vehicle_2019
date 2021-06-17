package poly.persistance.mapper;

import java.util.HashMap;
import java.util.List;

import config.Mapper;
import poly.dto.B_CommentDTO;
import poly.dto.BoardDTO;

@Mapper("BoardMapper")
public interface IBoardMapper {

	// 게시판 목록
	List<BoardDTO> getBoardList(HashMap<String, Integer> hMap) throws Exception;

	int getBoardCnt() throws Exception;//여기엔 잘있지?응 여기는 interface라ㅑ서 얼굴만 있는거구 몸통은 NoticeMapper 이잖아?오 응

	// 게시판 등록
	int insertBoardInfo(BoardDTO bDTO) throws Exception;

	// 게시판 상세보기
	BoardDTO getBoardDetail(String seq) throws Exception;

	// 게시판 수정
	int updateBoardInfo(BoardDTO bDTO) throws Exception;

	// 게시판 삭제
	int deleteBoardInfo(String seq) throws Exception;
/////////////////////////////////////////////////////////////////////////////////////////
	
	List<BoardDTO> getUserBoardList(String user_id)throws Exception;
	 


}