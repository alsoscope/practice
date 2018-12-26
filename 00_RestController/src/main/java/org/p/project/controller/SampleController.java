package org.p.project.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	@ResponseBody
	@RequestMapping("/sendList")
	public List<SampleVO> sendList(){
		List<SampleVO> list=new ArrayList<>();
		for(int i=0; i<10; i++) {
			SampleVO vo=new SampleVO();
			vo.setFirstName("무무");
			vo.setLastName("민민");
			vo.setMno(i);
			list.add(vo);
		}
		return list;
	}
	
	@ResponseBody
	@RequestMapping("/sendMap")
	public Map<Integer, SampleVO> sendMap(){
		Map<Integer, SampleVO> map=new HashMap<>();
		for(int i=0; i<=10; i++) {
			SampleVO vo=new SampleVO();
			vo.setFirstName("헬로");
			vo.setLastName("키티");
			vo.setMno(i);
			map.put(i, vo);
		}
		return map;
	}
}//class SampleController
