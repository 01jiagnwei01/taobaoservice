package com.gxkj.taobaoservice.services.impl;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gxkj.common.enums.BusinessExceptionInfos;
import com.gxkj.common.exceptions.BusinessException;
import com.gxkj.common.util.ListPager;
import com.gxkj.taobaoservice.daos.PicsDao;
import com.gxkj.taobaoservice.entitys.AdminUser;
import com.gxkj.taobaoservice.entitys.Pics;
import com.gxkj.taobaoservice.enums.PicStatus;
import com.gxkj.taobaoservice.services.PicsService;
import com.gxkj.taobaoservice.util.FileUtil;
@Service
public class PicsServiceImpl implements PicsService {
	
	@Autowired
	private PicsDao picsDao;

	public ListPager doPage(int pageno, int pagesize, String name, PicStatus status)
			throws SQLException {
		ListPager pager = picsDao.doPage(pageno,pagesize,name,status);
		return pager;
	}

	 
	public Pics addPics(MultipartFile pic, String picName,
			String picDesc, AdminUser adminUser,String baseDir) throws SQLException, BusinessException, IOException {
		if(pic  == null){
			throw new BusinessException(BusinessExceptionInfos.UP_LOAD_PIC_CANNOT_BE_NULL_ERROR);
		}
		String commonFile = "upload/pics";
		
		File saveDir_dir = new File(baseDir+commonFile);
		if (!saveDir_dir.exists()) {  //文件夹  
			saveDir_dir.mkdirs();  
		}

		 
		Pics entity = new Pics();
		Date now = new Date();
		entity.setCreateTime(now);
		entity.setCreateUser(adminUser.getId());
		entity.setPicDesc(picDesc);
		entity.setPicName(picName);
		entity.setStatus(PicStatus.NORMAL);
		//pic.getContentType()
		String picSaveName = FileUtil.generateFileNameWithDate(pic.getOriginalFilename());
		
		String savePath = String.format("%s/%s/%s", baseDir,commonFile,picSaveName);
		FileUtils.copyInputStreamToFile(pic.getInputStream(), new File(savePath));
		
		entity.setPicPath(commonFile+"/"+picSaveName);
		picsDao.insert(entity);
		
		System.out.println("文件名称: " + pic.getName());  
		System.out.println("文件原名: " + pic.getOriginalFilename());  

		
		return entity;
	}

	 
	public void doDelPics(int picId, AdminUser adminUser) throws Exception {
		Pics pic = (Pics) picsDao.selectById(picId, Pics.class);
		pic.setStatus(PicStatus.DELERATE);
		picsDao.update(pic);
		
	}

}
