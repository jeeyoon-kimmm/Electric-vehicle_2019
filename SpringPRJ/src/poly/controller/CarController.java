package poly.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.dto.ev_CarDTO;
import poly.service.ICarService;
import poly.util.CmmUtil;

@Controller
public class CarController {
	private Logger log = Logger.getLogger(this.getClass());

	@Resource(name = "CarService")
	private ICarService carService;

	// 국가보조금 페이지 ok
	@RequestMapping(value = "/car/money")
	public String userMon() throws Exception {
		log.info(this.getClass());

		return "/car/money";
	}

	// 보조금 검색 띄워주기 ok!!
	@RequestMapping(value = "/car/moneyfound")
	public String Moneyfound(HttpServletRequest request, HttpServletResponse respone, Model model) throws Exception {
	
		String sd =  CmmUtil.nvl(request.getParameter("bighobby")); //jsp에 있는 값을 가져옴
		String area =  CmmUtil.nvl(request.getParameter("hobby"));
		String car_type =  CmmUtil.nvl(request.getParameter("car"));

		ev_CarDTO cDTO = new ev_CarDTO(); //dto 선언
		
		cDTO.setSd(sd);
		cDTO.setArea(area);
		cDTO.setCar_type(car_type);

		List<ev_CarDTO> cList = new ArrayList();

		try {

			cList = carService.selectmoney(cDTO);

		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("cList", cList);

		return "/car/moneyfound";
	}

	// 위치 찾기 페이지ok
	@RequestMapping(value = "/car/carFind")
	public String carFind() throws Exception {
		
		return "/car/carFind";
	}

}
