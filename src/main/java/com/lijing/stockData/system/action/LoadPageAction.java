package com.lijing.stockData.system.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lijing.stockData.system.service.LoadStockDataService;

@Controller
public class LoadPageAction {
	@Autowired
	private LoadStockDataService loadStockDataService;
	// 上传文件的页面跳转
	@RequestMapping(value = "/action/uploadFilePage.html")
	public String uploadFile() {
		ModelAndView view = new ModelAndView();
		view.setViewName("uploadFile");
		return "uploadFile";
	}

	// 初始化数据展示的界面
	@RequestMapping(value = "/action/showAllData.html")
	public ModelAndView showAllData(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView view = new ModelAndView();
		view.addObject("Account", "A739496748,0130643699");
		//request.setAttribute("Account", "A739496748,0130643699");
		view.setViewName("StockDataPage");
		return view;
	}

}
