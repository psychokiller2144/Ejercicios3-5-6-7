/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.r2d2.wordcount;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

/**
 *
 * @author Administrador
 */
public class Archivos {

    public static void main(String[] args) {

        ArbolPalabras arbol;

        //arbol = readFile("romeo.txt");
        //System.out.println(arbol);
        //writeFile("output.txt", arbol); //Para mandar a un archivo la salida del metodo toString() del objeto arbol (Ejercicio 5)
        //System.out.println(arbol.sortedOutput()); //Para mandar la salida ordenada del objeto arbol (Ejercicio 6)
        //Ejercicio 7
        ArbolAlumnos arbolAlumnos = new ArbolAlumnos();

        Alumno alumnos[] = new Alumno[]{
            new Alumno(new Long("321487987321"), "Gordodum Perfeckiy"),
            new Alumno(new Long("798411548721"), "Julio Alcaraz"),
            new Alumno(new Long("014946215712"), "Eduard Thomas"),
            new Alumno(new Long("998741135598"), "Caroline Nguyen"),
            new Alumno(new Long("197354987452"), "Gerónimo Lemus"),};

        Arrays.asList(alumnos).forEach(alumno -> arbolAlumnos.agregarAlumno(alumno));

        System.out.println(arbolAlumnos);

    }

    /**
     * Esto corresponde al ejercicio 5
     */
    public static void writeFile(String filename, ArbolPalabras arbol) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(arbol.toString());

        } catch (Exception e) {
            System.err.format("No se pudo escribir en el archivo '%s'.", filename);
        }
    }

    private static ArbolPalabras readFile(String filename) {
        int i, j, k;
        char[] arr;
        i = 0;
        ArbolPalabras arbol = new ArbolPalabras();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.length() < 1) {
                    continue;
                }
                //System.out.println(line);
                i++;
                arr = line.toCharArray();
                j = 0;
                while (j < arr.length) {
                    //come blancos

                    while (j < arr.length && !Character.isLetter(arr[j])) {
                        j++;
                    }
                    //come distintos de blancos
                    k = j;
                    while (k < arr.length && Character.isLetter(arr[k])) {
                        k++;
                    }
                    String palabra = line.substring(j, k);
                    arbol.agreagaPalabra(palabra, j, k);
                    j = k;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.format("No pudo leer el archivo '%s'.", filename);
            return null;
        }
        return arbol;

    }

}
