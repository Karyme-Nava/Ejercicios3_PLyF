import java.lang.Exception

fun calcularOperacion(funcion: String, x: Double): Double{
    return when(funcion){
        "seno" -> Math.sin(x)
        "coseno" -> Math.cos(x)
        "tangente" -> Math.tan(x)
        "exponencial" -> Math.exp(x)
        else -> Math.log(x)
    }
}

fun abreviar(funcion: String): String{
    return when(funcion){
        "seno" -> "sin"
        "coseno" -> "cos"
        "tangente" -> "tan"
        "exponencial" -> "exp"
        else -> " ln"
    }
}

fun formarTabla(funcion: String, limite: Int){
    println("\n -------------------------------------------------------")
    print("|")
    if (funcion=="seno" || funcion=="coseno") print("\t\t")
    else if (funcion!="exponencial") print("\t")
    println("\t\t\t\tTabla de $funcion\t\t\t\t\t|")
    println(" -------------------------------------------------------")
    println("|\t\t\tx\t\t\t|\t\t\t${abreviar(funcion)}(x)\t\t\t\t|")
    println(" -------------------------------------------------------")
    for (i in 1..limite){
        print("|\t\t\t$i\t\t\t|")
        println(String.format("\t\t\t%.10f\t\t|", calcularOperacion(funcion, i.toDouble())))
    }
    println(" -------------------------------------------------------")
}

fun main(){
    try {
        println("Ingrese el valor:")
        val num = readLine()?.toInt() as Int
        println("Ingrese la funcion a aplicar:")
        val funcion: String = readLine()?.toString() as String
        formarTabla(funcion, num)
    } catch (e: Exception){
        println("Formato no valido")
    }
}