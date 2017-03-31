/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utileria;

import javax.swing.JOptionPane;

/**
 *
 * @author wilver
 */
public class Mensajes {
    //metodo para mostrar mensaje de error
    public static void MostrarMensajeError(String mensajeError)
    {
        JOptionPane.showMessageDialog(null, mensajeError, "Error", JOptionPane.ERROR_MESSAGE);
    }
    //metodo para mostrar un mensaje informativo
    public static void MostrarMensaje(String mensaje)
    {
        JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
    }
}
