package br.com.example.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.lang.String; 
import java.lang.String; 
import java.lang.Integer; 
import java.util.Date; 
import java.lang.Boolean; 


@Entity
@Table(name = "usermodels")
public class UserModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "idade")
    private Integer idade;

    @Column(name = "dateCreated")
    private Date dateCreated;

    @Column(name = "admin")
    private Boolean admin;

	public void setName(String name) {this.name = name;}
	public String getName() {return name;}
	public void setEmail(String email) {this.email = email;}
	public String getEmail() {return email;}
	public void setIdade(Integer idade) {this.idade = idade;}
	public Integer getIdade() {return idade;}
	public void setDateCreated(Date dateCreated) {this.dateCreated = dateCreated;}
	public Date getDateCreated() {return dateCreated;}
	public void setAdmin(Boolean admin) {this.admin = admin;}
	public Boolean getAdmin() {return admin;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}