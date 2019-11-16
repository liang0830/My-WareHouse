package com.la.mapper;

import java.util.List;

import com.la.beans.Company;
import com.la.utils.Domain;

/**
 * 
 * @ClassName: CompanyMapper 
 * @Description: 持久层
 * @author:liAng
 * @date: 2019年11月16日 上午8:30:26
 */
public interface CompanyMapper {

	List getList(Domain d);

	void add(Company company);

}
