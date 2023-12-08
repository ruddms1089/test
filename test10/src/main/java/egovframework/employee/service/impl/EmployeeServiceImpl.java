package egovframework.employee.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.egovframe.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.employee.service.EmployeeService;
import egovframework.employee.service.EmployeeDefaultVO;
import egovframework.employee.service.EmployeeVO;
import egovframework.employee.service.impl.EmployeeDAO;
import egovframework.employee.service.impl.EmployeeMapper;
/**
 * @Class Name : EmployeeServiceImpl.java
 * @Description : Employee Business Implement class
 * @Modification Information
 *
 * @author kke
 * @since 23-12-07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("employeeService")
public class EmployeeServiceImpl extends EgovAbstractServiceImpl implements
        EmployeeService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Resource(name="employeeMapper")
    private EmployeeMapper employeeDAO;
    
    //@Resource(name="employeeDAO")
    //private EmployeeDAO employeeDAO;
    
    /** ID Generation */
    //@Resource(name="{egovEmployeeIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * EMPLOYEE을 등록한다.
	 * @param vo - 등록할 정보가 담긴 EmployeeVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertEmployee(EmployeeVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	employeeDAO.insertEmployee(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * EMPLOYEE을 수정한다.
	 * @param vo - 수정할 정보가 담긴 EmployeeVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateEmployee(EmployeeVO vo) throws Exception {
        employeeDAO.updateEmployee(vo);
    }

    /**
	 * EMPLOYEE을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 EmployeeVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteEmployee(EmployeeVO vo) throws Exception {
        employeeDAO.deleteEmployee(vo);
    }

    /**
	 * EMPLOYEE을 조회한다.
	 * @param vo - 조회할 정보가 담긴 EmployeeVO
	 * @return 조회한 EMPLOYEE
	 * @exception Exception
	 */
    public EmployeeVO selectEmployee(EmployeeVO vo) throws Exception {
        EmployeeVO resultVO = employeeDAO.selectEmployee(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * EMPLOYEE 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return EMPLOYEE 목록
	 * @exception Exception
	 */
    public List<?> selectEmployeeList(EmployeeDefaultVO searchVO) throws Exception {
        return employeeDAO.selectEmployeeList(searchVO);
    }

    /**
	 * EMPLOYEE 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return EMPLOYEE 총 갯수
	 * @exception
	 */
    public int selectEmployeeListTotCnt(EmployeeDefaultVO searchVO) {
		return employeeDAO.selectEmployeeListTotCnt(searchVO);
	}
    
}
