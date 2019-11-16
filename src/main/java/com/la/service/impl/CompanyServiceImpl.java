package com.la.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.la.beans.Company;
import com.la.mapper.CompanyMapper;
import com.la.service.CompanyService;
import com.la.utils.Domain;

/**
 * 
 * @ClassName: CompanyServiceImpl 
 * @Description: 业务层实现类
 * @author:liAng
 * @date: 2019年11月16日 上午8:30:05
 */
@Service
public class CompanyServiceImpl implements CompanyService {

	
	@Autowired
	private CompanyMapper mapper;

	@Override
	public PageInfo getList(Domain d, Integer pageNum) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, 4);
		List list = mapper.getList(d);
		PageInfo info  = new PageInfo(list);
		return info;
	}

	@Override
	public void add(List<Company> list) {
		// TODO Auto-generated method stub
		for (Company company : list) {
			mapper.add(company);
		}
		
	}
	
}
