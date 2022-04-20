package hh.harjoitus;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.harjoitus.domain.CharacterRepository;
import hh.harjoitus.domain.Character;
import hh.harjoitus.domain.PlayerRepository;
import hh.harjoitus.domain.RegionRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CharacterRepositoryTest {

	@Autowired
	private PlayerRepository prepository;
	
	@Autowired
	private CharacterRepository crepository;
	
	@Autowired
	private RegionRepository rrepository;
	
	 @Test
	 public void findByNameShouldReturnCharacter() {
	 List<Character> characters = crepository.findByName("Pikachu");
	 assertThat(characters).hasSize(1);
	 assertThat(characters.get(0).getName()).isEqualTo("Pikachu");
	 }
	
	@Test
	public void createNewCharacter() {
		Character character = new Character("Lucas", "https://ssb.wiki.gallery/images/3/31/LucasHeadSSBUWebsite.png");
		crepository.save(character);
		assertThat(character.getCharacterid()).isNotNull();
	};
	
	@Test
	public void deleteCharacter() {
		Character character = new Character("Lucas", "https://ssb.wiki.gallery/images/3/31/LucasHeadSSBUWebsite.png");
		crepository.delete(character);
		assertThat(character.getCharacterid()).isNull();
	}
	
}
