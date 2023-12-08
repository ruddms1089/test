package egovframework.department_info.service;

import java.util.List;
import egovframework.department_info.service.DepartmentInfoDefaultVO;
import egovframework.department_info.service.DepartmentInfoVO;

/**
 * @Class Name : DepartmentInfoService.java
 * @Description : DepartmentInfo Business class
 * @Modification Information
 *
 * @author kke
 * @since 23-12-07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface DepartmentInfoService {
	
	/**
	 * DEPARTMENT_INFO을 등록한다.
	 * @param vo - 등록할 정보가 담긴 DepartmentInfoVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertDepartmentInfo(DepartmentInfoVO vo) throws Exception;
    
    /**
	 * DEPARTMENT_INFO을 수정한다.
	 * @param vo - 수정할 정보가 담긴 DepartmentInfoVO
	 * @return void형
	 * @exception Exception
	 */
    void updateDepartmentInfo(DepartmentInfoVO vo) throws Exception;
    
    /**
	 * DEPARTMENT_INFO을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 DepartmentInfoVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteDepartmentInfo(DepartmentInfoVO vo) throws Exception;
    
    /**
	 * DEPARTMENT_INFO을 조회한다.
	 * @param vo - 조회할 정보가 담긴 DepartmentInfoVO
	 * @return 조회한 DEPARTMENT_INFO
	 * @exception Exception
	 */
    DepartmentInfoVO selectDepartmentInfo(DepartmentInfoVO vo) throws Exception;
    
    /**
	 * DEPARTMENT_INFO 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return DEPARTMENT_INFO 목록
	 * @exception Exception
	 */
    List selectDepartmentInfoList(DepartmentInfoDefaultVO searchVO) throws Exception;
    
    /**
	 * DEPARTMENT_INFO 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return DEPARTMENT_INFO 총 갯수
	 * @exception
	 */
    int selectDepartmentInfoListTotCnt(DepartmentInfoDefaultVO searchVO);
    
}
