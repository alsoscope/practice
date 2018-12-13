package org.p.project.controller;

import org.p.project.domain.SampleVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;

//RestControlelr spring 4부터 지원 3부터는 ResponseBody
//@RestController
@Controller
@RequestMapping("/sample")
public class SampleController {
	
	@RequestMapping("/hello")
	@ResponseBody
	public String sayHello() {
		return "Hello World";
	}
	
	@RequestMapping("/sendVO")
	@ResponseBody
	public SampleVO sendVO() {
		SampleVO vo=new SampleVO();
		vo.setFirstName("길길");
		vo.setLastName("동동");
		vo.setMno(123);
		return vo;
	}
}
