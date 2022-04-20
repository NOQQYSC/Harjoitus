package hh.harjoitus.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class Player {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Size(min=1, max=30)
	private String tag;
	
	@ManyToOne
	@JsonIgnoreProperties ("players")
	@JoinColumn(name = "regionid")
	private Region region;
	
	@ManyToOne
	@JsonIgnoreProperties ("players")
	@JoinColumn(name = "characterid")
	private Character character;

	public Player(String tag, Region region, Character character) {
		super();
		this.tag = tag;
		this.region = region;
		this.character = character;
	}
	
	public Player() {
		
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	public Long getId() {
		return id;
	}

	public String getTag() {
		return tag;
	}

	public Region getRegion() {
		return region;
	}

	public Character getCharacter() {
		return character;
	}

	@Override
	public String toString() {
		return "Player id=" + id + ", tag=" + tag;
	}
	
	
}
