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
public class ArbolPalabras {

    TreeMap<String, ListaCoord> palabras;

    public ArbolPalabras() {
        palabras = new TreeMap();
    }

    public void agreagaPalabra(String palabra, int ren, int col) {
        //Buscar si la palabra ya está dada de alta en el árbol
        palabra = palabra.toUpperCase();
        //Si la palabra está en el arbol
        if (palabras.containsKey(palabra)) {
            //que esté
            palabras.get(palabra).agregaCoordenada(new Coordenada(ren, col));
        } else {
            ListaCoord listaCoordenadas = new ListaCoord();
            listaCoordenadas.agregaCoordenada(new Coordenada(ren, col));
            palabras.put(palabra, listaCoordenadas);
        }
    }

    /**
     * Esto corresponde al ejercicio 6
     */
    public String sortedOutput() {

        StringBuilder stringBuilder = new StringBuilder();
        List<Map.Entry> entryList = new ArrayList<>();

        Set set = palabras.entrySet();
        Iterator i = set.iterator();

        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            entryList.add(me);

        }

        Collections.sort(entryList, (a, b) -> ((ListaCoord) (a.getValue())).getListaCoordenadas().size() - ((ListaCoord) (b.getValue())).getListaCoordenadas().size());

        entryList.stream()
                .forEach((entry) -> {
                    stringBuilder.append(entry.getKey().toString());
                    stringBuilder.append("-> (");
                    stringBuilder.append(((ListaCoord) (entry.getValue())).getListaCoordenadas().size());
                    stringBuilder.append(")");
                    stringBuilder.append("\n");
                });

        return stringBuilder.toString();
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        Set set = palabras.entrySet();
        Iterator i = set.iterator();

        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();

            stringBuilder.append(me.getKey().toString());
            stringBuilder.append("-> (");
            stringBuilder.append(((ListaCoord) (me.getValue())).getListaCoordenadas().size());
            stringBuilder.append(")");
            stringBuilder.append(": ");
            stringBuilder.append((ListaCoord) (me.getValue()));
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
