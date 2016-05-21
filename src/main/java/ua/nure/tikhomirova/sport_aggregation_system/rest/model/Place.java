package ua.nure.tikhomirova.sport_aggregation_system.rest.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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

	@Column(length = 45)
	private String name;

	private double lat;

	private double lng;

	// bi-directional many-to-one association to Competition
	@OneToMany(mappedBy = "place", fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<Competition> competitions;

	// bi-directional many-to-one association to City
	@ManyToOne
	@JoinColumn(name = "cityId")
	@JsonBackReference
	private City city;

	public Place() {
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

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
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

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

}