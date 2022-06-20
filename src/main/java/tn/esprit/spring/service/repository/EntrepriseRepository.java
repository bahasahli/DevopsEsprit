package tn.esprit.spring.service.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.service.entities.Entreprise;

public interface EntrepriseRepository extends CrudRepository<Entreprise, Integer>  {
	
	
}
