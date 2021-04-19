package com.cat.daily.jsonbean;

import com.cat.boot.jsonbean.BaseAppBean;
import com.cat.boot.model.BaseEntity;
import com.cat.boot.util.StringUtil;
import com.cat.daily.model.Meeting;

import java.util.ArrayList;
import java.util.List;

public class MeetingBean extends BaseAppBean {

    private static final long serialVersionUID = 7777525968411090290L;

    private String id;
    /** 序号*/
    private int num;
    /** 标题*/
    private String title;
    /** 内容 */
    private String content;
    /** 会议日期*/
    private String meetingDate;
    /** 会议开始时间 */
    private String stime;
    /** 会议结束时间 */
    private String etime;
    /** 会议主持人 */
    private String host;
    /** 会议召开地址*/
    private String addr;

    /** 起止日期*/
    private String meetingTime;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(String meetingDate) {
        this.meetingDate = meetingDate;
    }

    public String getStime() {
        return stime;
    }

    public void setStime(String stime) {
        this.stime = stime;
    }

    public String getEtime() {
        return etime;
    }

    public void setEtime(String etime) {
        this.etime = etime;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getMeetingTime() {
        return meetingTime;
    }

    public void setMeetingTime(String meetingTime) {
        this.meetingTime = meetingTime;
    }

    public MeetingBean() {}

    public MeetingBean(BaseEntity entity) {
        super(entity);
    }

    public static MeetingBean setThis(Meeting entity) {
        MeetingBean bean = new MeetingBean(entity);
        bean.setId(entity.getId());
        bean.setTitle(entity.getTitle());
        bean.setContent(entity.getContent());
        bean.setMeetingDate(entity.getMeetingDate());
        bean.setStime(entity.getStime());
        bean.setEtime(entity.getEtime());
        bean.setHost(entity.getHost());
        bean.setAddr(entity.getAddr());
        bean.setMeetingTime(!StringUtil.isEmpty(entity.getStime())&&!StringUtil.isEmpty(entity.getEtime())?entity.getStime()+"-"+entity.getEtime():"");
        return bean;
    }

    public static List<MeetingBean> setThis(List<Meeting> entitys) {
        List<MeetingBean> beans = new ArrayList<>();
        if (!StringUtil.isListEmpty(entitys)) {
            for (Meeting entity : entitys) {
                MeetingBean bean = setThis(entity);
                beans.add(bean);
            }
        }
        return beans;
    }

    public static void clone(Meeting bean, MeetingBean entity) {
        bean.setId(entity.getId());
        bean.setTitle(entity.getTitle());
        bean.setContent(entity.getContent());
        bean.setMeetingDate(entity.getMeetingDate());
        bean.setStime(entity.getStime());
        bean.setEtime(entity.getEtime());
        bean.setHost(entity.getHost());
        bean.setAddr(entity.getAddr());
    }
}