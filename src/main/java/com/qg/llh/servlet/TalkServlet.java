package com.qg.llh.servlet;


import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qg.llh.service.QueryService;

/**
 * 对话页的初始化控制
 */
@Controller
public class TalkServlet  {
	@Autowired
	private QueryService queryService;
	
	@ResponseBody
	@RequestMapping(value="/AutoReplyServlet.action",produces = "text/html;charset=UTF-8")
	private String AutoReply(HttpServletResponse response,String content){
		return queryService.queryByCommand(content);
	}

	@RequestMapping(value = "/InitTalkServlet.action")
	private String InitTalkServlet(){
		return "front/talk";
	}
	
	
}
