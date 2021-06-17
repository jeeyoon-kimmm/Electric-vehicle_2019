package poly.persistance.mapper;

import java.util.HashMap;
import java.util.List;

import config.Mapper;
import poly.dto.NoticeDTO;

@Mapper("NoticeMapper")
public interface INoticeMapper {

	// 공지사항 목록
	//List<NoticeDTO> getNoticeList(int iNum) throws Exception;

	int getNoticeCnt() throws Exception;//여기엔 잘있지?응 여기는 interface라ㅑ서 얼굴만 있는거구 몸통은 NoticeMapper 이잖아?오 응

	// 공지사항 등록
	int insertNoticeInfo(NoticeDTO nDTO) throws Exception;

	// 공지사항 상세보기
	NoticeDTO getNoticeDetail(String seq) throws Exception;

	// 공지사항 수정
	int updateNoticeInfo(NoticeDTO nDTO) throws Exception;

	// 공지사항 삭제
	int deleteNoticeInfo(String seq) throws Exception;

	//공지사항 목록
	List<NoticeDTO> getNoticeList(HashMap<String, Integer> hMap) throws Exception;

}