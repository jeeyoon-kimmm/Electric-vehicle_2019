package poly.service;

import java.util.List;

import poly.dto.UserDTO;

public interface IMypageService {

	UserDTO getUserPageInfo(String userId)throws Exception;

	int updateUserPageInfo(UserDTO uDTO)throws Exception;

	int deleteUserPageInfo(String userId)throws Exception;

	int updateUserPwInfo(UserDTO uDTO)throws Exception;
//////////////////////////////////////////////////////////////////////////////
	UserDTO getMPageInfo(String userId)throws Exception;

	int updateMPageInfo(UserDTO uDTO)throws Exception;

	int updateMPwInfo(UserDTO mDTO)throws Exception;
	
	List<UserDTO> getUserList() throws Exception;
	
	int deleteUser(String user_id) throws Exception;


}
