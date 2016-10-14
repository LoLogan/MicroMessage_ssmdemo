package com.qg.llh.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qg.llh.dao.MessageDao;
import com.qg.llh.service.MaintainService;

/**
 * 维护相关的业务功能
 */
@Service
public class MaintainServiceImpl implements MaintainService{
	
	@Autowired
	private MessageDao messageDao;
	
	/**
	 * 单条删除
	 */
	public void deleteOne(String id) {
		if(id != null && !"".equals(id.trim())) {
			messageDao.deleteOne(Integer.valueOf(id));
		}
	}
	
	/**
	 * 批量删除
	 */
	public void deleteBatch(String[] ids) {
		List<Integer> idList = new ArrayList<Integer>();
		for(String id : ids) {
			idList.add(Integer.valueOf(id));
		}
		messageDao.deleteBatch(idList);
	}
}
