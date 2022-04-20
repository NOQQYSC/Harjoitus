package hh.harjoitus.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Region {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long regionid;
	
	@Size(min=2, max=30)
	private String name;
	private String flag;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "region")
	@JsonIgnoreProperties("region")
	private List<Player> players;
	
	public Region() {}

	public Region(String name, String flag) {
		super();
		this.name = name;
		this.flag = flag;	}
	
	public void setRegionid(Long regionid) {
		this.regionid = regionid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	public Long getRegionid() {
		return regionid;
	}

	public String getName() {
		return name;
	}

	public String getFlag() {
		return flag;
	}

	public List<Player> getPlayers() {
		return players;
	}
	
	@Override
	public String toString() {
		return "Region [regionid=" + regionid + ", name=" + name + ", flag=" + flag +"]";
	}
}
