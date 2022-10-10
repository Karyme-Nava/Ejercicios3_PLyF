fun obtenerPrecio(inmueble: MutableMap<String, Double>): Double{
    val metros = inmueble["metros"] ?: 0.0
    val habitaciones = inmueble["habitaciones"] ?: 0.0
    val garaje = inmueble["garage"] ?: 0.0
    val antiguedad = 2022.0 - (inmueble["anio"] ?: 0.0)
    var precio = (metros * 1000.0 + habitaciones * 5000.0 + garaje * 15000.0) * (1.0-antiguedad/100.0)
    if(inmueble["zona"] == 'B'.code.toDouble()) precio*=1.5
    return precio
}

fun buscarInmuebles(lstInmuebles: List<MutableMap<String, Double>>, presupuesto: Double): List<MutableMap<String, Double>>{
    val lstInmueblesEnPresupuesto = mutableListOf<MutableMap<String, Double>>()
    for (inmueble in lstInmuebles){
        val precio = obtenerPrecio(inmueble)
        if(precio <= presupuesto){
            inmueble.put("precio", precio)
            lstInmueblesEnPresupuesto.add(inmueble)
        }
    }
    return lstInmueblesEnPresupuesto
}

fun imprimirConFormato(lstInmuebles: List<MutableMap<String, Double>>){
    for (inmueble in lstInmuebles){
        print("{")
        for ((nombre, valor) in inmueble){
            print("$nombre = ")
            if (nombre == "zona") print(valor.toInt().toChar())
            else if(nombre == "metros" || nombre == "precio") print(String.format("%.2f", valor))
            else if(nombre == "garaje") print(valor==1.0)
            else print(valor.toInt())
            if(nombre != "precio") print(", ")
        }
        println("}")
    }
}

fun main(){
    val lstInmuebles =  listOf(
        mutableMapOf("anio" to 2000.0, "metros" to 100.0, "habitaciones" to 3.0, "garaje" to 1.0, "zona" to 'A'.code.toDouble()),
        mutableMapOf("anio" to 2012.0, "metros" to 60.0, "habitaciones" to 2.0, "garaje" to 1.0, "zona" to 'B'.code.toDouble()),
        mutableMapOf("anio" to 1980.0, "metros" to 120.0, "habitaciones" to 4.0, "garaje" to 0.0, "zona" to 'A'.code.toDouble()),
        mutableMapOf("anio" to 2005.0, "metros" to 75.0, "habitaciones" to 3.0, "garaje" to 1.0, "zona" to 'B'.code.toDouble()),
        mutableMapOf("anio" to 2015.0, "metros" to 90.0, "habitaciones" to 2.0, "garaje" to 0.0, "zona" to 'A'.code.toDouble())
    )
    val lstInmueblesEnPresupuesto = buscarInmuebles(lstInmuebles, 94000.0)
    imprimirConFormato(lstInmueblesEnPresupuesto)
}