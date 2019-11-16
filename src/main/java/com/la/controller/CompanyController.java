package com.la.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.la.service.CompanyService;
import com.la.utils.Domain;
/**
 * 
 * @ClassName: CompanyController 
 * @Description: 控制层
 * @author:liAng
 * @date: 2019年11月16日 上午8:29:39
 */
@Controller
public class CompanyController {

	@Autowired
	private CompanyService service;
	
	@RequestMapping("list.do")
	public String getList(Model m,Domain d,@RequestParam(defaultValue = "1")Integer pageNum) {
		
		PageInfo info = service.getList(d,pageNum);
		m.addAttribute("info", info);
		m.addAttribute("d", d);
		return "list";
	}
	
}
