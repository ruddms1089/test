package egovframework.employee.service.impl;

import java.util.List;

import egovframework.employee.service.EmployeeVO;
import egovframework.employee.service.EmployeeDefaultVO;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name : EmployeeMapper.java
 * @Description : Employee Mapper Class
 * @Modification Information
 *
 * @author kke
 * @since 23-12-07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Mapper("employeeMapper")
public interface EmployeeMapper {

	/**
	 * EMPLOYEE을 등록한다.
	 * @param vo - 등록할 정보가 담긴 EmployeeVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertEmployee(EmployeeVO vo) throws Exception;

    /**
	 * EMPLOYEE을 수정한다.
	 * @param vo - 수정할 정보가 담긴 EmployeeVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateEmployee(EmployeeVO vo) throws Exception;

    /**
	 * EMPLOYEE을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 EmployeeVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteEmployee(EmployeeVO vo) throws Exception;

    /**
	 * EMPLOYEE을 조회한다.
	 * @param vo - 조회할 정보가 담긴 EmployeeVO
	 * @return 조회한 EMPLOYEE
	 * @exception Exception
	 */
    public EmployeeVO selectEmployee(EmployeeVO vo) throws Exception;

    /**
	 * EMPLOYEE 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return EMPLOYEE 목록
	 * @exception Exception
	 */
    public List<?> selectEmployeeList(EmployeeDefaultVO searchVO) throws Exception;

    /**
	 * EMPLOYEE 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return EMPLOYEE 총 갯수
	 * @exception
	 */
    public int selectEmployeeListTotCnt(EmployeeDefaultVO searchVO);

}
