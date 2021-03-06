package oracle.mybatis.vo;

import java.util.Date;

public class BizPartsrepbill {
    private Integer billid;

    private String billflag;

    private String billtype;

    private Integer partsid;

    private Integer billcount;

    private Date billtime;

    private Integer billuser;

    public Integer getBillid() {
        return billid;
    }

    public void setBillid(Integer billid) {
        this.billid = billid;
    }

    public String getBillflag() {
        return billflag;
    }

    public void setBillflag(String billflag) {
        this.billflag = billflag == null ? null : billflag.trim();
    }

    public String getBilltype() {
        return billtype;
    }

    public void setBilltype(String billtype) {
        this.billtype = billtype == null ? null : billtype.trim();
    }

    public Integer getPartsid() {
        return partsid;
    }

    public void setPartsid(Integer partsid) {
        this.partsid = partsid;
    }

    public Integer getBillcount() {
        return billcount;
    }

    public void setBillcount(Integer billcount) {
        this.billcount = billcount;
    }

    public Date getBilltime() {
        return billtime;
    }

    public void setBilltime(Date billtime) {
        this.billtime = billtime;
    }

    public Integer getBilluser() {
        return billuser;
    }

    public void setBilluser(Integer billuser) {
        this.billuser = billuser;
    }
}