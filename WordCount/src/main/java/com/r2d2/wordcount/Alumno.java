package com.r2d2.wordcount;

/**
 * Esta clase es utilizada por ArbolAlumnos, que almacena objetos de la clase Alumno (Ejercicio 7)
*/

public class Alumno {

    private Long matricula;
    private String nombre;

    public Alumno() {

    }

    public Alumno(Long matricula, String nombre) {
        this.matricula = matricula;
        this.nombre = nombre;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int compareTo(Alumno a) {
        return this.nombre.compareTo(a.getNombre());
    }

    public int compare(Object a, Object b) {
        return ((Alumno) a).getNombre().compareTo(((Alumno) b).getNombre());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alumno other = (Alumno) obj;
        if (this.matricula != other.matricula) {
            return false;
        }

        if (this.nombre.compareTo(other.getNombre()) != 0) {
            return false;
        }

        return true;
    }
    
    public Alumno clonar(){
        return new Alumno(this.matricula, this.nombre);
    }

    @Override
    public String toString() {
        return "Alumno{" + "matricula=" + matricula + ", nombre=" + nombre + '}';
    }
    
    

}
