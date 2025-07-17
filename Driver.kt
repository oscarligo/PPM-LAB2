
// STEP 1

// Enum para la representación de los equipos.  PARTE 1
// Propiedades para el enum.    PARTE 2.


enum class Team(
    val originCountry: String,
    val yearFounded: Int,
    val wins: Int,
) {
    MCLAREN("Reino Unido",1963, 183),
    FERRARI ("Italia",1950,244),
    MERCEDES("Alemania",210,125),
    RED_BULL("Austria",2005,120),
    WILLIAMS("Reino Unido",1977,114),
    KICK_SAUBER("Suiza",1993,1),
    ASTON_MARTIN("Reino Unido",2021,0),
    ALPINE("Francia",2021,1);

    override fun toString(): String {
        return "$name: | Pais de Origen: $originCountry | Fundación: $yearFounded | Victorias: $wins |"
    }

}

// Clase de datos para los conductores.     PARTE 1
data class Driver(
    val name: String,
    val country: String,
    var team: Team,
    var carNumber: Int,
)

 // TASK 5.     PARTE 1
{
    override fun toString(): String {
        return "Conductor: | Nombre: $name | País: $country | Equipo: $team | Númro de Carro: $carNumber |"
    }
}






