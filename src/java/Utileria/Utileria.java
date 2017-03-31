/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utileria;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.math.BigInteger;
import java.security.MessageDigest;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 *
 * @author wilver
 */
public class Utileria {
    public String hashPassword(String password)
    {
        String PasswordEncriptado="";
        try {
            MessageDigest passwordHash= MessageDigest.getInstance("MD5");
            passwordHash.update(password.getBytes());
            byte[] hashedPassword=passwordHash.digest();
            BigInteger phData=new BigInteger(1,hashedPassword);
            PasswordEncriptado=phData.toString(16);
        } catch (Exception e) {
            Mensajes.MostrarMensajeError(e.toString());
        }
        return PasswordEncriptado;
    }
    
    public void abriVentana(JInternalFrame internalFrame, JDesktopPane jdpContenedor)
    {
        jdpContenedor.add(internalFrame);
        //Dimension desktopSize = jdpContenedor.getSize();
        Dimension desktopSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension jInternalFrameSize = internalFrame.getSize();
        int width=(desktopSize.width - jInternalFrameSize.width)/2;
        int height=(desktopSize.height-40- jInternalFrameSize.height)/2;
        internalFrame.setLocation(width, height);
        internalFrame.setVisible(true);
    }
}
