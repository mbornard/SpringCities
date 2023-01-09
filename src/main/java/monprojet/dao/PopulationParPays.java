package monprojet.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import monprojet.entity.Country;

public interface PopulationParPays {
	String getName();
	Integer getPop();
	

}
