package com.cat.project.jsonbean;

import com.cat.boot.jsonbean.BaseAppBean;
import com.cat.boot.model.BaseEntity;
import com.cat.boot.service.BaseService;
import com.cat.boot.util.StringUtil;
import com.cat.dictionary.model.Dictionary;
import com.cat.project.model.Equipment;
import com.cat.project.model.Schedule;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EquipmentBean extends BaseAppBean {

    private static final long serialVersionUID = 7777525968411090290L;

    private String id;
    /** 编号*/
    private String code;
    /** 采购合同号 */
    private String coding;
    /** 销售合同ID（如果不关联则为空） */
    private String xsht_id;
    /** 销售合同单号（如果不关联则为空） */
    private String xsht_coding;
    /** 项目名称 */
    private String projectName;
    /** 供应商名称 */
    private String supplierName;
    /** 采购合同金额*/
    private Double money;
    /** 合同质保期*/
    private String warranty;
    /** 最后一次付款时间*/
    private String lastfkdate;
    /** 采购合同扫描状态 */
    private String cghtsmState_code;
    /** 采购合同扫描状态*/
    private String cghtsmState_name;
    /** 付款与收票状态 */
    private String fkyspState_code;
    /** 付款与收票状态 */
    private String fkyspState_name;
    /** 收货状态*/
    private String shState_code;
    /** 收货状态 */
    private String shState_name;
    /** 退换货状态*/
    private String thhState_code;
    /** 退换货状态 */
    private String thhState_name;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCoding() {
        return coding;
    }

    public void setCoding(String coding) {
        this.coding = coding;
    }

    public String getXsht_id() {
        return xsht_id;
    }

    public void setXsht_id(String xsht_id) {
        this.xsht_id = xsht_id;
    }

    public String getXsht_coding() {
        return xsht_coding;
    }

    public void setXsht_coding(String xsht_coding) {
        this.xsht_coding = xsht_coding;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public String getLastfkdate() {
        return lastfkdate;
    }

    public void setLastfkdate(String lastfkdate) {
        this.lastfkdate = lastfkdate;
    }

    public String getCghtsmState_code() {
        return cghtsmState_code;
    }

    public void setCghtsmState_code(String cghtsmState_code) {
        this.cghtsmState_code = cghtsmState_code;
    }

    public String getCghtsmState_name() {
        return cghtsmState_name;
    }

    public void setCghtsmState_name(String cghtsmState_name) {
        this.cghtsmState_name = cghtsmState_name;
    }

    public String getFkyspState_code() {
        return fkyspState_code;
    }

    public void setFkyspState_code(String fkyspState_code) {
        this.fkyspState_code = fkyspState_code;
    }

    public String getFkyspState_name() {
        return fkyspState_name;
    }

    public void setFkyspState_name(String fkyspState_name) {
        this.fkyspState_name = fkyspState_name;
    }

    public String getShState_code() {
        return shState_code;
    }

    public void setShState_code(String shState_code) {
        this.shState_code = shState_code;
    }

    public String getShState_name() {
        return shState_name;
    }

    public void setShState_name(String shState_name) {
        this.shState_name = shState_name;
    }

    public String getThhState_code() {
        return thhState_code;
    }

    public void setThhState_code(String thhState_code) {
        this.thhState_code = thhState_code;
    }

    public String getThhState_name() {
        return thhState_name;
    }

    public void setThhState_name(String thhState_name) {
        this.thhState_name = thhState_name;
    }

    public EquipmentBean() {}

    public EquipmentBean(BaseEntity entity) {
        super(entity);
    }

    public static EquipmentBean setThis(Equipment entity) {
        EquipmentBean bean = new EquipmentBean(entity);
        bean.setId(entity.getId());
        bean.setCode(entity.getCode());
        bean.setCoding(entity.getCoding());
        bean.setXsht_id(entity.getContractId());
        bean.setXsht_coding(entity.getContractCoding());
        bean.setProjectName(entity.getProjectName());
        bean.setSupplierName(entity.getSupplierName());
        bean.setMoney(entity.getMoney());
        bean.setWarranty(entity.getWarranty());
        bean.setLastfkdate(entity.getLastfkdate());
        if (entity.getCghtsmState() != null) {
            bean.setCghtsmState_code(entity.getCghtsmState().getCode());
            bean.setCghtsmState_name(entity.getCghtsmState().getName());
        }
        if(entity.getFkyspState()!=null) {
            bean.setFkyspState_code(entity.getFkyspState().getCode());
            bean.setFkyspState_name(entity.getFkyspState().getName());
        }
        if(entity.getShState()!=null) {
            bean.setShState_code(entity.getShState().getCode());
            bean.setShState_name(entity.getShState().getName());
        }
        if(entity.getThhState()!=null) {
            bean.setThhState_code(entity.getThhState().getCode());
            bean.setThhState_name(entity.getThhState().getName());
        }
        return bean;
    }

    public static List<EquipmentBean> setThis(List<Equipment> entitys) {
        List<EquipmentBean> beans = new ArrayList<>();
        if (!StringUtil.isListEmpty(entitys)) {
            for (Equipment bean : entitys) {
                beans.add(setThis(bean));
            }
        }
        return beans;
    }

    public static List<EquipmentBean> setSelect(List<Equipment> entitys) {
        List<EquipmentBean> beans = new ArrayList<>();
        if (!StringUtil.isListEmpty(entitys)) {
            for (Equipment entity : entitys) {
                EquipmentBean bean = new EquipmentBean();
                bean.setId(entity.getId());
                bean.setCoding(entity.getCoding());
                beans.add(bean);
            }
        }
        return beans;
    }

    public static void clone(Equipment bean, EquipmentBean entity, BaseService baseService) {
        bean.setId(entity.getId());
        bean.setCoding(entity.getCoding());
        bean.setContractId(entity.getXsht_id());
        bean.setContractCoding(entity.getXsht_coding());
        bean.setProjectName(entity.getProjectName());
        bean.setSupplierName(entity.getSupplierName());
        bean.setMoney(entity.getMoney());
        bean.setWarranty(entity.getWarranty());
        bean.setLastfkdate(entity.getLastfkdate());
        if (StringUtils.isNotEmpty(entity.getCghtsmState_code())) {
            bean.setCghtsmState((Dictionary) baseService.findById(Dictionary.class, entity.getCghtsmState_code()));
        }
        if (StringUtils.isNotEmpty(entity.getFkyspState_code())) {
            bean.setFkyspState((Dictionary) baseService.findById(Dictionary.class,entity.getFkyspState_code()));
        }
        if (StringUtils.isNotEmpty(entity.getShState_code())) {
            bean.setShState((Dictionary) baseService.findById(Dictionary.class,entity.getShState_code()));
        }
        if (StringUtils.isNotEmpty(entity.getThhState_code())) {
            bean.setThhState((Dictionary) baseService.findById(Dictionary.class,entity.getThhState_code()));
        }
    }
}