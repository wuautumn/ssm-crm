package com.it.crm.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.it.crm.pojo.BaseDict;
import com.it.crm.pojo.Customer;
import com.it.crm.pojo.QueryVo;
import com.it.crm.service.BaseDictService;
import com.it.crm.service.CustomerService;
import com.it.crm.util.Page;
/**
 * 客户管理
 * @author asus
 *
 */
@Controller
public class CustomerController {
	
	@Value("${customer.source.code}")
	private String customerSourceCode;
	@Value("${customer.industry.code}")
	private String customerIndustryCode;
	@Value("${customer.level.code}")
	private String customerLevelCode;
	
	@Autowired
	private BaseDictService baseDictService;
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/customer/list")
	public String showCustomerList(QueryVo queryVo,Model model) throws Exception {
		
		//处理乱码问题
		if(StringUtils.isNotBlank(queryVo.getCustName())){
			queryVo.setCustName(new String(queryVo.getCustName().getBytes("iso8859-1"),"utf-8"));
		}
		
		//初始化客户来源
		List<BaseDict> sourceList = baseDictService.getDictListByTypeCode(customerSourceCode);
		//所属行业
		List<BaseDict> industryList = baseDictService.getDictListByTypeCode(customerIndustryCode);
		//客户级别
		List<BaseDict> levelList = baseDictService.getDictListByTypeCode(customerLevelCode);
		//把字典信息传递给页面
		model.addAttribute("fromType", sourceList);
		model.addAttribute("industryType", industryList);
		model.addAttribute("levelType", levelList);
		
		//根据查询条件查询客户列表
		Page<Customer> page = customerService.getCustomerList(queryVo);
		//客户列表传递给页面
		model.addAttribute("page", page);
		//参数回显
		model.addAttribute("custName", queryVo.getCustName());
		model.addAttribute("custSource", queryVo.getCustSource());
		model.addAttribute("custIndustry", queryVo.getCustIndustry());
		model.addAttribute("custLevel", queryVo.getCustLevel());		
		
		return "customer";
	}
	
	@RequestMapping("/customer/edit")
	@ResponseBody
	public Customer getCustomerId(Long id){
		Customer customer = customerService.getCustomerById(id);
		return customer;
	}
	
	//保存修改
	@RequestMapping("/customer/update")
	@ResponseBody
	public String updateCustomer(Customer customer){
		customerService.updateCustomer(customer);
		return "OK";
	}
	
	//删除客户
	@RequestMapping("/customer/delete")
	@ResponseBody
	public String deleteCustomer(Long id){
		customerService.deleteCustomer(id);
		return "OK";
	}
}
