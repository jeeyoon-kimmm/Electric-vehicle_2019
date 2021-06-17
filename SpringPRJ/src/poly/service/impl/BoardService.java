package poly.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.B_CommentDTO;
import poly.dto.BoardDTO;
import poly.persistance.mapper.IBoardMapper;
import poly.service.IBoardService;

@Service("BoardService")
public class BoardService implements IBoardService {
	@Resource(name = "BoardMapper")
	private IBoardMapper boardMapper;

	@Override
	public List<BoardDTO> getBoardList(HashMap<String, Integer> hMap) throws Exception {
		// 공지사항 목록 ok
		return boardMapper.getBoardList(hMap);
	}

	@Override
	public int getBoardCnt() throws Exception {
		// ok
		return boardMapper.getBoardCnt();
	}

	@Override
	public int insertBoardInfo(BoardDTO bDTO) throws Exception {
		// 공지사항 등록 ok
		return boardMapper.insertBoardInfo(bDTO);
	}

	@Override
	public BoardDTO getBoardDetail(String seq) throws Exception {
		// 공지사항 상세보기 ok
		return boardMapper.getBoardDetail(seq);
	}

	@Override
	public int updateBoardInfo(BoardDTO bDTO) throws Exception {
		// 공지사항 수정
		return boardMapper.updateBoardInfo(bDTO);
	}

	@Override
	public int deleteBoardInfo(String seq) throws Exception {
		// 공지사항 삭제
		return boardMapper.deleteBoardInfo(seq);
	}
	////////////////////////////////////////////////////////////////////

	
	  @Override
	  public List<BoardDTO> getUserBoardList(String user_id)throws Exception{
		  return boardMapper.getUserBoardList(user_id); 
		  }
	 

}
