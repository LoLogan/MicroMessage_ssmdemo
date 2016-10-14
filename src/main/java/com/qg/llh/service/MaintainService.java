package com.qg.llh.service;


/**
 * 维护相关的业务功能
 */
public interface MaintainService {
	/**
	 * 单条删除
	 */
	public void deleteOne(String id) ;
	
	/**
	 * 批量删除
	 */
	public void deleteBatch(String[] ids) ;
}
