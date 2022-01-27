/** 
 * PROJECT  : 재능기부 프로젝트
 * NAME  :  TalentDonationProjectService.java
 * DESC  :  재능 기부 프로젝트를 저장, 수정, 삭제, 검색하는 서비스 로직
 * 
 * @author  
 * @version 1.0
*/

package step02.probono.service;

import java.util.ArrayList;

import step02.probono.exception.ProjectNameDuplicationException;
import step02.probono.exception.ProjectNotFoundException;
import step02.probono.model.dto.Beneficiary;
import step02.probono.model.dto.Donator;
import step02.probono.model.dto.TalentDonationProject;

public class TalentDonationProjectService {

	
	/* instance 및 arraylist 생성 */
	
	private static TalentDonationProjectService instance = new TalentDonationProjectService();
	private ArrayList<TalentDonationProject> donationProjectList = new ArrayList<TalentDonationProject>();
	private TalentDonationProjectService() {}
	public static TalentDonationProjectService getInstance() {
		return instance;
	}
	

	
	
	/* 검색 및 반환 메소드 */ 

	public ArrayList<TalentDonationProject> getDonationProjectsList() {
		return donationProjectList;
	}


	public TalentDonationProject getDonationProject(String projectName) 
			throws ProjectNotFoundException {
		
		for(TalentDonationProject e : donationProjectList) {
			if(e.getTalentDonationProjectName().equals(projectName)) {
				return e;
			}
		}
		throw new ProjectNotFoundException("요청하신 project는 존재하지 않습니다");
	}
	

	

	/* 추가 메소드 */

	public void donationProjectInsert(TalentDonationProject project) 
			throws ProjectNameDuplicationException {
		
		for(TalentDonationProject e : donationProjectList) {
			if(e.getTalentDonationProjectName().equals( project.getTalentDonationProjectName() )) {
				throw new ProjectNameDuplicationException("이미 존재하는 Project입니다");
			}
		}
		donationProjectList.add(project);
	}

	
	

	/* 수정 메소드 */

	public boolean donationProjectUpdate(String projectName, Donator people) {
		
		for(TalentDonationProject project : donationProjectList) {
			if(project.getTalentDonationProjectName().equals(projectName)) {
				project.setProjectDonator(people);
				return true;   //메소드 자체가 종료
			}
		}
		return false;
	}
	
	
	public void beneficiaryProjectUpdate(String projectName, Beneficiary people) 
			throws ProjectNotFoundException{
		
		for(TalentDonationProject e : donationProjectList) {
			if(e != null && e.getTalentDonationProjectName().equals(projectName)) {
				e.setProjectBeneficiary(people);
				return; 
			}
		}		
		throw new ProjectNotFoundException("수혜자 정보를 수정하고자 하는 프로젝트가 미 존재합니다.");
	}
	
	


	/* 삭제 메소드 */

	public boolean donationProjectDelete(String projectName) {
		
		TalentDonationProject project = null;
		int count = donationProjectList.size();
		for(int i=0; i<count; i++) {
			project = donationProjectList.get(i);
			if(project.getTalentDonationProjectName().equals(projectName)) {
				donationProjectList.remove(i);
				return true;
			}
		}		
		return false;
	}

}
