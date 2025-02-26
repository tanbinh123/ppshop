package com.ppshop.service.impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ppshop.common.pojo.EUDataGridResult;
import com.ppshop.common.pojo.PpShopResult;
import com.ppshop.mapper.TbItemParamMapper;
import com.ppshop.pojo.TbItemParam;
import com.ppshop.service.ItemParamService;

/**
 * 商品规格service
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
@Service
public class ItemParamServiceImpl implements ItemParamService{
	
	@Autowired 
	private TbItemParamMapper tbItemParamMapper;

	@Override
	public EUDataGridResult getItemParamList(int page, int rows) {
		PageHelper.startPage(page, rows);
		List<TbItemParam> list= tbItemParamMapper.getItemParamList();
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		PageInfo<TbItemParam> pageInfo = new PageInfo<TbItemParam>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public PpShopResult getItemParamById(long cid){
		TbItemParam tbItemParam = tbItemParamMapper.getItemParamByCid(cid);
		if (tbItemParam != null){
			return PpShopResult.ok(tbItemParam);
		}
		return PpShopResult.ok();
	}

	@Override
	public PpShopResult insertItemParam(TbItemParam tbItemParam) {
		tbItemParam.setCreated(new Date());
		tbItemParam.setUpdated(new Date());
		tbItemParamMapper.insertItemParam(tbItemParam);
		return PpShopResult.ok();
	}
}
