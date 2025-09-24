package ui;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Date;

import model.BioPlace;
import model.Route;
import model.Species;
import model.controllerCop16;
public class Cop16 {
    private controllerCop16 controladora = new controllerCop16();
    private Scanner reader = new Scanner(System.in);
    public  int i = 0;
    
    
    public static void main(String[] args) {
        Cop16 executable = new Cop16();
        executable.menu();
      
    }

     /**
     * Descripcion: Muestra el menu principal de la aplicacion
     * pre:
     * pos:
     */

    
    public void menu(){
        int opcion = 0;
        boolean salir = false;

        do{
        System.out.println("Menu Principal");
        System.out.println("1. Seleccion de rutas");
        System.out.println("2. Gestion de lugares biodiversos");
        System.out.println("3. Salir");
        opcion = reader.nextInt();
        reader.nextLine();


        switch (opcion) {
            case 1:
                seccion1();
                break;
            case 2:
                seccion2();
                break;
            
           case 3:
            System.out.println("\nGracias por usar nuestros servicios!");
                    salir = true;
                    reader.close();
                
                break;
        
            default:
                System.out.println("Opcion no valida");
                
                break;
        



        
        }
        } while(!salir);
    }
    /**
 * Descripcion: Gestiona la interacción del usuario en la sección de selección de rutas ecológicas.
 * pre: El scanner debe estar inicializado y funcionando correctamente. La controladora debe estar inicializada y funcionando correctamente
 * pos: Se captura el nombre y cédula del usuario, y se registra la ruta ecológica seleccionada.
 */
    
    
    public void seccion1(){

         
        System.out.println(" Bienvenido voluntario a la aplicación de Interacción de Rutas Ecológicas COP 16 Cali - Colombia. ");
        System.out.println("¿Cual es tu nombre?");
        String name = reader.nextLine();
        System.out.println("Por favor digite su cedula");
        String id = reader.nextLine();
        System.out.println("¡Bienvenido, "+name+"!");
        boolean resultado = controladora.registerVoluntary(name,id);

        if (resultado==true){
        System.out.println("Usuario registrada exitosamente");

        } else {
        System.out.println("Error memoria llena!");
     }
     Scanner scanner = new Scanner(System.in);
        Route[] rutas = controladora.obtenerRutas();
        System.out.println("Seleccione una ruta:");
        for (int i = 0; i < rutas.length; i++) {
            System.out.println(i + 1 + ". " + rutas[i].getName());
        }

        int opcion = scanner.nextInt() - 1; // Restamos 1 para convertir a índice
        Route rutaSeleccionada = rutas[opcion];

        if (rutaSeleccionada != null) {
            System.out.println(rutaSeleccionada);
        } else {
            System.out.println("Opción inválida");
        }
        System.out.println("¿Cuantos participantes acudiran a la caminata el dia de hoy? ");
        int numParticipants = reader.nextInt();
        rutaSeleccionada.setNumParticipants(numParticipants);
        System.out.println("Cuantos guias acudiran acudiran a la caminata el dia de hoy?");
        int numGuides = reader.nextInt();
        rutaSeleccionada.setNumGuides(numGuides);
         System.out.println("Ingresar la temperatura en grados centigrados °C");
         double temperatura = reader.nextDouble();
         rutaSeleccionada.setTemperature(temperatura);
        System.out.println("Ingresar el porcentaje de humedad relativa");
        int humidity = reader.nextInt();
        rutaSeleccionada.setHumidity(humidity);

        boolean registered = controladora.registerRoute(opcion, numParticipants, numGuides, temperatura, humidity);
        
       
        String mensajeCondiciones = rutaSeleccionada.temperatura(temperatura, humidity);
        System.out.println(mensajeCondiciones);

        String mensajeBuses = rutaSeleccionada.personasBus(numParticipants, numGuides);
        System.out.println(mensajeBuses);
       
    

    

    }
     /**
     * Descripcion: Metodo que muestra la seccion 2 del menu
     * pre:
     * pos:
     */
    public  void seccion2 () {

        System.out.println("Bienvenido voluntario a la aplicación de Gestión de Lugares Biodiversos COP 16 Cali - Colombia.");
        menu2(); 

    }

    /**
 * Descripcion: Gestiona la interacción del usuario en la gestion de lugares biodiversos
 * pre: El scanner debe estar inicializado y funcionando correctamente.
 * pos: Se captura el nombre y cédula del usuario, y se registra la ruta ecológica seleccionada.
 */
    
     
    
    public  void menu2(){
        int seleccion = 0;
        boolean salirAlMenu = false;

        do{
        
        System.out.println("Menu");
        System.out.println("1. Para registrar un lugar con Diversidad Biologia");
        System.out.println("2. Para consultar los lugares ordenados de menor a mayor con respecto al área");
        System.out.println("3. Para consultar el departamento que tiene más lugares con diversidad biológica registrados hasta el momento");
        System.out.println("4. Registrar especies en un lugar");
        System.out.println("5. Modificar una especie en un lugar");
        System.out.println("6. Consultar el lugar con mas especies registradas");
        System.out.println("7. Consultar la información de las comunidades cuyos problemas son: que les falta un hospital o que les falta una escuela.");
        System.out.println("8. Para salir al menu principal");
        seleccion = reader.nextInt();
        reader.nextLine();

        switch (seleccion) {
            case 1:

                System.out.println("Has elegido registrar un lugar con Diversidad Biologia.");
                registerBioPlace();
                
                
                break;
            case 2:
                
                if(i==0){ System.out.println("No se han registrado lugares");}
                else {
                System.out.println("Has elegido consultar los lugares ordenados de menor a mayor con respecto al área");
                organizePlaceByArea();}
                
                break;
            case 3:
                if(i==0){System.out.println("No se han registrado lugares");}
                else{
                System.out.println("Has elegido consultar el departamento que tiene más lugares con diversidad biológica registrados hasta el momento.");
                contarDepartamentos();
                }
                
                break;

            case 4:
            if(i==0){System.out.println("No se han registrado lugares");}
            else{
            System.out.println("Has elegido registrar especies en un lugar");
            registerSpecies();
            }
            
            break;
            case 5:
            if(i==0){System.out.println("No se han registrado lugares");}
            else{
            System.out.println("Has elegido modificar especies en un lugar");
            updateSpecies();
            }
            break;

            case 6:

            if(i==0){System.out.println("No se han registrado lugares");}
            else{
            System.out.println("Has elegido consultar el lugar con mas especies registradas");
            contarLugarConMasEspecies();
            
            
            }
            
            break;

            case 7:

            if(i==0){System.out.println("No se han registrado lugares");}
            else{
            System.out.println("Has elegido Consultar la información de las comunidades cuyos problemas son: que les falta un hospital o que les falta una escuela.");
            consultarComunidadesConProblemas();
            
            
            }

            break;


            case 8: 
            System.out.println("Volviendo al menu principal....");
            
            
            break;


            default:
            System.out.println("Opción no válida. Digite de nuevo");
            
            break;
        }
       
        }while (seleccion!=8);



        



    }

    /**
     * Descripcion: Metodo que registra un lugar biodiverso
     * pre: El scanner debe estar inicializado y funcionando correctamente
     *  La controladora debe estar incializada y funcionando correctamente 
     * Debe haber espacio disponible para registrar un nuevo lugar biodiverso
     * pos: Se creara un objeto BioPlace y se guardara en el espacio en memoria que tiene controladora
     * El contador 'i' incrementa
     * 
     */

    public  void registerBioPlace (){
        String department = "";
        String nombreValido = "";
        String nameBioPlace;
        do{
            while(true){
            System.out.println("Ingrese el nombre del lugar biodiverso");
            nameBioPlace = reader.nextLine();
            if(!controladora.analizarBioPlace(nameBioPlace)){
                System.out.println("Lugar ya registrado, digite otro");
            } else {
                nombreValido=nameBioPlace;
                break;
            }
        
        
        }
            do{
            System.out.println("Ingrese el departamento en el cual esta el lugar");
            department = reader.nextLine().trim().toLowerCase();
            if (!Arrays.asList(controladora.departamentos).contains(department)){
                System.out.println("Departamento inválido. Intenta de nuevo.");
            }
            } while (!Arrays.asList(controladora.departamentos).contains(department));

            System.out.println("Ingrese el area del lugar");
            double area = reader.nextDouble();
            reader.nextLine();

            System.out.println("Ingrese el url de la foto del lugar");
            String photo = reader.nextLine();

            System.out.println("Ingrese la fecha de inauguracion del lugar");
            String startDate = reader.nextLine();

            System.out.println("Ingrese los recursos necesarios ($) para un buen cuidado del habitat");
            double money = reader.nextDouble();
            reader.nextLine();

            controladora.place = controladora.registerPlace(nameBioPlace, department, area, photo, startDate, money);
            if (controladora.place != null){
            registerCommunity();
            registerRepresentative();

            System.out.println("Lugar ingresado con exito");
            i++;}
            else {
                System.out.println("Error no se pudo registrar el lugar");
            }


            
            
           
        }while(i<1);
        
       






    }
/**
     * Descripcion: Metodo que registra una comunidad al lugar biodiverso previamente registrado
     * pre: El scanner debe estar inicializado y funcionando correctamente
     *  La controladora debe estar incializada y funcionando correctamente 
     * Debe haberse creado un objeto BioPlace previamente
     * Debe haber espacio disponible en el arreglo de las comunidades para registrar una comunidad 
     * pos: Se creara un objeto Community y se guardara en el espacio en memoria que tiene asginado en BioPlace 
     *
     * 
     */
    

    public void registerCommunity(){
        String commType;
        String[] commIsuesType = new String[4];
        Arrays.fill(commIsuesType, "");

        System.out.println("Ingrese el nombre de la comunidad que lo habita");
        String nameCommunity = reader.nextLine();

        System.out.println("Ingrese la poblacion de la comunidad");
            
            int population = reader.nextInt();
            reader.nextLine();
        do{
            System.out.println("Ingrese el tipo de comunidad");
            commType = reader.nextLine().trim().toLowerCase();
        if (!Arrays.asList(controladora.tiposComm).contains(commType)){
            System.out.println("Tipo de comunidad inválido. Intenta de nuevo.");
        }
        } while (!Arrays.asList(controladora.tiposComm).contains(commType));

        for (int i = 0; i < 4; i++) {
            System.out.println("Ingrese el problema #" + (i + 1) + " que enfrenta la comunidad (o presione Enter para omitir):");
            String problema = reader.nextLine().trim().toLowerCase();
            if (!problema.isEmpty() && Arrays.asList(controladora.problemasComm).contains(problema)) {
                commIsuesType[i] = problema;
            } 
        };
        


            boolean resultado2 = controladora.registerCommunity(nameCommunity, population, commType, commIsuesType);

            

            
            
    }

    /**
     * Descripcion: Metodo que registra una especie a un lugar biodiverso
     * pre: El scanner debe estar inicializado y funcionando correctamente
     *  La controladora debe estar incializada y funcionando correctamente
     * El usuario debe haber seleccionado un lugar biodiverso existente  
     * Debe haber espacio disponible para registrar una nueva especie
     * pos: Se creara un objeto Species y se guardara en el espacio en memoria que tiene asignado en BioPlace
     * 
     * 
     */

    public void registerSpecies(){
        String speciesType = "";
        System.out.println(controladora.construirListaDeLugares());
        System.out.println("Ingrese el nombre de el lugar al que le desea registrar la comunidad");
        String nameBioPlace = reader.nextLine().toLowerCase();
        controladora.place = controladora.searchPlace(nameBioPlace);
        if (controladora.place != null) { // Check if a BioPlace was found
            System.out.println("Ingrese el nombre de la especie");
        String speciesName = reader.nextLine();
        do{
        System.out.println("Ingrese el tipo de la especie");
        speciesType = reader.nextLine().trim().toLowerCase();
        if(!Arrays.asList(controladora.tipoSpecie).contains(speciesType)){
            System.out.println("Tipo de especie inválido. Intenta de nuevo.");
        }
        }while (!Arrays.asList(controladora.tipoSpecie).contains(speciesType));
        System.out.println("Ingrese el url de la foto de la especie");
        String photoSp = reader.nextLine();
        System.out.println("Ingrese el numero de ejemplares de la especie en el lugar");
        int speciesNum = reader.nextInt();
        reader.nextLine();

        controladora.registerSpecies(speciesName, speciesType, photoSp, speciesNum);

        } else {
            System.out.println("BioPlace not found.");
        } 
        



    }

    /**
     * Descripcion: Metodo que registra un representante a su respectiva comunidad
     * pre: El scanner debe estar inicializado y funcionando correctamente
     *  La controladora debe estar incializada y funcionando correctamente 
     * Debe haberse creado una comunidad previamente
     * Debe haber espacio disponible para registrar un nuevo representante
     * pos: Se creara un objeto Representative y se guardara en el espacio en memoria que tiene asignado en Community
     *
     * 
     */

    public void registerRepresentative(){
        System.out.println("Ingrese el nombre del representante de la comunidad");
            String commRepresentant = reader.nextLine();

            System.out.println("Ingrese el numero de telefono del representante");
            String numRepresentant = reader.nextLine();

            controladora.registerRepresentative(commRepresentant, numRepresentant);

    }
    
    /**
     * Descripcion: Modifica la informacion de una especie previamente seleccionada
     * pre: El scanner debe estar inicializado y funcionando correctamente
     *  La controladora debe estar incializada y funcionando correctamente 
     * Debe haberse seleccionado un lugar existente y una especie existente
     * pos: Se actualizara la informacion de la especie mostrandose como quedo la informacion despues de ser modificada
     * 
     * 
     */

    public void updateSpecies(){
    String speciesName = "";
    System.out.println(controladora.construirListaDeLugares());

        System.out.println("Ingrese el nombre del lugar:");
    String nameBioPlace = reader.nextLine();

    controladora.place = controladora.searchPlace(nameBioPlace); 

    if (controladora.place != null) { 
        System.out.println(controladora.construirListaDeEspecies());
        System.out.println("Ingrese el nombre de la especie a buscar:");
        speciesName = reader.nextLine().toLowerCase();

        Species foundSpecies = controladora.searchSpecies(speciesName);

        if (foundSpecies != null) {
            System.out.println("Elija el atributo a modificar \n 1. Nombre \n 2. Tipo \n 3. Url de la Foto \n 4. Numero de ejemplares");
        int opcion = reader.nextInt();
        reader.nextLine();

        String mod="";

        switch (opcion) {
            case 1:
                System.out.println("Ingrese el nuevo nombre de la especie que desea modificar");
                mod = reader.nextLine();
                
                System.out.println("Especie modificada exitosamente");
                break;

            case 2:
            do{
                System.out.println("Ingrese el nuevo tipo de la especie que desea modificar (Flora o Fauna)");
                mod = reader.nextLine();
            if(!Arrays.asList(controladora.departamentos).contains(mod)){
                System.out.println("Tipo de especie inválido. Intenta de nuevo.");
            }
            } while (!Arrays.asList(controladora.tipoSpecie).contains(mod));
                
    
                System.out.println("Especie modificada exitosamente");
                
                break;

            case 3:
                System.out.println("Ingrese el nuevo url de la Foto de la especie que desea modificar");
                mod = reader.nextLine();
                
                System.out.println("Especie modificada exitosamente");
                
                break;

            case 4:
                System.out.println("Ingrese el nuevo numero de ejemplares de la especie que desea modificar");
                mod = reader.nextInt()+"";
                reader.nextLine();
                
                System.out.println("Especie modificada exitosamente");
                
                break;
        
            default:
                System.out.println("Opción inválida!");
                break;
        }
        
       controladora.updateSpecies(nameBioPlace,speciesName, opcion, mod);

       System.out.println(controladora.construirListaDeEspecies());
        } else {
            System.out.println("Especie no encontrada.");
        }
    } else {
        System.out.println("Lugar no encontrado.");
    }

       
    }

    /**
     * Descripcion: Metodo que cuenta las ocurrencias de los departamentos 
     * pre: La controladora debe estar incializada y funcionando correctamente 
     * Debe haber lugares registrados 
     * pos: Se mostrara el departamento con mas lugares registrados
     * 
     * 
     */

    public void contarDepartamentos(){
        String mensajeContarDepto= controladora.contarDepartamentos();
        System.out.println(mensajeContarDepto);

    }

    
    /**
     * Descripcion: Metodo que organiza los lugares por su area 
     * pre: La controladora debe estar incializada y funcionando correctamente 
     * Debe haber lugares registrados 
     * pos: Se mostrara los lugares ordenados por su area
     * 
     * 
     */


    public void organizePlaceByArea (){
        
        String mensajeArea = controladora.organizePlaceByArea();
        System.out.println(mensajeArea);

    }


    /**
     * Descripcion: Metodo que analiza cual es el lugar con mas especies registradas
     * pre: La controladora debe estar incializada y funcionando correctamente 
     * Debe haber lugares registrados 
     * Deben haber especies registradas
     * pos: Se mostrara el lugar con mas especies registradas y el numero de especies que tiene registradas
     * 
     * 
     */
    
    public void contarLugarConMasEspecies(){
        String mensajeEspecies = controladora.contarLugarConMasEspecies();
        System.out.println(mensajeEspecies);
    }

    /**
     * Descripcion: Metodo que una lista de las comunidades que reportan o "falta de escuela" o "falta de hospital"
     * pre: La controladora debe estar incializada y funcionando correctamente 
     * Debe haber lugares registrados 
     * Deben haber comunidades registradas
     * pos: Se mostrara la lista de comunidades que reportan los problemas previamente mencionados
     * 
     * 
     */


    public void consultarComunidadesConProblemas(){
        String mensajeComunidades = controladora.consultarComunidadesConProblemas();
        System.out.println(mensajeComunidades);
    }

    
}
   
       






