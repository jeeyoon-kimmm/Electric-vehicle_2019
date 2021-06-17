package poly.service;

import poly.dto.UserDTO;

public interface IMainService {

	/* public int idCheck(String userid) throws Exception; */
	   int idCheck(String user_id) throws Exception;
	
	public int userRegProc(UserDTO uDTO) throws Exception;

	public UserDTO getPwInfo(UserDTO uDTO) throws Exception;

	public int updatePwInfo(UserDTO uDTO) throws Exception;

	public UserDTO getIdInfo(UserDTO uDTO) throws Exception;

	public UserDTO getLogin(UserDTO uDTO) throws Exception;

}
