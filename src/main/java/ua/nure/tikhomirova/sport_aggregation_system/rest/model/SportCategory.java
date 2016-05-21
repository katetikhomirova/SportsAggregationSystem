package ua.nure.tikhomirova.sport_aggregation_system.rest.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * The persistent class for the sportcategory database table.
 * 
 */
@Entity
@Table(name = "sportcategory")
@NamedQuery(name = "SportCategory.findAll", query = "SELECT s FROM SportCategory s")
public class SportCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private int id;

	@Column(nullable = false, length = 50)
	private String name;

	// bi-directional many-to-one association to Sport
	@OneToMany(mappedBy = "sportcategory", fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<Sport> sports;

	public SportCategory() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Sport> getSports() {
		return this.sports;
	}

	public void setSports(List<Sport> sports) {
		this.sports = sports;
	}

	public Sport addSport(Sport sport) {
		getSports().add(sport);
		//sport.setSportcategory(this);

		return sport;
	}

	public Sport removeSport(Sport sport) {
		getSports().remove(sport);
		//sport.setSportcategory(null);

		return sport;
	}

}