/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tibha
 */
@Entity
@Table(name = "analyses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Analyses.findAll", query = "SELECT a FROM Analyses a")
    , @NamedQuery(name = "Analyses.findByIdAnalyses", query = "SELECT a FROM Analyses a WHERE a.idAnalyses = :idAnalyses")
    , @NamedQuery(name = "Analyses.findByItem", query = "SELECT a FROM Analyses a WHERE a.item = :item")
    , @NamedQuery(name = "Analyses.findByValeur", query = "SELECT a FROM Analyses a WHERE a.valeur = :valeur")})
public class Analyses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idAnalyses")
    private Integer idAnalyses;
    @Column(name = "Item")
    private String item;
    @Column(name = "Valeur")
    private String valeur;

    public Analyses() {
    }

    public Analyses(Integer idAnalyses) {
        this.idAnalyses = idAnalyses;
    }

    public Integer getIdAnalyses() {
        return idAnalyses;
    }

    public void setIdAnalyses(Integer idAnalyses) {
        this.idAnalyses = idAnalyses;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnalyses != null ? idAnalyses.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Analyses)) {
            return false;
        }
        Analyses other = (Analyses) object;
        if ((this.idAnalyses == null && other.idAnalyses != null) || (this.idAnalyses != null && !this.idAnalyses.equals(other.idAnalyses))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Analyses[ idAnalyses=" + idAnalyses + " ]";
    }
    
}
