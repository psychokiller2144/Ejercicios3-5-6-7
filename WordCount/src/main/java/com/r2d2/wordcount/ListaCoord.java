/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.r2d2.wordcount;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author PCERF2
 */
public class ListaCoord {

    private List<Coordenada> listaCoordenadas;

    public ListaCoord() {
        listaCoordenadas = new LinkedList();
    }

    public ListaCoord(List<Coordenada> listaCoordenadas) {
        this.listaCoordenadas = listaCoordenadas;
    }

    public List<Coordenada> getListaCoordenadas() {
        return listaCoordenadas;
    }

    public void setListaCoordenadas(List<Coordenada> listaCoordenadas) {
        this.listaCoordenadas = listaCoordenadas;
    }

    public void agregaCoordenada(Coordenada c) {
        listaCoordenadas.add(c);
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        listaCoordenadas.forEach((coor) -> {
            if (stringBuilder.length() == 0) {
                stringBuilder.append(coor);
            } else {
                stringBuilder.append(",");
                stringBuilder.append(coor);
            }
        });
        return stringBuilder.toString();
    }
}
