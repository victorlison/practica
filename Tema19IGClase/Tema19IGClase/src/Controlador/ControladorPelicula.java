/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Pelicula;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class ControladorPelicula {
    
    private ConexionDB4O c;
    
    public ControladorPelicula(ConexionDB4O c){
        this.c=c;
    }
    
    public ArrayList<Pelicula> consultarTodo(){
        ArrayList<Pelicula> pelis=new ArrayList<>();
        Query consulta=c.getBd().query();
        consulta.constrain(Pelicula.class);
        ObjectSet<Pelicula> res=c.consultaInterfaz(consulta);
        
        while(res.hasNext()){
            pelis.add(res.next());
        }
        return pelis;
    }
}
