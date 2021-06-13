package com.project.Job_Alert;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("getData")
	public Map<String,Object> getData() {
		Map<String, Object> returnMap = new HashMap();
		returnMap.put("data", "Neeraj") ; 
		return returnMap;
	}
}
