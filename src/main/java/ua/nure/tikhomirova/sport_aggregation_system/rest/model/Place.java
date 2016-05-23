package ua.nure.tikhomirova.sport_aggregation_system.rest.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the place database table.
 * 
 */
@Entity
@Table(name = "place")
@NamedQuery(name = "Place.findAll", query = "SELECT p FROM Place p")
public class Place implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private int id;

	@Column(length = 500)
	private String description;

	private double lat;

	private double lng;

	@Column(length = 45)
	private String name;

	@Column(length = 200)
	private String address;

	// bi-directional many-to-one association to Competition
	@OneToMany(mappedBy = "place")
	private List<Competition> competitions;

	public Place() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getLat() {
		return this.lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return this.lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Competition> getCompetitions() {
		return this.competitions;
	}

	public void setCompetitions(List<Competition> competitions) {
		this.competitions = competitions;
	}

	public Competition addCompetition(Competition competition) {
		getCompetitions().add(competition);
		competition.setPlace(this);

		return competition;
	}

	public Competition removeCompetition(Competition competition) {
		getCompetitions().remove(competition);
		competition.setPlace(null);

		return competition;
	}

}