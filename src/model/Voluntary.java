package model;

public class Voluntary {

	private String id;
	private String name;
	private Route[] memoria2 = new Route[3];



	
	public Voluntary(String id, String name) {
		this.id = id;
		this.name = name;

		memoria2[0] = new Route("Farallones", "Calle 16 - Universidad del Valle", "06:40", "16:00");
	 	memoria2[1] = new Route("Ladera", "Bulevar del Río", "07:00", "15:00");
        memoria2[2] = new Route("Oriente", "Bulevar del Río", "07:00", "13:00");
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
/**
 * Descripción: Agrega información adicional a una ruta predefinida del voluntario.
 * 
 * Precondición: El índice de la ruta ('routeIndex') debe ser válido (dentro del rango del arreglo 'memoria2').
 *               Los parámetros 'numParticipants', 'numGuides', 'temperature' y 'humidity' deben ser valores válidos.
 * 
 * Postcondición: Se actualiza la información de la ruta seleccionada en el arreglo 'memoria2' con los datos proporcionados.
 * 
 * @param routeIndex      El índice de la ruta a actualizar en el arreglo 'memoria2'.
 * @param numParticipants El número de participantes en la ruta.
 * @param numGuides       El número de guías en la ruta.
 * @param temperature     La temperatura en grados Celsius.
 * @param humidity        La humedad relativa.
 * 
 * @return boolean True si la ruta se actualizó correctamente, False en caso contrario (por ejemplo, si el índice de la ruta es inválido).
 */
	
	public boolean addRoute(int routeIndex, int numParticipants, int numGuides, double temperature, int humidity) {
		if (routeIndex < 0 || routeIndex >= memoria2.length) {
            return false; // Índice de ruta inválido
        }

        Route selectedRoute = memoria2[routeIndex];
        selectedRoute.setNumParticipants(numParticipants);
        selectedRoute.setNumGuides(numGuides);
        selectedRoute.setTemperature(temperature);
        selectedRoute.setHumidity(humidity);

        return true;

	}
/**
 * Descripción: Obtiene las rutas predefinidas del voluntario.
 * 
 * Precondición: Ninguna.
 * 
 * Postcondición: No se modifica ningún dato.
 * 
 * @return Route[] Un arreglo que contiene las rutas predefinidas del voluntario.
 */
	public Route[] obtenerRutas() {
		return memoria2; 
	  }

	

	

	
	 

}