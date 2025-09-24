package model;
public class Community {

	private String name;
	private int population;
	private String type;
	//private String commIsuestype;
	private Representative[] memoria6 = new Representative[30];
	private String[] commIsuesType = new String[4];
	public Community(String name, int population, String type, String[] commIsuesType) {
		this.name = name;
		this.population = population;
		this.type = type;
		if (commIsuesType != null) {
			for (int i = 0; i < this.commIsuesType.length && i < commIsuesType.length; i++) {
				this.commIsuesType[i] = commIsuesType[i];
			}
		}
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String[] getCommIsuesType() {
		return commIsuesType;
	}
	public void setCommIsuestype(String[] commIsuestype) {
		this.commIsuesType = commIsuesType;
	}

	/**
 * Descripción: Agrega un nuevo representante al arreglo 'memoria6' de la comunidad actual.
 * 
 * Precondición: Los parámetros 'name' y 'phoneNumber' deben ser válidos.
 *               Debe haber espacio disponible en el arreglo 'memoria6' para almacenar el nuevo representante.
 * 
 * Postcondición: Se crea un nuevo objeto 'Representative' con la información proporcionada y se agrega al arreglo 'memoria6'.
 * 
 * @param name        El nombre del representante.
 * @param phoneNumber El número de teléfono del representante.
 * 
 * @return boolean True si el representante se agregó correctamente, False en caso contrario (por ejemplo, si no hay espacio disponible en 'memoria6').
 */

	public boolean addRepresentative (String name, String phoneNumber){
		Representative newRepresentative = new Representative(name, phoneNumber);
		for(int l = 0; l < memoria6.length; l++){
            if (memoria6[l] == null){
            memoria6[l]= newRepresentative;
            return true;
            }
        }
        return false;
	

	
	}
	
	
}