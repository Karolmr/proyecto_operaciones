package cr.ac.ucr.eii.data.cliente;

import cr.ac.ucr.eii.data.Data.Dato;


public class Cliente extends Dato {
        private Integer codigo;  
        private String cedula;
        private String nombre;
        private String direccion;
        private String telefono;
        private String correo;
        private String clasificacion;
        private String comentario;

        

    public String getnombre() {
        return nombre;
    }


    public void setnombre(String nombre) {
        this.nombre = nombre;
    }


    public String getcedula() {
        return cedula;
    }


    public void setcedula(String cedula) {
        this.cedula = cedula;
    }


    public String gettelefono() {
        return telefono;
    }


    public void settelefono(String telefono) {
        this.telefono = telefono;
    }


    public String getcorreo() {
        return correo;
    }


    public void setcorreo (String correo) {
        this.correo = correo;
    }
    
    public String toString() {
        return getcedula() + " " + getnombre();
    }

  
    public Integer getcodigo() {
        return codigo;
    }

    public void setcodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getcomentario() {
        return comentario;
    }


    public void setcomentario (String comentario) {
        this.comentario = comentario;
    }
        public String getdireccion() {
        return direccion;
    }


    public void setdireccion (String direccion) {
        this.direccion = direccion;
    }
        public String getclasificacion() {
        return clasificacion;
    }


    public void setclasificacion (String clasificacion) {
        this.clasificacion = clasificacion;
    }
}
