package com.qg.llh.service;

import java.util.List;
import com.qg.llh.bean.Message;

/**
 * 查询相关的业务功能
 */
public interface QueryService {
	public List<Message> queryMessageList(String command,String description) ;
	
	/**
	 * 通过指令查询自动回复的内容
	 * @param command 指令
	 * @return 自动回复的内容
	 */
	public String queryByCommand(String command) ;
}
