package step02.probono.controller;

import step02.probono.exception.ProjectNameDuplicationException;
import step02.probono.exception.ProjectNotFoundException;
import step02.probono.model.dto.Beneficiary;
import step02.probono.model.dto.Donator;
import step02.probono.model.dto.TalentDonationProject;
import step02.probono.service.TalentDonationProjectService;
import step02.probono.view.EndFailView;
import step02.probono.view.EndView;

public class TalentDonationProjectController {
	
	
	/* instance 생성 및 service 불러오기 */
	private static TalentDonationProjectController instance = new TalentDonationProjectController(); 
	private TalentDonationProjectService service = TalentDonationProjectService.getInstance();
	private TalentDonationProjectController() {}
	public static TalentDonationProjectController getInstance() {
		return instance;
	}
	
	
	
	
	/* 검색 및 반환 메소드 */
	
	public void getDonationProject(String projectName) {
		
		try {
			EndView.projectView(service.getDonationProject(projectName));
		} catch (ProjectNotFoundException e) {
			e.printStackTrace();  //개발 및 관리자만 보는 콘솔창 메세지
			EndFailView.failView(e.getMessage()); //end user에게 출력하는 서비스 메세지
		}
	}
	
	
	public void getDonationProjectsList() {
		EndView.projectListView(service.getDonationProjectsList());
	}


	
	
	/* 추가 메소드 */
	
	public void donationProjectInsert(TalentDonationProject project) {
		
		if(project != null) {
			try {
				service.donationProjectInsert(project);
			} catch (ProjectNameDuplicationException e) {
				e.printStackTrace();
				EndFailView.failView(e.getMessage());
			}
		}else {
			EndFailView.failView("저장하고자 하는 데이터 자체가 없습니다.");
		}
	}
	
	
	
	
	/* 수정 메소드 */
	
	public void donationProjectUpdate(String projectName, Donator people) {
		
		if(projectName != null && people != null) {
			boolean result = service.donationProjectUpdate(projectName, people);
			if(result) { 
				try {
					EndView.projectView(service.getDonationProject(projectName));
				} catch (ProjectNotFoundException e) {
					e.printStackTrace();
					EndFailView.failView("기부자 갱신 후 검색 실패 " );
				}
			}else {
				EndFailView.failView("미 존재하는 프로젝트 수정 시도");
			}
			
		}else {
			EndFailView.failView("기부자 갱신 정보 제대로 입력하세요!!!");
		}
	}
	
	
	public void beneficiaryProjectUpdate(String projectName, Beneficiary people) {
		
		if(projectName != null && people != null) {
			try {
				service.beneficiaryProjectUpdate(projectName, people);
				EndView.successView("수혜자 정보 갱신 성공");
			} catch (ProjectNotFoundException e) {
				e.printStackTrace();
				EndFailView.failView(e.getMessage()); //"수혜자 정보를 수정하고자 하는 프로젝트가 미 존재합니다." 정보 의미
			}
		}else {
			EndFailView.failView("수혜자 갱신 정보 제대로 입력하세요!!!");
		}
	}
	
	
	
	
	/* 삭제 메소드 */
	
	public void donationProjectDelete(String projectName) {
		
		if(projectName != null) {
			boolean result = service.donationProjectDelete(projectName);
			if(result) {
				EndView.successView(projectName + " 프로젝트 삭제 성공");
			}else {
				EndFailView.failView("삭제하려는 프로젝트가 미 존재합니다.");
			}
		}else {
			EndFailView.failView("삭제하려는 프로젝트명 입력하세요");
		}
	}
	
}
