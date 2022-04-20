package hh.harjoitus.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface RegionRepository extends CrudRepository<Region, Long>{

	List<Region> findByName(String name);
	
}
