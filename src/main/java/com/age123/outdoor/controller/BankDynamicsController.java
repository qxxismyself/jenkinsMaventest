package com.age123.outdoor.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.age123.outdoor.service.BankDynamicsService;
import com.age123.outdoor.service.PublicInfoService;

@Controller
public class BankDynamicsController {

	@Resource
	private BankDynamicsService bankDynamicsService;

	@RequestMapping(value = "/bankDynamics")
	public String list() {
		System.out.println(bankDynamicsService.getById(1).getBankName());
		System.out.println(bankDynamicsService.getAll().size());
		System.out.println("hello world");
		return "publicInfo.list";
	}
}
