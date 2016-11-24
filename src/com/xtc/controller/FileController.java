package com.xtc.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xml.sax.SAXException;

import com.xtc.service.FileService;

@Controller
public class FileController {
	 @Autowired
	 private FileService Service;
	 /**
	  * http://localhost:8080/Apkupload/upload.do
	  * @param map
	  * @throws IOException
	  * @throws ParserConfigurationException
	  * @throws SAXException
	  */
	 @ResponseBody 
	 @RequestMapping("upload")
	 public Map<String, Object> fileUpload(ModelMap map) throws IOException, ParserConfigurationException, SAXException{
		 Map<String, Object> mapRtn = new HashMap<String, Object>();
		 try {
			File fileisE = new File("D:\\Android\\baimi-normal.apk");
			FileInputStream inputFile = new FileInputStream(fileisE);
			byte[] buffer = new byte[(int)fileisE.length()];
			inputFile.read(buffer);
			inputFile.close();
			String file = new Base64().encodeToString(buffer);
			byte[] oc = new Base64().decode(file);
			ByteArrayInputStream org = new ByteArrayInputStream(oc);
			//写入到指定的目录
			String newFileName =Service.upload(org,null);
			mapRtn.put("RESULT",newFileName);
			System.out.println(newFileName);
		} catch (Exception e) {
			System.out.println("上传报错了！");
		}
		return mapRtn;
	}
}
