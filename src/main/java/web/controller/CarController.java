package web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.CarService;

@Controller
public class CarController {
	
	@Autowired
	CarService carServ;
	
	@GetMapping(value = "/cars")
	public String showCars(@RequestParam(value="count", required=false) Integer c, Model model) {
		int count = Optional.ofNullable(c).orElse(5);
		model.addAttribute("cars", carServ.getCars(count));
		return "cars";
	}
}
