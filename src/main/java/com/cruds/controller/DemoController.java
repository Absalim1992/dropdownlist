package com.cruds.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cruds.model.Country;
import com.cruds.service.CityService;
import com.cruds.service.CountryService;
import com.cruds.service.StateService;
import com.google.gson.Gson;

@Controller
@RequestMapping("/")
public class DemoController {

	@Autowired
	private CountryService countryService;
	
	@Autowired
	private StateService stateService;
	
	@Autowired
	private CityService cityService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap){
		System.out.println("Loaded Index");
		modelMap.put("countries", countryService.findAll());
		return "/index";
	}
	
	@RequestMapping(value= "loadState/{id}", method= RequestMethod.GET)
	@ResponseBody
	public String loadState(@PathVariable("id") int id){
		System.out.println("Inside LoadState");
		Gson gson = new Gson();
		return gson.toJson(stateService.findByCountry(id));
		
	}
	
	@RequestMapping(value= "loadCities/{id}", method= RequestMethod.GET)
	@ResponseBody
	public String loadCities(@PathVariable("id") int id){
		Gson gson = new Gson();
		return gson.toJson(cityService.findByState(id));
	}
}
