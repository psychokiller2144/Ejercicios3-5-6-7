/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.r2d2.wordcount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author PCERF2
 */

/**
 * Esta clase es la modificada para que almacene objetos de la clase Alumno (Ejercicio 7)
*/
public class ArbolAlumnos {

    TreeMap<Long, Alumno> alumnos;

    public ArbolAlumnos() {
        alumnos = new TreeMap();
    }
    
    public void agregarAlumno(Alumno alumno){
        alumnos.put(alumno.getMatricula(), alumno);
    }
    
    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        Set set = alumnos.entrySet();
        Iterator i = set.iterator();

        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();

            stringBuilder.append(me.getKey());
            stringBuilder.append(" -> ");
            stringBuilder.append((Alumno)me.getValue());
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
