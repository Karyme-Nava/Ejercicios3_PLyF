fun nota2(calificacion: Int): String{
    return when(calificacion){
        in 95..100 -> "Excelente"
        in 85..94 -> "Notable"
        in 75..84 -> "Bueno"
        in 70..74 -> "Suficiente"
        else -> "Desempeño insuficiente"
    }
}

fun obtenerAprobadas(mapNotas: Map<String, Int>): Map<String, String>{
    val mapCalif = mutableMapOf<String, String>()
    for((asignatura, nota) in mapNotas){
        if(nota>=70) mapCalif.put(asignatura.uppercase(), nota2(nota))
    }
    return mapCalif
}

fun main(){
    val mapNotas = mapOf("Algebra" to 87, "Comprension lectora" to 65, "Fisica" to 72,
        "Etica" to 98, "Fundamentos de programacion" to 82)
    val mapAsignaturasAprobadas = obtenerAprobadas(mapNotas)
    for(r in mapAsignaturasAprobadas) println(r)
}