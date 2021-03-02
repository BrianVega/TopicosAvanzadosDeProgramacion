import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class Inicio extends JFrame implements ActionListener{
   public JPanel inicioPanel;
   public JLabel opcLabel, idFieldLabel, nombreFieldLabel, telefonoFieldLabel, emailFieldLabel, fechaFieldLabel;
   public JButton altaButton, darAltaButton, buscarButton, buscarUserButton, eliminarButton, eliminarUserButton, modificarButton, modificarUserButton, modiDefi;
   public JTextField idTXT, nombreTXT, telefonoTXT, emailTXT, fechaTXT;
   public String auxId, auxNombre, auxEmail, auxFecha, auxTelefono, auxIdModificar, nombreNuevo, direccionNueva, fechaNueva, numeroNuevo;
   public int auxIdModificarVerificado, auxOpcModificar=0;
   static int tama = 4;
   public boolean modiValue;
   static int contPersonasArreglo = 0;// contPersonasVisible = 1;
   static controlPersonas[] acceder = new controlPersonas[tama];
   
   public Inicio(){
      this.setSize(720, 480);
      setLocationRelativeTo(null);
      setTitle("Inicio");
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      screen();
   }//atributos de la ventana de login
   
   public void actionPerformed(ActionEvent event){
      if(event.getSource() == altaButton){
         visible();
         limpiar();
         idTXT.setEditable(true);
         nombreTXT.setEditable(true);
         telefonoTXT.setEditable(true);
         emailTXT.setEditable(true);
         fechaTXT.setEditable(true);
         darAltaButton.setVisible(true);
         if(contPersonasArreglo == tama){
            darAltaButton.setVisible(false);
         }
      }
      if(event.getSource() == buscarButton){
         visible();
         limpiar();
         idTXT.setEditable(true);
         nombreTXT.setEditable(false);
         telefonoTXT.setEditable(false);
         emailTXT.setEditable(false);
         fechaTXT.setEditable(false);
         buscarUserButton.setVisible(true);
      }
      if(event.getSource() == eliminarButton){
         visible();
         limpiar();
         idTXT.setEditable(true);
         nombreTXT.setEditable(false);
         telefonoTXT.setEditable(false);
         emailTXT.setEditable(false);
         fechaTXT.setEditable(false);
         buscarUserButton.setVisible(true);
         eliminarUserButton.setVisible(true);
      }
      if(event.getSource() == modificarButton){
         visible();
         limpiar();
         idTXT.setEditable(true);
         nombreTXT.setEditable(false);
         telefonoTXT.setEditable(false);
         emailTXT.setEditable(false);
         fechaTXT.setEditable(false);
         modificarUserButton.setVisible(true);
      }
      if(event.getSource() == darAltaButton){
         altaPersona();
         if(contPersonasArreglo == tama){
            darAltaButton.setVisible(false);
         }
      }
      if(event.getSource() == buscarUserButton){
         limpiarElementos();
         buscarPersona();
      }
      if(event.getSource() == eliminarUserButton){
         limpiarElementos();
         eliminarPersona();
      }
      if(event.getSource() == modificarUserButton){
         nombreTXT.setEditable(true);
         telefonoTXT.setEditable(true);
         emailTXT.setEditable(true);
         fechaTXT.setEditable(true);
         modificarPersona();
         if(modiValue){
            modiDefi.setVisible(true);
            modificarUserButton.setVisible(false);
         }
      }
      if(event.getSource()== modiDefi){
         setearDatos();
         JOptionPane.showMessageDialog(null, "usuario modificado con exito");
         visible();
         limpiar();
         idTXT.setEditable(true);
         nombreTXT.setEditable(false);
         telefonoTXT.setEditable(false);
         emailTXT.setEditable(false);
         fechaTXT.setEditable(false);
         modificarUserButton.setVisible(true);
      }
   }//Eventos
   
   public void screen(){
      /*Elemmentos generales*/
      inicioPanel = new JPanel();
      inicioPanel.setLayout(null);
      this.getContentPane().add(inicioPanel);
      
      opcLabel = new JLabel();
      opcLabel.setOpaque(true);
      opcLabel.setText("Elija una opcion");
      opcLabel.setBounds(50, 30, 150, 30);
      inicioPanel.add(opcLabel);
      
      /*Botones*/
      altaButton = new JButton("Alta");
      altaButton.setBounds(50, 80, 100, 40);
      inicioPanel.add(altaButton);
      altaButton.addActionListener(this);
      
      buscarButton = new JButton("Buscar");
      buscarButton.setBounds(50, 150, 100, 40);
      inicioPanel.add(buscarButton);
      buscarButton.addActionListener(this);
      
      eliminarButton = new JButton("Eliminar");
      eliminarButton.setBounds(50, 220, 100, 40);
      inicioPanel.add(eliminarButton);
      eliminarButton.addActionListener(this);
      
      modificarButton = new JButton("Modificar");
      modificarButton.setBounds(50, 290, 100, 40);
      inicioPanel.add(modificarButton);
      modificarButton.addActionListener(this);
      
      darAltaButton = new JButton("Dar de alta");
      darAltaButton.setBounds(360, 380, 140, 40);
      inicioPanel.add(darAltaButton);
      darAltaButton.addActionListener(this);
      darAltaButton.setVisible(false);
      
      buscarUserButton = new JButton("Buscar usuario");
      buscarUserButton.setBounds(360, 380, 140, 40);
      inicioPanel.add(buscarUserButton);
      buscarUserButton.addActionListener(this);
      buscarUserButton.setVisible(false);
      
      eliminarUserButton = new JButton("Eliminar");
      eliminarUserButton.setBounds(520, 380, 140, 40);
      inicioPanel.add(eliminarUserButton);
      eliminarUserButton.addActionListener(this);
      eliminarUserButton.setVisible(false);
      
      modificarUserButton = new JButton("Buscar usuario");
      modificarUserButton.setBounds(360, 380, 140, 40);
      inicioPanel.add(modificarUserButton);
      modificarUserButton.addActionListener(this);
      modificarUserButton.setVisible(false);
      
      modiDefi = new JButton("Modificar");
      modiDefi.setBounds(360, 380, 140, 40);
      inicioPanel.add(modiDefi);
      modiDefi.addActionListener(this);
      modiDefi.setVisible(false);
      
      /*Etiquetas*/
      idFieldLabel = new JLabel();
      idFieldLabel.setOpaque(true);
      idFieldLabel.setText("ID");
      idFieldLabel.setBounds(360, 30, 100, 30);
      inicioPanel.add(idFieldLabel);
      idFieldLabel.setVisible(false);
      
      nombreFieldLabel = new JLabel();
      nombreFieldLabel.setOpaque(true);
      nombreFieldLabel.setText("Nombre");
      nombreFieldLabel.setBounds(360, 100, 100, 30);
      inicioPanel.add(nombreFieldLabel);
      nombreFieldLabel.setVisible(false);
      
      telefonoFieldLabel = new JLabel();
      telefonoFieldLabel.setOpaque(true);
      telefonoFieldLabel.setText("Telefono");
      telefonoFieldLabel.setBounds(360, 170, 100, 30);
      inicioPanel.add(telefonoFieldLabel);
      telefonoFieldLabel.setVisible(false);
      
      emailFieldLabel = new JLabel();
      emailFieldLabel.setOpaque(true);
      emailFieldLabel.setText("email");
      emailFieldLabel.setBounds(360, 240, 100, 30);
      inicioPanel.add(emailFieldLabel);
      emailFieldLabel.setVisible(false);
      
      fechaFieldLabel = new JLabel();
      fechaFieldLabel.setOpaque(true);
      fechaFieldLabel.setText("Fecha de nacimiento");
      fechaFieldLabel.setBounds(360, 310, 200, 30);
      inicioPanel.add(fechaFieldLabel);
      fechaFieldLabel.setVisible(false);
      
      /*Cajas de texto*/
      idTXT = new JTextField();
      idTXT.setBounds(360, 60, 300, 30);
      inicioPanel.add(idTXT);
      idTXT.setVisible(false);
      
      nombreTXT = new JTextField();
      nombreTXT.setBounds(360, 130, 300, 30);
      inicioPanel.add(nombreTXT);
      nombreTXT.setVisible(false);
      
      telefonoTXT = new JTextField();
      telefonoTXT.setBounds(360, 200, 300, 30);
      inicioPanel.add(telefonoTXT);
      telefonoTXT.setVisible(false);
      
      emailTXT = new JTextField();
      emailTXT.setBounds(360, 270, 300, 30);
      inicioPanel.add(emailTXT);
      emailTXT.setVisible(false);
      
      fechaTXT = new JTextField();
      fechaTXT.setBounds(360, 340, 300, 30);
      inicioPanel.add(fechaTXT);
      fechaTXT.setVisible(false);
   }//Elementos de la ventana
   
   public void visible(){
      idFieldLabel.setVisible(true);
      nombreFieldLabel.setVisible(true);
      telefonoFieldLabel.setVisible(true);
      emailFieldLabel.setVisible(true);
      fechaFieldLabel.setVisible(true);
      
      idTXT.setVisible(true);
      nombreTXT.setVisible(true);
      telefonoTXT.setVisible(true);
      emailTXT.setVisible(true);
      fechaTXT.setVisible(true);
   }//Vuelve visibles los elementos de la agenda
   
   public void limpiar(){
      idTXT.setText(null);
      nombreTXT.setText(null);
      telefonoTXT.setText(null);
      emailTXT.setText(null);
      fechaTXT.setText(null);
      
      darAltaButton.setVisible(false);
      buscarUserButton.setVisible(false);
      eliminarUserButton.setVisible(false);
      modificarUserButton.setVisible(false);
      modiDefi.setVisible(false);
   }//Limpiar los recuadros de la agenda
   
   public void limpiarElementos(){
      nombreTXT.setText(null);
      telefonoTXT.setText(null);
      emailTXT.setText(null);
      fechaTXT.setText(null);
   }
   
   public void vaciarCajas(){
      idTXT.setText(null);
      nombreTXT.setText(null);
      telefonoTXT.setText(null);
      emailTXT.setText(null);
      fechaTXT.setText(null);
   }
   private void altaPersona(){
      String auxNombre, auxEmail, auxCumple;
      String auxId = " ";
      int auxiliarAltas;
      String auxNumero;
      boolean flagA = true;
      //contPersonasVisible++;
      auxId = idTXT.getText();
      for(int x = 0; x < contPersonasArreglo; x++)
         if(acceder[x].getId().equals(auxId)){
            JOptionPane.showMessageDialog(null, "Este ID ya existe");
            flagA = false;
         }
         else{
    	      flagA = true;
         }
         if(flagA){
         	auxNombre = nombreTXT.getText();
        	   auxNumero = telefonoTXT.getText();
      	   auxEmail = emailTXT.getText();
      	   auxCumple = fechaTXT.getText();   
      	   acceder[contPersonasArreglo] = new controlPersonas(auxId, auxNombre, auxNumero, auxEmail, auxCumple);
      	   contPersonasArreglo++;
            JOptionPane.showMessageDialog(null, "Usuario registrado con exito");
            vaciarCajas();
         }
   }//altaPersona
   
   private void buscarPersona(){
      int auxBusquedaID;
      String auxId; 
      auxId = idTXT.getText();
      auxBusquedaID = funcionBuscar(auxId); 
      if (auxBusquedaID == -1){
         JOptionPane.showMessageDialog(null, "No se encuentra ningun usuario con este ID");
         
      }//coincidencia no encontrada
      else{
         JOptionPane.showMessageDialog(null, "Registro encontrado con exito");
         imprimir(auxBusquedaID);
      }//Coincidencia encontrada
   }//buscarPersona

private static int funcionBuscar(String auxId){
   boolean flag = false;
   int auxPosicionX = 0;
   for(int x=0; x<contPersonasArreglo; x++)
         if(acceder[x].getId().equals(auxId)){
            auxPosicionX = x;
            flag = true;
            break;
         }//if coincidencia encontrada
         else if(flag == false && x == contPersonasArreglo-1){
            auxPosicionX = -1;
         }//else coincidencia NO encontrada
   return auxPosicionX;
}//funcionBuscar

private void eliminarPersona(){
   String idEliminar;
   int idEliminarVerificado;
   idEliminar = idTXT.getText();
   idEliminarVerificado = funcionBuscar(idEliminar); 
   if(idEliminarVerificado != -1){
      imprimir(idEliminarVerificado);
      int dialogButton = JOptionPane.YES_NO_OPTION;
      int dialogResult = JOptionPane.showConfirmDialog (null, "Esta seguro de que desea eliminar el resgitro?","Warning",dialogButton);
      if(dialogResult == JOptionPane.YES_OPTION){
         acceder[idEliminarVerificado] = new controlPersonas("null", "null", "null", "null", "null");
         JOptionPane.showMessageDialog(null, "Registro eliminado con exito");
         contPersonasArreglo--;
         vaciarCajas();
      }//if
      else
         System.out.println("Operación cancelada"); //control de operacion en consola     
      }//Coincidencia encontrada
   else{
      JOptionPane.showMessageDialog(null, "No se ha encontrado ningun registro con este ID");
   }//Coincidencia NO encontrada
}//eliminarPersona

private void modificarPersona(){
   auxIdModificar = idTXT.getText();
   auxIdModificarVerificado = funcionBuscar(auxIdModificar);
   if(auxIdModificarVerificado == -1){
      JOptionPane.showMessageDialog(null, "No se ha encontrado ningun registro con este ID");
      idTXT.setEditable(true);
   }//coincidencia NO encontrada
   else{
      idTXT.setEditable(false);
      JOptionPane.showMessageDialog(null, "Registro entontrado con exito");
      imprimir(auxIdModificarVerificado);
      int dialogButton = JOptionPane.YES_NO_OPTION;
      int dialogResult = JOptionPane.showConfirmDialog (null, "quieres modificar este usuario?","Warning",dialogButton);
      if(dialogResult == JOptionPane.YES_OPTION){
         modiValue = true;
      }
      else{
         modiValue = false;
         visible();
         limpiar();
         idTXT.setEditable(true);
         nombreTXT.setEditable(false);
         telefonoTXT.setEditable(false);
         emailTXT.setEditable(false);
         fechaTXT.setEditable(false);
         modificarUserButton.setVisible(true);
      }
   }//Coincidencia encontrada
}//modificarPersona

public void setearDatos(){
   nombreNuevo = nombreTXT.getText();
   acceder[auxIdModificarVerificado] = new controlPersonas(acceder[auxIdModificarVerificado].getId(), nombreNuevo, acceder[auxIdModificarVerificado].getNumero(), acceder[auxIdModificarVerificado].getEmail(), acceder[auxIdModificarVerificado].getCumple());

   numeroNuevo = telefonoTXT.getText();
   acceder[auxIdModificarVerificado] = new controlPersonas(acceder[auxIdModificarVerificado].getId(), acceder[auxIdModificarVerificado].getNombre(), numeroNuevo, acceder[auxIdModificarVerificado].getEmail(), acceder[auxIdModificarVerificado].getCumple());

   direccionNueva = emailTXT.getText();
   acceder[auxIdModificarVerificado] = new controlPersonas(acceder[auxIdModificarVerificado].getId(), acceder[auxIdModificarVerificado].getNombre(), acceder[auxIdModificarVerificado].getNumero(), direccionNueva, acceder[auxIdModificarVerificado].getCumple());


   fechaNueva = fechaTXT.getText();
   acceder[auxIdModificarVerificado] = new controlPersonas(acceder[auxIdModificarVerificado].getId(), acceder[auxIdModificarVerificado].getNombre(), acceder[auxIdModificarVerificado].getNumero(), acceder[auxIdModificarVerificado].getEmail(), fechaNueva);
  
}
private void imprimir(int x){
   idTXT.setText(acceder[x].getId());
   nombreTXT.setText(acceder[x].getNombre());
   telefonoTXT.setText(acceder[x].getNumero());
   emailTXT.setText(acceder[x].getEmail());
   fechaTXT.setText(acceder[x].getCumple());
}//imprimir
}