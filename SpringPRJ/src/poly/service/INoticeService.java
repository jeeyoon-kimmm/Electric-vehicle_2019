package poly.service;

import java.util.HashMap;
import java.util.List;

import poly.dto.NoticeDTO;

public interface INoticeService {

//	// 공지사항 목록
//	List<NoticeDTO> getNoticeList(int i) throws Exception;

	int getNoticeCnt()throws Exception;

	//NoticeDTO getNoticeDetail(int iNum2)throws Exception;
	
	// 공지사항 등록
	int insertNoticeInfo(NoticeDTO nDTO) throws Exception;

	// 공지사항 상세보기
	NoticeDTO getNoticeDetail(String seq) throws Exception;

	// 공지사항 수정
	int updateNoticeInfo(NoticeDTO nDTO) throws Exception;

	// 공지사항 삭제
	int deleteNoticeInfo(String seq) throws Exception;

	//공지사항목록
	List<NoticeDTO> getNoticeList(HashMap<String, Integer> hMap) throws Exception;


}
