package ua.nure.tikhomirova.sport_aggregation_system.rest.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the standart database table.
 * 
 */
@Entity
@Table(name="standart")
@NamedQuery(name="Standart.findAll", query="SELECT s FROM Standart s")
public class Standart implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	private int ceilingAge;

	private int floorAge;

	@Column(length=1)
	private String gender;

	private int numberOfTimes;

	private int takePosition;

	private int value;

	//bi-directional many-to-one association to Sport
	@ManyToOne
	@JoinColumn(name="sportId", nullable=false)
	private Sport sport;

	//bi-directional many-to-one association to Sportrank
	@ManyToOne
	@JoinColumn(name="sportRank", nullable=false)
	private Sportrank sportrank;

	//bi-directional many-to-one association to Unit
	@ManyToOne
	@JoinColumn(name="units")
	private Unit unit;

	public Standart() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCeilingAge() {
		return this.ceilingAge;
	}

	public void setCeilingAge(int ceilingAge) {
		this.ceilingAge = ceilingAge;
	}

	public int getFloorAge() {
		return this.floorAge;
	}

	public void setFloorAge(int floorAge) {
		this.floorAge = floorAge;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getNumberOfTimes() {
		return this.numberOfTimes;
	}

	public void setNumberOfTimes(int numberOfTimes) {
		this.numberOfTimes = numberOfTimes;
	}

	public int getTakePosition() {
		return this.takePosition;
	}

	public void setTakePosition(int takePosition) {
		this.takePosition = takePosition;
	}

	public int getValue() {
		return this.value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Sport getSport() {
		return this.sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

	public Sportrank getSportrank() {
		return this.sportrank;
	}

	public void setSportrank(Sportrank sportrank) {
		this.sportrank = sportrank;
	}

	public Unit getUnit() {
		return this.unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

}