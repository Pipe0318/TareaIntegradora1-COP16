package model;
import java.util.Date;

public class controllerCop16 {

	
	public BioPlace[] memoria3;
	public Voluntary voluntario;
	public BioPlace place;
	public  String [] departamentos = {"choco", "valle", "cauca", "narino"};
	public String [] tiposComm = {"indigena", "raizal", "afrocolombiano"}; 
	public String [] problemasComm = {"falta de hospital", "falta de escuela", "falta de agua potable", "falta de acceso a alimentacion basica"};
	public String [] tipoSpecie = {"flora", "fauna"};



	public controllerCop16() {
		
		memoria3 = new BioPlace[30];

	}

	/**
 * Descripción: Registra un nuevo voluntario en el sistema.
 * 
 * Precondición: Los parámetros 'nombre' e 'id' deben ser cadenas de texto válidas.
 * 
 * Postcondición: Se crea un nuevo objeto 'Voluntario' con el nombre e ID proporcionados.
 *                El objeto 'Voluntario' se almacena en la variable 'voluntario' de la controladora.
 *                Se inicializan las rutas predefinidas para el voluntario.
 * 
 * @param nombre El nombre del voluntario.
 * @param id     El ID del voluntario.
 * 
 * @return boolean True si el voluntario se registró correctamente, False en caso contrario.
 */
	public boolean registerVoluntary(String name, String id) {
		voluntario = new Voluntary(name, id);

		return true;
	
        


	}

	/**
 * Descripción: Registra una ruta para el voluntario actual.
 * 
 * Precondición: El objeto 'voluntario' debe estar inicializado (es decir, un voluntario debe haberse registrado).
 *               El índice de la ruta ('routeIndex') debe ser válido (dentro del rango del arreglo 'memoria2' del voluntario).
 * 
 * Postcondición: Se actualiza la información de la ruta seleccionada por el voluntario con el número de participantes,
 *                el número de guías, la temperatura y la humedad.
 * 
 * @param routeIndex      El índice de la ruta a registrar en el arreglo 'memoria2' del voluntario.
 * @param numParticipants El número de participantes en la ruta.
 * @param numGuides       El número de guías en la ruta.
 * @param temperature     La temperatura en grados Celsius.
 * @param humidity        La humedad relativa.
 * 
 * @return boolean True si la ruta se registró correctamente, False en caso contrario (por ejemplo, si el índice de la ruta es inválido).
 */

	
	public boolean registerRoute(int routeIndex, int numParticipants, int numGuides, double temperature, int humidity) {
		
		return voluntario.addRoute(routeIndex, numParticipants, numGuides, temperature, humidity);
		
	
	}
	/**
 * Descripción: Obtiene las rutas predefinidas del voluntario actual.
 * 
 * Precondición: El objeto 'voluntario' debe estar inicializado (es decir, un voluntario debe haberse registrado).
 * 
 * Postcondición: No se modifica ningún dato.
 * 
 * @return Route[] Un arreglo que contiene las rutas predefinidas del voluntario.
 */


	public Route[] obtenerRutas(){
	
		return voluntario.obtenerRutas();
	}

	/**
 * Descripción: Obtiene una ruta específica del voluntario actual según su índice.
 * 
 * Precondición: El objeto 'voluntario' debe estar inicializado (es decir, un voluntario debe haberse registrado).
 *               El índice de la ruta ('indice') debe ser válido (dentro del rango del arreglo 'memoria2' del voluntario).
 * 
 * Postcondición: No se modifica ningún dato.
 * 
 * @param indice El índice de la ruta a obtener del arreglo 'memoria2' del voluntario.
 * 
 * @return Route La ruta correspondiente al índice proporcionado, o null si el índice es inválido.
 */
	public Route obtenerRutaPorIndice(int indice) {
        Route[] rutas = obtenerRutas();
        if (indice >= 0 && indice < rutas.length) {
            return rutas[indice];
        }
        return null; // Retorna null si el índice es inválido
    }

	/**
 * Descripción: Registra un nuevo lugar biodiverso en el sistema.
 * 
 * Precondición: Los parámetros 'nameBioPlace', 'department', 'area', 'photo', 'startDate' y 'money' deben ser válidos.
 *               Debe haber espacio disponible en el arreglo 'memoria3' para almacenar un nuevo lugar biodiverso.
 * 
 * Postcondición: Se crea un nuevo objeto 'BioPlace' con la información proporcionada.
 *                El objeto 'BioPlace' se almacena en el arreglo 'memoria3'.
 *                La variable 'place' de la controladora se actualiza con el nuevo 'BioPlace'.
 * 
 * @param nameBioPlace El nombre del lugar biodiverso.
 * @param department  El departamento donde se encuentra el lugar.
 * @param area        El área del lugar en kilómetros cuadrados.
 * @param photo       La URL de la foto del lugar.
 * @param startDate   La fecha de inauguración del lugar (en formato String).
 * @param money       Los recursos necesarios para el cuidado del hábitat.
 * 
 * @return BioPlace El nuevo objeto 'BioPlace' creado, o null si no hay espacio disponible en 'memoria3'.
 */ 	
	public BioPlace registerPlace(String nameBioPlace, String department, double area, String photo, String startDate, Double money) {
		BioPlace newBioPlace = new BioPlace(nameBioPlace, department, area, photo, startDate, money);
		for(int k = 0; k < memoria3.length; k++){
            if (memoria3[k] == null){
            memoria3[k]= newBioPlace;
			
            return newBioPlace;
            }
        }
        return null;
	}

	/**
 * Descripción: Registra una nueva especie en el lugar biodiverso actual ('place').
 * 
 * Precondición: El objeto 'place' debe estar inicializado (es decir, un lugar biodiverso debe haberse registrado).
 *               Los parámetros 'name', 'type', 'photoSP' y 'speciesNum' deben ser válidos.
 *               Debe haber espacio disponible en el arreglo 'memoria4' del lugar biodiverso para almacenar una nueva especie.
 * 
 * Postcondición: Se crea un nuevo objeto 'Species' con la información proporcionada.
 *                El objeto 'Species' se almacena en el arreglo 'memoria4' del lugar biodiverso actual.
 * 
 * @param name       El nombre de la especie.
 * @param type       El tipo de especie (flora o fauna).
 * @param photoSP    La URL de la foto de la especie.
 * @param speciesNum El número de ejemplares de la especie en el lugar.
 * 
 * @return boolean True si la especie se registró correctamente, False en caso contrario (por ejemplo, si no hay espacio disponible en 'memoria4').
 */
	public boolean registerSpecies(String name, String type, String photoSP, int speciesNum) {
		if(place!=null){
			place.addSpecies(name, type, photoSP, speciesNum);
		return true;}
		return false;

	}

	/**
 * Descripción: Registra una nueva comunidad en el lugar biodiverso actual ('place').
 * 
 * Precondición: El objeto 'place' debe estar inicializado (es decir, un lugar biodiverso debe haberse registrado).
 *               Los parámetros 'name', 'population', 'type' y 'commIsuesType' deben ser válidos.
 *               Debe haber espacio disponible en el arreglo 'memoria5' del lugar biodiverso para almacenar una nueva comunidad.
 * 
 * Postcondición: Se crea un nuevo objeto 'Community' con la información proporcionada.
 *                El objeto 'Community' se almacena en el arreglo 'memoria5' del lugar biodiverso actual.
 * 
 * @param name           El nombre de la comunidad.
 * @param population     La población de la comunidad.
 * @param type           El tipo de comunidad (indígena, raizal, afrocolombiano).
 * @param commIsuesType Un arreglo de cadenas de texto que representa los problemas que enfrenta la comunidad.
 * 
 * @return boolean True si la comunidad se registró correctamente, False en caso contrario (por ejemplo, si no hay espacio disponible en 'memoria5').
 */
	public boolean registerCommunity(String name, int population, String type, String[] commIsuesType) {
		if(place != null){
		place.addCommunity(name, population, type, commIsuesType);
		
		return true;}
		return false;
	}

	/**
 * Descripción: Registra un nuevo representante para la comunidad actual en el lugar biodiverso actual ('place').
 * 
 * Precondición: El objeto 'place' debe estar inicializado (es decir, un lugar biodiverso debe haberse registrado).
 *               La comunidad actual en 'place' debe estar inicializada (es decir, una comunidad debe haberse registrado en el lugar).
 *               Los parámetros 'name' y 'phoneNumber' deben ser válidos.
 *               Debe haber espacio disponible en el arreglo 'memoria6' de la comunidad para almacenar un nuevo representante.
 * 
 * Postcondición: Se crea un nuevo objeto 'Representative' con la información proporcionada.
 *                El objeto 'Representative' se almacena en el arreglo 'memoria6' de la comunidad actual en el lugar biodiverso actual.
 * 
 * @param name        El nombre del representante.
 * @param phoneNumber El número de teléfono del representante.
 * 
 * @return boolean True si el representante se registró correctamente, False en caso contrario (por ejemplo, si no hay espacio disponible en 'memoria6').
 */

	public boolean registerRepresentative(String name, String phoneNumber){
		if(place != null){
		place.addRepresentative(name,phoneNumber);
		return true;}
		return false;
	}
	/**
 * Descripción: Busca un lugar biodiverso en el sistema por su nombre.
 * 
 * Precondición: El parámetro 'nameBioPlace' debe ser una cadena de texto válida.
 *               El arreglo 'memoria3' debe contener objetos 'BioPlace'.
 * 
 * Postcondición: No se modifica ningún dato.
 * 
 * @param nameBioPlace El nombre del lugar biodiverso a buscar.
 * 
 * @return BioPlace El objeto 'BioPlace' encontrado con el nombre proporcionado, o null si no se encuentra ningún lugar con ese nombre.
 */

	public BioPlace searchPlace(String nameBioPlace) {
		for(int k=0;k<memoria3.length;k++){
            if(memoria3[k]!=null && memoria3[k].getNameBioPlace().equalsIgnoreCase(nameBioPlace)){
                return memoria3[k];
            }
        }
        return null; 
		
	}
	/**
 * Descripción: Construye una lista de nombres de lugares biodiversos registrados en el sistema.
 * 
 * Precondición: El arreglo 'memoria3' debe contener objetos 'BioPlace'.
 * 
 * Postcondición: No se modifica ningún dato.
 * 
 * @return String Una cadena de texto que contiene la lista de nombres de lugares biodiversos, separados por saltos de línea. 
 *                Si no hay lugares registrados, devuelve el mensaje "No hay lugares registrados".
 */

	public String construirListaDeLugares(){
		String lista = "";
        boolean validar = false; 
         for(int j=0; j<memoria3.length; j++){
             if(memoria3[j]!=null){
                 lista+="\n"+memoria3[j].getNameBioPlace()+ " - "+memoria3[j].getDepartment()+ " - "+memoria3[j].getArea()+"\n";
                 validar=true;
             } 
 
             
         }
         if (validar==false){
             lista = "No hay lugares registrados";
        
         }
 
         
         return lista;

	}

/**
 * Descripción: Construye una lista de nombres de especies registradas en el lugar biodiverso actual ('place').
 * 
 * Precondición: El objeto 'place' debe estar inicializado (es decir, un lugar biodiverso debe haberse registrado).
 *               El arreglo 'memoria4' del lugar biodiverso actual debe contener objetos 'Species'.
 * 
 * Postcondición: No se modifica ningún dato.
 * 
 * @return String Una cadena de texto que contiene la lista de nombres de especies, separados por saltos de línea. 
 *                Si no hay especies registradas en el lugar, devuelve el mensaje "No hay especies registradas".
 */

	public String construirListaDeEspecies(){
		String lista2 = "";
        boolean validar = false; 
         for(int j=0; j<place.getMemoria4().length; j++){
             if(place.getMemoria4()[j]!=null){
                 lista2+="\n"+place.getMemoria4()[j].getName()+ " - "+place.getMemoria4()[j].getType()+ " - "+place.getMemoria4()[j].getSpeciesNum()+"\n";
                 validar=true;
             } 
 
             
         }
         if (validar==false){
             lista2 = "No hay especies registradas";
        
         }
 
         
         return lista2;


	}
/**
 * Descripción: Analiza si un lugar biodiverso con el nombre dado ya está registrado en el sistema.
 * 
 * Precondición: El parámetro 'nameBioPlace' debe ser una cadena de texto válida.
 *               El arreglo 'memoria3' debe contener objetos 'BioPlace'.
 * 
 * Postcondición: No se modifica ningún dato.
 * 
 * @param nameBioPlace El nombre del lugar biodiverso a analizar.
 * 
 * @return boolean True si el nombre del lugar biodiverso NO está registrado en el sistema, False en caso contrario.
 */
	
	public boolean analizarBioPlace(String nameBioPlace){

        for (int v = 0; v < memoria3.length;v++){
            if(memoria3[v] != null && memoria3[v].getNameBioPlace().equals(nameBioPlace)){
             return false;
            
            }


        }
        return true;
        
    }
/**
 * Descripción: Busca una especie en el lugar biodiverso actual ('place') por su nombre.
 * 
 * Precondición: El objeto 'place' debe estar inicializado (es decir, un lugar biodiverso debe haberse registrado).
 *               El parámetro 'speciesName' debe ser una cadena de texto válida.
 *               El arreglo 'memoria4' del lugar biodiverso actual debe contener objetos 'Species'.
 * 
 * Postcondición: No se modifica ningún dato.
 * 
 * @param speciesName El nombre de la especie a buscar.
 * 
 * @return Species El objeto 'Species' encontrado con el nombre proporcionado, o null si no se encuentra ninguna especie con ese nombre en el lugar.
 */

	public Species searchSpecies(String speciesName){
		if(place!=null){
		return place.searchSpecies(speciesName);}
		else {return null;}
		


	}
/**
 * Descripción: Actualiza la información de una especie específica en un lugar biodiverso.
 * 
 * Precondición: El objeto 'place' debe estar inicializado (es decir, un lugar biodiverso debe haberse registrado).
 *               El parámetro 'speciesName' debe ser una cadena de texto válida que representa el nombre de la especie a actualizar.
 *               El parámetro 'opcion' debe ser un entero válido que indica qué atributo de la especie se va a modificar:
 *                  1: Nombre
 *                  2: Tipo
 *                  3: URL de la foto
 *                  4: Número de ejemplares
 *               El parámetro 'mod' debe ser una cadena de texto válida que representa el nuevo valor para el atributo seleccionado.
 *               La especie con el nombre 'speciesName' debe existir en el lugar biodiverso actual ('place').
 * 
 * Postcondición: Se actualiza el atributo seleccionado de la especie con el nuevo valor proporcionado en 'mod'.
 * 
 * @param speciesName El nombre de la especie a actualizar.
 * @param opcion      El número que indica qué atributo se va a modificar (1: Nombre, 2: Tipo, 3: URL de la foto, 4: Número de ejemplares).
 * @param mod         El nuevo valor para el atributo seleccionado.
 * 
 * @return String Una cadena de texto vacía. Este método no devuelve ningún valor significativo.
 */
	public String updateSpecies(String nameBioPlace, String speciesName, int opcion, String mod) {
		BioPlace consulta = searchPlace(nameBioPlace);
		Species consulta2 = consulta.searchSpecies(speciesName);
		if(consulta2 != null){
		switch (opcion) {
            case 1:
                consulta2.setName(mod);
                
                break;

            case 2:
                
                consulta2.setType(mod);
                
                break;
            case 3:
                consulta2.setPhotoSP(mod);
                
                break;
            case 4:
			int numero = Integer.parseInt(mod);
				consulta2.setSpeciesNum(numero);
                
                break;
        
            default:
                break;
        } }
		else {System.out.println("Especie no encontrada");}
        

		
		return "";
	}

	/**
 * Descripción: Ordena los lugares biodiversos registrados en el sistema de mayor a menor área y construye una cadena de texto con la información.
 * 
 * Precondición: El arreglo 'memoria3' debe contener objetos 'BioPlace'.
 * 
 * Postcondición: No se modifica el arreglo original 'memoria3'.
 * 
 * @return String Una cadena de texto que contiene la lista de lugares biodiversos ordenados por área de mayor a menor, 
 *                con el formato "nombreLugar - area km cuadrados", separados por saltos de línea. 
 *                Si no hay lugares registrados, devuelve el mensaje "No hay lugares registrados".
 */
	public String organizePlaceByArea() {
			int nonNullCount = 0;
			for (BioPlace place : memoria3) {
				if (place != null) {
					nonNullCount++;
				}
			}
		
			BioPlace[] nonNullPlaces = new BioPlace[nonNullCount]; 
			int index = 0;
			for (BioPlace place : memoria3) {
				if (place != null) {
					nonNullPlaces[index] = place;
					index++;
				}
			}
		
			
			for (int c = 0; c < nonNullPlaces.length - 1; c++) {
				int indice = c;
				for (int d = c + 1; d < nonNullPlaces.length; d++) {
					if (nonNullPlaces[d].getArea() > nonNullPlaces[indice].getArea()) {
						indice = d;
					}
				}
		
				BioPlace indicePlace = nonNullPlaces[c];
				nonNullPlaces[c] = nonNullPlaces[indice];
				nonNullPlaces[indice] = indicePlace;
			}
		
			// Build the output message
			StringBuilder mensajeCartas = new StringBuilder();
			if (nonNullPlaces.length > 0) {
				for (BioPlace place : nonNullPlaces) {
					mensajeCartas.append("\n")
								 .append(place.getNameBioPlace())
								 .append(" - ")
								 .append(place.getArea())
								 .append(" kilometros cuadrados");
				}
			} else {
				mensajeCartas.append("No hay lugares registrados");
			}
		
			return mensajeCartas.toString();
		}
/**
 * Descripción: Determina el departamento con la mayor cantidad de lugares biodiversos registrados.
 * 
 * Precondición: El arreglo 'memoria3' debe contener objetos 'BioPlace'.
 * 
 * Postcondición: No se modifica ningún dato.
 * 
 * @return String Un mensaje que indica el departamento con más lugares biodiversos registrados, 
 *                o un mensaje indicando que no hay departamentos registrados si no existen.
 */

	public  String contarDepartamentos() {
        int[] contador = new int[departamentos.length];
    
        // Contar las ocurrencias de cada departamento
        for (int j = 0; j < memoria3.length; j++) {
            for (int k = 0; k < departamentos.length; k++) {
                if (memoria3[j] != null && memoria3[j].getDepartment().equals(departamentos[k])) {
                    contador[k]++;
                }
            }
        }
    
        // Encontrar el departamento más repetido
        String mensajeDeptoRep = "";
		int max = 0;
        String deptoMasRepetido = "";
        for (int k = 0; k < departamentos.length; k++) {
            if (contador[k] > max) {
                max = contador[k];
                deptoMasRepetido = departamentos[k];
            }
        }
    
        // Mostrar el departamento más repetido
        if (max > 0) {
            mensajeDeptoRep = "El departamento con mas lugares biodiversos registrados es: " + deptoMasRepetido + " con " + max + " lugares biodiversos.";
        } else {
            mensajeDeptoRep = "No hay departamentos registrados.";
        }

		return mensajeDeptoRep;
    }
/**
 * Descripción: Determina el lugar biodiverso con la mayor cantidad de especies registradas.
 * 
 * Precondición: El arreglo 'memoria3' debe contener objetos 'BioPlace'.
 *               Los objetos 'BioPlace' pueden contener objetos 'Species' en sus arreglos 'memoria4'.
 * 
 * Postcondición: No se modifica ningún dato.
 * 
 * @return String Un mensaje que indica el lugar con más especies registradas y el número de especies, 
 *                o un mensaje indicando que no hay lugares con especies registradas si no existen.
 */
	public String contarLugarConMasEspecies(){
		int maxEspecies = 0;
		String lugarConMasEspecies = "";

		for (BioPlace lugar : memoria3) {
			if (lugar != null) {
				int numEspecies = 0;
				for (Species especie : lugar.getMemoria4()) {
					if (especie != null) {
						numEspecies++;
					}
				}
	
				if (numEspecies > maxEspecies) {
					maxEspecies = numEspecies;
					lugarConMasEspecies = lugar.getNameBioPlace();
				}
			}
		}
	
		if (maxEspecies > 0) {
			return "El lugar con más especies registradas es: " + lugarConMasEspecies + " con " + maxEspecies + " especies.";
		} else {
			return "No hay lugares con especies registradas.";
		}
	}
/**
 * Descripción: Busca y lista las comunidades que han reportado problemas específicos ("falta de escuela" o "falta de hospital").
 * 
 * Precondición: El arreglo 'memoria3' debe contener objetos 'BioPlace'.
 *               Los objetos 'BioPlace' pueden contener objetos 'Community' en sus arreglos 'memoria5'.
 *               Los objetos 'Community' deben tener un arreglo 'commIsuesType' que contiene los problemas de la comunidad.
 * 
 * Postcondición: No se modifica ningún dato.
 * 
 * @return String Una cadena de texto que contiene la lista de comunidades que reportan "falta de escuela" o "falta de hospital", 
 *                junto con el nombre del lugar biodiverso al que pertenecen y la lista completa de problemas de cada comunidad. 
 *                El formato es: "nombreComunidad - nombreLugarBiodiverso - problema1, problema2, ...". 
 *                Las comunidades se separan por saltos de línea. 
 *                Si no se encuentran comunidades con estos problemas, devuelve el mensaje "No hay comunidades con problemas de escuela u hospital.".
 */
	public String consultarComunidadesConProblemas(){
		String listaCommConProblemas = "";
    boolean hayComunidades = false;
	
	

    // Iterate over all BioPlaces
    for (int j = 0; j < memoria3.length; j++) {
        if (memoria3[j] != null) {
            // Iterate over all communities within the current BioPlace
            for (int k = 0; k < memoria3[j].getMemoria5().length; k++) {
                if (memoria3[j].getMemoria5()[k] != null) {
                    String[] problemasComunidad = memoria3[j].getMemoria5()[k].getCommIsuesType();

                    // Iterate over the problems of the community
                    for (String problema : problemasComunidad) {
                        // Check if the problem is "falta de escuela" or "falta de hospital"
                        if (problema != null && (problema.trim().toLowerCase().equals("falta de escuela".trim().toLowerCase()) || problema.trim().toLowerCase().equals("falta de hospital".trim().toLowerCase()))) {
                            listaCommConProblemas += "\n" + memoria3[j].getMemoria5()[k].getName() + " - " + memoria3[j].getNameBioPlace() + " - " + String.join(", ", problemasComunidad);
                            hayComunidades = true;
                            // No need to break here, continue checking other problems
                        } 
                    }
                }
            }
        }
    }

    if (!hayComunidades) {
        listaCommConProblemas = "No hay comunidades con problemas de escuela u hospital.";
    }

    return listaCommConProblemas;
}

	

		
    
	

	public String toString() {
		return "";
	}

}