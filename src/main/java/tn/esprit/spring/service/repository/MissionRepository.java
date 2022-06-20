package tn.esprit.spring.service.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.service.entities.Mission;


public interface MissionRepository extends CrudRepository<Mission, Integer> {

}
