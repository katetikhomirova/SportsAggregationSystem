package ua.nure.tikhomirova.sport_aggregation_system.rest.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the competitor database table.
 * 
 */
@Entity
@Table(name="competitor")
@NamedQuery(name="Competitor.findAll", query="SELECT c FROM Competitor c")
public class Competitor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	private int position;

	//uni-directional many-to-one association to Team
	@ManyToOne
	@JoinColumn(name="teamId")
	private Team team;

	//uni-directional many-to-one association to SportCompetition
	@ManyToOne
	@JoinColumn(name="sportCompetition")
	private SportCompetition sportcompetition;

	public Competitor() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPosition() {
		return this.position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public Team getTeam() {
		return this.team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public SportCompetition getSportcompetition() {
		return this.sportcompetition;
	}

	public void setSportcompetition(SportCompetition sportcompetition) {
		this.sportcompetition = sportcompetition;
	}

}