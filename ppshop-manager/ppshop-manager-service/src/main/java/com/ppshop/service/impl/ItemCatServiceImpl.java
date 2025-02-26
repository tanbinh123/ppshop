package com.ppshop.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ppshop.common.pojo.EUTreeNode;
import com.ppshop.mapper.TbItemCatMapper;
import com.ppshop.pojo.TbItemCat;
import com.ppshop.service.ItemCatService;

/**
 * 商品分类
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
public class ItemCatServiceImpl implements ItemCatService{
	@Autowired
	private TbItemCatMapper tbItemCatMapper;
	
	@Override
	public List<EUTreeNode> getCatList(long parentId) {
		List<TbItemCat> tbItemCatList = tbItemCatMapper.getCatList(parentId);
		List<EUTreeNode> euTreeNodes = new ArrayList<EUTreeNode>();
		for (TbItemCat tbItemCat : tbItemCatList) {
			EUTreeNode node = new EUTreeNode();
			node.setId(tbItemCat.getId());
			node.setText(tbItemCat.getName());
			node.setState(tbItemCat.getIsParent()?"closed":"open");
			euTreeNodes.add(node);
		}
		return euTreeNodes;
	}

}
