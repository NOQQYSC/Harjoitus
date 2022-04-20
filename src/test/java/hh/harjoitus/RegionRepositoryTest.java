package hh.harjoitus;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.harjoitus.domain.CharacterRepository;
import hh.harjoitus.domain.PlayerRepository;
import hh.harjoitus.domain.Region;
import hh.harjoitus.domain.RegionRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class RegionRepositoryTest {

	@Autowired
	private PlayerRepository prepository;
	
	@Autowired
	private CharacterRepository crepository;
	
	@Autowired
	private RegionRepository rrepository;
	
	@Test
	 public void findByNameShouldReturnRegion() {
	 List<Region> regions = rrepository.findByName("Mexico");
	 assertThat(regions).hasSize(1);
	 assertThat(regions.get(0).getName()).isEqualTo("Mexico");
	 }
	
	@Test
	public void createNewRegion() {
		Region region = new Region("Sweden", "https://flagicons.lipis.dev/flags/4x3/se.svg");
		rrepository.save(region);
		assertThat(region.getRegionid()).isNotNull();
	};
	
	@Test
	public void deleteRegion() {
		Region region = new Region("Sweden", "https://flagicons.lipis.dev/flags/4x3/se.svg");
		rrepository.delete(region);
		assertThat(region.getRegionid()).isNull();
	}
	
}
