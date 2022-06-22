package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Contrat;
public interface IContratService {



	Long addContrat(Contrat contrat);

	void supprimerContrat(Long contratId);
	
	List<Contrat> getContrats();
	
	void affecterContrat(Long contratId, Long employeeId);
	Contrat retrieveContratById(String id);
}



