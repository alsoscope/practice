package org.p.project.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.p.project.domain.SampleVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	//ResponseEntity HTTP상태코드 제어. 예외적인 상황에서 문제 발생시 정보 전달
	@ResponseBody
	@RequestMapping("/sendErrorAuth")
	public ResponseEntity<Void> sendListAuth(){
		//HTTP 상태(Status) 코드 전송
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@ResponseBody
	@RequestMapping("/sendErrorNot")
	public ResponseEntity<List<SampleVO>> sendListNot(){
		List<SampleVO> list=new ArrayList<>();
		for(int i=0; i<10; i++) {
			SampleVO vo=new SampleVO();
			vo.setFirstName("로로");
			vo.setLastName("마마");
			vo.setMno(i);
			list.add(vo);
		}
		return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
	}
	
	//
}//class SampleController
