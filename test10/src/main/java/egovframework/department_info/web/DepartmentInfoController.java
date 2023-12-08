package egovframework.department_info.web;

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

import egovframework.department_info.service.DepartmentInfoService;
import egovframework.department_info.service.DepartmentInfoDefaultVO;
import egovframework.department_info.service.DepartmentInfoVO;

/**
 * @Class Name : DepartmentInfoController.java
 * @Description : DepartmentInfo Controller class
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
@SessionAttributes(types=DepartmentInfoVO.class)
public class DepartmentInfoController {

    @Resource(name = "departmentInfoService")
    private DepartmentInfoService departmentInfoService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * DEPARTMENT_INFO 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 DepartmentInfoDefaultVO
	 * @return "/departmentInfo/DepartmentInfoList"
	 * @exception Exception
	 */
    @RequestMapping(value="/departmentInfo/DepartmentInfoList.do")
    public String selectDepartmentInfoList(@ModelAttribute("searchVO") DepartmentInfoDefaultVO searchVO, 
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
		
        List<?> departmentInfoList = departmentInfoService.selectDepartmentInfoList(searchVO);
        model.addAttribute("resultList", departmentInfoList);
        
        int totCnt = departmentInfoService.selectDepartmentInfoListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "/departmentInfo/DepartmentInfoList";
    } 
    
    @RequestMapping("/departmentInfo/addDepartmentInfoView.do")
    public String addDepartmentInfoView(
            @ModelAttribute("searchVO") DepartmentInfoDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("departmentInfoVO", new DepartmentInfoVO());
        return "/departmentInfo/DepartmentInfoRegister";
    }
    
    @RequestMapping("/departmentInfo/addDepartmentInfo.do")
    public String addDepartmentInfo(
            DepartmentInfoVO departmentInfoVO,
            @ModelAttribute("searchVO") DepartmentInfoDefaultVO searchVO, SessionStatus status)
            throws Exception {
        departmentInfoService.insertDepartmentInfo(departmentInfoVO);
        status.setComplete();
        return "forward:/departmentInfo/DepartmentInfoList.do";
    }
    
    @RequestMapping("/departmentInfo/updateDepartmentInfoView.do")
    public String updateDepartmentInfoView(
            @RequestParam("depNumber") java.math.BigDecimal depNumber ,
            @ModelAttribute("searchVO") DepartmentInfoDefaultVO searchVO, Model model)
            throws Exception {
        DepartmentInfoVO departmentInfoVO = new DepartmentInfoVO();
        departmentInfoVO.setDepNumber(depNumber);
        // 변수명은 CoC 에 따라 departmentInfoVO
        model.addAttribute(selectDepartmentInfo(departmentInfoVO, searchVO));
        return "/departmentInfo/DepartmentInfoRegister";
    }

    @RequestMapping("/departmentInfo/selectDepartmentInfo.do")
    public @ModelAttribute("departmentInfoVO")
    DepartmentInfoVO selectDepartmentInfo(
            DepartmentInfoVO departmentInfoVO,
            @ModelAttribute("searchVO") DepartmentInfoDefaultVO searchVO) throws Exception {
        return departmentInfoService.selectDepartmentInfo(departmentInfoVO);
    }

    @RequestMapping("/departmentInfo/updateDepartmentInfo.do")
    public String updateDepartmentInfo(
            DepartmentInfoVO departmentInfoVO,
            @ModelAttribute("searchVO") DepartmentInfoDefaultVO searchVO, SessionStatus status)
            throws Exception {
        departmentInfoService.updateDepartmentInfo(departmentInfoVO);
        status.setComplete();
        return "forward:/departmentInfo/DepartmentInfoList.do";
    }
    
    @RequestMapping("/departmentInfo/deleteDepartmentInfo.do")
    public String deleteDepartmentInfo(
            DepartmentInfoVO departmentInfoVO,
            @ModelAttribute("searchVO") DepartmentInfoDefaultVO searchVO, SessionStatus status)
            throws Exception {
        departmentInfoService.deleteDepartmentInfo(departmentInfoVO);
        status.setComplete();
        return "forward:/departmentInfo/DepartmentInfoList.do";
    }

}
