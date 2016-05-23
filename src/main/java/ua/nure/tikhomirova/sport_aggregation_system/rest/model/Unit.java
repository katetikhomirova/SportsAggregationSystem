package ua.nure.tikhomirova.sport_aggregation_system.rest.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the unit database table.
 * 
 */
@Entity
@Table(name="unit")
@NamedQuery(name="Unit.findAll", query="SELECT u FROM Unit u")
public class Unit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=45)
	private String unitName;

	//bi-directional many-to-one association to Result
	@OneToMany(mappedBy="unitBean")
	private List<Result> results;

	//bi-directional many-to-one association to Standart
	@OneToMany(mappedBy="unit")
	private List<Standart> standarts;

	public Unit() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUnitName() {
		return this.unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public List<Result> getResults() {
		return this.results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	public Result addResult(Result result) {
		getResults().add(result);
		result.setUnitBean(this);

		return result;
	}

	public Result removeResult(Result result) {
		getResults().remove(result);
		result.setUnitBean(null);

		return result;
	}

	public List<Standart> getStandarts() {
		return this.standarts;
	}

	public void setStandarts(List<Standart> standarts) {
		this.standarts = standarts;
	}

	public Standart addStandart(Standart standart) {
		getStandarts().add(standart);
		standart.setUnit(this);

		return standart;
	}

	public Standart removeStandart(Standart standart) {
		getStandarts().remove(standart);
		standart.setUnit(null);

		return standart;
	}

}