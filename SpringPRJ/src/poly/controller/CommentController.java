package poly.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.dto.B_CommentDTO;
import poly.service.ICommentService;
import poly.util.CmmUtil;

@Controller
public class CommentController {
	private Logger log = Logger.getLogger(this.getClass());

	@Resource(name = "CommentService")
	private ICommentService commentService;

	// 댓글 등록
	@RequestMapping(value = "/commentAddProc")
	public String f_commentAdd_Proc(HttpServletRequest request, HttpSession session, Model model) throws Exception {

		// 값을 받아오고 선언
		String content = CmmUtil.nvl(request.getParameter("content"));
		String userId = (String) session.getAttribute("userId");
		String no_seq = CmmUtil.nvl(request.getParameter("no_seq"));

		log.info("content : " + content);
		log.info("userId : " + userId);
		log.info("no_seq : " + no_seq);

		// B_CommentDTO bDTO 선언와 값들을 저장
		B_CommentDTO bDTO = new B_CommentDTO();
		bDTO.setContent(content);
		bDTO.setUser_id(userId);
		bDTO.setNo_seq(no_seq);

		int result = 0;

		try {
			// 에러가 발생할 수 있는 코드
			result = commentService.commentAdd_Proc(bDTO);
		} catch (Exception e) {
			// 에러시 수행
			e.printStackTrace(); // 오류 출력
		}

		log.info("result : " + result);
		

		// result가 0보다 크면 값이 제대로 전달이 되는 것이기에 등록 성공
		// else는 전달 x 등록 실패
		if (result > 0) {
			model.addAttribute("url", "/board/BoardDetail.do?seq="+no_seq+"&pgNum=1");
			model.addAttribute("msg", "댓글 등록에 성공하였습니다.");
		} else {
			model.addAttribute("url", "/board/BoardDetail.do?seq="+no_seq+"&pgNum=1");
			model.addAttribute("msg", "댓글 등록에 실패하였습니다.");
		}

		

		return "/redirect";
	}

	// 자유게시판 댓글 삭제
	@RequestMapping(value = "/commentDelete")
	public String f_commentDelete(HttpServletRequest request, HttpSession session, Model model) throws Exception {

		log.info(this.getClass().getName() + "/commentDelete start!");
		
		// 값을 받아오고 선언
		String com_seq = CmmUtil.nvl(request.getParameter("com_seq"));
		String no_seq = CmmUtil.nvl(request.getParameter("no_seq"));

		log.info("com_seq : " + com_seq);
		log.info("no_seq : " + no_seq);

		// B_CommentDTO rDTO 선언과 rDTO에 com_seq를 저장
		B_CommentDTO rDTO = new B_CommentDTO();
		rDTO.setCom_seq(com_seq);

		int result = 0;

		try {
			result = commentService.commentDelete(rDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("result : " + result);

		if (result > 0) {
			model.addAttribute("url", "/board/BoardDetail.do?seq="+no_seq);
			model.addAttribute("msg", "삭제되었습니다.");
			
			log.info(this.getClass().getName() + "/commentDelete end!");
		} else {
			model.addAttribute("url", "/board/BoardDetail.do?seq="+no_seq);
			model.addAttribute("msg", "삭제에 실패하였습니다.");
			
			log.info(this.getClass().getName() + "/commentDelete end!");
		}

		return "/redirect";
	}

	// 자유게시판 댓글 수정
	@RequestMapping(value = "/commentModify")
	public String f_commentModify(HttpServletRequest request, HttpSession session, Model model) throws Exception {

		// 값을 받아오고 선언
		String com_seq = CmmUtil.nvl(request.getParameter("com_seq"));
		String content = CmmUtil.nvl(request.getParameter("content"));
		String no_seq = CmmUtil.nvl(request.getParameter("no_seq"));

		// B_CommentDTO rDTO 선언과 F_seq, Content 저장
		B_CommentDTO rDTO = new B_CommentDTO();
		rDTO.setCom_seq(com_seq);
		rDTO.setContent(content);

		log.info("com_seq : " + com_seq);
		log.info("content : " + content);

		int result = 0;

		try {
			result = commentService.commentModify(rDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("result : " + result);

		if (result > 0) {
			model.addAttribute("url", "/board/BoardDetail.do?seq="+no_seq);
			model.addAttribute("msg", "댓글이 수정되었습니다.");
		} else {
			model.addAttribute("url", "/board/BoardDetail.do?seq="+no_seq);
			model.addAttribute("msg", "댓글 수정에 실패하였습니다.");
		}

		return "/redirect";
	}
	
	public B_CommentDTO B_CommentFilter( B_CommentDTO nDTO) {
		
		if (nDTO.getContent() != null) {
			nDTO.setContent(nDTO.getContent().replaceAll("scr!pt", "script"));
			nDTO.setContent(nDTO.getContent().replaceAll("& lt;script", "&lt;script"));
			nDTO.setContent(nDTO.getContent().replaceAll("& lt;/script", "&lt;/script"));
			nDTO.setContent(nDTO.getContent().replaceAll("& #39;", "&#39;"));
			nDTO.setContent(nDTO.getContent().replaceAll("& lt;", "&lt;"));
			nDTO.setContent(nDTO.getContent().replaceAll("& gt;", "&gt;"));
			nDTO.setContent(nDTO.getContent().replaceAll("& #40;", "("));
			nDTO.setContent(nDTO.getContent().replaceAll("& #41;", ")"));
			nDTO.setContent(nDTO.getContent().replaceAll("&nbsp;", " "));
		}
		return nDTO;
		
	}
}
