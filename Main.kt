//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

print("\n****************************************  PARTE 1  **************************************************\n\n")


    println("""
        ============================================
        TASK 1: CREATE AND PRINT DRIVERS
        ============================================   
    """.trimIndent())

    // Metodo reutilizable para imprimir los detalles de un conductor

    fun driverDetails (driver: Driver) {
        println("""
        --------------------------------
        Nombre: ${driver.name}
        País: ${driver.country}
        Equipo: ${driver.team}
        Númeto de Carro: ${driver.carNumber}
        --------------------------------
    """)
    }

    // Lista de 5 conductores

    val driver1 = Driver("Oscar Piastri", "Australia", Team.MCLAREN, 81)
    val driver2 = Driver("Lewis Hamilton", "United Kingdom", Team.MERCEDES, 44)
    val driver3 = Driver("Max Verstappen", "Netherlands", Team.RED_BULL, 1)
    val driver4 = Driver("Charles Leclerc", "Monaco", Team.FERRARI, 16)
    val driver5 = Driver("Esteban Ocon", "France", Team.ALPINE, 31)

    val drivers = listOf( driver1,driver2, driver3, driver4,driver5)

    driverDetails(driver1)

    //drivers.forEach { driverDetails(it) }

    println("""
        ============================================
        TASK 2: COMPARE DRIVERS
        ============================================   
    """.trimIndent())

    /*----------------------------------------------------------------------------------------------------
       Explicación: en Kotlin existen dos tipos igualdad y desigualdad, la estructural y la referencial.
       Uno tiene el proposito de  comparar el contenido (==, !=), y otro para comparar si una referencia
       apunta al mismo objeto (====, !==).

       Cuando se comparan driver1 y driver6, una igualdad estructural, devolverá verdadero, ya que driver6
       es una instancia exactamente igual a driver1. Al usar una igualdad referencial, devolverá falso, ya
       que cada uno tiene un espacio distinto en memoria.

       Lo contrario pasa para una desigualdad.

       En casos de la vida real, una desigualdad estructural puede ser insuficiente ya que  utilizarla
       no garantiza que se esté comparando al mismo objeto en memoria y podría crear conflictos.
    ----------------------------------------------------------------------------------------------------*/

    val driver6 = Driver("Oscar Piastri", "Australia", Team.MCLAREN, 81)

    println("""
        --------------------------------
        Igualdad:
            Estructural: ${(driver1 == driver6)}
            Referencial: ${(driver1 === driver6)}
        --------------------------------   
    """)

    println("""
        --------------------------------
        Desigualdad:
            Estructural: ${(driver1 != driver6)}
            Referencial: ${(driver1 !== driver6)}
        --------------------------------   
    """)

    println("""
        ============================================
        TASK 3: COPY AND MODIFY
        ============================================   
    """.trimIndent())


    // copia de uno de los conductores haciendole algunas modificaciones.

    val driver1Copy = driver1.copy(carNumber = 10, team = Team.RED_BULL)

    println("\nConductor Original:")
    driverDetails(driver1)

    println("\nConductor con Modificaciones:")
    driverDetails(driver1Copy)

    /*----------------------------------------------------------------------------------------------------
        ¿Cómo es qué la función .copy() contribuye a la inmutabilidad y el manejo de estado seguro?

        Ya que crea un objeto nuevo sin alterar al original, permitiendo hacer modificaciones de manera s
        egura para evitar cualquier incoveniente y efecto secundario que pueda surgir de modificar un
        objeto del que dependan otras partes del código.
    ----------------------------------------------------------------------------------------------------*/

    println("""
        ============================================
        TASK 4; DESTRUCTURE A DRIVER
        ============================================   
    """.trimIndent())

    // desestructuración de un objeto

    val driverDetructure = driver1.copy()

    val (name1, country1, team1, carNumber1,) = driverDetructure

    println("""        
Conductor desestructurado:
        
        Nombre: $name1
        País: $country1
        Equipo: $team1
        Número de Carro: $carNumber1
               
    """)

    /*----------------------------------------------------------------------------------------------------
        Casos de uso en una gran base de código:

        - Contribuye a un código más limpio y legible,
        - Permite hacer múltiples retornos en una función.
        - Da acceso rápido a propiedades de un objeto.

    ----------------------------------------------------------------------------------------------------*/

    println("""
        ============================================
        TASK 5: CUSTOMIZE STRING OUTPUT 
        ============================================   
    """.trimIndent())

    // impresioó de un conductor con el metodo toString sobreescrito.

    println("\n" + driver1)

    /*----------------------------------------------------------------------------------------------------
        ¿Por qué esto beneficia los logs o debugging?

        - Da mayor legibilidad.
        - Facilita encontrar inconsistencias.
        - Evita tener que revisar manualmente cada propiedad de un objeto.

    ----------------------------------------------------------------------------------------------------*/

    print("\n****************************************  PARTE 2  **************************************************\n\n")

    println("""
        ============================================
        TASK 1: PRINT TEAM DETAILS
        ============================================   
    """.trimIndent())

    // Función para imprimir 3 hechos de un equipo utilizando when. PARTE 2

    println("")
    fun teamFacts(team: Team) {
        when (team) {
            Team.FERRARI -> println("* Ferrari es el equipo más exitoso de la F1 con ${team.wins} victorias desde ${team.yearFounded}.")
            Team.MERCEDES -> println("* Mercedes dominó la era híbrida, acumulando ${team.wins} victorias desde ${team.yearFounded}.")
            Team.RED_BULL -> println("* Red Bull, fundado en ${team.yearFounded}, es conocido por su innovación y agresividad en carrera.")
            Team.MCLAREN -> println("* McLaren, uno de los equipos históricos del Reino Unido, tiene ${team.wins} victorias desde ${team.yearFounded}.")
            Team.ASTON_MARTIN -> println("* Aston Martin es uno de los equipos más jóvenes, fundado en ${team.yearFounded}, y aún no ha conseguido una victoria.")
            Team.WILLIAMS -> println("* Williams ha tenido épocas doradas, sumando ${team.wins} victorias desde ${team.yearFounded}.")
            Team.KICK_SAUBER -> println("* Kick Sauber, conocido anteriormente como Sauber, solo ha conseguido ${team.wins} victoria en su historia.")
            Team.ALPINE -> println("* Alpine es el sucesor de Renault F1 y lleva ${team.wins} victoria desde su fundación en ${team.yearFounded}.")
        }
    }

    teamFacts(Team.RED_BULL)
    teamFacts(Team.MCLAREN)
    teamFacts(Team.FERRARI)
    println("\n")
    println("""
        ============================================
        TASK 2: SORT AND DISPLAY
        ============================================   
    """.trimIndent())

    // función para imprimir y ordenar por nombre a los equipos

    fun printAndSortTeamsByName() {
        println("\nOrden por Nombre:\n")
        Team.entries.sortedBy { it.name }.forEach { println(it) }
    }

    printAndSortTeamsByName()

    // función para imprimir y ordenar por país a los equipos.

    fun printAndSortTeamsByCountry() {
        println("\nOrden por País:\n")
        Team.entries.sortedBy { it.originCountry }.forEach { println(it) }
    }

    printAndSortTeamsByCountry()



    println("\n")
    println("""
        ============================================
        TASK 3: FILTER AND GROUO DRIVERS BY ENUM
        ============================================   
    """.trimIndent())

    val driversList = listOf(
        Driver("Oscar Piastri", "Australia", Team.MCLAREN, 81),
        Driver("Lando Norris", "United Kingdom", Team.FERRARI, 4),
        Driver("Sergio Perez", "Mexico", Team.RED_BULL, 11),
        Driver("Lewis Hamilton", "United Kingdom", Team.MERCEDES, 44),
        Driver("Carlos Sainz", "Spain", Team.FERRARI, 55)
    )

    fun groupDriversByTeam(drivers: List<Driver>) {
        val grouped = drivers.groupBy { it.team }

        println("\nAgrupación por Equipo:\n")
        grouped.forEach { (team, drivers) ->
            println("$team: ${drivers.map { it.name }}")
        }
    }

    fun teamWithMostDrivers(drivers: List<Driver>) {
        val teamCounts = drivers.groupingBy { it.team }.eachCount()
        val maxEntry = teamCounts.maxByOrNull { it.value }

        println("\nEquipo con más conductores:\n")
        maxEntry?.let { println("${it.key} con ${it.value} conductores") }
    }

    groupDriversByTeam(driversList)
    teamWithMostDrivers(driversList)


    print("\n****************************************  BONUS CHALLENGE  ***************************************************\n\n")

    println("")
    println("""
        ============================================
        National Representation
        ============================================   
    """.trimIndent())
    println("\n")
    fun countDriversByCountry(drivers: List<Driver>) {
        val countryCounts = drivers.groupingBy { it.country }.eachCount()

        println("Conductores por Pais:")
        countryCounts.forEach { (country, count) ->
            println("$country → $count conductor(es)")
        }
    }

    countDriversByCountry(driversList)

    println("")
    println("""
        ============================================
        Top Team Filte
        ============================================   
    """.trimIndent())
    println("\n")
    fun filterDriversFromTopTeams(drivers: List<Driver>) {
        val topTeamDrivers = drivers.filter { it.team.wins >= 150 }

        println("Conductores de los mejores equipos: ")
        topTeamDrivers.forEach {
            println("${it.name} de ${it.team.name} con ${it.team.wins} victorias")
        }
    }

    filterDriversFromTopTeams(driversList)


    println("")
    println("""
        ============================================
        Use of Destructuring in Higher-Order Functions
        ============================================   
    """.trimIndent())

    fun printDriverNumbers(drivers: List<Driver>) {
        println("\nNombre de los conductores y número de carro (por destructuración):")
        drivers.forEach { (name, _, _, carNumber) ->
            println("$name, con el carro #$carNumber")

        }
    }

    printDriverNumbers(drivers)

        print("\n********************************  Algorithms Using Kotlin Excercise 2  ***************************************\n\n")

        val buildings = listOf(3, 5, 4, 4, 3, 1, 3, 2)
        val direction = "West"

        fun canSeeTheSunset(buildings: List<Int>, direction: String): List<Int> {
            val sunset = mutableListOf<Int>()
            var frontBuilding = 0

            if (direction == "West") {
                for (i in buildings.indices) {
                    if (frontBuilding < buildings[i]) {
                        frontBuilding = buildings[i]
                        sunset.add(i)
                    }
                }

            } else if (direction == "East") {
                for (i in buildings.indices.reversed()) {
                    if (frontBuilding < buildings[i]) {
                        frontBuilding = buildings[i]
                        sunset.add(i)
                    }
                }

                sunset.reverse()
            }

            return sunset
        }

        println(canSeeTheSunset(buildings, direction))

        print("\n********************************  Algorithms Using Kotlin Excercise 3  ***************************************\n\n")

        val text = "aabbcc"

        fun firstNonRepeatingChar(text: String): Int {

            val chars = text.toCharArray()
            val charMap = mutableMapOf<Char, Int>()

            for (i in chars.indices) {
                val c = chars[i]
                if (charMap.containsKey(c)) {
                    charMap[c] = charMap[c]!! + 1
                } else {
                    charMap.putIfAbsent(c, 1)
                }
            }

            for (i in chars.indices) {
                if (charMap[chars[i]] == 1) {
                    return i
                }
            }

            return -1
        }

        println(firstNonRepeatingChar(text))
}








