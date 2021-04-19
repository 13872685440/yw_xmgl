package com.cat.file.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cat.boot.catconst.RedisConst;
import com.cat.boot.config.JedisUtil;
import com.cat.boot.config.MinioTemplate;
import com.cat.boot.exception.CatException;
import com.cat.boot.jsonbean.ResultBean;
import com.cat.boot.service.BaseService;
import com.cat.boot.util.NameQueryUtil;
import com.cat.boot.util.StringUtil;
import com.cat.file.jsonbean.FileBean;
import com.cat.file.jsonbean.FileInfoBean;
import com.cat.file.jsonbean.ResultFileBean;
import com.cat.file.jsonbean.UploadBean;
import com.cat.file.model.FileInfo;
import com.cat.file.model.YeWuBLZLWD;
import com.cat.file.model.YeWuBanLiZlLx;
import com.cat.file.utils.FileUtils;

@RestController
@RequestMapping("/miniofile")
public class MinioFileController {

	@Autowired
	private BaseService baseService;
	
	@Autowired
	public JedisUtil jedisUtil;
	
	@Autowired
    private MinioTemplate minioTemplate;
	
	public void replaceTmpId(String tmpId, String entityId, String ebcn) {
		baseService.update("YeWuBLZLWD", "file", "YeWuBLZLWD_replaceTmpId",
				NameQueryUtil.setParams("entityId", entityId, "tmpId", tmpId, "ebcn", ebcn));
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/hasfile", method = RequestMethod.GET)
	public String hasFile(UploadBean bean) throws CatException {
		List<YeWuBLZLWD> wds = (List<YeWuBLZLWD>)baseService.getList("YeWuBLZLWD", null, true,
				NameQueryUtil.setParams("keyValue",bean.getKeyValue(),"ebcn",bean.getEbcn(),"sign",bean.getSign()));
		if(StringUtil.isListEmpty(wds)) {
			return ResultBean.getSucess("");
		}else {
			return ResultBean.getSucess(wds.get(0).getId());
		}
	}
	
	@RequestMapping(value = "/viewimage_bean", method = RequestMethod.GET)
	public void viewimage_bean(UploadBean bean,@RequestParam String token, HttpServletResponse response) throws Exception {
		if (StringUtil.isEmpty(token) || !jedisUtil.exists(token,RedisConst.token_db)) {

			CatException.responseData(response, 401, "认证超时");
			throw new CatException("认证超时");
		}
		InputStream in = null;
		try {
			YeWuBLZLWD wd = (YeWuBLZLWD) baseService.getSimple("YeWuBLZLWD", "o.ct desc", true
					,NameQueryUtil.setParams("sign",bean.getSign(),"keyValue",bean.getKeyValue(),"ebcn",bean.getEbcn()));
			if (wd == null) {
				return;
			} else {
				
			}
			//in = minioTemplate.getObject("uploadpath", "com.cat.personnel.model.Leave/ac73b263-179c-4cdc-bc92-cec3f5487eba/1615538446519/26_IMG_20210214_004407.jpg");
			in = minioTemplate.getObject(jedisUtil.getMinioPath("uploadpath"),wd.getFileinfo().getUrlName());
				
			byte[] b = new byte[1024];
			int len = -1;
			while ((len = in.read(b, 0, 1024)) != -1) {
				response.getOutputStream().write(b, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@RequestMapping(value = "/viewimage", method = RequestMethod.GET)
	public void viewimage(@RequestParam String id,@RequestParam String token, HttpServletResponse response) throws Exception {
		if (StringUtil.isEmpty(token) || !jedisUtil.exists(token,RedisConst.token_db)) {

			CatException.responseData(response, 401, "认证超时");
			throw new CatException("认证超时");
		}
		InputStream in = null;
		try {
			YeWuBLZLWD wd = (YeWuBLZLWD) baseService.findById(YeWuBLZLWD.class, id);
			if (wd == null) {
				return;
			} else {
				
			}
			//in = minioTemplate.getObject("uploadpath", "com.cat.personnel.model.Leave/ac73b263-179c-4cdc-bc92-cec3f5487eba/1615538446519/26_IMG_20210214_004407.jpg");
			in = minioTemplate.getObject(jedisUtil.getMinioPath("uploadpath"),wd.getFileinfo().getUrlName());
				
			byte[] b = new byte[1024];
			int len = -1;
			while ((len = in.read(b, 0, 1024)) != -1) {
				response.getOutputStream().write(b, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/load", method = RequestMethod.GET)
	public String load(UploadBean bean) throws CatException, IOException {
		Map<Object, Object> maps = NameQueryUtil.setParams("ebcn", bean.getEbcn(), "keyValue", StringUtil.isListEmpty(bean.getKeyValues()) ? 
				bean.getKeyValue() : bean.getKeyValues(),
				"sign", bean.getSign());
		List<YeWuBLZLWD> datas = (List<YeWuBLZLWD>) baseService.getList("YeWuBLZLWD", "o.ct asc", true, maps);
		List<FileInfoBean> beans = new ArrayList<FileInfoBean>();
		if(!StringUtil.isListEmpty(datas)) {
			for (YeWuBLZLWD wd : datas) {
				String path = minioTemplate.getObjectURL(jedisUtil.getMinioPath("uploadpath"),wd.getFileinfo().getUrlName(),60*60);
				FileInfoBean fileinfobean = new FileInfoBean();
				if(!bean.isIsapp()) {
					fileinfobean = FileInfoBean.setThis(wd);
				} else {
					fileinfobean.setId(wd.getId());
					fileinfobean.setName(wd.getFileinfo().getOriginalName());
					fileinfobean.setFile_ext(wd.getFileinfo().getFileExt());
				//	fileinfobean.setName(
						//	URLEncoder.encode(wd.getFileinfo().getOriginalName(),"UTF-8"));
				}
				fileinfobean.setUrl(path);
				beans.add(fileinfobean);
			}
			return ResultBean.getSucess(beans);
		} else {
			return ResultBean.getSucess(beans);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String uploadFile(HttpServletResponse response, HttpServletRequest request,
			@RequestParam(value = "file", required = false) MultipartFile file, UploadBean bean)
			throws CatException, IOException {
		FileBean filebean = new FileBean(file);
		YeWuBLZLWD wd = saveFile(response, bean, filebean);
		if(!StringUtil.isEmpty(bean.getKeyProp()) && "flutter".equals(bean.getKeyProp())) {
			if (wd!=null) {
				String path = minioTemplate.getObjectURL(jedisUtil.getMinioPath("uploadpath"),wd.getFileinfo().getUrlName(),60*60);
				FileInfoBean fileinfobean = new FileInfoBean();
				if(!bean.isIsapp()) {
					fileinfobean = FileInfoBean.setThis(wd);
				} else {
					fileinfobean.setId(wd.getId());
					fileinfobean.setName(wd.getFileinfo().getOriginalName());
					fileinfobean.setFile_ext(wd.getFileinfo().getFileExt());
					//fileinfobean.setName(URLEncoder.encode(wd.getFileinfo().getOriginalName(),"UTF-8"));
				}
				fileinfobean.setUrl(path);
				return ResultBean.getSucess(fileinfobean);
			} else {
				return ResultBean.getResultBean("400", "上传失败", "");
			}
		} else {
			if (wd!=null) {
				return ResultFileBean.getSucess(FileInfoBean.setThis(wd));
			} else {
				return ResultFileBean.getError();
			}
		}
	}
	
	@RequestMapping(value = "/downloadFile", method = RequestMethod.GET)
	public void downloadFile(HttpServletResponse response, @RequestParam String blwdId, @RequestParam String isOnLine)
			throws Exception {
		YeWuBLZLWD wd = (YeWuBLZLWD) baseService.findById(YeWuBLZLWD.class, blwdId);
		if (wd == null) {
			return;
		} else {
			InputStream in = minioTemplate.getObject(jedisUtil.getMinioPath("uploadpath"),wd.getFileinfo().getUrlName());
			FileInfo info = wd.getFileinfo();
			FileUtils.download(response, in, info.getOriginalName(),isOnLine);
		}
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	@RequestMapping(value = "/deleteFile", method = RequestMethod.POST)
	public String deleteFile(@RequestParam String id) {
		YeWuBLZLWD data = (YeWuBLZLWD) baseService.findById(YeWuBLZLWD.class, id);
		FileInfo info = (FileInfo)data.getFileinfo();
		minioTemplate.removeObject(jedisUtil.getMinioPath("uploadpath"), info.getUrlName());
		
		baseService.delete(data);
		baseService.delete(info);
		

		return ResultBean.getSucess("");
	}

	private YeWuBLZLWD saveFile(HttpServletResponse response, UploadBean bean, FileBean filebean) throws IOException {
		String sign = "";
		String path = "";
		if (!StringUtil.isEmpty(bean.getCode())) {
			YeWuBanLiZlLx zllx = (YeWuBanLiZlLx) baseService.findById(YeWuBanLiZlLx.class, bean.getCode());
			path = zllx.getPath() + "/" + bean.getKeyValue() + "/" + zllx.getName()
					+ "/" + Calendar.getInstance().getTimeInMillis() + "/" + filebean.getTitle();
			sign = zllx.getCode();
		} else {
			path = bean.getEbcn() + "/" + bean.getKeyValue() + "/"
					+ Calendar.getInstance().getTimeInMillis() + "/" + filebean.getTitle();
			sign = bean.getSign();
		}
		String uploadDir = jedisUtil.getMinioPath("uploadpath");

		return saveWd(response, filebean, path, uploadDir, sign, bean);
	}

	private YeWuBLZLWD saveWd(HttpServletResponse response, FileBean filebean, String path, String uploadDir, String sign,
			UploadBean bean) throws IOException {
		byte[] bytes = filebean.getBytes();
		ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
		
		minioTemplate.putObject(uploadDir, path , inputStream);
		
		FileInfo doc = new FileInfo();

		doc.setOriginalName(filebean.getTitle());
		doc.setUrlName(path);
		doc.setSize(Double.valueOf(filebean.getSize()));
		baseService.save(doc, false);

		YeWuBLZLWD blwd = new YeWuBLZLWD();
		blwd.setSign(sign);
		blwd.setFileinfo(doc);
		blwd.setEbcn(bean.getEbcn());

		blwd.setKeyValue(bean.getKeyValue());
		blwd.setNowinsert("1");

		baseService.save(blwd, false);

		return blwd;
	}
}
