/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nexp.com.app.security.model;

/**
 *
 * @author santi
 */
import nexp.com.app.model.*;

import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.Size;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Usuario;
    @NotNull
    @Column(unique = true)
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 7, max = 50)
    @Column(name = "email")
    private String email;
    @Size(min = 1, max = 25)
    @Column(name = "img_url")
    private String imgUrl;
    @NotNull
    private String password;
    @OneToMany(mappedBy = "usuario")
    private Collection<Notificacion> notificacionCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private Collection<ClientePasajero> clientePasajeroCollection;
    @OneToMany(mappedBy = "usuario")
    private Collection<Pasajero> pasajeroCollection;
    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"),
    inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new HashSet<>();
    @OneToMany(mappedBy = "usuario")
    private Collection<Compra> compraCollection;
    @OneToMany(mappedBy = "usuario")
    private Collection<Calificacion> calificacionCollection;
    @OneToMany(mappedBy = "usuario")
    private Collection<Sugerencia> sugerenciaCollection;
    @OneToMany(mappedBy = "usuario")
    private Collection<SolicitudTour> solicitudTourCollection;


    public Usuario() {
    }

    public Usuario(int id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public Usuario(@NotNull String nombreUsuario, @NotNull String email, @NotNull String password) {
      
        this.username = nombreUsuario;
        this.email = email;
        this.password = password;
    }

    public Usuario(int id_Usuario, String username, String email, String imgUrl, String password) {
        this.id_Usuario = id_Usuario;
        this.username = username;
        this.email = email;
        this.imgUrl = imgUrl;
        this.password = password;
    }

    public int getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(int id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    
    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

    public Collection<Notificacion> notificacionCollection() {
        return notificacionCollection;
    }

    public Collection<ClientePasajero> clientePasajeroCollection() {
        return clientePasajeroCollection;
    }

    public void setClientePasajeroCollection(Collection<ClientePasajero> clientePasajeroCollection) {
        this.clientePasajeroCollection = clientePasajeroCollection;
    }

    public void setNotificacionCollection(Collection<Notificacion> notificacionCollection) {
        this.notificacionCollection = notificacionCollection;
    }

    public Collection<Pasajero> pasajeroCollection() {
        return pasajeroCollection;
    }

    public void setPasajeroCollection(Collection<Pasajero> pasajeroCollection) {
        this.pasajeroCollection = pasajeroCollection;
    }

    public Collection<Compra> compraCollection() {
        return compraCollection;
    }

    public void setCompraCollection(Collection<Compra> compraCollection) {
        this.compraCollection = compraCollection;
    }

    public Collection<Calificacion> calificacionCollection() {
        return calificacionCollection;
    }

    public void setCalificacionCollection(Collection<Calificacion> calificacionCollection) {
        this.calificacionCollection = calificacionCollection;
    }

    public Collection<Sugerencia> sugerenciaCollection() {
        return sugerenciaCollection;
    }

    public void setSugerenciaCollection(Collection<Sugerencia> sugerenciaCollection) {
        this.sugerenciaCollection = sugerenciaCollection;
    }

    public Collection<SolicitudTour> solicitudPaqueteCollection() {
        return solicitudTourCollection;
    }

    public void setSolicitudPaqueteCollection(Collection<SolicitudTour> solicitudTourCollection) {
        this.solicitudTourCollection = solicitudTourCollection;
    }
    
    @Override
    public String toString() {
        return "nexp.com.app.security.entity.Usuario[ idUsuario=" + id_Usuario + " ]";
    }
}