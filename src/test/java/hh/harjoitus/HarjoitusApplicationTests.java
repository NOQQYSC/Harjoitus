package hh.harjoitus;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import hh.harjoitus.web.CharacterController;
import hh.harjoitus.web.PlayerController;
import hh.harjoitus.web.RegionController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class HarjoitusApplicationTests {

	@Autowired
	private PlayerController pcontroller;
	
	@Autowired
	private CharacterController ccontroller;
	
	@Autowired
	private RegionController rcontroller;
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(pcontroller).isNotNull();
	}

	@Test
	public void contextLoads2() throws Exception {
		assertThat(ccontroller).isNotNull();
	}
	
	@Test
	public void contextLoads3() throws Exception {
		assertThat(rcontroller).isNotNull();
	}
	
}
