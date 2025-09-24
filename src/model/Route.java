package model;
public class Route {

	private String name;
	private String startTime;
	private String endTime;
	private String meetingPoint;
	private int numParticipants;
	private int numGuides;
	private double temperature;
	private int humidity;
	

	
	public Route(String name, String meetingPoint, String startTime, String endTime) {
		this.name = name;
		this.meetingPoint = meetingPoint;
		this.startTime = startTime;
		this.endTime = endTime;
	
	}
	public String getName() {
		return name;
	}



	public String getMeetingPoint() {
		return meetingPoint;
	}
	

	public String getStartTime() {
		return startTime;
	}

	

	public String getEndTime() {
		return endTime;
	}

	
	

	public int getNumParticipants() {
		return numParticipants;
	}

	public void setNumParticipants(int numParticipants) {
		this.numParticipants = numParticipants;
	}

	public int getNumGuides() {
		return numGuides;
	}

	public void setNumGuides(int numGuides) {
		this.numGuides = numGuides;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	/**
     * Descripcion: el metodo seleccionRutas permite seleccionar una ruta dependiendo de el nombre que digite el usuario y dar el lugar de encuentro y su horario 
     * @return string Un mensaje dependiendo de la ruta seleccionada
     */

	public String toString() {
        return "¡Excelente! la ruta " + name + " tiene como punto de Encuentro: " + meetingPoint + " iniciando a las " + startTime + " , y acabando a las " + endTime;
    }

	
   /**
 * Descripción: Determina si las condiciones climáticas son favorables para caminar por Cali.
 * 
 * Precondición: Los parámetros 'temperature' y 'humidity' deben ser valores numéricos válidos.
 * 
 * Postcondición: No se modifica ningún dato.
 * 
 * @param temperature La temperatura en grados Celsius.
 * @param humidity    La humedad relativa.
 * 
 * @return String Un mensaje que indica si hace un buen día para caminar por Cali o no, 
 *                basándose en la temperatura y la humedad proporcionadas.
 */
	
	public String temperatura(double temperature, int humidity){
        String mensajeTemp;

        if (temperature >= 20 && temperature <= 25 && humidity >= 40 && humidity <= 60) {
            mensajeTemp = "¡Hace un buen día para caminar por Cali!";
        } else {
            mensajeTemp = "No hace buen día para caminar por Cali";
        }




     return mensajeTemp;




    }

	/**
 * Descripción: Calcula el número de buses necesarios para transportar a los participantes y guías de la ruta.
 * 
 * Precondición: Los parámetros 'numParticipants' y 'numGuides' deben ser valores enteros no negativos.
 * 
 * Postcondición: No se modifica ningún dato.
 * 
 * @param numParticipants El número de participantes en la ruta.
 * @param numGuides       El número de guías en la ruta.
 * 
 * @return String Un mensaje que indica el número total de personas y el número de buses necesarios para transportarlas, 
 *                asumiendo una capacidad máxima de 25 personas por bus.
 */
	
	public  String personasBus(int numParticipants, int numGuides){
        String mensaje;

        int totalP = numParticipants + numGuides;
        int capacidadBus = 25;

        int numerodeBuses = (int) Math.ceil((double) totalP / capacidadBus);
        mensaje = "Al ser un total de " + totalP  + " personas se necesitaran un total de " +numerodeBuses+ " buses  para llevarla a cabo de manera exitosa. ¡Nos vemos en la COP16!";

        return mensaje;


    }


}