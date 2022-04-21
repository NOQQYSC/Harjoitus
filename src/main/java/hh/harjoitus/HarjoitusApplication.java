package hh.harjoitus;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;


import hh.harjoitus.domain.Character;
import hh.harjoitus.domain.CharacterRepository;
import hh.harjoitus.domain.Player;
import hh.harjoitus.domain.PlayerRepository;
import hh.harjoitus.domain.Region;
import hh.harjoitus.domain.RegionRepository;
import hh.harjoitus.domain.User;
import hh.harjoitus.domain.UserRepository;

@SpringBootApplication
public class HarjoitusApplication implements WebMvcConfigurer{

	private static final Logger log = LoggerFactory.getLogger(HarjoitusApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(HarjoitusApplication.class, args);
	}
	
	
	
	@Bean
	public LocaleResolver localeResolver() {
	    CookieLocaleResolver localeResolver = new CookieLocaleResolver(); // <--- 2
	    localeResolver.setDefaultLocale(Locale.US); // <--- 3
	    return localeResolver;
	}
	
	
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
	    LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
	    localeChangeInterceptor.setParamName("localeData");
	    return localeChangeInterceptor;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry interceptorRegistry) {
	    interceptorRegistry.addInterceptor(localeChangeInterceptor());
	}
	
	@Bean
	public CommandLineRunner demo(PlayerRepository prepository, CharacterRepository crepository, UserRepository userrepository, RegionRepository rrepository) {
		return (args) -> {
			
			log.info("save some characters");
			
			Character c1 = new Character("Byleth", "https://ssb.wiki.gallery/images/8/86/BylethHeadSSBUWebsite.png");
			Character c2 = new Character("Cloud", "https://ssb.wiki.gallery/images/c/cb/CloudHeadSSBUWebsite.png");
			Character c3 = new Character("Diddy Kong", "https://ssb.wiki.gallery/images/5/5d/DiddyKongHeadSSBUWebsite.png");
			Character c4 = new Character("Wario", "https://ssb.wiki.gallery/images/7/7f/WarioHeadSSBUWebsite.png");
			Character c5 = new Character("Min Min", "https://ssb.wiki.gallery/images/f/fc/MinMinHeadSSBUWebsite.png");
			Character c6 = new Character("Fox", "https://ssb.wiki.gallery/images/c/c9/FoxHeadSSBUWebsite.png");
			Character c7 = new Character("Pyra/Mythra", "https://ssb.wiki.gallery/images/7/7c/PyraHeadSSBUWebsite.png");
			Character c8 = new Character("Dark Samus", "https://ssb.wiki.gallery/images/2/24/DarkSamusHeadSSBUWebsite.png");
			Character c9 = new Character("Pac-Man", "https://ssb.wiki.gallery/images/3/3d/Pac-ManHeadSSBUWebsite.png");
			Character c10 = new Character("Olimar", "https://ssb.wiki.gallery/images/9/97/OlimarHeadSSBUWebsite.png");
			Character c11 = new Character("Joker", "https://ssb.wiki.gallery/images/6/63/JokerHeadSSBUWebsite.png");
			Character c12 = new Character("Greninja", "https://ssb.wiki.gallery/images/7/79/GreninjaHeadSSBUWebsite.png");
			Character c13 = new Character("Palutena", "https://ssb.wiki.gallery/images/d/d7/PalutenaHeadSSBUWebsite.png");
			Character c14 = new Character("Rosalina & Luma", "https://ssb.wiki.gallery/images/6/63/RosalinaHeadSSBUWebsite.png");
			Character c15 = new Character("Mr. Game & Watch", "https://ssb.wiki.gallery/images/1/15/MrGame%26WatchHeadSSBUWebsite.png");
			Character c16 = new Character("Pikachu", "https://ssb.wiki.gallery/images/5/52/PikachuHeadSSBUWebsite.png");
			Character c17 = new Character("Incineroar", "https://ssb.wiki.gallery/images/e/e3/IncineroarHeadSSBUWebsite.png");
			Character c18 = new Character("Sheik", "https://ssb.wiki.gallery/images/1/1e/SheikHeadSSBUWebsite.png");
			Character c19 = new Character("Sonic", "https://ssb.wiki.gallery/images/b/b7/SonicHeadSSBUWebsite.png");
			Character c20 = new Character("Ken", "https://ssb.wiki.gallery/images/e/ef/KenHeadSSBUWebsite.png");
			Character c21 = new Character("R.O.B.", "https://ssb.wiki.gallery/images/b/be/ROBHeadSSBUWebsite.png");
			Character c22 = new Character("Samus", "https://ssb.wiki.gallery/images/d/d0/SamusHeadSSBUWebsite.png");
			Character c23 = new Character("Pokemon Trainer", "https://ssb.wiki.gallery/images/2/2c/Pok%C3%A9monTrainerHeadSSBUWebsite.png");
			Character c24 = new Character("Roy", "https://ssb.wiki.gallery/images/2/22/RoyHeadSSBUWebsite.png");
			Character c25 = new Character("Chrom", "https://ssb.wiki.gallery/images/7/70/ChromHeadSSBUWebsite.png");
			Character c26 = new Character("Ridley", "https://ssb.wiki.gallery/images/7/7c/RidleyHeadSSBUWebsite.png");
			Character c27 = new Character("Luigi", "https://ssb.wiki.gallery/images/9/9d/LuigiHeadSSBUWebsite.png");
			Character c28 = new Character("Steve", "https://ssb.wiki.gallery/images/4/4f/SteveHeadSSBUWebsite.png");
			Character c29 = new Character("Snake", "https://ssb.wiki.gallery/images/9/9f/SnakeHeadSSBUWebsite.png");
			Character c30 = new Character("Mario", "https://ssb.wiki.gallery/images/9/9e/MarioHeadSSBUWebsite.png");
			Character c31 = new Character("Kazuya", "https://ssb.wiki.gallery/images/8/85/KazuyaHeadSSBUWebsite.png");
			Character c32 = new Character("Yoshi", "https://ssb.wiki.gallery/images/9/93/YoshiHeadSSBUWebsite.png");
			
			crepository.save(c1);
			crepository.save(c2);
			crepository.save(c3);
			crepository.save(c4);
			crepository.save(c5);
			crepository.save(c6);
			crepository.save(c7);
			crepository.save(c8);
			crepository.save(c9);
			crepository.save(c10);
			crepository.save(c11);
			crepository.save(c12);
			crepository.save(c13);
			crepository.save(c14);
			crepository.save(c15);
			crepository.save(c16);
			crepository.save(c17);
			crepository.save(c18);
			crepository.save(c19);
			crepository.save(c20);
			crepository.save(c21);
			crepository.save(c22);
			crepository.save(c23);
			crepository.save(c24);
			crepository.save(c25);
			crepository.save(c26);
			crepository.save(c27);
			crepository.save(c28);
			crepository.save(c29);
			crepository.save(c30);
			crepository.save(c31);
			crepository.save(c32);
			
			Region r1 = new Region("Mexico", "https://flagicons.lipis.dev/flags/4x3/mx.svg");
			Region r2 = new Region("USA", "https://flagicons.lipis.dev/flags/4x3/us.svg");
			Region r3 = new Region("Japan", "https://flagicons.lipis.dev/flags/4x3/jp.svg");
			Region r4 = new Region("Germany", "https://flagicons.lipis.dev/flags/4x3/de.svg");
			Region r5 = new Region("France", "https://flagicons.lipis.dev/flags/4x3/fr.svg");
			Region r6 = new Region("Finland", "https://flagicons.lipis.dev/flags/4x3/fi.svg");
			Region r7 = new Region("Spain", "https://flagicons.lipis.dev/flags/4x3/es.svg");
			Region r8 = new Region("Netherlands", "https://flagicons.lipis.dev/flags/4x3/nl.svg");
			
			rrepository.save(r1);
			rrepository.save(r2);
			rrepository.save(r3);
			rrepository.save(r4);
			rrepository.save(r5);
			rrepository.save(r6);
			rrepository.save(r7);
			rrepository.save(r8);
			
			User user1 = new User("user", "$2a$10$hDyTx2kkbfUuQtHR7CX1tO0RB.aD5X3oFckoMfWxluvU0e7rm/8i6", "USER");
			User user2 = new User("admin", "$2a$10$RHYQWYWhUTnDPxqG5kjjfuFSdO8wuYq.ax/amu0u0ycI7/yNV2tW.", "ADMIN");
			userrepository.save(user1);
			userrepository.save(user2);
			
			log.info("save some players");
			
			Player p1 = new Player("MKLeo", rrepository.findByName("Mexico").get(0), 
					 crepository.findByName("Byleth").get(0));
			Player p2 = new Player("Sparg0", rrepository.findByName("Mexico").get(0), 
					 crepository.findByName("Cloud").get(0));
			Player p3 = new Player("Tweek", rrepository.findByName("USA").get(0), 
					 crepository.findByName("Diddy Kong").get(0));
			Player p4 = new Player("Glutonny", rrepository.findByName("France").get(0), 
					 crepository.findByName("Wario").get(0));
			Player p5 = new Player("ProtoBanham", rrepository.findByName("Japan").get(0), 
					 crepository.findByName("Min Min").get(0));
			Player p6 = new Player("Light", rrepository.findByName("USA").get(0), 
					 crepository.findByName("Fox").get(0));
			Player p7 = new Player("Cosmos", rrepository.findByName("USA").get(0), 
					 crepository.findByName("Pyra/Mythra").get(0));
			Player p8 = new Player("Sisqui", rrepository.findByName("Spain").get(0), 
					 crepository.findByName("Dark Samus").get(0));
			Player p9 = new Player("Tea", rrepository.findByName("Japan").get(0), 
					 crepository.findByName("Pac-Man").get(0));
			Player p10 = new Player("Shuton", rrepository.findByName("Japan").get(0), 
					 crepository.findByName("Olimar").get(0));
			Player p11 = new Player("Zackray", rrepository.findByName("Japan").get(0), 
					 crepository.findByName("Joker").get(0));
			Player p12 = new Player("Tarik", rrepository.findByName("Germany").get(0), 
					 crepository.findByName("Greninja").get(0));
			Player p13 = new Player("Chag", rrepository.findByName("Mexico").get(0), 
					 crepository.findByName("Palutena").get(0));
			Player p14 = new Player("Dabuz", rrepository.findByName("USA").get(0), 
					 crepository.findByName("Rosalina & Luma").get(0));
			Player p15 = new Player("Maister", rrepository.findByName("Mexico").get(0), 
					 crepository.findByName("Mr. Game & Watch").get(0));
			Player p16 = new Player("ESAM", rrepository.findByName("USA").get(0), 
					 crepository.findByName("Pikachu").get(0));
			Player p17 = new Player("Skyjay", rrepository.findByName("Mexico").get(0), 
					 crepository.findByName("Incineroar").get(0));
			Player p18 = new Player("KEN", rrepository.findByName("Japan").get(0), 
					 crepository.findByName("Sonic").get(0));
			Player p19 = new Player("AndresFn", rrepository.findByName("Spain").get(0), 
					 crepository.findByName("Ken").get(0));
			Player p20 = new Player("Mr. R", rrepository.findByName("Netherlands").get(0), 
					 crepository.findByName("Sheik").get(0));
			Player p21 = new Player("Kola", rrepository.findByName("USA").get(0), 
					 crepository.findByName("Roy").get(0));
			Player p22 = new Player("quiK", rrepository.findByName("Germany").get(0), 
					 crepository.findByName("Samus").get(0));
			Player p23 = new Player("Atelier", rrepository.findByName("Japan").get(0), 
					 crepository.findByName("Pokemon Trainer").get(0));
			Player p24 = new Player("BigBoss", rrepository.findByName("Mexico").get(0), 
					 crepository.findByName("R.O.B.").get(0));
			Player p25 = new Player("Lancelot", rrepository.findByName("Finland").get(0), 
					 crepository.findByName("Chrom").get(0));
			Player p26 = new Player("Elegant", rrepository.findByName("USA").get(0), 
					 crepository.findByName("Luigi").get(0));
			Player p27 = new Player("Yoshidora", rrepository.findByName("Japan").get(0), 
					 crepository.findByName("Yoshi").get(0));
			Player p28 = new Player("Nair^", rrepository.findByName("Mexico").get(0), 
					 crepository.findByName("Ridley").get(0));
			Player p29 = new Player("Raflow", rrepository.findByName("France").get(0), 
					 crepository.findByName("Palutena").get(0));
			Player p30 = new Player("Jake", rrepository.findByName("USA").get(0), 
					 crepository.findByName("Steve").get(0));
			Player p31 = new Player("Paseriman", rrepository.findByName("Japan").get(0), 
					 crepository.findByName("Fox").get(0));
			Player p32 = new Player("AlanDiss", rrepository.findByName("Mexico").get(0), 
					 crepository.findByName("Snake").get(0));
			
			prepository.save(p1);
			prepository.save(p2);
			prepository.save(p3);
			prepository.save(p4);
			prepository.save(p5);
			prepository.save(p6);
			prepository.save(p7);
			prepository.save(p8);
			prepository.save(p9);
			prepository.save(p10);
			prepository.save(p11);
			prepository.save(p12);
			prepository.save(p13);
			prepository.save(p14);
			prepository.save(p15);
			prepository.save(p16);
			prepository.save(p17);
			prepository.save(p18);
			prepository.save(p19);
			prepository.save(p20);
			prepository.save(p21);
			prepository.save(p22);
			prepository.save(p23);
			prepository.save(p24);
			prepository.save(p25);
			prepository.save(p26);
			prepository.save(p27);
			prepository.save(p28);
			prepository.save(p29);
			prepository.save(p30);
			prepository.save(p31);
			prepository.save(p32);
			
			
			
		};
	}
}
