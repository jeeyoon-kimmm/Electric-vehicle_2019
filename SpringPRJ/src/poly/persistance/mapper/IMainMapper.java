package poly.persistance.mapper;

import config.Mapper;
import poly.dto.UserDTO;

@Mapper("MainMapper")
public interface IMainMapper {

	int idCheck(String user_id)throws Exception;

	int userRegProc(UserDTO uDTO)throws Exception;

	int updatePwInfo(UserDTO uDTO)throws Exception;
	
	UserDTO getLogin(UserDTO uDTO)throws Exception;

	UserDTO getIdInfo(UserDTO uDTO)throws Exception;

	UserDTO getPwInfo(UserDTO uDTO)throws Exception;
	
}
