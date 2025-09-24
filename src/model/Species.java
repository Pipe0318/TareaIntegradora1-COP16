package model;
public class Species {

	
	private String name;
	private String type;
	private String photoSP;
	private int speciesNum;
	public Species(String name, String type, String photoSP, int speciesNum) {
		this.name = name;
		this.type = type;
		this.photoSP = photoSP;
		this.speciesNum = speciesNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPhotoSP() {
		return photoSP;
	}
	public void setPhotoSP(String photoSP) {
		this.photoSP = photoSP;
	}
	public int getSpeciesNum() {
		return speciesNum;
	}
	public void setSpeciesNum(int speciesNum) {
		this.speciesNum = speciesNum;
	}
	
	
	
	
}
	