package probono.view;

import java.util.ArrayList;

import probono.model.dto.ProbonoProjectDTO;

public class RunningEndView {
	


	/* 모든 프로젝트 출력 */

	public static void projectListView(ArrayList allProbonoProject){
		
		int length = allProbonoProject.size();
		if( length != 0 ){
			for(int index = 0; index < length; index++){			
				System.out.println("검색정보 " + (index+1) + " - " + allProbonoProject.get(index));
			}
		}
	}
		

	/* 특정 프로젝트 출력 */

	public static void projectView(ProbonoProjectDTO project){
		System.out.println(project);		
	}
	

	/* 모든 DTO 정보 출력 */

	public static void allView(Object object){
		System.out.println(object);
	}
	
	
	/* 예외 상황 출력 */

	public static void showError(String message){
		System.out.println(message);		
	}


	
}
