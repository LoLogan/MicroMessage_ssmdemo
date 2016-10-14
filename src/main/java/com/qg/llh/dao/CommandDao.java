package com.qg.llh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qg.llh.bean.Command;

/**
 * 与指令表对应的数据库操作类
 */
public interface CommandDao {
	/**
	 * 根据查询条件查询指令列表
	 */
	public List<Command> queryCommandList(@Param("name")String name,@Param("description") String description);
	}

