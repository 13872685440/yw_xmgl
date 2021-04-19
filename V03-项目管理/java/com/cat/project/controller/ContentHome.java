package com.cat.project.controller;

import com.cat.boot.jsonbean.ResultBean;
import com.cat.boot.service.BaseHome;
import com.cat.boot.util.StringUtil;
import com.cat.dictionary.model.Dictionary;
import com.cat.project.jsonbean.ContentBean;
import com.cat.project.model.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/content")
public class ContentHome extends BaseHome<Content> {

    /**
     *
     */
    private static final long serialVersionUID = -5079095773304621404L;

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(@RequestParam String id) {
        if (!StringUtil.isEmpty(id)) {
            Content entity = findById(id);
            return ResultBean.getSucess(ContentBean.setThis(entity));
        } else {
            return ResultBean.getSucess(ContentBean.setThis(new Content()));
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(ContentBean entity) throws Exception {
        Content bean = new Content();
        if (StringUtils.isNotEmpty(entity.getId())) {
            bean = findById(entity.getId());
        }
        ContentBean.clone(bean, entity, baseService);
        if (entity.getType() == 1 || entity.getType() == 2 || entity.getType() == 3) {
            bean.setKeyId("Schedule");
            Schedule entity1 = (Schedule) baseService.findById(Schedule.class, entity.getKeyValue());
            if (entity.getType() == 1) {
                entity1.setGdjlState((Dictionary) baseService.findById(Dictionary.class, entity.getState_code()));
            } else if (entity.getType() == 2) {
                entity1.setZsbjState((Dictionary) baseService.findById(Dictionary.class, entity.getState_code()));
            } else if (entity.getType() == 3) {
                entity1.setCbzjState((Dictionary) baseService.findById(Dictionary.class, entity.getState_code()));
            }
            baseService.save(entity1);
        } else if (entity.getType() == 4 || entity.getType() == 5 || entity.getType() == 6) {
            bean.setKeyId("Contract");
            Contract entity1 = (Contract) baseService.findById(Contract.class, entity.getKeyValue());
            if (entity.getType() == 4) {
                entity1.setHtsmState((Dictionary) baseService.findById(Dictionary.class, entity.getState_code()));
            } else if (entity.getType() == 5) {
                entity1.setFhState((Dictionary) baseService.findById(Dictionary.class, entity.getState_code()));
            } else if (entity.getType() == 6) {
                entity1.setSzzcState((Dictionary) baseService.findById(Dictionary.class, entity.getState_code()));
            }
            baseService.save(entity1);
        } else if (entity.getType() == 7 || entity.getType() == 8 || entity.getType() == 9 || entity.getType() == 10) {
            bean.setKeyId("Equipment");
            Equipment entity1 = (Equipment) baseService.findById(Equipment.class, entity.getKeyValue());
            if (entity.getType() == 7) {
                entity1.setCghtsmState((Dictionary) baseService.findById(Dictionary.class, entity.getState_code()));
            } else if (entity.getType() == 8) {
                entity1.setFkyspState((Dictionary) baseService.findById(Dictionary.class, entity.getState_code()));
            } else if (entity.getType() == 9) {
                entity1.setShState((Dictionary) baseService.findById(Dictionary.class, entity.getState_code()));
            } else if (entity.getType() == 10) {
                entity1.setThhState((Dictionary) baseService.findById(Dictionary.class, entity.getState_code()));
            }
            baseService.save(entity1);
        } else if (entity.getType() == 11 || entity.getType() == 12) {
            bean.setKeyId("Aftersales");
            Aftersales entity1 = (Aftersales) baseService.findById(Aftersales.class, entity.getKeyValue());
            if (entity.getType() == 11) {
                entity1.setShlwState((Dictionary) baseService.findById(Dictionary.class, entity.getState_code()));
            } else if (entity.getType() == 12) {
                entity1.setSkykpState((Dictionary) baseService.findById(Dictionary.class, entity.getState_code()));
            }
            baseService.save(entity1);
        }
        baseService.save(bean);
        return ResultBean.getSucess("sucess");
    }

}
