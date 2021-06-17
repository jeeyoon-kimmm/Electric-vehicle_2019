package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.ev_CarDTO;

@Mapper("CarMapper")
public interface ICarMapper {

	List<ev_CarDTO> selectmoney(ev_CarDTO cDTO) throws Exception;
}
