package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	//rest
	@Autowired
	private MemberRepository memberDao;
	
	@RequestMapping("/add")
	@ResponseBody
	public Member add(Member member) {
		Member memberData = memberDao.save(member);
		return memberData;
	}
	
	
	@RequestMapping("/view/{id}")
	@ResponseBody
	public Member view(@PathVariable long id) {
		Member memberData = memberDao.findById(id).get();
		return memberData;
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public List<Member> list(){
		List<Member> memberList = memberDao.findAll();
		System.out.println("here");
		return memberList;
	}
	
	@RequestMapping("/del/{id}")
	public String delete(@PathVariable long id) {
		System.out.println("id= " + id);
		memberDao.deleteById(id);
		return "redirect:/member/list";
	}
	
	@RequestMapping("/edit/{id}")
	@ResponseBody
	public Member edit(Member member) {
		Member memberData = memberDao.save(member);
		return memberData;
	}
	

}
