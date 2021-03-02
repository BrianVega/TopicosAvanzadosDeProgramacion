public class controlPersonas{
      private String nombrePersona, direccionPersona, fechaCumplePersona;
      private String idPersona;
      private String telefonoPersona; 
   
   public controlPersonas(String id, String nombre, String numero, String email, String cumple){
      idPersona = id;
      nombrePersona = nombre;
      telefonoPersona = numero; 
      direccionPersona = email;
      fechaCumplePersona = cumple;
      
   }//setData
   
   public void setId(String idPersona){
      this.idPersona = idPersona;
   }//set
   public String getId(){
      return idPersona;
   }//get


   public void setNombre(String nombre){
      this.nombrePersona = nombre;
   }//set
   public String getNombre(){
      return nombrePersona;
   }//get
   
   
   public void setNumero(String numero){
      this.telefonoPersona = numero;
   }//set
   public String getNumero(){
      return telefonoPersona;
   }//get
   
   
   public void setEmail(String email){
      this.direccionPersona = email;
   }//set
   public String getEmail(){
      return direccionPersona;
   }//get
      

   public void setCumple(String cumple){
      this.fechaCumplePersona = cumple;
   }//set
   public String getCumple(){
      return fechaCumplePersona;
   }//get
   

}//classs