package com.exe.springwebview;

import java.io.FileOutputStream;
import java.io.InputStream;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomViewController {

	/*넘어오는 메소드 방식을 언급하지 않으면 디폴트로 get방식*/
	@RequestMapping(value = "/simpleCustomView.action")
	public ModelAndView customView() {
		
		ModelAndView mav = new ModelAndView();
		
		//mav.setViewName("simpleCustomView"); //jsp파일로 감
		
		
		//Class파일로 데이터 넘기기
		mav.setView(new SimpleCustomView()); //class파일로 감
		mav.addObject("message", "SimpleCustomView Class 입니다");
		
		return mav;
	}
	
	@RequestMapping(value = "pdfView.action")
	public ModelAndView getPdfView() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setView(new CustomPdfView());
		mav.addObject("message", "PDF File");
		
		return mav;
		
	}
	
	@RequestMapping(value = "excelView.action")
	public ModelAndView getExcelView() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setView(new CustomExcelView());
	
		return mav;
	}
	
	@RequestMapping(value = "upload.action",method = RequestMethod.POST)
	public String upload(MultipartHttpServletRequest request,String str) throws Exception{
		
		String path = request.getSession().getServletContext().getRealPath("/WEB-INF/files");
		
		/**home.jsp의 name=upload 인것*/
		MultipartFile file = request.getFile("upload");
		
		if(file!=null && file.getSize()>0) {
			
			try {
				
				InputStream is = file.getInputStream();
				
				FileOutputStream fos = new FileOutputStream(path + "/" + file.getOriginalFilename());
				
				/*
				int data;
				byte[] bufffer = new byte[4096];
				
				while((data=is.read(bufffer, 0, bufffer.length))!=-1) {
					fos.write(bufffer,0,data);
				}
				*/
				
				FileCopyUtils.copy(is, fos);
				
				is.close();
				fos.close();
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			
		}
		return "uploadResult";
	}
	
	@RequestMapping(value = "download.action")
	public ModelAndView download() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setView(new DownloadView());
		
		return mav;
	}
	
}
