package hh.harjoitus.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CharacterRepository extends CrudRepository<Character, Long>{

	List<Character> findByName(String name);
	
}
