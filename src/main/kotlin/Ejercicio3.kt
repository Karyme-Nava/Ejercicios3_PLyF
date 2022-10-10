fun nota1(calificacion: Int): String{
    return when(calificacion){
        in 95..100 -> "Excelente"
        in 85..94 -> "Notable"
        in 75..84 -> "Bueno"
        in 70..74 -> "Suficiente"
        else -> "Desempeño insuficiente"
    }
}

fun convertirCalif(lstCalif: List<Int>): List<String>{
    val lstNotas = mutableListOf<String>()
    for (calificacion in lstCalif){
        lstNotas.add(nota1(calificacion))
    }
    return lstNotas
}

fun main(){
    val lstCalif1 = listOf(100, 81, 92, 73, 51, 98)
    println("Lista 1:")
    println(convertirCalif(lstCalif1))
    val lstCalif2 = listOf(5, 93, 46, 87, 79, 99)
    println("Lista 2:")
    println(convertirCalif(lstCalif2))
}