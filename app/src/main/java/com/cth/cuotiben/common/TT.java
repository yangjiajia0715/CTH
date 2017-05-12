package com.cth.cuotiben.common;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yangjiajia on 2017/5/12 0012.
 */

public class TT<T> implements Serializable {

    /**
     * flag : 0
     * data : [{"id":58,"createTime":1482829353000,"updateTime":1487135280000,"grade":"高三","subjectName":"数学","classTime":null,"startTime":1485446400000,"endTime":1490630399000,"regEnable":true,"regStartTime":1482768000000,"regEndTime":1483286399000,"numberLimit":30,"stock":0,"regPrice":1,"lastRegPrice":0,"createUserId":446,"introductionUserId":446,"consultUserId":514,"status":"ONLINE","priority":0,"name":"江彪老师培训班","cover":3489,"schoolId":143,"address":"北京市东城区朝阳门外大街昆泰国际大厦912","tel":"18618362080","picsDspt":"3487,3488","dspt":"名师线下辅导班","menuTitle":"FeeClass","schoolName":"戴氏精品堂龙泉总校","schoolAddress":"北京市东城区朝阳门","colleced":false,"paidFlag":"","orderedNum":0,"paidNum":0},{"id":39,"createTime":1482746985000,"updateTime":1487135280000,"grade":"六年级","subjectName":"英语","classTime":"<null>","startTime":1482595200000,"endTime":1483113599000,"regEnable":true,"regStartTime":1482595200000,"regEndTime":1485014399000,"numberLimit":50,"stock":6,"regPrice":1,"lastRegPrice":0,"createUserId":446,"introductionUserId":446,"consultUserId":175,"status":"ONLINE","priority":0,"name":"收费班级NO.3","cover":3426,"schoolId":143,"address":"北京市外交部南街13号","tel":"4008517517","picsDspt":"3430,3431,3429,3427,3428","dspt":"李经理积极进了今年不不不","menuTitle":"FeeClass","schoolName":"戴氏精品堂龙泉总校","schoolAddress":"北京市东城区朝阳门","colleced":false,"paidFlag":"","orderedNum":2,"paidNum":2},{"id":37,"createTime":1482746610000,"updateTime":1487135280000,"grade":"初三","subjectName":"数学","classTime":null,"startTime":1482681600000,"endTime":1483027200000,"regEnable":true,"regStartTime":1482595200000,"regEndTime":1484841600000,"numberLimit":30,"stock":0,"regPrice":1,"lastRegPrice":0,"createUserId":446,"introductionUserId":446,"consultUserId":446,"status":"ONLINE","priority":0,"name":"收费班NO.2","cover":3420,"schoolId":143,"address":"北京市朝阳区雅宝路秀水河胡同","tel":"15810000008","picsDspt":"3425,3422,3424,3423,3421","dspt":"一给你你你你你你你你摸了摸了摸了摸了摸计划经济精美礼理解个图催咯给你明目图图他了啦本以为是","menuTitle":"FeeClass","schoolName":"戴氏精品堂龙泉总校","schoolAddress":"北京市东城区朝阳门","colleced":false,"paidFlag":"","orderedNum":1,"paidNum":1},{"id":36,"createTime":1482746208000,"updateTime":1487135280000,"grade":"高三","subjectName":"语文","classTime":null,"startTime":1482595200000,"endTime":1482854400000,"regEnable":true,"regStartTime":1482595200000,"regEndTime":1482854400000,"numberLimit":30,"stock":0,"regPrice":1,"lastRegPrice":0,"createUserId":446,"introductionUserId":446,"consultUserId":446,"status":"ONLINE","priority":0,"name":"11100012124","cover":3405,"schoolId":143,"address":"11100012124","tel":"11100012124","picsDspt":"3406,3407","dspt":"哩哩啦啦丽丽丽丽默默的的把题目是祝您和您的","menuTitle":"FeeClass","schoolName":"戴氏精品堂龙泉总校","schoolAddress":"北京市东城区朝阳门","colleced":false,"paidFlag":"","orderedNum":1,"paidNum":1},{"id":12,"createTime":1482112819000,"updateTime":1483499649000,"grade":"初三","subjectName":"英语","classTime":null,"startTime":1482076800000,"endTime":1482336000000,"regEnable":true,"regStartTime":1482076800000,"regEndTime":1482422400000,"numberLimit":1000,"stock":0,"regPrice":3000000,"lastRegPrice":0,"createUserId":446,"introductionUserId":446,"consultUserId":446,"status":"ONLINE","priority":0,"name":"将军金甲夜不脱","cover":3238,"schoolId":143,"address":"学校地址","tel":"18618361080","picsDspt":"file:///storage/emulated/0/Pictures/Screenshots/Screenshot_2016-03-22-16-31-27.png","dspt":"1、Overload和Override的区别。Overloaded的方法是否可以改变返回值的类型?","menuTitle":"FeeClass","schoolName":"戴氏精品堂龙泉总校","schoolAddress":"北京市东城区朝阳门","colleced":false,"paidFlag":"","orderedNum":0,"paidNum":0}]
     * msg : null
     */

    private int flag;
    private Object msg;
    private List<T> data;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

//    public  class DataBean implements Serializable{
//        /**
//         * id : 58
//         * createTime : 1482829353000
//         * updateTime : 1487135280000
//         * grade : 高三
//         * subjectName : 数学
//         * classTime : null
//         * startTime : 1485446400000
//         * endTime : 1490630399000
//         * regEnable : true
//         * regStartTime : 1482768000000
//         * regEndTime : 1483286399000
//         * numberLimit : 30
//         * stock : 0
//         * regPrice : 1
//         * lastRegPrice : 0
//         * createUserId : 446
//         * introductionUserId : 446
//         * consultUserId : 514
//         * status : ONLINE
//         * priority : 0
//         * name : 江彪老师培训班
//         * cover : 3489
//         * schoolId : 143
//         * address : 北京市东城区朝阳门外大街昆泰国际大厦912
//         * tel : 18618362080
//         * picsDspt : 3487,3488
//         * dspt : 名师线下辅导班
//         * menuTitle : FeeClass
//         * schoolName : 戴氏精品堂龙泉总校
//         * schoolAddress : 北京市东城区朝阳门
//         * colleced : false
//         * paidFlag :
//         * orderedNum : 0
//         * paidNum : 0
//         */
//
//        private int id;
//        private long createTime;
//        private long updateTime;
//        private String grade;
//        private String subjectName;
//        private Object classTime;
//        private long startTime;
//        private long endTime;
//        private boolean regEnable;
//        private long regStartTime;
//        private long regEndTime;
//        private int numberLimit;
//        private int stock;
//        private int regPrice;
//        private int lastRegPrice;
//        private int createUserId;
//        private int introductionUserId;
//        private int consultUserId;
//        private String status;
//        private int priority;
//        private String name;
//        private int cover;
//        private int schoolId;
//        private String address;
//        private String tel;
//        private String picsDspt;
//        private String dspt;
//        private String menuTitle;
//        private String schoolName;
//        private String schoolAddress;
//        private boolean colleced;
//        private String paidFlag;
//        private int orderedNum;
//        private int paidNum;
//
//        public int getId() {
//            return id;
//        }
//
//        public void setId(int id) {
//            this.id = id;
//        }
//
//        public long getCreateTime() {
//            return createTime;
//        }
//
//        public void setCreateTime(long createTime) {
//            this.createTime = createTime;
//        }
//
//        public long getUpdateTime() {
//            return updateTime;
//        }
//
//        public void setUpdateTime(long updateTime) {
//            this.updateTime = updateTime;
//        }
//
//        public String getGrade() {
//            return grade;
//        }
//
//        public void setGrade(String grade) {
//            this.grade = grade;
//        }
//
//        public String getSubjectName() {
//            return subjectName;
//        }
//
//        public void setSubjectName(String subjectName) {
//            this.subjectName = subjectName;
//        }
//
//        public Object getClassTime() {
//            return classTime;
//        }
//
//        public void setClassTime(Object classTime) {
//            this.classTime = classTime;
//        }
//
//        public long getStartTime() {
//            return startTime;
//        }
//
//        public void setStartTime(long startTime) {
//            this.startTime = startTime;
//        }
//
//        public long getEndTime() {
//            return endTime;
//        }
//
//        public void setEndTime(long endTime) {
//            this.endTime = endTime;
//        }
//
//        public boolean isRegEnable() {
//            return regEnable;
//        }
//
//        public void setRegEnable(boolean regEnable) {
//            this.regEnable = regEnable;
//        }
//
//        public long getRegStartTime() {
//            return regStartTime;
//        }
//
//        public void setRegStartTime(long regStartTime) {
//            this.regStartTime = regStartTime;
//        }
//
//        public long getRegEndTime() {
//            return regEndTime;
//        }
//
//        public void setRegEndTime(long regEndTime) {
//            this.regEndTime = regEndTime;
//        }
//
//        public int getNumberLimit() {
//            return numberLimit;
//        }
//
//        public void setNumberLimit(int numberLimit) {
//            this.numberLimit = numberLimit;
//        }
//
//        public int getStock() {
//            return stock;
//        }
//
//        public void setStock(int stock) {
//            this.stock = stock;
//        }
//
//        public int getRegPrice() {
//            return regPrice;
//        }
//
//        public void setRegPrice(int regPrice) {
//            this.regPrice = regPrice;
//        }
//
//        public int getLastRegPrice() {
//            return lastRegPrice;
//        }
//
//        public void setLastRegPrice(int lastRegPrice) {
//            this.lastRegPrice = lastRegPrice;
//        }
//
//        public int getCreateUserId() {
//            return createUserId;
//        }
//
//        public void setCreateUserId(int createUserId) {
//            this.createUserId = createUserId;
//        }
//
//        public int getIntroductionUserId() {
//            return introductionUserId;
//        }
//
//        public void setIntroductionUserId(int introductionUserId) {
//            this.introductionUserId = introductionUserId;
//        }
//
//        public int getConsultUserId() {
//            return consultUserId;
//        }
//
//        public void setConsultUserId(int consultUserId) {
//            this.consultUserId = consultUserId;
//        }
//
//        public String getStatus() {
//            return status;
//        }
//
//        public void setStatus(String status) {
//            this.status = status;
//        }
//
//        public int getPriority() {
//            return priority;
//        }
//
//        public void setPriority(int priority) {
//            this.priority = priority;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public int getCover() {
//            return cover;
//        }
//
//        public void setCover(int cover) {
//            this.cover = cover;
//        }
//
//        public int getSchoolId() {
//            return schoolId;
//        }
//
//        public void setSchoolId(int schoolId) {
//            this.schoolId = schoolId;
//        }
//
//        public String getAddress() {
//            return address;
//        }
//
//        public void setAddress(String address) {
//            this.address = address;
//        }
//
//        public String getTel() {
//            return tel;
//        }
//
//        public void setTel(String tel) {
//            this.tel = tel;
//        }
//
//        public String getPicsDspt() {
//            return picsDspt;
//        }
//
//        public void setPicsDspt(String picsDspt) {
//            this.picsDspt = picsDspt;
//        }
//
//        public String getDspt() {
//            return dspt;
//        }
//
//        public void setDspt(String dspt) {
//            this.dspt = dspt;
//        }
//
//        public String getMenuTitle() {
//            return menuTitle;
//        }
//
//        public void setMenuTitle(String menuTitle) {
//            this.menuTitle = menuTitle;
//        }
//
//        public String getSchoolName() {
//            return schoolName;
//        }
//
//        public void setSchoolName(String schoolName) {
//            this.schoolName = schoolName;
//        }
//
//        public String getSchoolAddress() {
//            return schoolAddress;
//        }
//
//        public void setSchoolAddress(String schoolAddress) {
//            this.schoolAddress = schoolAddress;
//        }
//
//        public boolean isColleced() {
//            return colleced;
//        }
//
//        public void setColleced(boolean colleced) {
//            this.colleced = colleced;
//        }
//
//        public String getPaidFlag() {
//            return paidFlag;
//        }
//
//        public void setPaidFlag(String paidFlag) {
//            this.paidFlag = paidFlag;
//        }
//
//        public int getOrderedNum() {
//            return orderedNum;
//        }
//
//        public void setOrderedNum(int orderedNum) {
//            this.orderedNum = orderedNum;
//        }
//
//        public int getPaidNum() {
//            return paidNum;
//        }
//
//        public void setPaidNum(int paidNum) {
//            this.paidNum = paidNum;
//        }
//    }
}
