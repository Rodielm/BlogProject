/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rodielm
 */
@Entity
@Table(name = "postcomments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Postcomments.findAll", query = "SELECT p FROM Postcomments p"),
    @NamedQuery(name = "Postcomments.findByPostCommentsID", query = "SELECT p FROM Postcomments p WHERE p.postCommentsID = :postCommentsID"),
    @NamedQuery(name = "Postcomments.findByDateCreated", query = "SELECT p FROM Postcomments p WHERE p.dateCreated = :dateCreated"),
    @NamedQuery(name = "Postcomments.findByTitle", query = "SELECT p FROM Postcomments p WHERE p.title = :title"),
    @NamedQuery(name = "Postcomments.findByBody", query = "SELECT p FROM Postcomments p WHERE p.body = :body")})
public class Postcomments implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PostCommentsID")
    private Integer postCommentsID;
    @Column(name = "dateCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Size(max = 45)
    @Column(name = "title")
    private String title;
    @Size(max = 255)
    @Column(name = "body")
    private String body;
    @JoinColumn(name = "PostID", referencedColumnName = "PostID")
    @ManyToOne(optional = false)
    private Post postID;
    @JoinColumn(name = "UserID", referencedColumnName = "UsersID")
    @ManyToOne(optional = false)
    private Users userID;

    public Postcomments() {
    }

    public Postcomments(Integer postCommentsID) {
        this.postCommentsID = postCommentsID;
    }

    public Integer getPostCommentsID() {
        return postCommentsID;
    }

    public void setPostCommentsID(Integer postCommentsID) {
        this.postCommentsID = postCommentsID;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Post getPostID() {
        return postID;
    }

    public void setPostID(Post postID) {
        this.postID = postID;
    }

    public Users getUserID() {
        return userID;
    }

    public void setUserID(Users userID) {
        this.userID = userID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (postCommentsID != null ? postCommentsID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Postcomments)) {
            return false;
        }
        Postcomments other = (Postcomments) object;
        if ((this.postCommentsID == null && other.postCommentsID != null) || (this.postCommentsID != null && !this.postCommentsID.equals(other.postCommentsID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Postcomments[ postCommentsID=" + postCommentsID + " ]";
    }
    
}
