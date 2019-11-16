package com.la.demo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.la.beans.Company;
import com.la.service.CompanyService;
import com.la.utils.DateUtils;
import com.la.utils.RandomUtils;
import com.la.utils.StringUtils;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:spring-beans.xml")
public class TestAdd {
	
	@Autowired
	private CompanyService service;
	
	/*
	 * (1)公司名称：以“北京”开头，以“有限公司”或“股份有限公司”或“集团有限公司”结尾，中间使用StringUtil.
	 * randomChineseString()方法创建2-4个随机汉字（4分）
	 * (2)法人代表姓名：调用StringUtil.generateChineseName()创建（4分）
	 * (3)注册地址：以“北京市”开头，后面调用StringUtil.randomChineseString()创建20-40个汉字（4分）
	 * (4)注册资本：调用RandomUtil随机数工具方法生成，值在10万元-10亿元之间（4分）
	 * (5)营业执照号：调用RandomUtil随机数工具方法生成，以1101开头，加上11位随机数，总共15位。（4分）
	 * (6)公司经济类型：调用RandomUtil随机数工具方法，在公司类型表中的所有id中随机抽（4分）。
	 * (7)成立时间：模拟从1980年1月1日至今任意随机日期（4分）。 (8)营业期限：在成立时间上延后50年（2分）。
	 */
	@Test
	public void add() {
		List<Company> list = new ArrayList<Company>();
		for (int i = 0; i < 10000; i++) {
			// 获取随机中文字符串
			String randomCn = StringUtils.getRandomCn(2);
			String randomCn2 = StringUtils.getRandomCn(3);
			String randomCn3 = StringUtils.getRandomCn(20);
			String generateNumberString = RandomUtils.generateNumberString(8);
			String generateNumberString1 = RandomUtils.generateNumberString(4);
			Date randomHireday2 = DateUtils.randomHireday2();
			Company com = new Company();
			com.setName("北京"+randomCn+"股份有限公司");
			com.setCorporation(randomCn2);
			com.setAddress("北京市"+randomCn3);
			com.setCapital(Integer.parseInt(generateNumberString));
			com.setRegist_no(1101+Integer.parseInt(generateNumberString1));
			com.setTid(Integer.parseInt(RandomUtils.generateNumberString(1)));
			com.setCreated(randomHireday2);
			Date period = randomHireday2;
			Calendar cal = Calendar.getInstance();  
			cal.setTime(period);
			cal.add(Calendar.YEAR, +50);
			java.util.Date time = cal.getTime();
			Date created = new Date(time.getTime());
			com.setPeriod(created);
			list.add(com);
		}
		service.add(list);
		
	}
	
	@Test
	public void tT() {
		//验证邮箱正确
		boolean email = StringUtils.isEmail("1531956770@qq.com");
		System.out.println(email);
		//验证邮箱错误
		boolean email1 = StringUtils.isEmail("1531956770@.qq.com");
		System.out.println(email1);
		//验证手机号正确
		boolean mobile = StringUtils.isMobile("13152740830");
		System.out.println(mobile);
		//验证手机号错误
		boolean mobile1 = StringUtils.isMobile("131527408350");
		System.out.println(mobile1);
	}
	
}
