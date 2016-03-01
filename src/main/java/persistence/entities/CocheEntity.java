package persistence.entities;

import javax.persistence.*;

@Embeddable
public class CocheEntity {
	private String matricula;
	private String modelo;
	public CocheEntity(){}
	public CocheEntity(String matricula, String modelo){
		this.matricula = matricula;
		this.modelo = modelo;
	}
	@Override
	public String toString(){
		return "CocheEntity[matricula="+this.matricula+", modelo="+this.modelo+"]";
	}
	public String getMatricula() {
		return matricula;
	}
	public String getModelo() {
		return modelo;
	}
	
}
