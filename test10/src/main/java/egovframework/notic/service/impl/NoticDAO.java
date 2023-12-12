package egovframework.notic.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import egovframework.notic.service.NoticVO;
import egovframework.notic.service.NoticDefaultVO;

/**
 * @Class Name : NoticDAO.java
 * @Description : Notic DAO Class
 * @Modification Information
 *
 * @author kke
 * @since 2023-12-07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("noticDAO")
public class NoticDAO extends EgovAbstractMapper {

	/**
	 * NOTIC을 등록한다.
	 * @param vo - 등록할 정보가 담긴 NoticVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertNotic(NoticVO vo) throws Exception {
        insert("noticDAO.insertNotic", vo);
    }

    /**
	 * NOTIC을 수정한다.
	 * @param vo - 수정할 정보가 담긴 NoticVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateNotic(NoticVO vo) throws Exception {
        update("noticDAO.updateNotic", vo);
    }

    /**
	 * NOTIC을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 NoticVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteNotic(NoticVO vo) throws Exception {
        delete("noticDAO.deleteNotic", vo);
    }

    /**
	 * NOTIC을 조회한다.
	 * @param vo - 조회할 정보가 담긴 NoticVO
	 * @return 조회한 NOTIC
	 * @exception Exception
	 */
    public NoticVO selectNotic(NoticVO vo) throws Exception {
        return (NoticVO) selectOne("noticDAO.selectNotic", vo);
    }

    /**
	 * NOTIC 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 List<NoticDefaultVO>
	 * @return NOTIC 목록
	 * @exception Exception
	 */
    public List<NoticDefaultVO> selectNoticList(NoticDefaultVO searchVO) throws Exception {
        return selectList("noticDAO.selectNoticList", searchVO);
    }

    /**
     * Department 이름을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return 부서 이름
	 * @exception
	 */
    public int selectNoticListTotCnt(NoticDefaultVO searchVO) {
        return (Integer)selectOne("noticDAO.selectNoticListTotCnt", searchVO);
    }
}
