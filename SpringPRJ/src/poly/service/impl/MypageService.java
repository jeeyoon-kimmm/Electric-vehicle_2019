package poly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.UserDTO;
import poly.persistance.mapper.IMypageMapper;
import poly.service.IMypageService;

@Service("MypageService")
public class MypageService implements IMypageService {

	@Resource(name = "MypageMapper")
	private IMypageMapper mypageMapper;

	@Override
	public UserDTO getUserPageInfo(String userId) throws Exception {
		return mypageMapper.getUserPageInfo(userId);
	}

	@Override
	public int updateUserPageInfo(UserDTO uDTO) throws Exception {
		return mypageMapper.updateUserPageInfo(uDTO);
	}

	@Override
	public int deleteUserPageInfo(String userId) throws Exception {
		return mypageMapper.deleteUserPageInfo(userId);
	}

	@Override
	public int updateUserPwInfo(UserDTO uDTO) throws Exception {
		return mypageMapper.updateUserPwInfo(uDTO);
	}
/////////////////////////////////////////////////////////////////////////
	@Override
	public UserDTO getMPageInfo(String userId) throws Exception {
		return  mypageMapper.getMPageInfo(userId);
	}

	@Override
	public int updateMPageInfo(UserDTO mDTO) throws Exception {
		return mypageMapper.updateMPageInfo(mDTO);
	}

	@Override
	public int updateMPwInfo(UserDTO mDTO) throws Exception {
		return mypageMapper.updateMPwInfo(mDTO);
	}
	
	@Override
	public List<UserDTO> getUserList() throws Exception {
		return mypageMapper.getUserList();
	}
	
	@Override
	public int deleteUser(String user_id) throws Exception {
		return mypageMapper.deleteUser(user_id);
	}
}
