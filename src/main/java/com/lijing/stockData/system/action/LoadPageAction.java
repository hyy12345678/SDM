package com.lijing.stockData.system.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoadPageAction {

	// 上传文件的页面跳转
	@RequestMapping(value = "/action/uploadFilePage.html")
	public String uploadFile() {
		ModelAndView view = new ModelAndView();
		view.setViewName("uploadFile");
		return "uploadFile";
	}

	// 数据展示的界面
	@RequestMapping(value = "/action/showAllData.html")
	public ModelAndView showAllData() {
		ModelAndView view = new ModelAndView();
		view.setViewName("StockDataPage");
		return view;
	}

}
