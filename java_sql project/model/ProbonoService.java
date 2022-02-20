package probono.model;

import java.sql.SQLException;
import java.util.ArrayList;

import probono.exception.NotExistException;
import probono.model.dto.ActivistDTO;
import probono.model.dto.ProbonoDTO;
import probono.model.dto.ProbonoProjectDTO;
import probono.model.dto.RecipientDTO;

public class ProbonoService {
	


	private static ProbonoService instance = new ProbonoService();
	
	private ProbonoService(){}
	
	public static ProbonoService getInstance(){
		return instance;
	}
	
		 
	/* Probono CRUD */

	public static void notExistProbono(String probonoId) throws NotExistException, SQLException{
		ProbonoDTO probono = ProbonoDAO.getProbono(probonoId);
		if(probono == null){
			throw new NotExistException("검색하진 재능기부 정보가 없습니다.");
		}
	}
	
	public static ArrayList<ProbonoDTO> getAllProbonos() throws SQLException{
		return ProbonoDAO.getAllProbonos();
	}

	public static ProbonoDTO getProbono(String probonoId) throws SQLException, NotExistException{
		ProbonoDTO probono = ProbonoDAO.getProbono(probonoId);
		if(probono == null){
			throw new NotExistException("검색하신 재능기부 정보가 없습니다.");
		}
		return probono;
	}

	public static boolean addProbono(ProbonoDTO probono) throws SQLException{
		return ProbonoDAO.addProbono(probono);
	}

	public static boolean updateProbono(String probonoId, String probonoPurpose) throws SQLException, NotExistException{
		notExistProbono(probonoId);
		return ProbonoDAO.updateProbono(probonoId, probonoPurpose);
	}

	public boolean deleteProbono(String probonoId) throws SQLException, NotExistException{
		notExistProbono(probonoId);
		return ProbonoDAO.deleteProbono(probonoId);
	}
		
	
	/* Activist CRUD */

	public static void notExistActivist(String activistId) throws NotExistException, SQLException{
		ActivistDTO activist = ActivistDAO.getActivist(activistId);
		if(activist == null){
			throw new NotExistException("검색하는 재능 기부자가 미 존재합니다.");
		}
	}

	public static boolean addActivist(ActivistDTO activist) throws SQLException{
		return ActivistDAO.addActivist(activist);	
	}

	public static boolean updateActivist(String activistId, String major) throws SQLException, NotExistException{
		notExistActivist(activistId);
		return ActivistDAO.updateActivist(activistId, major);
	}

	public boolean deleteActivist(String activistId) throws SQLException, NotExistException{
		notExistActivist(activistId);
		return ActivistDAO.deleteActivist(activistId);
	}

	public static ActivistDTO getActivist(String activistId) throws SQLException, NotExistException{
		ActivistDTO activist = ActivistDAO.getActivist(activistId);
		if(activist == null){
			throw new NotExistException("검색하는 재능 기부자가 미 존재합니다.");
		}
		return activist;
	}

	public static ArrayList<ActivistDTO> getAllActivists() throws SQLException{
		return ActivistDAO.getAllActivists();
	}
	
	
	/* Recipient CRUD */

	public static void notExistRecipient(String recipientId) throws NotExistException, SQLException{
		RecipientDTO recipient = RecipientDAO.getRecipient(recipientId);
		if(recipient == null){
			throw new NotExistException("검색하는 재능 수해자가 미 존재합니다.");
		}
	}

	public static boolean addRecipient(RecipientDTO recipient) throws SQLException{
		return RecipientDAO.addRecipient(recipient);
	}

	public static boolean updateRecipient(String recipientId, String receiveHopeContent) throws SQLException, NotExistException{
		notExistRecipient(recipientId);
		return RecipientDAO.updateRecipient(recipientId, receiveHopeContent);
	}

	public boolean deleteRecipient(String recipientId) throws SQLException, NotExistException{
		notExistRecipient(recipientId);
		return RecipientDAO.deleteRecipient(recipientId);
	}

	public static RecipientDTO getRecipient(String recipientId) throws SQLException{
		return RecipientDAO.getRecipient(recipientId);
	}

	public static ArrayList<RecipientDTO> getAllRecipients() throws SQLException{
		return RecipientDAO.getAllRecipients();
	}
	

	/* ProjectUserDAO CRUD */

	public static void notExistProbonoUser(int probonoUserId) throws NotExistException, SQLException{
		ProbonoProjectDTO probonoUser = ProbonoProjectDAO.getProbonoProject(probonoUserId);
		if(probonoUser == null){
			throw new NotExistException("검색하는 재능기부 프로젝트가 미 존재합니다.");
		}
	}

	public static boolean addProbonoUser(ProbonoProjectDTO probonoUser) throws SQLException{
		return ProbonoProjectDAO.addProbonoProject(probonoUser);
	}

	public static boolean updateProbonoUserActivist(int probonoUserId, String activistId) throws SQLException, NotExistException{
		notExistProbonoUser(probonoUserId);
		return ProbonoProjectDAO.updateProbonoProjectActivist(probonoUserId, activistId);
	}

	public static boolean updateProbonoUserReceive(int probonoUserId, String  receiveId) 	throws SQLException, NotExistException{
		notExistProbonoUser(probonoUserId);
		return ProbonoProjectDAO.updateProbonoProjectReceive(probonoUserId, receiveId);
	}

	public static boolean deleteProbonoUser(int probonoUserId) throws SQLException, NotExistException{
		notExistProbonoUser(probonoUserId);
		return ProbonoProjectDAO.deleteProbonoProject(probonoUserId);
	}
	
	//project id로 존재 유무 검색
	public static ProbonoProjectDTO getProbonoUser(int probonoUserId) throws SQLException, NotExistException{
		ProbonoProjectDTO probonoUser = ProbonoProjectDAO.getProbonoProject(probonoUserId);
		if(probonoUser == null){
			throw new NotExistException("검색하는 재능기부 프로젝트가 미 존재합니다.");
		}
		return probonoUser;
	}
	
	public static ArrayList<ProbonoProjectDTO> getAllProbonoUsers() throws SQLException{
		return ProbonoProjectDAO.getAllProbonoProjects();
	}
	
	
	
}
