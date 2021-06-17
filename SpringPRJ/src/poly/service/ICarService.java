package poly.service;

import java.util.List;

import poly.dto.ev_CarDTO;

public interface ICarService {

	List<ev_CarDTO> selectmoney(ev_CarDTO cDTO) throws Exception;

}
