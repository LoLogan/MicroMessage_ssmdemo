package com.qg.llh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qg.llh.bean.Message;

/**
 * 和message表相关的数据库操作
 */
public interface MessageDao {
	
	/**
	 * 根据查询条件查询消息列表
	 */
	public List<Message> queryMessageList(@Param("command") String command,@Param("description")String description) ;
	/**
	 * 单条删除
	 */
	public void deleteOne(int id);
	
	/**
	 * 多条删除
	 */
	public void deleteBatch(List<Integer> ids);
	}
