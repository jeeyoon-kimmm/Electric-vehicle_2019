package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.B_CommentDTO;

@Mapper("CommentMapper")
public interface ICommentMapper {

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
