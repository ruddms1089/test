package egovframework.department_info.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.egovframe.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.department_info.service.DepartmentInfoService;
import egovframework.department_info.service.DepartmentInfoDefaultVO;
import egovframework.department_info.service.DepartmentInfoVO;
import egovframework.department_info.service.impl.DepartmentInfoDAO;
import egovframework.department_info.service.impl.DepartmentInfoMapper;
/**
 * @Class Name : DepartmentInfoServiceImpl.java
 * @Description : DepartmentInfo Business Implement class
 * @Modification Information
 *
 * @author kke
 * @since 23-12-07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("departmentInfoService")
public class DepartmentInfoServiceImpl extends EgovAbstractServiceImpl implements
        DepartmentInfoService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentInfoServiceImpl.class);

    @Resource(name="departmentInfoMapper")
    private DepartmentInfoMapper departmentInfoDAO;
    
    //@Resource(name="departmentInfoDAO")
    //private DepartmentInfoDAO departmentInfoDAO;
    
    /** ID Generation */
    //@Resource(name="{egovDepartmentInfoIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * DEPARTMENT_INFO을 등록한다.
	 * @param vo - 등록할 정보가 담긴 DepartmentInfoVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertDepartmentInfo(DepartmentInfoVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	departmentInfoDAO.insertDepartmentInfo(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * DEPARTMENT_INFO을 수정한다.
	 * @param vo - 수정할 정보가 담긴 DepartmentInfoVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateDepartmentInfo(DepartmentInfoVO vo) throws Exception {
        departmentInfoDAO.updateDepartmentInfo(vo);
    }

    /**
	 * DEPARTMENT_INFO을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 DepartmentInfoVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteDepartmentInfo(DepartmentInfoVO vo) throws Exception {
        departmentInfoDAO.deleteDepartmentInfo(vo);
    }

    /**
	 * DEPARTMENT_INFO을 조회한다.
	 * @param vo - 조회할 정보가 담긴 DepartmentInfoVO
	 * @return 조회한 DEPARTMENT_INFO
	 * @exception Exception
	 */
    public DepartmentInfoVO selectDepartmentInfo(DepartmentInfoVO vo) throws Exception {
        DepartmentInfoVO resultVO = departmentInfoDAO.selectDepartmentInfo(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * DEPARTMENT_INFO 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return DEPARTMENT_INFO 목록
	 * @exception Exception
	 */
    public List<?> selectDepartmentInfoList(DepartmentInfoDefaultVO searchVO) throws Exception {
        return departmentInfoDAO.selectDepartmentInfoList(searchVO);
    }

    /**
	 * DEPARTMENT_INFO 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return DEPARTMENT_INFO 총 갯수
	 * @exception
	 */
    public int selectDepartmentInfoListTotCnt(DepartmentInfoDefaultVO searchVO) {
		return departmentInfoDAO.selectDepartmentInfoListTotCnt(searchVO);
	}
    
}
