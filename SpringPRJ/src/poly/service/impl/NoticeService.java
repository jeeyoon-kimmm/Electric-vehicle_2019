package poly.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.NoticeDTO;
import poly.persistance.mapper.INoticeMapper;
import poly.service.INoticeService;

@Service("NoticeService")
public class NoticeService implements INoticeService {
	@Resource(name = "NoticeMapper")
	private INoticeMapper noticeMapper;

	@Override
	public List<NoticeDTO> getNoticeList(HashMap<String, Integer> hMap) throws Exception {
		// 공지사항 목록 ok
		return noticeMapper.getNoticeList(hMap);
	}

	@Override
	public int getNoticeCnt() throws Exception {
		// ok
		return noticeMapper.getNoticeCnt();
	}

	@Override
	public int insertNoticeInfo(NoticeDTO nDTO) throws Exception {
		// 공지사항 등록 ok
		return noticeMapper.insertNoticeInfo(nDTO);
	}

	@Override
	public NoticeDTO getNoticeDetail(String seq) throws Exception {
		// 공지사항 상세보기 ok
		return noticeMapper.getNoticeDetail(seq);
	}

	@Override
	public int updateNoticeInfo(NoticeDTO nDTO) throws Exception {
		// 공지사항 수정
		return noticeMapper.updateNoticeInfo(nDTO);
	}

	@Override
	public int deleteNoticeInfo(String seq) throws Exception {
		// 공지사항 삭제
		return noticeMapper.deleteNoticeInfo(seq);
	}

}
