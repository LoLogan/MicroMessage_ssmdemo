package com.qg.llh.servlet;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qg.llh.service.MaintainService;
import com.qg.llh.service.QueryService;

/**
 * 列表页面初始化和查询控制
 */
@Controller
public class ListServlet {
	
	@Autowired
	QueryService listService;
	
	@Autowired
	MaintainService maintainService;
	// 接受页面的值

	@RequestMapping(value = "/DeleteOneServlet.action")
	private String DeleteBatchServlet(String id) {
		maintainService.deleteOne(id);
		return "forward:/List.action";
	}
	
	@RequestMapping(value = "/DeleteBatchServlet.action")
	private String DeleteBatchServlet(String[] id) {
		maintainService.deleteBatch(id);
		return "forward:/List.action";
	}

	
	@RequestMapping(value = "/List.action")
	private String ListServlet(HttpServletRequest req,String command, String description) {
		req.setAttribute("messageList", listService.queryMessageList(command, description));
		req.setAttribute("command", command);
		req.setAttribute("description", description);
		return "back/list";
	}
	

}