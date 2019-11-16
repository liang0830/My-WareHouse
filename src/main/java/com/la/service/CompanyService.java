package com.la.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.la.beans.Company;
import com.la.utils.Domain;

/**
 * 
 * @ClassName: CompanyService 
 * @Description: 业务层
 * @author:liAng
 * @date: 2019年11月16日 上午8:29:55
 */
public interface CompanyService {

	PageInfo getList(Domain d, Integer pageNum);

	void add(List<Company> list);

}
