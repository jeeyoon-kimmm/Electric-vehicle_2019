package poly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.B_CommentDTO;
import poly.persistance.mapper.ICommentMapper;
import poly.service.ICommentService;

@Service("CommentService")
public class CommentService implements ICommentService {

	@Resource(name = "CommentMapper")
	private ICommentMapper commentMapper;

	@Override
	public List<B_CommentDTO> commentList(String no_seq) throws Exception {
		// 댓글 리스트
		return commentMapper.commentList(no_seq);
	}

	@Override
	public int commentAdd_Proc(B_CommentDTO bDTO) throws Exception {
		// 댓글 등록
		return commentMapper.commentAdd_Proc(bDTO);
	}

	@Override
	public int commentDelete(B_CommentDTO rDTO) throws Exception {
		// 댓글 삭제
		return commentMapper.commentDelete(rDTO);
	}

	@Override
	public int commentModify(B_CommentDTO rDTO) throws Exception {
		// 댓글 수정
		return commentMapper.commentModify(rDTO);
	}
	
	@Override
	public List<B_CommentDTO> getUserCommentList(String user_id)throws Exception {
		// 댓글 수정
		return commentMapper.getUserCommentList(user_id);
	}
}
