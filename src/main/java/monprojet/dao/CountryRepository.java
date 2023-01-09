package monprojet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import monprojet.entity.City;
import monprojet.entity.Country;

// This will be AUTO IMPLEMENTED by Spring 

public interface CountryRepository extends JpaRepository<Country, Integer> {
	
	
	@Query(value = "select sum(city.population) "
			+ " from country inner join city on country.id = city.country_id "
			+ "where country.id = :p_id", nativeQuery = true)
	public int populationPour(int p_id) ;
	
	
	@Query (value = "select country.name as name, sum(city.population) as pop" 
			+ " from country inner join city on country.id = city.country_id"
			+ " group by country.name", nativeQuery = true)

	public List<PopulationParPays> popParPays();
	
}
