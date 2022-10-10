fun esPrimo(x: Int): Boolean{
    for (i in 2..x-1){
        if(x%i == 0) return false
    }
    return true
}

fun obtenerValoresPrimos(funcion: (Int) -> Boolean, lstValores: List<Int>): List<Int>{
    val lstPrimos = mutableListOf<Int>()
    for (valor in lstValores){
        if (funcion(valor)) lstPrimos.add(valor)
    }
    return lstPrimos
}

fun main(){
    val lstValores1 = listOf(5, 60, 11, 23, 16, 106, 1698, 385, 311)
    print("Valores primos de la lista 1 = ")
    println(obtenerValoresPrimos(::esPrimo, lstValores1))
    val lstValores2 = listOf(1568, 16891, 659, 2214, 9397, 4598, 1193)
    print("Valores primos de la lista 2 = ")
    println(obtenerValoresPrimos(::esPrimo, lstValores2))
}