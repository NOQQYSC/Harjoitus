package hh.harjoitus.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Character {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long characterid;
	
	@Size(min=2, max=30)
	private String name;
	private String icon;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "character")
	@JsonIgnoreProperties("character")
	private List<Player> players;
	
	public Character() {}

	public Character(String name, String icon) {
		super();
		this.name = name;
		this.icon = icon;	}

	public void setCharid(Long characterid) {
		this.characterid = characterid;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setIcon(String icon) {
		this.icon = icon;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Long getCharacterid() {
		return characterid;
	}

	public String getName() {
		return name;
	}

	public String getIcon() {
		return icon;
	}
	
	public List<Player> getPlayers() {
		return players;
	}

	@Override
	public String toString() {
		return "Character [characterid=" + characterid + ", name=" + name + ", icon=" + icon +"]";
	}
	
}
