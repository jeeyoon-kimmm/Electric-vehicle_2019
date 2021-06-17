package poly.service;

import java.util.List;

import poly.dto.B_CommentDTO;
import poly.dto.BoardDTO;

public interface ICommentService {

	// 댓글 리스트
	List<B_CommentDTO> commentList(String no_seq) throws Exception;

	// 댓글 등록
	int commentAdd_Proc(B_CommentDTO bDTO) throws Exception;

	// 댓글 삭제
	int commentDelete(B_CommentDTO rDTO) throws Exception;

	// 댓글 수정
	int commentModify(B_CommentDTO rDTO) throws Exception;
	
	List<B_CommentDTO> getUserCommentList(String user_id)throws Exception;

}
