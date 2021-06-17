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
import org.springframework.web.bind.annotation.RequestMethod;

import oracle.net.aso.b;
import poly.dto.B_CommentDTO;
import poly.dto.BoardDTO;
import poly.dto.NoticeDTO;
import poly.dto.PagingDTO;
import poly.dto.UserDTO;
import poly.service.IBoardService;
import poly.service.ICommentService;
import poly.service.IMypageService;
import poly.service.INoticeService;
import poly.service.impl.MainService;
import poly.util.CmmUtil;

@Controller
public class mypageController {

	private Logger log = Logger.getLogger(this.getClass());

	@Resource(name = "MypageService")
	private IMypageService mypageService;

	@Resource(name = "NoticeService")
	private INoticeService noticeService;

	@Resource(name = "BoardService")
	private IBoardService boardService;

	@Resource(name = "CommentService")
	private ICommentService commentService;

	// 마이페이지 사용자 개인정보 수정 페이지
	@RequestMapping(value = "main/mypage")
	public String userModify(HttpServletRequest request, Model model, HttpSession session) throws Exception {

		String userId = (String) session.getAttribute("userId");

		if (userId != null) {
			UserDTO uDTO = new UserDTO();

			try {
				uDTO = mypageService.getUserPageInfo(userId);

			} catch (Exception e) {
				e.printStackTrace();
			}

			model.addAttribute("uDTO", uDTO);
			return "/main/mypage";
		} else {
			model.addAttribute("msg", "로그인이 필요한 서비스 입니다.");
			model.addAttribute("url", "/main/llogin.do");
			return "/redirect";
		}
	}

	// 마이페이지 수정: 사용자 개인정보
	@RequestMapping(value = "main/mypageProc")
	public String userModifyProc(HttpServletRequest request, Model model, HttpSession session) throws Exception {

		String userName = CmmUtil.nvl(request.getParameter("userName"));
		String userId = CmmUtil.nvl(request.getParameter("userId"));
		String userTel = CmmUtil.nvl(request.getParameter("userTel"));
		String userEmail = CmmUtil.nvl(request.getParameter("userEmail"));

		UserDTO uDTO = new UserDTO();

		uDTO.setUserName(userName);
		uDTO.setUserId(userId);
		uDTO.setUserTel(userTel);
		uDTO.setUserEmail(userEmail);

		int result = 0;
		try {
			result = mypageService.updateUserPageInfo(uDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (result > 0) {
			model.addAttribute("msg", "수정되었습니다.");
			model.addAttribute("url", "/main/mypage.do");
		} else {
			model.addAttribute("msg", "수정에 실패했습니다.");
			model.addAttribute("url", "/main/mypage.do");
		}

		return "/redirect";
	}

	// 마이페이지 수정: 비밀번호
	@RequestMapping(value = "main/mypageProc2", method = RequestMethod.POST) // POST 가 보이지 않게 값을 보냄
	public String userPwProc(HttpServletRequest request, Model model, HttpSession session) throws Exception {

		log.info(this.getClass().getName() + "./main/mypageProc2 start!");

		String userId = (String) session.getAttribute("userId");

		String userPassword = CmmUtil.nvl(request.getParameter("userPassword"));
		String PasswordRepeat = CmmUtil.nvl(request.getParameter("PasswordRepeat"));

		UserDTO uDTO = new UserDTO();

		uDTO.setUserPassword(userPassword);
		uDTO.setUserId(userId);

		if (!userPassword.equals(PasswordRepeat)) {
			model.addAttribute("msg", "비밀번호가 일치하지 않습니다. 비밀번호 확인을 다시 해주세요.");
			model.addAttribute("url", "/main/mypage.do");
		} else {
			int result = 0;
			try {
				result = mypageService.updateUserPwInfo(uDTO);
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (result > 0) {
				model.addAttribute("msg", "수정되었습니다.");
				model.addAttribute("url", "/main/mypage.do");
			} else {
				model.addAttribute("msg", "수정에 실패했습니다.");
				model.addAttribute("url", "/main/mypage.do");
			}
		}

		return "/redirect";
	}

	// 마이페이지 사용자 회원 탈퇴
	@RequestMapping(value = "main/mypageUserDelete")
	public String userDelete(HttpServletRequest request, Model model, HttpSession session) throws Exception {

		log.info(this.getClass().getName() + "./main/mypageUserDelete start!");

		String userId = (String) session.getAttribute("userId");

		int result = 0;

		try {
			result = mypageService.deleteUserPageInfo(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (result > 0) {
			model.addAttribute("url", "/Logoutbtn.do");
			model.addAttribute("msg", "회원탈퇴에 성공하셨습니다.");
		} else {
			model.addAttribute("url", "/mian/mypage.do");
			model.addAttribute("msg", "탈퇴에 실패했습니다.");

		}

		return "/redirect";
	}

	// 관리자  페이지///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// 관리자 페이지 개인정보 수정 페이지 ok!!!!!!!!!!!
	@RequestMapping(value = "manager/page")
	public String managerModify(HttpServletRequest request, Model model, HttpSession session) throws Exception {

		String userId = (String) session.getAttribute("userId");

		UserDTO mDTO = new UserDTO();

		try {
			mDTO = mypageService.getMPageInfo(userId);

		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("mDTO", mDTO);
		return "/manager/page";
	}

	// 관리자 페이지 개인정보 수정
	@RequestMapping(value = "manager/pageProc")
	public String managerModifyProc(HttpServletRequest request, Model model, HttpSession session) throws Exception {

		String userName = CmmUtil.nvl(request.getParameter("userName"));
		String userId = CmmUtil.nvl(request.getParameter("userId"));
		String userTel = CmmUtil.nvl(request.getParameter("userTel"));
		String userEmail = CmmUtil.nvl(request.getParameter("userEmail"));

		UserDTO mDTO = new UserDTO();

		mDTO.setUserName(userName);
		mDTO.setUserId(userId);
		mDTO.setUserTel(userTel);
		mDTO.setUserEmail(userEmail);

		int result = 0;
		try {
			result = mypageService.updateMPageInfo(mDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (result > 0) {
			model.addAttribute("msg", "수정되었습니다.");
			model.addAttribute("url", "/manager/page.do");
		} else {
			model.addAttribute("msg", "수정에 실패했습니다.");
			model.addAttribute("url", "/manager/page.do");
		}

		return "/redirect";
	}

	// 관리자 페이지 수정: 비밀번호 수정

	@RequestMapping(value = "manager/pageProc2", method = RequestMethod.POST) // POST가 보이지 않게 값을 보냄

	public String managerPwProc(HttpServletRequest request, Model model, HttpSession session) throws Exception {

		String userId = (String) session.getAttribute("userId");

		String userPassword = CmmUtil.nvl(request.getParameter("userPassword"));
		String PasswordRepeat = CmmUtil.nvl(request.getParameter("PasswordRepeat"));

		UserDTO mDTO = new UserDTO();

		mDTO.setUserPassword(userPassword);
		mDTO.setUserId(userId);

		if (!userPassword.equals(PasswordRepeat)) {
			model.addAttribute("msg", "비밀번호가 일치하지 않습니다. 비밀번호 확인을 다시 해주세요.");
			model.addAttribute("url", "/manager/page.do");

		} else {
			int result = 0;
			try {
				result = mypageService.updateMPwInfo(mDTO);
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (result > 0) {
				model.addAttribute("msg", "수정되었습니다.");
				model.addAttribute("url", "/manager/page.do");
			} else {
				model.addAttribute("msg", "수정에 실패했습니다.");
				model.addAttribute("url", "/manager/page.do");
			}
		}

		return "/redirect";
	}

	@RequestMapping(value = "/manager/noticeList")
	public String noticeList(HttpServletRequest request, Model model, HttpSession session) throws Exception {

		int page = 1;
		PagingDTO paging = new PagingDTO();
		List<NoticeDTO> nList = new ArrayList<>(); // 전역변수

		try {
			page = Integer.parseInt(request.getParameter("pgNum"));
		} catch (Exception e) {
			page = 1;
			log.info("page 오류로 1로 설정");
		}
		int listCnt = noticeService.getNoticeCnt();
		log.info("listCnt : " + listCnt);

		if (listCnt == 0) {
			NoticeDTO nDTO = new NoticeDTO(); // 지역변수
			nDTO.setTitle("없음");

			nList.add(nDTO);

		} else {

			if (page <= 0) {
				page = 1;
				log.info("listCnt 변경 : " + listCnt);
			}
			log.info("page 체크 : " + page);

			paging.pageInfo(page, listCnt);
			HashMap<String, Integer> hMap = new HashMap<>();
			int i = paging.getStartList();
			log.info("startlist : " + i);
			int j = paging.getListSize();
			log.info("listsize : " + j);
			hMap.put("startlist", i);
			hMap.put("listsize", j * page);

			try {
				nList = noticeService.getNoticeList(hMap);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		if (nList == null) {
			nList = new ArrayList<>();
		} else {
			for (int i = 0; i < nList.size(); i++) {
				NoticeFilter(nList.get(i));
			}
		}

		model.addAttribute("nList", nList);
		model.addAttribute("paging", paging);

		return "/manager/noticeList";
	}

	@RequestMapping(value = "/manager/boardList")
	public String boardList(HttpServletRequest request, Model model, HttpSession session) throws Exception {

		int page = 1;

		try {
			page = Integer.parseInt(request.getParameter("pgNum"));
		} catch (Exception e) {
			page = 1;
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

		paging.pageInfo(page, listCnt);
		HashMap<String, Integer> hMap = new HashMap<>();
		int i = paging.getStartList();
		log.info("startlist : " + i);
		int j = paging.getListSize();
		log.info("listsize : " + j);
		hMap.put("startlist", i);
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
			for (int i1 = 0; i1 < bList.size(); i1++) {
				BoardFilter(bList.get(i1));
			}
		}
		model.addAttribute("bList", bList);
		model.addAttribute("paging", paging);

		return "/manager/boardList";
	}

	@RequestMapping(value = "/manager/commentList")
	public String commentList(HttpServletRequest request, Model model, HttpSession session) throws Exception {

		int page = 1;

		try {
			page = Integer.parseInt(request.getParameter("pgNum"));
		} catch (Exception e) {
			page = 1;
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

		paging.pageInfo(page, listCnt);
		HashMap<String, Integer> hMap = new HashMap<>();
		int i = paging.getStartList();
		log.info("startlist : " + i);
		int j = paging.getListSize();
		log.info("listsize : " + j);
		hMap.put("startlist", i);
		hMap.put("listsize", j * page);
		
		// CmmUtil은 널값을 막는 것
		String seq = CmmUtil.nvl(request.getParameter("seq"));
		String no_seq = seq;

		// 댓글 리스트가 보여야 할 게시글 상세보기에 댓글 리스트 관련 로직을 작성
		// 댓글 리스트는 일반 게시글 리스트가 보이는 컨트롤러랑 비슷하다고 생각
		List<B_CommentDTO> rList = new ArrayList<>();

		try {
			rList = commentService.commentList(no_seq); // no_seq값을 넘긴다.
			log.info("rList : " + rList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 댓글을 리스트로 선언한거임
		// 댓글의 값이 있을때 for문을 돌려서 리스트에 값이 있으면 필터를 돌림->스크립트 막기!
		if (rList == null) {
			rList = new ArrayList<B_CommentDTO>();
		} else {
			for (int j1 = 0; j1 < rList.size(); j1++) {
				B_CommentFilter(rList.get(j1));
			}
		}

		model.addAttribute("rList", rList); // rList 저장
		model.addAttribute("no_seq", no_seq); // no_seq값 저장
		model.addAttribute("paging", paging);

			return "/manager/commentList";
	}

	public NoticeDTO NoticeFilter(NoticeDTO nDTO) {
		if (nDTO.getTitle() != null) {
			nDTO.setTitle(nDTO.getTitle().replaceAll("scr!pt", "script"));
			nDTO.setTitle(nDTO.getTitle().replaceAll("& #39;", "&#39;")); // 작은따옴표
			nDTO.setTitle(nDTO.getTitle().replaceAll("& lt;", "&lt;"));
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

	public BoardDTO BoardFilter(BoardDTO nDTO) {
		if (nDTO.getTitle() != null) {
			nDTO.setTitle(nDTO.getTitle().replaceAll("scr!pt", "script"));
			nDTO.setTitle(nDTO.getTitle().replaceAll("& #39;", "&#39;")); // 작은따옴표
			nDTO.setTitle(nDTO.getTitle().replaceAll("& lt;", "&lt;"));
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

	
	  public B_CommentDTO B_CommentFilter(B_CommentDTO nDTO) {
	  
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
	  
	  } return nDTO; }
	 
	
	@RequestMapping(value = "/mypage/userBoard")
	public String userBoard(HttpServletRequest request, Model model, HttpSession session) throws Exception {
		String user_id = "";
		user_id = (String) session.getAttribute("userId");
		
		try {
			user_id.length();
		}catch (Exception e) {
			// TODO: handle exception
			user_id ="";
		}
		if(user_id.length() > 0) {
			List<BoardDTO> bList = null;
			bList = boardService.getUserBoardList(user_id);
			
			model.addAttribute("bList", bList);
			
			return "/mypage/userBoard";
		}else {
			model.addAttribute("url", "/main/llogin.do");
			model.addAttribute("msg", "로그인 후 이용해주세요.");


		return "/redirect";
		}
		
	}
	
	@RequestMapping(value = "/mypage/userComment")
	public String userComment(HttpServletRequest request, Model model, HttpSession session) throws Exception {
		String user_id = "";
		user_id = (String) session.getAttribute("userId");
			
		try {
			user_id.length();
		}catch (Exception e) {
			// TODO: handle exception
			user_id ="";
		}
		if(user_id.length() > 0) {
			List<B_CommentDTO> bList = null;
			bList = commentService.getUserCommentList(user_id);
			
			for (int j1 = 0; j1 < bList.size(); j1++) {
				B_CommentFilter(bList.get(j1));
			}
			
			model.addAttribute("bList", bList);
			
			return "/mypage/userComment";
		}else {
			model.addAttribute("url", "/main/llogin.do");
			model.addAttribute("msg", "로그인 후 이용해주세요.");

		return "/redirect";
		}
		
		
	}
	
	@RequestMapping(value = "/manager/userManage")
	public String userManage(HttpServletRequest request, Model model, HttpSession session) throws Exception {
		String user_Rights = "";
		user_Rights = (String) session.getAttribute("user_Rights");
		
		if(user_Rights.equals("1")) {
			List<UserDTO> bList = null;
			bList = mypageService.getUserList();
			
			model.addAttribute("bList", bList);
			
			return "/manager/userManage";
		}else {
			model.addAttribute("url", "/main/llogin.do");
			model.addAttribute("msg", "관리자가 아닙니다.");

		return "/redirect";
		}
	}
	
	@RequestMapping(value = "/manager/deleteUser")
	public String deleteUser(HttpServletRequest request, Model model, HttpSession session) throws Exception {
		String user_id = "";
		int result = 0;
		user_id = CmmUtil.nvl(request.getParameter("userid"));
		System.out.println(user_id);
		try {
			user_id.length();
		} catch (Exception e) {
			// TODO: handle exception
			user_id = "";
		}
		
		if(user_id.length()>0) {
			result = mypageService.deleteUser(user_id);
		}else {
			model.addAttribute("url", "/manager/userManage.do");
			model.addAttribute("msg", "삭제에 실패했습니다.");
		}
		if(result > 0) {
			model.addAttribute("url", "/manager/userManage.do");
			model.addAttribute("msg", "삭제에 성공했습니다.");
		}else {
			model.addAttribute("url", "/manager/userManage.do");
			model.addAttribute("msg", "삭제에 실패했습니다.");
		}
		return "/redirect";
		
	}

}
