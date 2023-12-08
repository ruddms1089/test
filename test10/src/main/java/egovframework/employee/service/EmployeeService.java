package egovframework.employee.service;

import java.util.List;
import egovframework.employee.service.EmployeeDefaultVO;
import egovframework.employee.service.EmployeeVO;

/**
 * @Class Name : EmployeeService.java
 * @Description : Employee Business class
 * @Modification Information
 *
 * @author kke
 * @since 23-12-07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface EmployeeService {
	
	/**
	 * EMPLOYEE을 등록한다.
	 * @param vo - 등록할 정보가 담긴 EmployeeVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertEmployee(EmployeeVO vo) throws Exception;
    
    /**
	 * EMPLOYEE을 수정한다.
	 * @param vo - 수정할 정보가 담긴 EmployeeVO
	 * @return void형
	 * @exception Exception
	 */
    void updateEmployee(EmployeeVO vo) throws Exception;
    
    /**
	 * EMPLOYEE을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 EmployeeVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteEmployee(EmployeeVO vo) throws Exception;
    
    /**
	 * EMPLOYEE을 조회한다.
	 * @param vo - 조회할 정보가 담긴 EmployeeVO
	 * @return 조회한 EMPLOYEE
	 * @exception Exception
	 */
    EmployeeVO selectEmployee(EmployeeVO vo) throws Exception;
    
    /**
	 * EMPLOYEE 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return EMPLOYEE 목록
	 * @exception Exception
	 */
    List selectEmployeeList(EmployeeDefaultVO searchVO) throws Exception;
    
    /**
	 * EMPLOYEE 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return EMPLOYEE 총 갯수
	 * @exception
	 */
    int selectEmployeeListTotCnt(EmployeeDefaultVO searchVO);
    
}
