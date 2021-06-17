package poly.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.dto.B_CommentDTO;
import poly.dto.BoardDTO;
import poly.dto.PagingDTO;
import poly.service.IBoardService;
import poly.service.ICommentService;
import poly.util.CmmUtil;

@Controller
public class BoardController {
	private Logger log = Logger.getLogger(this.getClass());

	@Resource(name = "BoardService")
	private IBoardService boardService;

	@Resource(name = "CommentService")
	private ICommentService commentService;

	// 게시판 페이지 ok!
	@RequestMapping(value = "/board/board")
	public String BoardPage(HttpServletRequest request, Model model, HttpSession session) throws Exception {

		int page = 1;

		try {
			page = Integer.parseInt(request.getParameter("pgNum"));
		} catch (Exception e) {
			page = 1;    //현재페이지 page
			log.info("page 오류로 1로 설정");
		}
		int listCnt = boardService.getBoardCnt();
		log.info("listCnt : " + listCnt);

		if (page <= 0) {
			page = 1;
			log.info("listCnt 변경 : " + listCnt);
		}
		log.info("page 체크 : " + page);

		PagingDTO paging = new PagingDTO();

		paging.pageInfo(page, listCnt);  //현재페이지수, 총 게시물 개수
		HashMap<String, Integer> hMap = new HashMap<>();
		int i = paging.getStartList();
		log.info("startlist : " + i);  //게시판 시작번호
		int j = paging.getListSize(); //한 페이지에 출력되는 게시물 수
		hMap.put("startlist", i); //게시판 시작번호
		hMap.put("listsize", j * page);

		List<BoardDTO> bList = new ArrayList<>();

		try {
			bList = boardService.getBoardList(hMap);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (bList == null) {
			bList = new ArrayList<>();
		} else {
			for(int i1 = 0 ; i1<bList.size();i1++) {
				BoardFilter(bList.get(i1));
			}
		}
		model.addAttribute("bList", bList);
		model.addAttribute("paging", paging);

		return "/board/board";
	}

	// 게시판 자세히보기 OK!
	@RequestMapping(value = "board/BoardDetail")
	public String BoardDetailUser(HttpServletRequest request, Model model, HttpSession session) throws Exception {

		//CmmUtil은 널값을 막는 것
		String seq = CmmUtil.nvl(request.getParameter("seq"));
		String pgNum = CmmUtil.nvl(request.getParameter("pgNum"));
		String no_seq = seq;

		BoardDTO bDTO = new BoardDTO();

		try {
			bDTO = boardService.getBoardDetail(seq);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 댓글 리스트가 보여야 할 게시글 상세보기에 댓글 리스트 관련 로직을 작성
		// 댓글 리스트는 일반 게시글 리스트가 보이는 컨트롤러랑 비슷하다고 생각
		List<B_CommentDTO> rList = new ArrayList<>();

		try {
			rList = commentService.commentList(no_seq); // no_seq값을 넘긴다.
			log.info("rList : " + rList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//댓글을 리스트로 선언한거임
		//댓글의 값이 있을때 for문을 돌려서 리스트에 값이 있으면 필터를 돌림->스크립트 막기! 
		if (rList == null) {
			rList = new ArrayList<B_CommentDTO>();
		} else {
			for (int j = 0; j < rList.size(); j++) {
				B_CommentFilter(rList.get(j));
			}
		}
		
		model.addAttribute("rList", rList); // rList 저장
		model.addAttribute("no_seq", no_seq); // no_seq값 저장

		
		if (bDTO == null) {
			model.addAttribute("msg", "게시글이 없습니다."); //메시지를 띄워줌
			model.addAttribute("url", "/board/board.do?pgNum=1"); //이쪽으로 넘어감
			
			return "redirect"; 
		} else {
			BoardFilter(bDTO); //스크립트 막는걸 쓰는거임
			
			model.addAttribute("bDTO", bDTO);
			model.addAttribute("seq", seq);
			model.addAttribute("pgNum", pgNum);
			
			return "/board/boardDetail";
		}
	}

	// 게시판 등록 페이지 ok
	@RequestMapping(value = "board/boardWrite")
	public String boardWrite(HttpSession session, Model model) throws Exception {

		String userId = (String) session.getAttribute("userId"); // 세션은 CmmUtil 사용할 필요없음

		if (userId != null) {
			return "/board/boardWrite";
		} else {
			model.addAttribute("msg", "로그인이 필요한 서비스 입니다.");
			model.addAttribute("url", "/main/llogin.do");
			return "/redirect";
		}
	}

	// 게시판 등록 실행 ok
	@RequestMapping(value = "board/BoardRegProc")
	public String GuideRegProc(HttpServletRequest request, Model model, HttpSession session) throws Exception {

		log.info(this.getClass().getName() + "./board/BoardRegProc start!");

		String title = CmmUtil.nvl(request.getParameter("title"));
		String content = CmmUtil.nvl(request.getParameter("content"));
		String userId = (String) session.getAttribute("userId");

		log.info("제목 : " + title);
		log.info("내용 : " + content);
		log.info("작성자 : " + userId);

		BoardDTO bDTO = new BoardDTO();
		bDTO.setContent(content);
		bDTO.setTitle(title);
		bDTO.setReg_id(userId);

		int result = 0;

		try {
			result = boardService.insertBoardInfo(bDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (result > 0) {
			model.addAttribute("msg", "게시판이 등록되었습니다.");
			model.addAttribute("url", "/board/board.do?pgNum=1");
		} else {
			model.addAttribute("msg", "게시판 등록에 실패하였습니다.");
			model.addAttribute("url", "/board/e.do?pgNum=1");
		}

		return "/redirect";
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////
	
	// 게시판 수정 페이지 
	@RequestMapping(value = "board/boardModify")
	public String modify(HttpServletRequest request, HttpSession session, Model model) throws Exception {

		String seq = CmmUtil.nvl(request.getParameter("seq"));
		String userId = (String) session.getAttribute("userId"); // 로그인한 세션 아이디 값 사용하려고 선언

		if (userId != null) {
			BoardDTO bDTO = new BoardDTO();

			try {
				bDTO = boardService.getBoardDetail(seq);
			} catch (Exception e) {
				e.printStackTrace();
			}

			BoardFilter(bDTO);
			model.addAttribute("seq", seq);
			model.addAttribute("bDTO", bDTO);
			return "/board/boardModify";

		} else {
			model.addAttribute("msg", "로그인이 필요한 서비스 입니다.");
			model.addAttribute("url", "/main/llogin.do");
			return "/redirect";
		}
	}

	// 게시판 수정 실행
	@RequestMapping(value = "board/boardModifyProc")
	public String BoardModifyProc(HttpServletRequest request, Model model) throws Exception {

		String title = CmmUtil.nvl(request.getParameter("title"));
		String content = CmmUtil.nvl(request.getParameter("content"));
		String seq = CmmUtil.nvl(request.getParameter("seq"));

		BoardDTO bDTO = new BoardDTO();
		bDTO.setContent(content);
		bDTO.setSeq(seq);
		bDTO.setTitle(title);

		int result = 0;
		try {
			result = boardService.updateBoardInfo(bDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (result > 0) {
			model.addAttribute("msg", "수정되었습니다.");
			model.addAttribute("url", "/board/board.do?pgNum=1");
		} else {
			model.addAttribute("msg", "수정에 실패했습니다.");
			model.addAttribute("url", "/board/board.do?pgNum=1");
		}

		return "/redirect";
	}

	// 게시판 삭제
	@RequestMapping(value = "board/BoardDelete")
	public String NoticeDelete(HttpServletRequest request, Model model, HttpSession session) throws Exception {
		String seq = request.getParameter("seq");
		int result = 0;
		try {
			result = boardService.deleteBoardInfo(seq);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (result > 0) {
			model.addAttribute("url", "/board/board.do?pgNum=1");
			model.addAttribute("msg", "삭제되었습니다.");
		} else {
			model.addAttribute("url", "/board/board.do?pgNum=1");
			model.addAttribute("msg", "삭제에 실패했습니다.");
		}

		return "/redirect";
	}
	
	//스크립트 막기///////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public BoardDTO BoardFilter(BoardDTO nDTO) {
		if (nDTO.getTitle() != null) {
			nDTO.setTitle(nDTO.getTitle().replaceAll("scr!pt", "script"));
			nDTO.setTitle(nDTO.getTitle().replaceAll("& #39;", "&#39;")); // 작은따옴표
			nDTO.setTitle(nDTO.getTitle().replaceAll("& lt;",  "&lt;"));
			nDTO.setTitle(nDTO.getTitle().replaceAll("& gt;", "&gt;"));
			nDTO.setTitle(nDTO.getTitle().replaceAll("& #40;", "("));
			nDTO.setTitle(nDTO.getTitle().replaceAll("& #41;", ")"));
			nDTO.setTitle(nDTO.getTitle().replaceAll("&nbsp;", " "));
		}
		if (nDTO.getContent() != null) {
			nDTO.setContent(nDTO.getContent().replaceAll("scr!pt", "script"));
			nDTO.setContent(nDTO.getContent().replaceAll("& lt;script", "&lt;script"));
			nDTO.setContent(nDTO.getContent().replaceAll("& lt;/script", "&lt;/script"));
			nDTO.setContent(nDTO.getContent().replaceAll("& #39;", "&#39;"));
			nDTO.setContent(nDTO.getContent().replaceAll("& lt;", "<"));
			nDTO.setContent(nDTO.getContent().replaceAll("& gt;", ">"));
			nDTO.setContent(nDTO.getContent().replaceAll("& #40;", "("));
			nDTO.setContent(nDTO.getContent().replaceAll("& #41;", ")"));
			nDTO.setContent(nDTO.getContent().replaceAll("&nbsp;", " "));
		}
		return nDTO;
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
