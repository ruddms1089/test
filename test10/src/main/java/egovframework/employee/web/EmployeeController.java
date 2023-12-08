package egovframework.employee.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import egovframework.employee.service.EmployeeService;
import egovframework.employee.service.EmployeeDefaultVO;
import egovframework.employee.service.EmployeeVO;

/**
 * @Class Name : EmployeeController.java
 * @Description : Employee Controller class
 * @Modification Information
 *
 * @author kke
 * @since 23-12-07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=EmployeeVO.class)
public class EmployeeController {

    @Resource(name = "employeeService")
    private EmployeeService employeeService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * EMPLOYEE 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 EmployeeDefaultVO
	 * @return "/employee/EmployeeList"
	 * @exception Exception
	 */
    @RequestMapping(value="/employee/EmployeeList.do")
    public String selectEmployeeList(@ModelAttribute("searchVO") EmployeeDefaultVO searchVO, 
    		ModelMap model)
            throws Exception {
    	
    	/** EgovPropertyService.sample */
    	searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
    	searchVO.setPageSize(propertiesService.getInt("pageSize"));
    	
    	/** pageing */
    	PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());
		
		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
        List<?> employeeList = employeeService.selectEmployeeList(searchVO);
        model.addAttribute("resultList", employeeList);
        
        int totCnt = employeeService.selectEmployeeListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "/employee/EmployeeList";
    } 
    
    @RequestMapping("/employee/addEmployeeView.do")
    public String addEmployeeView(
            @ModelAttribute("searchVO") EmployeeDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("employeeVO", new EmployeeVO());
        return "/employee/EmployeeRegister";
    }
    
    @RequestMapping("/employee/addEmployee.do")
    public String addEmployee(
            EmployeeVO employeeVO,
            @ModelAttribute("searchVO") EmployeeDefaultVO searchVO, SessionStatus status)
            throws Exception {
        employeeService.insertEmployee(employeeVO);
        status.setComplete();
        return "forward:/employee/EmployeeList.do";
    }
    
    @RequestMapping("/employee/updateEmployeeView.do")
    public String updateEmployeeView(
            @RequestParam("empNumber") java.lang.String empNumber ,
            @ModelAttribute("searchVO") EmployeeDefaultVO searchVO, Model model)
            throws Exception {
        EmployeeVO employeeVO = new EmployeeVO();
        employeeVO.setEmpNumber(empNumber);
        // 변수명은 CoC 에 따라 employeeVO
        model.addAttribute(selectEmployee(employeeVO, searchVO));
        return "/employee/EmployeeRegister";
    }

    @RequestMapping("/employee/selectEmployee.do")
    public @ModelAttribute("employeeVO")
    EmployeeVO selectEmployee(
            EmployeeVO employeeVO,
            @ModelAttribute("searchVO") EmployeeDefaultVO searchVO) throws Exception {
        return employeeService.selectEmployee(employeeVO);
    }

    @RequestMapping("/employee/updateEmployee.do")
    public String updateEmployee(
            EmployeeVO employeeVO,
            @ModelAttribute("searchVO") EmployeeDefaultVO searchVO, SessionStatus status)
            throws Exception {
        employeeService.updateEmployee(employeeVO);
        status.setComplete();
        return "forward:/employee/EmployeeList.do";
    }
    
    @RequestMapping("/employee/deleteEmployee.do")
    public String deleteEmployee(
            EmployeeVO employeeVO,
            @ModelAttribute("searchVO") EmployeeDefaultVO searchVO, SessionStatus status)
            throws Exception {
        employeeService.deleteEmployee(employeeVO);
        status.setComplete();
        return "forward:/employee/EmployeeList.do";
    }

}
