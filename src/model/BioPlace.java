package model;
import java.util.Date;
public class BioPlace {

	private double area;
	private String department;
	private String nameBioPlace;
	private String photo;
	private String startDate;
	private double money;
	private Species[] memoria4 = new Species[50];
	private Community[] memoria5 = new Community[30];
	private Community newCommunity;


	public BioPlace(String nameBioPlace, String department, double area, String photo, String startDate, Double money) {
		this.area = area;
		this.department = department;
		this.nameBioPlace = nameBioPlace;
		this.photo = photo;
		this.startDate = startDate;
		this.money = money;
	}

	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getNameBioPlace() {
		return nameBioPlace;
	}
	public void setName(String nameBioPlace) {
		this.nameBioPlace = nameBioPlace;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}

	public Species[] getMemoria4() {
		return memoria4;
	}

	public Community[] getMemoria5() {
		return memoria5;
	}

/**
 * Descripción: Agrega una nueva especie al arreglo 'memoria4' del lugar biodiverso.
 * 
 * Precondición: Los parámetros 'name', 'type', 'photoSP' y 'speciesNum' deben ser válidos.
 *               Debe haber espacio disponible en el arreglo 'memoria4' para almacenar la nueva especie.
 * 
 * Postcondición: Se crea un nuevo objeto 'Species' con la información proporcionada y se agrega al arreglo 'memoria4'.
 * 
 * @param name       El nombre de la especie.
 * @param type       El tipo de especie (flora o fauna).
 * @param photoSP    La URL de la foto de la especie.
 * @param speciesNum El número de ejemplares de la especie en el lugar.
 * 
 * @return boolean True si la especie se agregó correctamente, False en caso contrario (por ejemplo, si no hay espacio disponible en 'memoria4').
 */
	public boolean addSpecies (String name, String type, String photoSP, int speciesNum){
		Species newSpecies = new Species(name, type, photoSP, speciesNum);
		for(int l = 0; l < memoria4.length; l++){
            if (memoria4[l] == null){
            memoria4[l]= newSpecies;
            return true;
            }
        }
        return false;
	

	}
/**
 * Descripción: Agrega una nueva comunidad al arreglo 'memoria5' del lugar biodiverso.
 * 
 * Precondición: Los parámetros 'name', 'population', 'type' y 'commIsuesType' deben ser válidos.
 *               Debe haber espacio disponible en el arreglo 'memoria5' para almacenar la nueva comunidad.
 * 
 * Postcondición: Se crea un nuevo objeto 'Community' con la información proporcionada y se agrega al arreglo 'memoria5'.
 * 
 * @param name           El nombre de la comunidad.
 * @param population     La población de la comunidad.
 * @param type           El tipo de comunidad (indígena, raizal, afrocolombiano).
 * @param commIsuesType Un arreglo de cadenas de texto que representa los problemas que enfrenta la comunidad.
 * 
 * @return boolean True si la comunidad se agregó correctamente, False en caso contrario (por ejemplo, si no hay espacio disponible en 'memoria5').
 */
	public boolean addCommunity (String name, int population, String type, String[] commIsuesType){
		newCommunity = new Community (name, population, type, commIsuesType);
		for(int m = 0; m < memoria5.length; m++){
            if (memoria5[m] == null){
            memoria5[m]= newCommunity;
            return true;
            }
        }
        return false;
	
	
	}
/**
 * Descripción: Agrega un nuevo representante a la comunidad actual en el lugar biodiverso.
 * 
 * Precondición: La comunidad actual en el lugar biodiverso debe estar inicializada (es decir, una comunidad debe haberse agregado al lugar).
 *               Los parámetros 'name' y 'phoneNumber' deben ser válidos.
 *               Debe haber espacio disponible en el arreglo 'memoria6' de la comunidad para almacenar el nuevo representante.
 * 
 * Postcondición: Se delega la acción de agregar el representante al método 'addRepresentative' de la comunidad actual.
 * 
 * @param name        El nombre del representante.
 * @param phoneNumber El número de teléfono del representante.
 * 
 * @return void Este método no devuelve ningún valor.
 */
	public void addRepresentative (String name, String phoneNumber){

		newCommunity.addRepresentative(name, phoneNumber);
	}
	/**
 * Descripción: Busca una especie en el lugar biodiverso por su nombre.
 * 
 * Precondición: El parámetro 'speciesName' debe ser una cadena de texto válida.
 *               El arreglo 'memoria4' debe contener objetos 'Species'.
 * 
 * Postcondición: No se modifica ningún dato.
 * 
 * @param speciesName El nombre de la especie a buscar.
 * 
 * @return Species El objeto 'Species' encontrado con el nombre proporcionado, o null si no se encuentra ninguna especie con ese nombre.
 */
	public Species searchSpecies(String speciesName){
		for(int k=0;k<memoria4.length;k++){
            if(memoria4[k]!=null && memoria4[k].getName().toLowerCase().equals(speciesName)){
                return memoria4[k];
            }
        }
        return null; 
		

	}

	
	

}
	

