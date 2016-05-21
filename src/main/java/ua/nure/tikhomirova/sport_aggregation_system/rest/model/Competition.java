package ua.nure.tikhomirova.sport_aggregation_system.rest.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the competition database table.
 * 
 */
@Entity
@Table(name="competition")
@NamedQuery(name="Competition.findAll", query="SELECT c FROM Competition c")
public class Competition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date endDate;

	@Column(nullable=false)
	private byte open;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date startDate;

	//bi-directional many-to-one association to Place
	@ManyToOne
	@JoinColumn(name="placeId")
	private Place place;

	//bi-directional many-to-one association to Status
	@ManyToOne
	@JoinColumn(name="statusId")
	private Status status;

	//bi-directional many-to-one association to SportCompetition
	@OneToMany(mappedBy="competition", fetch=FetchType.EAGER)
	private List<SportCompetition> sportcompetitions;

	public Competition() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public byte getOpen() {
		return this.open;
	}

	public void setOpen(byte open) {
		this.open = open;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Place getPlace() {
		return this.place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<SportCompetition> getSportcompetitions() {
		return this.sportcompetitions;
	}

	public void setSportcompetitions(List<SportCompetition> sportcompetitions) {
		this.sportcompetitions = sportcompetitions;
	}

	public SportCompetition addSportcompetition(SportCompetition sportcompetition) {
		getSportcompetitions().add(sportcompetition);
		sportcompetition.setCompetition(this);

		return sportcompetition;
	}

	public SportCompetition removeSportcompetition(SportCompetition sportcompetition) {
		getSportcompetitions().remove(sportcompetition);
		sportcompetition.setCompetition(null);

		return sportcompetition;
	}

}