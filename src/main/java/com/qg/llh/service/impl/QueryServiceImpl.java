package com.qg.llh.service.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qg.llh.bean.Command;
import com.qg.llh.bean.CommandContent;
import com.qg.llh.bean.Message;
import com.qg.llh.dao.CommandDao;
import com.qg.llh.dao.MessageDao;
import com.qg.llh.service.QueryService;
import com.qg.llh.util.Iconst;

/**
 * 查询相关的业务功能
 */
@Service
public class QueryServiceImpl implements QueryService{
	
	
	@Autowired
	private MessageDao messageDao;
	
	@Autowired
	private CommandDao commandDao;
	
	public List<Message> queryMessageList(String command,String description) {
		// 查询并返回结果
		return messageDao.queryMessageList(command,description);
	}
	
	/**
	 * 通过指令查询自动回复的内容
	 * @param command 指令
	 * @return 自动回复的内容
	 */
	public String queryByCommand(String command) {
		List<Command> commandList;
		if(Iconst.HELP_COMMAND.equals(command)) {
			commandList = commandDao.queryCommandList(null, null);
			StringBuilder result = new StringBuilder();
			for(int i = 0; i < commandList.size(); i++) {
				if(i != 0) {
					result.append("<br/>");
				}
				result.append("回复[" + commandList.get(i).getName() + "]可以查看" + commandList.get(i).getDescription());
			}
			return result.toString();
		}
		commandList = commandDao.queryCommandList(command, null);
		if(commandList.size() > 0) {
			List<CommandContent> contentList = commandList.get(0).getContentList();
			int i = new Random().nextInt(contentList.size());
			return contentList.get(i).getContent();
		}
		return Iconst.NO_MATCHING_CONTENT;
	}
}
