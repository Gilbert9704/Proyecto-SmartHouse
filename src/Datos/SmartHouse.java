package Datos;

import java.util.*;
import javax.swing.JOptionPane;

import DAO.ArchivoUsr;
import GUI.RegistroFrame;

public class SmartHouse {
	
	String name = null;
	String userName = null;
	String password = null;
	String relationship = null;
	boolean doorA = false;
	boolean doorB = false;
	boolean blind = false;
	
	public HashMap <String, Usuario> usuarios = new HashMap<>();
	
	Usuario regstUsr = new Usuario(name, userName, password, relationship, doorA, doorB, blind);
	ArchivoUsr archUsr = new ArchivoUsr();
	
	public void registrarUsuario(){
		try{
			name = RegistroFrame.txfdNombre.getText();
			regstUsr.setNombre(name);
			userName = RegistroFrame.txfdNombreUsr.getText();
			regstUsr.setNombreDeUsuario(userName);
			password = RegistroFrame.txfdContrasena.getText();
			regstUsr.setContrasena(password);
			relationship = RegistroFrame.txfdParentesco.getText();
			regstUsr.setParentesco(relationship);
			doorA = RegistroFrame.chckbxAlcoba_1.isSelected();
			regstUsr.isPrtAlcoba1();
			doorB = RegistroFrame.chckbxAlcoba_2.isSelected();
			regstUsr.isPrtAlcoba2();
			blind = RegistroFrame.chckbxPersiana.isSelected();
			regstUsr.isPersiana();
			
			if ("".equals(name) || "".equals(userName) || "".equals(password) || "".equals(relationship)){
                throw new IllegalArgumentException("A�n faltan datos por completar");
            }else if (isNumeric(name) || isNumeric(relationship)){
                throw new IllegalArgumentException("El formato del nombre es incorrecto");
            }else{
            	JOptionPane.showMessageDialog(null, "Registro Exitoso");
            	/* cuando funcione esto, quitarlo
                if (usuarios.containsKey(userName)){
                    JOptionPane.showMessageDialog(null, "El nombre de usuario ya existe, ingrese uno distinto");
                }else{
                    usuarios.put(userName, new Usuario(name, userName, password, relationship, doorA, doorB, blind));
                    JOptionPane.showMessageDialog(null, "��Registro Exitoso!!");
                    //mostrarDatos();
                    //arch.almacenarDatosUsr(usuarios);
                }
                */
            }
		}catch(IllegalArgumentException iae){
			JOptionPane.showMessageDialog(null, iae.getMessage());
		}
	}
	
	private boolean isNumeric(String nombre) {  //Determina si existe algun numero en el nombre  
    	String numeros = "1234567890";			//de haberlo este formato ser�a incorrecto
    	for(int i = 0; i < nombre.length(); i++){
    	      if (numeros.indexOf(nombre.charAt(i), 0)!= -1){
    	         return true;
    	      }
    	}
    	return false;
    }
	 

}