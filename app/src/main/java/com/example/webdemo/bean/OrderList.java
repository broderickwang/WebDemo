package com.example.webdemo.bean;

import java.util.List;

public class OrderList {

    /**
     * end : 0
     * limit : 20
     * offset : 0
     * order : asc
     * pageListSize : 9
     * pageNumList : [1]
     * pageNumber : 1
     * pages : 1
     * rows : [{"depaName":"鹿邑城郊乡接种门诊","downloadCheck":0,"inAgid":13953,"inAmount":0,"inAudit":"高原","inAuditDate":"2021-04-01 15:26:53","inBillType":1,"inCount":2510,"inCreateTime":"2021-04-01 10:20:50","inCreator":"李冬","inCredential":"4123280000002021033120","inDelete":0,"inEditTime":"2021-04-01 15:26:53","inHeadTime":"2021-04-01 10:47:00","inHeadType":1,"inHeadid":314919,"inHeadno":"4123280260012021040104","inRefuse":0,"inStatus":2,"inSupAgentType":1,"inSupAgid":"14740","inTag":0,"inType":1,"subPlanTaskId":0,"supDepaName":"鹿邑县疾控","synStatus":1,"synTimes":1,"tranHeadId":173040,"tranHeadNo":"4123280000002021033121","uploadStatus":0,"uploadTimes":0}]
     * total : 1
     */

    private int end;
    private int limit;
    private int offset;
    private String order;
    private int pageListSize;
    private int pageNumber;
    private int pages;
    private int total;
    private List<Integer> pageNumList;
    private List<RowsBean> rows;

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public int getPageListSize() {
        return pageListSize;
    }

    public void setPageListSize(int pageListSize) {
        this.pageListSize = pageListSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Integer> getPageNumList() {
        return pageNumList;
    }

    public void setPageNumList(List<Integer> pageNumList) {
        this.pageNumList = pageNumList;
    }

    public List<RowsBean> getRows() {
        return rows;
    }

    public void setRows(List<RowsBean> rows) {
        this.rows = rows;
    }

    public static class RowsBean {
        /**
         * depaName : 鹿邑城郊乡接种门诊
         * downloadCheck : 0
         * inAgid : 13953
         * inAmount : 0.0
         * inAudit : 高原
         * inAuditDate : 2021-04-01 15:26:53
         * inBillType : 1
         * inCount : 2510
         * inCreateTime : 2021-04-01 10:20:50
         * inCreator : 李冬
         * inCredential : 4123280000002021033120
         * inDelete : 0
         * inEditTime : 2021-04-01 15:26:53
         * inHeadTime : 2021-04-01 10:47:00
         * inHeadType : 1
         * inHeadid : 314919
         * inHeadno : 4123280260012021040104
         * inRefuse : 0
         * inStatus : 2
         * inSupAgentType : 1
         * inSupAgid : 14740
         * inTag : 0
         * inType : 1
         * subPlanTaskId : 0
         * supDepaName : 鹿邑县疾控
         * synStatus : 1
         * synTimes : 1
         * tranHeadId : 173040
         * tranHeadNo : 4123280000002021033121
         * uploadStatus : 0
         * uploadTimes : 0
         */

        private String depaName;
        private int downloadCheck;
        private int inAgid;
        private double inAmount;
        private String inAudit;
        private String inAuditDate;
        private int inBillType;
        private int inCount;
        private String inCreateTime;
        private String inCreator;
        private String inCredential;
        private int inDelete;
        private String inEditTime;
        private String inHeadTime;
        private int inHeadType;
        private int inHeadid;
        private String inHeadno;
        private int inRefuse;
        private int inStatus;
        private int inSupAgentType;
        private String inSupAgid;
        private int inTag;
        private int inType;
        private int subPlanTaskId;
        private String supDepaName;
        private int synStatus;
        private int synTimes;
        private int tranHeadId;
        private String tranHeadNo;
        private int uploadStatus;
        private int uploadTimes;

        public String getDepaName() {
            return depaName;
        }

        public void setDepaName(String depaName) {
            this.depaName = depaName;
        }

        public int getDownloadCheck() {
            return downloadCheck;
        }

        public void setDownloadCheck(int downloadCheck) {
            this.downloadCheck = downloadCheck;
        }

        public int getInAgid() {
            return inAgid;
        }

        public void setInAgid(int inAgid) {
            this.inAgid = inAgid;
        }

        public double getInAmount() {
            return inAmount;
        }

        public void setInAmount(double inAmount) {
            this.inAmount = inAmount;
        }

        public String getInAudit() {
            return inAudit;
        }

        public void setInAudit(String inAudit) {
            this.inAudit = inAudit;
        }

        public String getInAuditDate() {
            return inAuditDate;
        }

        public void setInAuditDate(String inAuditDate) {
            this.inAuditDate = inAuditDate;
        }

        public int getInBillType() {
            return inBillType;
        }

        public void setInBillType(int inBillType) {
            this.inBillType = inBillType;
        }

        public int getInCount() {
            return inCount;
        }

        public void setInCount(int inCount) {
            this.inCount = inCount;
        }

        public String getInCreateTime() {
            return inCreateTime;
        }

        public void setInCreateTime(String inCreateTime) {
            this.inCreateTime = inCreateTime;
        }

        public String getInCreator() {
            return inCreator;
        }

        public void setInCreator(String inCreator) {
            this.inCreator = inCreator;
        }

        public String getInCredential() {
            return inCredential;
        }

        public void setInCredential(String inCredential) {
            this.inCredential = inCredential;
        }

        public int getInDelete() {
            return inDelete;
        }

        public void setInDelete(int inDelete) {
            this.inDelete = inDelete;
        }

        public String getInEditTime() {
            return inEditTime;
        }

        public void setInEditTime(String inEditTime) {
            this.inEditTime = inEditTime;
        }

        public String getInHeadTime() {
            return inHeadTime;
        }

        public void setInHeadTime(String inHeadTime) {
            this.inHeadTime = inHeadTime;
        }

        public int getInHeadType() {
            return inHeadType;
        }

        public void setInHeadType(int inHeadType) {
            this.inHeadType = inHeadType;
        }

        public int getInHeadid() {
            return inHeadid;
        }

        public void setInHeadid(int inHeadid) {
            this.inHeadid = inHeadid;
        }

        public String getInHeadno() {
            return inHeadno;
        }

        public void setInHeadno(String inHeadno) {
            this.inHeadno = inHeadno;
        }

        public int getInRefuse() {
            return inRefuse;
        }

        public void setInRefuse(int inRefuse) {
            this.inRefuse = inRefuse;
        }

        public int getInStatus() {
            return inStatus;
        }

        public void setInStatus(int inStatus) {
            this.inStatus = inStatus;
        }

        public int getInSupAgentType() {
            return inSupAgentType;
        }

        public void setInSupAgentType(int inSupAgentType) {
            this.inSupAgentType = inSupAgentType;
        }

        public String getInSupAgid() {
            return inSupAgid;
        }

        public void setInSupAgid(String inSupAgid) {
            this.inSupAgid = inSupAgid;
        }

        public int getInTag() {
            return inTag;
        }

        public void setInTag(int inTag) {
            this.inTag = inTag;
        }

        public int getInType() {
            return inType;
        }

        public void setInType(int inType) {
            this.inType = inType;
        }

        public int getSubPlanTaskId() {
            return subPlanTaskId;
        }

        public void setSubPlanTaskId(int subPlanTaskId) {
            this.subPlanTaskId = subPlanTaskId;
        }

        public String getSupDepaName() {
            return supDepaName;
        }

        public void setSupDepaName(String supDepaName) {
            this.supDepaName = supDepaName;
        }

        public int getSynStatus() {
            return synStatus;
        }

        public void setSynStatus(int synStatus) {
            this.synStatus = synStatus;
        }

        public int getSynTimes() {
            return synTimes;
        }

        public void setSynTimes(int synTimes) {
            this.synTimes = synTimes;
        }

        public int getTranHeadId() {
            return tranHeadId;
        }

        public void setTranHeadId(int tranHeadId) {
            this.tranHeadId = tranHeadId;
        }

        public String getTranHeadNo() {
            return tranHeadNo;
        }

        public void setTranHeadNo(String tranHeadNo) {
            this.tranHeadNo = tranHeadNo;
        }

        public int getUploadStatus() {
            return uploadStatus;
        }

        public void setUploadStatus(int uploadStatus) {
            this.uploadStatus = uploadStatus;
        }

        public int getUploadTimes() {
            return uploadTimes;
        }

        public void setUploadTimes(int uploadTimes) {
            this.uploadTimes = uploadTimes;
        }
    }
}
