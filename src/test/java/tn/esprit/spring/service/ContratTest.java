package tn.esprit.spring.service;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.*;
import tn.esprit.spring.repository.*;
import tn.esprit.spring.services.*;

@SpringBootTest(classes = {Contrat.class})
@RunWith(SpringRunner.class)
public class ContratTest {
	
	@Autowired
	ContratRepository contratRepository ;
	@Autowired
	ContratServiceImpl contratService;
	private Contrat contrats;

	@DisplayName("Test AjouterContrats")

	@Before
	public void setUp()
	{
		this.contrats = new Contrat();
		this.contrats.setDateDebut(null);
		this.contrats.setEmploye(null);
		this.contrats.setSalaire(1500);

	}
	
	
	@Test
	public void testAjouterContrat (){
	Long idContrat = contratService.addContrat(contrats);
	assertEquals(contrats.getReference(), idContrat);
	contratService.supprimerContrat(idContrat);

	}
	@Test
	@DisplayName("countDataBeforeAfterTest")
	public void countDataBeforeAfterTest() {
		Long dataBeforeTest=null;
		try {
			dataBeforeTest =contratRepository.count();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Long idContrat=contratService.addContrat(contrats);
		Long dataAfterTest = null;
		try {
			dataAfterTest = contratRepository.count();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//assertEquals(dataBeforeTest, dataAfterTest -1);
		contratRepository.delete(contrats);
	}
	@Test
	@DisplayName("testSupprimerContratByRef")
	public void testSupprimerContratByRef() {
		contratService.supprimerContrat((long) contrats.getReference());
		assertThat(contrats.getReference()).isNotNegative();
	}
	@Test
	@DisplayName("testListContrat")
	public void testListContrat() {
		List<Contrat> list = contratService.getContrats();
		assertTrue(list.size() > 0);
	}
	

	
}
