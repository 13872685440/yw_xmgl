package com.cat.system.jsonbean;

import java.util.ArrayList;
import java.util.List;

import com.cat.boot.jsonbean.BaseAppBean;
import com.cat.boot.service.BaseService;
import com.cat.boot.util.NameQueryUtil;
import com.cat.boot.util.StringUtil;
import com.cat.dictionary.model.Dictionary;
import com.cat.system.model.Organization;
import com.cat.system.model.Post;
import com.cat.system.model.Role;

public class PostBean extends BaseAppBean{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7320672214259624135L;

	private String id;

	private String name;
	
	private Integer xh = 1;
	
	private List<String> orgs = new ArrayList<String>();
	
	private List<String> org_names = new ArrayList<String>();
	
	private List<String> roles = new ArrayList<String>();
	
	private List<String> role_names = new ArrayList<String>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getXh() {
		return xh;
	}

	public void setXh(Integer xh) {
		this.xh = xh;
	}

	public List<String> getOrgs() {
		return orgs;
	}

	public void setOrgs(List<String> orgs) {
		this.orgs = orgs;
	}

	public List<String> getOrg_names() {
		return org_names;
	}

	public void setOrg_names(List<String> org_names) {
		this.org_names = org_names;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public List<String> getRole_names() {
		return role_names;
	}

	public void setRole_names(List<String> role_names) {
		this.role_names = role_names;
	}

	public static PostBean setThis(Post entity) {
		PostBean bean = new PostBean();
		bean.setName(entity.getName());
		bean.setXh(entity.getXh());
		bean.setId(entity.getId());
		if(!StringUtil.isSetEmpty(entity.getOrgs())) {
			for (Organization org : entity.getOrgs()) {
				bean.getOrgs().add(org.getCode());
				bean.getOrg_names().add(org.getName());
			}
		}
		if(!StringUtil.isSetEmpty(entity.getRoles())) {
			for (Role role : entity.getRoles()) {
				bean.getRoles().add(role.getName());
				bean.getRole_names().add(role.getDes());
			}
		}
		return bean;
	}
	
	public static List<PostBean> setThis(List<Post> entitys) {
		List<PostBean> beans = new ArrayList<PostBean>();
		if (!StringUtil.isListEmpty(entitys)) {
			for (Post bean : entitys) {
				beans.add(setThis(bean));
			}
		}
		return beans;
	}

	@SuppressWarnings("unchecked")
	public static void clone(Post bean, PostBean entity, BaseService baseService) {
		bean.setXh(entity.getXh());
		bean.setName(entity.getName());
		
		if (!StringUtil.isListEmpty(entity.getOrgs())) {

			List<Organization> as = (List<Organization>) baseService.getList("Organization", null, true,
					NameQueryUtil.setParams("code", entity.getOrgs()));

			if (!StringUtil.isListEmpty(as)) {
				bean.getOrgs().clear();
				bean.getOrgs().addAll(as);
			} else {
				bean.setOrgs(null);
			}
		} else {
			bean.setOrgs(null);
		}
		if (!StringUtil.isListEmpty(entity.getRoles())) {
			
			List<Role> as = (List<Role>) baseService.getList("Role", null, true,
					NameQueryUtil.setParams("name", entity.getRoles()));
			if (!StringUtil.isListEmpty(as)) {
				bean.getRoles().clear();
				bean.getRoles().addAll(as);
			} else {
				bean.setRoles(null);
			}
		} else {
			bean.setRoles(null);
		}
	}
}
