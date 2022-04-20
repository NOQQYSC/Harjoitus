package hh.harjoitus;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.harjoitus.domain.CharacterRepository;
import hh.harjoitus.domain.Player;
import hh.harjoitus.domain.PlayerRepository;
import hh.harjoitus.domain.RegionRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class PlayerRepositoryTest {

	@Autowired
	private PlayerRepository prepository;
	
	@Autowired
	private CharacterRepository crepository;
	
	@Autowired
	private RegionRepository rrepository;
	
	 @Test
	 public void findByNameShouldReturnPlayer() {
	 List<Player> players = prepository.findByTag("MKLeo");
	 assertThat(players).hasSize(1);
	 assertThat(players.get(0).getTag()).isEqualTo("MKLeo");
	 }
	
	@Test
	public void createNewPlayer() {
		Player player = new Player("NOQQYSC", rrepository.findByName("Finland").get(0), 
				 crepository.findByName("Incineroar").get(0));
		prepository.save(player);
		assertThat(player.getId()).isNotNull();
	};
	
	@Test
	public void deletePlayer() {
		Player player = new Player("NOQQYSC", rrepository.findByName("Finland").get(0), 
				 crepository.findByName("Incineroar").get(0));
		prepository.delete(player);
		assertThat(player.getId()).isNull();
	}
}
