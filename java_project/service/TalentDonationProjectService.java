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
		Optional<TalentDonationProject> opt = donationProjectList.stream().filter(p 
				-> p.getTalentDonationProjectName().equals(projectName)).findAny();
	
		if (opt.isPresent()) {
			return opt.get();
		}
		throw new ProjectNotFoundException();
	}
	

	

	/* 추가 메소드 */

	public void donationProjectInsert(TalentDonationProject project) 
			throws ProjectNameDuplicationException {
		boolean anyMatch = donationProjectList.stream().anyMatch(p -> 
		p.getTalentDonationProjectName().equals(project.getTalentDonationProjectName()));
		
		if (anyMatch) {
			throw new ProjectNameDuplicatedException();
		}else {
			donationProjectList.add(project);
		}
	}

	
	

	/* 수정 메소드 */

	public boolean donationProjectUpdate(String projectName, Donator people) {
		Optional<TalentDonationProject> opt = donationProjectList.stream().filter(p -> 
				p.getTalentDonationProjectName().equals(projectName)).findAny();
		
		if (opt.isPresent()) {
			opt.get().setProjectDonator(people);
			return true;
		}
		return false;
	}
	
	
	public void beneficiaryProjectUpdate(String projectName, Beneficiary people) 
			throws ProjectNotFoundException{
		Optional<TalentDonationProject> opt = donationProjectList.stream().filter(p -> 
			p.getTalentDonationProjectName().equals(projectName)).findAny();
		
		if (opt.isPresent()) {
			opt.get().setProjectBeneficiary(people);
			return;
		}
		throw new ProjectNotFoundException("수혜자 정보를 수정하고자 하는 프로젝트가 미존재합니다.");
	}
	
	


	/* 삭제 메소드 */

	public boolean donationProjectDelete(String projectName) {
		Optional<TalentDonationProject> opt = donationProjectList.stream().filter(p -> 
				p.getTalentDonationProjectName().equals(projectName)).findAny();
		
		if (opt.isPresent()) {
			donationProjectList.remove(opt.get());
			return true;
		}
		return false;
	}

}
