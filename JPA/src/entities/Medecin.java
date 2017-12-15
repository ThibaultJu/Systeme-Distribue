/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tibha
 */
@Entity
@Table(name = "medecin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medecin.findAll", query = "SELECT m FROM Medecin m")
    , @NamedQuery(name = "Medecin.findByIdmedecin", query = "SELECT m FROM Medecin m WHERE m.idmedecin = :idmedecin")
    , @NamedQuery(name = "Medecin.findByNom", query = "SELECT m FROM Medecin m WHERE m.nom = :nom")
    , @NamedQuery(name = "Medecin.findByPrenom", query = "SELECT m FROM Medecin m WHERE m.prenom = :prenom")
    , @NamedQuery(name = "Medecin.findByLogin", query = "SELECT m FROM Medecin m WHERE m.login = :login")})
public class Medecin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idmedecin")
    private Integer idmedecin;
    @Column(name = "Nom")
    private String nom;
    @Column(name = "Prenom")
    private String prenom;
    @Column(name = "Login")
    private String login;
    @OneToMany(mappedBy = "refMedecin")
    private Collection<Demande> demandeCollection;

    public Medecin() {
    }

    public Medecin(Integer idmedecin) {
        this.idmedecin = idmedecin;
    }

    public Integer getIdmedecin() {
        return idmedecin;
    }

    public void setIdmedecin(Integer idmedecin) {
        this.idmedecin = idmedecin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @XmlTransient
    public Collection<Demande> getDemandeCollection() {
        return demandeCollection;
    }

    public void setDemandeCollection(Collection<Demande> demandeCollection) {
        this.demandeCollection = demandeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmedecin != null ? idmedecin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medecin)) {
            return false;
        }
        Medecin other = (Medecin) object;
        if ((this.idmedecin == null && other.idmedecin != null) || (this.idmedecin != null && !this.idmedecin.equals(other.idmedecin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Medecin[ idmedecin=" + idmedecin + " ]";
    }
    
}
