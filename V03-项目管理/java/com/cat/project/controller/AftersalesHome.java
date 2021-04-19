package com.cat.project.controller;

import com.cat.boot.catconst.RedisConst;
import com.cat.boot.jsonbean.ResultBean;
import com.cat.boot.service.BaseHome;
import com.cat.boot.util.CalendarUtil;
import com.cat.boot.util.FrameUtils;
import com.cat.boot.util.NameQueryUtil;
import com.cat.boot.util.StringUtil;
import com.cat.project.jsonbean.AftersalesBean;
import com.cat.project.model.Aftersales;
import com.cat.project.model.Contract;
import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aftersales")
public class AftersalesHome extends BaseHome<Aftersales> {

    /**
     *
     */
    private static final long serialVersionUID = -5079095773304621404L;

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(@RequestParam String id) {
        if (!StringUtil.isEmpty(id)) {
            Aftersales entity = findById(id);
            return ResultBean.getSucess(AftersalesBean.setThis(entity));
        } else {
            return ResultBean.getSucess(AftersalesBean.setThis(new Aftersales()));
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(AftersalesBean bean) throws Exception {
        Aftersales entity = new Aftersales();
        if(StringUtils.isNotEmpty(bean.getId())){
            entity = findById(bean.getId());
            AftersalesBean.clone(entity, bean, baseService);
        }else{
            AftersalesBean.clone(entity, bean, baseService);
            createCode(entity);
        }

        if(StringUtils.isNotEmpty(bean.getXsht_id())){
            Contract contract = (Contract)baseService.findById(Contract.class,bean.getXsht_id());
            contract.setIsRelation(contract.getIsRelation()==0?2:9);
            baseService.save(contract);
        }
        baseService.save(entity);
        return ResultBean.getSucess(AftersalesBean.setThis(entity));
    }


    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public String find(@RequestParam String id) {
        Aftersales entity = findById(id);
        return ResultBean.getSucess(AftersalesBean.setThis(entity));
    }


    private void createCode(Aftersales entity){
        String date = CalendarUtil.getYyMmDd(CalendarUtil.now());
        String pcd = RedisConst.aftersales_code_prefix+"-"+date;
        String code = ((String) baseService.getSimple("Aftersales", "project", "Aftersales_getCode",
                NameQueryUtil.setParams("code",pcd)));
        entity.setCode(date+code);
        entity.setCoding(pcd+code);
    }
}
