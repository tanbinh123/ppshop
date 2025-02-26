package com.ppshop.search.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ppshop.common.pojo.PpShopResult;
import com.ppshop.common.utils.ExceptionUtil;
import com.ppshop.search.pojo.SearchResult;
import com.ppshop.search.service.SearchService;


/**
 * 商品查询
 * @author pangkaiguang
 *
 */
@Controller
public class SearchController {
	@Autowired
	private SearchService searchService;
	
	/**
	 * 搜索商品
	 * @param queryString
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value="/query", method=RequestMethod.GET)
	@ResponseBody
	public PpShopResult search(@RequestParam("q")String queryString,
			@RequestParam(defaultValue="1")Integer page,
			@RequestParam(defaultValue="60")Integer rows){
		//查询条件不能为空
		if (StringUtils.isBlank(queryString)){
			return PpShopResult.build(400, "查询条件不能为空");
		}
		SearchResult searchResult = null;
		try {
			queryString = new String(queryString.getBytes("iso8859-1"),"utf-8");
			searchResult = searchService.search(queryString, page, rows);
		} catch (Exception e) {
			e.printStackTrace();
			return PpShopResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		return PpShopResult.ok(searchResult);
	}
}
