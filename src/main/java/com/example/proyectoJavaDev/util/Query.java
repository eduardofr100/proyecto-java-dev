package com.example.proyectoJavaDev.util;

public class Query {

    private static String QUERY = "SELECT empresas.id_empresa,\n" +
            "       empresas.nombre_empresa,\n" +
            "       empresas.razon_social,\n" +
            "       empresas.direccion,\n" +
            "       empleados.id_empleado,\n" +
            "       empleados.nombre,\n" +
            "       empleados.ap_paterno,\n" +
            "       empleados.ap_materno,\n" +
            "       empleados.puesto,\n" +
            "       empleados.edad,\n" +
            "       empleados.genero,\n" +
            "       empleados.estado,\n" +
            "       computadoras.no_serie,\n" +
            "       computadoras.modelo,\n" +
            "       computadoras.marca,\n" +
            "       computadoras.precio\n" +
            "FROM mts_configuration_db.empresas\n" +
            "         INNER JOIN\n" +
            "     mts_configuration_db.empleados\n" +
            "         INNER JOIN\n" +
            "     mts_configuration_db.computadoras\n" +
            "     ON empresas.id_empresa = empleados.id_empresa AND\n" +
            "        empleados.id_empleado = computadoras.id_empleado;";

    public static String getQuery() {
        return QUERY;
    }
}
