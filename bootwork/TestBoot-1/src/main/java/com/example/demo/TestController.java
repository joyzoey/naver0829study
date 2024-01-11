package com.example.demo;

import java.util.List;
import java.util.Vector;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/test")
	public List<TestDto> list()
	{
		List<TestDto> list = new Vector<>();
		
		TestDto dto1 = new TestDto("강호동","서울","010-1234-0505");
		list.add(dto1);
		
		TestDto dto2 = TestDto.builder()
				.name("이영지")
				.addr("부산")
				.hp("010-4444-5555")
				.build();
		list.add(dto2);
		return list;
	}
}
