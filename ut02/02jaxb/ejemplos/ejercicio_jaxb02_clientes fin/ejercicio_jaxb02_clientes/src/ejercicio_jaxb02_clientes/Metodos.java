/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_jaxb02_clientes;

import java.util.List;
import jaxb.clientes.Clientes;
import jaxb.clientes.TipoDireccion;

/**
 *
 * @author Jose Luis Arias
 */
public class Metodos {

    /**
     * Ejercicio1
     *
     * @param listaClientes
     * @param posicion
     */
    public static void verDatosCliente(List<Clientes.Cliente> listaClientes, int posicion) {
        Clientes.Cliente cliente = listaClientes.get(posicion);
        System.out.println(cliente);
    }

    /**
     * Ejercicio2
     *
     * @param listaClientes
     */
    public static void verDatosTodosClientes(List<Clientes.Cliente> listaClientes) {

        for (int i = 0; i < listaClientes.size(); i++) {
            verDatosCliente(listaClientes, i);
        }

    }

    /**
     * Ejercicio 3
     *
     * @param listaClientes
     * @return el totasl de clientes
     */
    public static int totalClientes(List<Clientes.Cliente> listaClientes) {

        return listaClientes.size();

    }

    /**
     * Ejerciio 4
     *
     * @param listaClientes
     * @param posicion
     * @return
     */
    public static Clientes.Cliente borraClientePosicion(List<Clientes.Cliente> listaClientes, int posicion) {
        try {
            Clientes.Cliente removed = listaClientes.remove(posicion);
            return removed;
        } catch (UnsupportedOperationException e) {

            System.err.println("UnsupportedOperationException");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException");
        }

        return null;
    }

    /**
     * Ejercicio 5
     *
     * @param listaClientes
     * @param posicion
     * @param direccionNueva
     * @return true: exito false fracaso
     */
    public static boolean aniadeDireccionCliente(List<Clientes.Cliente> listaClientes, int posicion, TipoDireccion direccionNueva) {

        Clientes.Cliente cliente = listaClientes.get(posicion);

        List<TipoDireccion> listaDirecciones = cliente.getDireccion();
        if (listaDirecciones.size() < 3) {
            listaDirecciones.add(direccionNueva);
            return true;
        }
        return false;

    }

    /**
     * Ejercicio 6
     *
     * @param listaClientes
     * @param cliente
     */
    public static void aniadeCliente(List<Clientes.Cliente> listaClientes, Clientes.Cliente cliente) {
        // falta tratamiento Excepciones
        listaClientes.add(cliente);

    }

    /**
     * Ejercio 7
     *
     * @param listaClientes
     * @param posicion
     * @param direccionNueva
     * @param posicionDireccionaCambiar
     */
    public static void modificaDireccionCliente(List<Clientes.Cliente> listaClientes, int posicion, TipoDireccion direccionNueva, int posicionDireccionaCambiar) {

        Clientes.Cliente cliente = listaClientes.get(posicion);

        List<TipoDireccion> listaDirecciones = cliente.getDireccion();

        listaDirecciones.remove(posicionDireccionaCambiar);

        listaDirecciones.add(posicionDireccionaCambiar, direccionNueva);

    }

    /**
     * Ejercio 8
     *
     * @param listaClientes
     * @param posicion
     * @return blabla
     */
    public static boolean borraDireccionesSinCP(List<Clientes.Cliente> listaClientes, int posicion) {
        Clientes.Cliente cliente = listaClientes.get(posicion);

        List<TipoDireccion> listaDirecciones = cliente.getDireccion();

        for (TipoDireccion direccion : listaDirecciones) {

            if (direccion.getCp() == 0) {
                return listaDirecciones.remove(direccion);
            }

        }
        return false;

    }

    /**
     * Ejercico 9
     *
     * @param listaClientes
     * @return
     */
    public static boolean borraDireccionesSinCPTodos(List<Clientes.Cliente> listaClientes) {
        for (Clientes.Cliente cliente : listaClientes) {
            List<TipoDireccion> listaDirecciones = cliente.getDireccion();
            for (TipoDireccion direccion : listaDirecciones) {
                if (direccion.getCp() == 0) {
                    return listaDirecciones.remove(direccion);
                }
            }
        }
        return false;
    }
}
