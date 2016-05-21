package ua.nure.tikhomirova.sport_aggregation_system.rest.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * The persistent class for the sport database table.
 * 
 */
@Entity
@Table(name="sport")
@NamedQuery(name="Sport.findAll", query="SELECT s FROM Sport s")
public class Sport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false)
	private byte isCommand;

	@Column(nullable=false, length=50)
	private String name;

	//uni-directional many-to-one association to SportCategory
	@ManyToOne
	@JoinColumn(name="sportCategory")
	@JsonBackReference
	private SportCategory sportcategory;

	public Sport() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getIsCommand() {
		return this.isCommand;
	}

	public void setIsCommand(byte isCommand) {
		this.isCommand = isCommand;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SportCategory getSportcategory() {
		return this.sportcategory;
	}

	public void setSportcategory(SportCategory sportcategory) {
		this.sportcategory = sportcategory;
	}

}