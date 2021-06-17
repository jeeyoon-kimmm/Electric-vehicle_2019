package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.UserDTO;

@Mapper("MypageMapper")
public interface IMypageMapper {
	UserDTO getUserPageInfo(String userId) throws Exception;

	int updateUserPageInfo(UserDTO uDTO) throws Exception;
	
	int updateUserPwInfo(UserDTO uDTO) throws Exception;

	int deleteUserPageInfo(String userId) throws Exception;
//////////////////////////////////////////////////////////////////
	UserDTO getMPageInfo(String userId) throws Exception;

	int updateMPageInfo(UserDTO mDTO) throws Exception;

	int updateMPwInfo(UserDTO mDTO) throws Exception;
	
	List<UserDTO> getUserList() throws Exception;
	
	int deleteUser(String user_id) throws Exception;

}
