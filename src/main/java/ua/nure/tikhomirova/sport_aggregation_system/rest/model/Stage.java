package ua.nure.tikhomirova.sport_aggregation_system.rest.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the stage database table.
 * 
 */
@Entity
@Table(name="stage")
@NamedQuery(name="Stage.findAll", query="SELECT s FROM Stage s")
public class Stage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	//bi-directional many-to-one association to Result
	@OneToMany(mappedBy="stageBean")
	private List<Result> results;

	//bi-directional many-to-one association to SportCompetition
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="sportCompetition")
	private SportCompetition sportcompetition;

	public Stage() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Result> getResults() {
		return this.results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	public Result addResult(Result result) {
		getResults().add(result);
		result.setStageBean(this);

		return result;
	}

	public Result removeResult(Result result) {
		getResults().remove(result);
		result.setStageBean(null);

		return result;
	}

	public SportCompetition getSportcompetition() {
		return this.sportcompetition;
	}

	public void setSportcompetition(SportCompetition sportcompetition) {
		this.sportcompetition = sportcompetition;
	}

}