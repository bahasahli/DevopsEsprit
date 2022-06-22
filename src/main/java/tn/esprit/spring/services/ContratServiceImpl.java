package tn.esprit.spring.services;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.*;

@Service
public class ContratServiceImpl implements IContratService {

	private static final Logger logger = LogManager.getLogger(ContratServiceImpl.class);
	private static final String ENTRDEB = "Cours";

	@Autowired
	ContratRepository contratRepository;

	@Override
	public Long addContrat(Contrat contrat) {
		logger.info("Add of contrats : ");
		logger.debug(ENTRDEB, contrat);
		try {
			contrat = contratRepository.save(contrat);
			logger.info("Add cours success.");
			return (long) contrat.getReference();
		} catch (Exception e) {

			logger.error("Add cours failed", e);
		}
		return null;
	}

	@Override
	public List<Contrat> getContrats() {
		logger.info("Find list of Cours : ");
		logger.debug(ENTRDEB);
		List<Contrat> contrat = null;
		try {
			contrat = (List<Contrat>) contratRepository.findAll();
			return contrat;
		} catch (Exception e) {

			logger.error("Find contrat failed", e);
		}
		return null;
	}

	@Override
	public void affecterContrat(Long contratId, Long employeeId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Contrat retrieveContratById(String id) {
		Contrat contrat = null;
		logger.info("Find Cours : ");
		logger.debug(ENTRDEB);
		try {

			contrat = contratRepository.findById((long) Long.parseLong(id)).isPresent()
					? contratRepository.findById((long) Long.parseLong(id)).get()
					: null;

			return contrat;
		} catch (Exception e) {
			logger.error("Find contrat failed", e);
		}
		return null;
	}

	@Override
	public void supprimerContrat(Long contratId) {
		logger.info("Delete of contrat : ");
		logger.debug(ENTRDEB, contratId);
		try {
			((ContratServiceImpl) contratRepository).supprimerContrat(contratId);
			logger.info("Delete contrat success.");
		} catch (Exception e) {

			logger.error("Delete contrat failed", e);
		}
	}

}
