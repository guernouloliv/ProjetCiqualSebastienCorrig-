package fr.epita.TP_CIQUAL.domaine;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Aliment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String code;
	private String nom;
	private String jonesKCal;
	private String jonesKJ;
	private String ueKCal;
	private String ueKJ;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<ValeurNutritionnelle> valeurNutritionelles;
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getJonesKCal() {
		return jonesKCal;
	}
	public void setJonesKCal(String jonesKCal) {
		this.jonesKCal = jonesKCal;
	}
	public String getJonesKJ() {
		return jonesKJ;
	}
	public void setJonesKJ(String jonesKJ) {
		this.jonesKJ = jonesKJ;
	}
	public String getUeKCal() {
		return ueKCal;
	}
	public void setUeKCal(String ueKCal) {
		this.ueKCal = ueKCal;
	}
	public String getUeKJ() {
		return ueKJ;
	}
	public void setUeKJ(String ueKJ) {
		this.ueKJ = ueKJ;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<ValeurNutritionnelle> getValeurNutritionelles() {
		return valeurNutritionelles;
	}
	public void setValeurNutritionelles(List<ValeurNutritionnelle> valeurNutritionelles) {
		this.valeurNutritionelles = valeurNutritionelles;
	}

}
