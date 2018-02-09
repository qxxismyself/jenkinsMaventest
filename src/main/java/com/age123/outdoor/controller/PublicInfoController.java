package com.age123.outdoor.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.age123.outdoor.service.PublicInfoService;

@Controller
public class PublicInfoController {

	@Resource
	private PublicInfoService publicInfoService;

	@RequestMapping(value = "/publicInfo")
	public String list() {
		System.out.println(publicInfoService.getAll().size());
		return "publicInfo.list";
	}
}
