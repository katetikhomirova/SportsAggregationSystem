package ua.nure.tikhomirova.sport_aggregation_system.rest.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the result database table.
 * 
 */
@Entity
@Table(name="result")
@NamedQuery(name="Result.findAll", query="SELECT r FROM Result r")
public class Result implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	private int result;

	//bi-directional many-to-one association to Competitor
	@ManyToOne
	@JoinColumn(name="competitor")
	private Competitor competitorBean;

	//bi-directional many-to-one association to Stage
	@ManyToOne
	@JoinColumn(name="stage")
	private Stage stageBean;

	//bi-directional many-to-one association to Unit
	@ManyToOne
	@JoinColumn(name="unit")
	private Unit unitBean;

	public Result() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getResult() {
		return this.result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public Competitor getCompetitorBean() {
		return this.competitorBean;
	}

	public void setCompetitorBean(Competitor competitorBean) {
		this.competitorBean = competitorBean;
	}

	public Stage getStageBean() {
		return this.stageBean;
	}

	public void setStageBean(Stage stageBean) {
		this.stageBean = stageBean;
	}

	public Unit getUnitBean() {
		return this.unitBean;
	}

	public void setUnitBean(Unit unitBean) {
		this.unitBean = unitBean;
	}

}