package egovframework.department_info.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import egovframework.department_info.service.DepartmentInfoVO;
import egovframework.department_info.service.DepartmentInfoDefaultVO;

/**
 * @Class Name : DepartmentInfoDAO.java
 * @Description : DepartmentInfo DAO Class
 * @Modification Information
 *
 * @author kke
 * @since 23-12-07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("departmentInfoDAO")
public class DepartmentInfoDAO extends EgovAbstractMapper {

	/**
	 * DEPARTMENT_INFO을 등록한다.
	 * @param vo - 등록할 정보가 담긴 DepartmentInfoVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertDepartmentInfo(DepartmentInfoVO vo) throws Exception {
        insert("departmentInfoDAO.insertDepartmentInfo", vo);
    }

    /**
	 * DEPARTMENT_INFO을 수정한다.
	 * @param vo - 수정할 정보가 담긴 DepartmentInfoVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateDepartmentInfo(DepartmentInfoVO vo) throws Exception {
        update("departmentInfoDAO.updateDepartmentInfo", vo);
    }

    /**
	 * DEPARTMENT_INFO을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 DepartmentInfoVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteDepartmentInfo(DepartmentInfoVO vo) throws Exception {
        delete("departmentInfoDAO.deleteDepartmentInfo", vo);
    }

    /**
	 * DEPARTMENT_INFO을 조회한다.
	 * @param vo - 조회할 정보가 담긴 DepartmentInfoVO
	 * @return 조회한 DEPARTMENT_INFO
	 * @exception Exception
	 */
    public DepartmentInfoVO selectDepartmentInfo(DepartmentInfoVO vo) throws Exception {
        return (DepartmentInfoVO) selectOne("departmentInfoDAO.selectDepartmentInfo", vo);
    }

    /**
	 * DEPARTMENT_INFO 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 List<DepartmentInfoDefaultVO>
	 * @return DEPARTMENT_INFO 목록
	 * @exception Exception
	 */
    public List<DepartmentInfoDefaultVO> selectDepartmentInfoList(DepartmentInfoDefaultVO searchVO) throws Exception {
        return selectList("departmentInfoDAO.selectDepartmentInfoList", searchVO);
    }

    /**
	 * DEPARTMENT_INFO 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return DEPARTMENT_INFO 총 갯수
	 * @exception
	 */
    public int selectDepartmentInfoListTotCnt(DepartmentInfoDefaultVO searchVO) {
        return (Integer)selectOne("departmentInfoDAO.selectDepartmentInfoListTotCnt", searchVO);
    }

}
