package com.ppshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 页面跳转
 * <pre>
 * 程序的中文名称。
 * </pre>
 * @author pangkaiguang
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */

@Controller
public class PageController {
	/**
	 * 打开首页
	 */
	@RequestMapping("/")
	public String showIndex(){
		return "index";
	}
	
	/**
	 * 展示其他页面
	 * @param page
	 * @return
	 */
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page){
		return page;
	}
}
