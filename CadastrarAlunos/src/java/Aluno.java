import java.sql.Date;

public class Aluno {
private int id;
private String nome,senha,email;
private Date dataNascimento;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}

public Date getDataNascimento() {
        
	return dataNascimento;
}
public void setDataNascimento(Date dataNascimento) {
	this.dataNascimento = dataNascimento;
}

public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

public String getSenha() {
	return senha;
}
public void setSenha(String senha) {
	this.senha = senha;
}


}
