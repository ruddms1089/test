package egovframework.department_info.service;

/**
 * @Class Name : DepartmentInfoVO.java
 * @Description : DepartmentInfo VO class
 * @Modification Information
 *
 * @author kke
 * @since 23-12-07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class DepartmentInfoVO extends DepartmentInfoDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** DEP_NUMBER */
    private java.math.BigDecimal depNumber;
    
    /** COM_NUMBER */
    private java.math.BigDecimal comNumber;
    
    /** DEP_NAME */
    private java.lang.String depName;
    
    public java.math.BigDecimal getDepNumber() {
        return this.depNumber;
    }
    
    public void setDepNumber(java.math.BigDecimal depNumber) {
        this.depNumber = depNumber;
    }
    
    public java.math.BigDecimal getComNumber() {
        return this.comNumber;
    }
    
    public void setComNumber(java.math.BigDecimal comNumber) {
        this.comNumber = comNumber;
    }
    
    public java.lang.String getDepName() {
        return this.depName;
    }
    
    public void setDepName(java.lang.String depName) {
        this.depName = depName;
    }
    
}
