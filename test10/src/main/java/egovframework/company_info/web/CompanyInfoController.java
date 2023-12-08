package egovframework.company_info.web;

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

import egovframework.company_info.service.CompanyInfoService;
import egovframework.company_info.service.CompanyInfoDefaultVO;
import egovframework.company_info.service.CompanyInfoVO;

/**
 * @Class Name : CompanyInfoController.java
 * @Description : CompanyInfo Controller class
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
@SessionAttributes(types=CompanyInfoVO.class)
public class CompanyInfoController {

    @Resource(name = "companyInfoService")
    private CompanyInfoService companyInfoService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * COMPANY_INFO 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 CompanyInfoDefaultVO
	 * @return "/companyInfo/CompanyInfoList"
	 * @exception Exception
	 */
    @RequestMapping(value="/companyInfo/CompanyInfoList.do")
    public String selectCompanyInfoList(@ModelAttribute("searchVO") CompanyInfoDefaultVO searchVO, 
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
		
        List<?> companyInfoList = companyInfoService.selectCompanyInfoList(searchVO);
        model.addAttribute("resultList", companyInfoList);
        
        int totCnt = companyInfoService.selectCompanyInfoListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "/companyInfo/CompanyInfoList";
    } 
    
    @RequestMapping("/companyInfo/addCompanyInfoView.do")
    public String addCompanyInfoView(
            @ModelAttribute("searchVO") CompanyInfoDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("companyInfoVO", new CompanyInfoVO());
        return "/companyInfo/CompanyInfoRegister";
    }
    
    @RequestMapping("/companyInfo/addCompanyInfo.do")
    public String addCompanyInfo(
            CompanyInfoVO companyInfoVO,
            @ModelAttribute("searchVO") CompanyInfoDefaultVO searchVO, SessionStatus status)
            throws Exception {
        companyInfoService.insertCompanyInfo(companyInfoVO);
        status.setComplete();
        return "forward:/companyInfo/CompanyInfoList.do";
    }
    
    @RequestMapping("/companyInfo/updateCompanyInfoView.do")
    public String updateCompanyInfoView(
            @RequestParam("comNumber") java.math.BigDecimal comNumber ,
            @ModelAttribute("searchVO") CompanyInfoDefaultVO searchVO, Model model)
            throws Exception {
        CompanyInfoVO companyInfoVO = new CompanyInfoVO();
        companyInfoVO.setComNumber(comNumber);
        // 변수명은 CoC 에 따라 companyInfoVO
        model.addAttribute(selectCompanyInfo(companyInfoVO, searchVO));
        return "/companyInfo/CompanyInfoRegister";
    }

    @RequestMapping("/companyInfo/selectCompanyInfo.do")
    public @ModelAttribute("companyInfoVO")
    CompanyInfoVO selectCompanyInfo(
            CompanyInfoVO companyInfoVO,
            @ModelAttribute("searchVO") CompanyInfoDefaultVO searchVO) throws Exception {
        return companyInfoService.selectCompanyInfo(companyInfoVO);
    }

    @RequestMapping("/companyInfo/updateCompanyInfo.do")
    public String updateCompanyInfo(
            CompanyInfoVO companyInfoVO,
            @ModelAttribute("searchVO") CompanyInfoDefaultVO searchVO, SessionStatus status)
            throws Exception {
        companyInfoService.updateCompanyInfo(companyInfoVO);
        status.setComplete();
        return "forward:/companyInfo/CompanyInfoList.do";
    }
    
    @RequestMapping("/companyInfo/deleteCompanyInfo.do")
    public String deleteCompanyInfo(
            CompanyInfoVO companyInfoVO,
            @ModelAttribute("searchVO") CompanyInfoDefaultVO searchVO, SessionStatus status)
            throws Exception {
        companyInfoService.deleteCompanyInfo(companyInfoVO);
        status.setComplete();
        return "forward:/companyInfo/CompanyInfoList.do";
    }

}
