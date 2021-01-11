package com.cssl.pojo;

import java.util.Date;

public class CFTJ {
    private Integer pharmacyId;//药品id
    private String pharmacyName;//药品名称
    private Integer drugstoreId;//领货单位外键
    private Integer skullId;//经办人Id
    private Integer warehouseId;//库房Id
    private Integer unit;//库房
    private double sellingPrice;//售价
    private Integer area;//产地
    private Integer type;//类型
    private Date produceDate;//生产日期
    private Date validDate;//保质期
    private Integer drugstorenum;//数量
    private Integer skullbatch;//批号
    private String unitname;//单位名称

    private int cashier;//处方id
    private  Integer reportId;//挂号id
    private String durgname;//药品名称
    private int durgnum;//药品数量
    private double repiceprice;//价格
    private double repicetotal;//小计
    private Integer state;//状态
    private Integer  ostate;//项目状态
    private String jie;
    private Integer mstate;


    public Integer getMstate() {
        return mstate;
    }

    public void setMstate(Integer mstate) {
        this.mstate = mstate;
    }

    public String getJie() {
        return jie;
    }

    public void setJie(String jie) {
        this.jie = jie;
    }

    public Integer getOstate() {
        return ostate;
    }

    public void setOstate(Integer ostate) {
        this.ostate = ostate;
    }

    public int getCashier() {
        return cashier;
    }

    public void setCashier(int cashier) {
        this.cashier = cashier;
    }

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public String getDurgname() {
        return durgname;
    }

    public void setDurgname(String durgname) {
        this.durgname = durgname;
    }

    public int getDurgnum() {
        return durgnum;
    }

    public void setDurgnum(int durgnum) {
        this.durgnum = durgnum;
    }

    public double getRepiceprice() {
        return repiceprice;
    }

    public void setRepiceprice(double repiceprice) {
        this.repiceprice = repiceprice;
    }

    public double getRepicetotal() {
        return repicetotal;
    }

    public void setRepicetotal(double repicetotal) {
        this.repicetotal = repicetotal;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }


    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname;
    }

    public Integer getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(Integer pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public Integer getDrugstoreId() {
        return drugstoreId;
    }

    public void setDrugstoreId(Integer drugstoreId) {
        this.drugstoreId = drugstoreId;
    }

    public Integer getSkullId() {
        return skullId;
    }

    public void setSkullId(Integer skullId) {
        this.skullId = skullId;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getProduceDate() {
        return produceDate;
    }

    public void setProduceDate(Date produceDate) {
        this.produceDate = produceDate;
    }

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    public Integer getDrugstorenum() {
        return drugstorenum;
    }

    public void setDrugstorenum(Integer drugstorenum) {
        this.drugstorenum = drugstorenum;
    }

    public Integer getSkullbatch() {
        return skullbatch;
    }

    public void setSkullbatch(Integer skullbatch) {
        this.skullbatch = skullbatch;
    }
}
