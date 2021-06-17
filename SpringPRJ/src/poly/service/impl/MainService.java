package poly.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.UserDTO;
import poly.persistance.mapper.IMainMapper;
import poly.service.IMainService;

@Service("MainService")
public class MainService implements IMainService {
	@Resource(name="MainMapper")
	private IMainMapper mainMapper;

	@Override
	public int idCheck(String user_id) throws Exception {
		// TODO Auto-generated method stub
		return mainMapper.idCheck(user_id);
	}

	@Override
	public int userRegProc(UserDTO uDTO) throws Exception {
		// TODO Auto-generated method stub
		return mainMapper.userRegProc(uDTO);
	}
	
	@Override
	public int updatePwInfo(UserDTO uDTO) throws Exception {
		// TODO Auto-generated method stub
		return mainMapper.updatePwInfo(uDTO);
	}

	@Override
	public UserDTO getPwInfo(UserDTO uDTO) throws Exception {
		// TODO Auto-generated method stub
		return mainMapper.getPwInfo(uDTO);
	}

	@Override
	public UserDTO getIdInfo(UserDTO uDTO) throws Exception {
		// TODO Auto-generated method stub
		return mainMapper.getIdInfo(uDTO);
	}

	@Override
	public UserDTO getLogin(UserDTO uDTO) throws Exception {
		// TODO Auto-generated method stub
		return mainMapper.getLogin(uDTO);
	}

}
