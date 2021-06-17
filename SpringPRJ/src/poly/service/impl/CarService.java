package poly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.ev_CarDTO;
import poly.persistance.mapper.ICarMapper;
import poly.service.ICarService;

@Service("CarService")
public class CarService implements ICarService {

	@Resource(name="CarMapper")
	private ICarMapper carMapper;

	@Override
	public List<ev_CarDTO> selectmoney(ev_CarDTO cDTO) throws Exception {
		// TODO Auto-generated method stub
		return carMapper.selectmoney(cDTO);
	}
	
	
}
