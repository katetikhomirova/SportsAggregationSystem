package ua.nure.tikhomirova.sport_aggregation_system.rest.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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

	//bi-directional many-to-one association to SportCompetition
	@ManyToOne
	@JoinColumn(name="sportCompetition")
	private SportCompetition sportcompetition;

	//bi-directional many-to-one association to Team
	@ManyToOne
	@JoinColumn(name="teamId")
	private Team team;

	//bi-directional many-to-one association to Result
	@OneToMany(mappedBy="competitorBean", fetch=FetchType.EAGER)
	private List<Result> results;

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

	public SportCompetition getSportcompetition() {
		return this.sportcompetition;
	}

	public void setSportcompetition(SportCompetition sportcompetition) {
		this.sportcompetition = sportcompetition;
	}

	public Team getTeam() {
		return this.team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public List<Result> getResults() {
		return this.results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	public Result addResult(Result result) {
		getResults().add(result);
		result.setCompetitorBean(this);

		return result;
	}

	public Result removeResult(Result result) {
		getResults().remove(result);
		result.setCompetitorBean(null);

		return result;
	}

}