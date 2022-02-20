package probono.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import probono.model.ActivistDAO;
import probono.model.ProbonoDAO;
import probono.model.ProbonoProjectDAO;
import probono.model.dto.ActivistDTO;
import probono.model.dto.ProbonoDTO;
import probono.model.dto.ProbonoProjectDTO;
import probono.view.RunningEndView;

/* view.RunningStrartView에서 호출 */
public class ProbonoProjectController {
	

	
	/* 모든 project 검색 */

	public static ArrayList<ProbonoProjectDTO> getAllProbonoProjects(){
		ArrayList<ProbonoProjectDTO> allProject = null;
		try{			
			allProject = ProbonoProjectDAO.getAllProbonoProjects();			
		}catch(SQLException s){
			s.printStackTrace();
			RunningEndView.showError("모든 프로젝트 검색시 에러 발생");
		}
		return allProject;
	}
	

	/*새로운 project 저장 */

	public static boolean addProbonoProject(ProbonoProjectDTO probonoProject) {
		boolean result = false;
		try{
			result = ProbonoProjectDAO.addProbonoProject(probonoProject);
		}catch(SQLException s){
			s.printStackTrace();
			RunningEndView.showError("모든 프로젝트 저장시 에러 발생");
		}
		return result;
	}
	

	/* 모든 기부자 검색 */

	public static ArrayList<ActivistDTO> getAllActivists(){
		ArrayList<ActivistDTO> allProject = null;
		try{
			allProject = ActivistDAO.getAllActivists();			
		}catch(SQLException s){
			s.printStackTrace();
			RunningEndView.showError("모든 재능 기부자 검색시 에러 발생");
		}
		return allProject;
	}
	

	/* probono id로 probono 목적 수정 */

	public static boolean updateProbono(String probonoId, String probonoPurpose){
		boolean result = false;
		try{
			result = ProbonoDAO.updateProbono(probonoId, probonoPurpose);
		}catch(SQLException s){
			s.printStackTrace();
			RunningEndView.showError("프로보노 id로 프로보노 목적 변경 오류");
		}
		return result;
	}
	

	/* probono 정보 검색 */

	public static ProbonoDTO getProbono(String probonoId) {
		ProbonoDTO probono = null;
		try {
			probono = ProbonoDAO.getProbono(probonoId);
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("프로보노 id로 해당 프로보노 검색 오류 ");
		}
		return probono;
	}


	
}
