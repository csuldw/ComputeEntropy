package com.zola.study.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.zola.study.common.FileUtil;

@Controller
public class EntropyController {

	Logger log = Logger.getLogger(EntropyController.class);
	
	/** 
	 * 计算信息熵
	 */
	@RequestMapping(value = "/entropy/getEntropy.do")
	@ResponseBody
	public Map<String, Object> computeEntropy(String fasta, int k,
			@RequestParam(required = false) String fastaFilePath, 
			@RequestParam(required = false) String email)
	{
		log.info("fasta:" + fasta + " | fastaFile: " + fastaFilePath + " | k=" + k + " | email: " + email);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("entropy", 0.999);
		return resultMap;
	}
	
	@RequestMapping(value = "/entropy/get.do")
	@ResponseBody
	public Map<String, Object> get(){
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("data", "123");
		return resultMap;
	}
	
	/**
	 * 上传文件
	 * 
	 * Author:liudiwei Date:2017年12月29日
	 * Tomcat配置文件添加：<Context docBase="D:/data01/uploads" path="/MLZone/uploads/" reloadable="false"/>
	 * @param request
	 * @param file
	 * @return
	 * @since
	 */
	@RequestMapping(value = "/file/uploadFile.do", method = { RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> upLoadProjectFile(HttpServletRequest request,
			@RequestParam("file") CommonsMultipartFile file, 
			@RequestParam(required = false) String uploadType) {
		log.info("uploadType:" + uploadType);
		Map<String, Object> resultMap = new HashMap<>();
		String webPath = request.getScheme()+ "://" + request.getServerName() + ":" + request.getServerPort() +request.getContextPath();;
		
		//String serverUrl = request.getSession().getServletContext().getRealPath("");
		String fullPath = "/data01";
		
		//增加uploads目录
		webPath += File.separator + "uploads";
		fullPath += File.separator + "uploads";
		
		try {
			if(uploadType != null){
				fullPath += File.separator + uploadType;
				webPath += File.separator + uploadType;
			}
			String fileName = file.getOriginalFilename(); //文件名称
			log.info("filePath: " + fullPath + fileName);
//			if(FileUtil.checkFileExist(fullPath, fileName)){
//				log.info(fullPath + "目录下存在该文件：" + fileName);
//				long ts = DateUtils.getCurrentTimestamp();
//				fileName = "f" + ts + "-" + fileName;
//				log.info("保存文件重命名" + fileName);
//			}
			FileUtil.upload(file.getInputStream(), fullPath, fileName);
			resultMap.put("result", "success");
			if("article".equals(uploadType)){
				resultMap.put("filePath", fullPath + File.separator + fileName);
			}else{
				resultMap.put("filePath", webPath + File.separator + fileName);
			}
			log.info("上传文件成功");
		} catch (IOException e) {
			log.error("上传文件异常", e);
			resultMap.put("result", "error");
			resultMap.put("reason", "上传文件异常");
		}
		return resultMap;
	}
	
	
	
}
