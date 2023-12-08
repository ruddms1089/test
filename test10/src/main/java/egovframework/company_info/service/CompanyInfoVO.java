package egovframework.company_info.service;

/**
 * @Class Name : CompanyInfoVO.java
 * @Description : CompanyInfo VO class
 * @Modification Information
 *
 * @author kke
 * @since 23-12-07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class CompanyInfoVO extends CompanyInfoDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** COM_NUMBER */
    private java.math.BigDecimal comNumber;
    
    /** NUM */
    private java.math.BigDecimal num;
    
    /** COM_NAME */
    private java.lang.String comName;
    
    /** COM_CI */
    private java.lang.String comCi;
    
    /** COM_EMAIL */
    private java.lang.String comEmail;
    
    /** CEO_NAME */
    private java.lang.String ceoName;
    
    /** ZIP_CODE */
    private java.math.BigDecimal zipCode;
    
    /** ADDRESS1 */
    private java.lang.String address1;
    
    /** ADDRESS2 */
    private java.lang.String address2;
    
    /** NOTE */
    private java.lang.String note;
    
    /** CEO_PHONE */
    private java.lang.String ceoPhone;
    
    public java.math.BigDecimal getComNumber() {
        return this.comNumber;
    }
    
    public void setComNumber(java.math.BigDecimal comNumber) {
        this.comNumber = comNumber;
    }
    
    public java.math.BigDecimal getNum() {
        return this.num;
    }
    
    public void setNum(java.math.BigDecimal num) {
        this.num = num;
    }
    
    public java.lang.String getComName() {
        return this.comName;
    }
    
    public void setComName(java.lang.String comName) {
        this.comName = comName;
    }
    
    public java.lang.String getComCi() {
        return this.comCi;
    }
    
    public void setComCi(java.lang.String comCi) {
        this.comCi = comCi;
    }
    
    public java.lang.String getComEmail() {
        return this.comEmail;
    }
    
    public void setComEmail(java.lang.String comEmail) {
        this.comEmail = comEmail;
    }
    
    public java.lang.String getCeoName() {
        return this.ceoName;
    }
    
    public void setCeoName(java.lang.String ceoName) {
        this.ceoName = ceoName;
    }
    
    public java.math.BigDecimal getZipCode() {
        return this.zipCode;
    }
    
    public void setZipCode(java.math.BigDecimal zipCode) {
        this.zipCode = zipCode;
    }
    
    public java.lang.String getAddress1() {
        return this.address1;
    }
    
    public void setAddress1(java.lang.String address1) {
        this.address1 = address1;
    }
    
    public java.lang.String getAddress2() {
        return this.address2;
    }
    
    public void setAddress2(java.lang.String address2) {
        this.address2 = address2;
    }
    
    public java.lang.String getNote() {
        return this.note;
    }
    
    public void setNote(java.lang.String note) {
        this.note = note;
    }
    
    public java.lang.String getCeoPhone() {
        return this.ceoPhone;
    }
    
    public void setCeoPhone(java.lang.String ceoPhone) {
        this.ceoPhone = ceoPhone;
    }
    
}
