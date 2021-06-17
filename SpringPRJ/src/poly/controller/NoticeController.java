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

import poly.dto.NoticeDTO;
import poly.dto.PagingDTO;
import poly.service.INoticeService;
import poly.util.CmmUtil;

@Controller
public class NoticeController {
	private Logger log = Logger.getLogger(this.getClass());

	@Resource(name = "NoticeService")
	private INoticeService noticeService;

	// 공지사항 페이지 ok!
	@RequestMapping(value = "/notice/notice")
	public String NoticePage(HttpServletRequest request, Model model, HttpSession session) throws Exception {

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
			for(int i = 0 ; i<nList.size();i++) {
				NoticeFilter(nList.get(i));
			}
		}

		model.addAttribute("nList", nList);
		model.addAttribute("paging", paging);
		
		return "/notice/notice";
	}

	// 공지사항 자세히보기 ok!
	@RequestMapping(value = "notice/NoticeDetail")
	public String NoticeDetailUser(HttpServletRequest request, Model model, HttpSession session) throws Exception {

		String seq = CmmUtil.nvl(request.getParameter("seq"));
		String pgNum = CmmUtil.nvl(request.getParameter("pgNum"));

		NoticeDTO nDTO = new NoticeDTO();

		try {
			nDTO = noticeService.getNoticeDetail(seq);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (nDTO == null) {
			model.addAttribute("msg", "공지사항이 없습니다.");
			model.addAttribute("url", "/notice/notice.do?pgNum=1");
			return "redirect";
		} else {
			NoticeFilter(nDTO);
			model.addAttribute("nDTO", nDTO);
			model.addAttribute("seq", seq);
			model.addAttribute("pgNum", pgNum);
			return "/notice/noticeDetail";
		}
	}

	// 관리자 공지사항 등록 페이지
	@RequestMapping(value = "notice/noticeWrite")
	public String noticeWrite(HttpSession session, Model model) {

		String userId = (String) session.getAttribute("userId");

		if (userId != null) {
			return "/notice/noticeWrite";
		} else {
			model.addAttribute("msg", "로그인이 필요한 서비스 입니다.");
			model.addAttribute("url", "/main/llogin.do");
			return "/redirect";
		}
	}

	// 관리자 공지사항 등록 실행 ok!!
	@RequestMapping(value = "notice/NoticeRegProc")
	public String GuideRegProc(HttpServletRequest request, Model model, HttpSession session) throws Exception {

		log.info(this.getClass());

		String title = CmmUtil.nvl(request.getParameter("title"));
		String content = CmmUtil.nvl(request.getParameter("content"));
		String userId = (String) session.getAttribute("userId");

		log.info("제목 : " + title);
		log.info("내용 : " + content);
		log.info("작성자 : " + userId);

		NoticeDTO nDTO = new NoticeDTO();
		nDTO.setContent(content);
		nDTO.setTitle(title);
		nDTO.setReg_id(userId);

		int result = 0;

		try {
			result = noticeService.insertNoticeInfo(nDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (result > 0) {
			model.addAttribute("msg", "공지사항이 등록되었습니다.");
			model.addAttribute("url", "/notice/notice.do?pgNum=1");
		} else {
			model.addAttribute("msg", "공지사항 등록에 실패하였습니다.");
			model.addAttribute("url", "/notice/notice.do?pgNum=1");
		}

		return "/redirect";
	}

	// 관리자 공지사항 수정 페이지 ok!
	@RequestMapping(value = "notice/noticeModify")
	public String Manager_free_modify(HttpServletRequest request, HttpSession session, Model model) throws Exception {

		log.info(this.getClass().getName() + "./notice/noticeModify start!");
		String seq = CmmUtil.nvl(request.getParameter("seq"));
		String userId = (String) session.getAttribute("userId"); // 로그인한 세션 아이디 값 사용하려고 선언

		if (userId != null) {
			NoticeDTO nDTO = new NoticeDTO();

			try {
				nDTO = noticeService.getNoticeDetail(seq);
			} catch (Exception e) {
				e.printStackTrace();
			}

			NoticeFilter(nDTO);
			model.addAttribute("seq", seq);
			model.addAttribute("nDTO", nDTO);
			return "/notice/noticeModify";

		} else {
			model.addAttribute("msg", "로그인이 필요한 서비스 입니다.");
			model.addAttribute("url", "/main/llogin.do");
			return "/redirect";
		}
	}

	// 관리자 공지사항 수정 실행 ok!
	@RequestMapping(value = "notice/noticeModifyProc")
	public String NoticeModifyProc(HttpServletRequest request, Model model) throws Exception {

		String title = CmmUtil.nvl(request.getParameter("title"));
		String content = CmmUtil.nvl(request.getParameter("content"));
		String seq = CmmUtil.nvl(request.getParameter("seq"));

		NoticeDTO nDTO = new NoticeDTO();
		nDTO.setContent(content);
		nDTO.setSeq(seq);
		nDTO.setTitle(title);

		int result = 0;
		try {
			result = noticeService.updateNoticeInfo(nDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (result > 0) {
			model.addAttribute("msg", "수정되었습니다.");
			model.addAttribute("url", "/notice/notice.do?pgNum=1");
		} else {
			model.addAttribute("msg", "수정에 실패했습니다.");
			model.addAttribute("url", "/notice/notice.do?pgNum=1");
		}

		return "/redirect";
	}

	// 관리자 공지사항 삭제
	@RequestMapping(value = "notice/NoticeDelete")
	public String NoticeDelete(HttpServletRequest request, Model model, HttpSession session) throws Exception {
		String seq = request.getParameter("seq");
		int result = 0;
		try {
			result = noticeService.deleteNoticeInfo(seq);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (result > 0) {
			model.addAttribute("url", "/notice/notice.do?pgNum=1");
			model.addAttribute("msg", "삭제되었습니다.");
		} else {
			model.addAttribute("url", "/notice/notice.do?pgNum=1");
			model.addAttribute("msg", "삭제에 실패했습니다.");
		}

		return "/redirect";
	}

	public NoticeDTO NoticeFilter(NoticeDTO nDTO) {
		if (nDTO.getTitle() != null) {
			nDTO.setTitle(nDTO.getTitle().replaceAll("scr!pt", "script"));
			nDTO.setTitle(nDTO.getTitle().replaceAll("& #39;", "&#39;"));  //작은따옴표
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

}
