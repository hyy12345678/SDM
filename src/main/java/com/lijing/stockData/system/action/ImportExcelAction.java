package com.lijing.stockData.system.action;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.lijing.stockData.system.service.ProcessImportExcelService;

@Controller
public class ImportExcelAction {
	
	//上传文件的大小限制为1M
	private static long MAX_SIZE = 1024*1024;
	
	@Autowired
	private ProcessImportExcelService processImportExcel;
	/**
	 * 处理页面上传的Excel文件
	 * @param file
	 * @return
	 */
	@RequestMapping(value="/action/importExcel")
	public ModelAndView handleImportExcel(@RequestParam("excelFile")MultipartFile excelFile)
	{
		ModelAndView view = new ModelAndView();
		view.setViewName("forward:uploadFile");
		
		String result = "";
		//设置返回界面
		
		//判断文件大小
		if( MAX_SIZE < excelFile.getSize() )
		{
			view.addObject("message", "文件过大，请传输1M以内的文件！");
			return view;
		}
		//进行业务处理，判断业务处理结果
//		File f = new file
//		File excelFile = (File) uploadFile;
		try {
			result = processImportExcel.processExcel( excelFile.getInputStream() );
			view.addObject("message", "上传成功！");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return view;
	}

}
