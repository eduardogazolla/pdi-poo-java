package br.com.eduardo.usuarios.modelo;

public abstract class Usuario {

	// Encapsulamento de atributos, só o código dentro da classe pode mexer aqui.
	// Ativo = true para todos porque todos usuários já são criados ativos.
	private String nome;
	private String email;
	private String senha;
	private boolean ativo = true;

	/* Construtores (chamados quando é feito new br.com.eduardo.usuarios.modelo.Usuario(...)) recebendo os setters para que as validações valham
	desde a criação do usuário. Fazendo com que seja impossível um usuário com nome vazio e etc... */
	public Usuario(String nome, String email, String senha) {
		setNome(nome);
		setEmail(email);
		setSenha(senha);
	}

	// ---------- Getters (nota: não existe getSenha, a senha não sai da classe) ----------
	public String getNome() {return nome;}
	public String getEmail() {return email;}
	public boolean isAtivo() {return ativo;}

	// ---------- Setters com validação ----------
	public void setNome(String nome) {
		if (nome == null || nome.isBlank()) {
			throw new IllegalArgumentException("Não pode ser vazio.");
		} this.nome = nome;
	}

	public void setEmail(String email) {
		if (email == null || !email.contains("@")){
			throw new IllegalArgumentException("Digite um email válido");
		} this.email = email;
	}

	public void setSenha(String senha) {
		if (senha == null || senha.length() < 6){
			throw new IllegalArgumentException("A senha deve ter pelo menos 6 caracteres.");
		} this.senha = senha;
	}

	// ---------- Comportamentos / Métodos ----------
	public boolean autenticar(String senhaDigitada){
		// Um usuário desativado não vai conseguir autenticar, por isso o && (and).
		return ativo && senha.equals(senhaDigitada);
	}

	public void ativar(){this.ativo = true;}
	public void desativar(){this.ativo = false;}

	public String getPerfil(){
		return "CLIENTE";
	}

	public String descrever(){
		// getPerfil() é chamado aqui: se o objeto for br.com.eduardo.usuarios.modelo.UsuarioAdmin, roda a versão do Admin que está na classe
		// br.com.eduardo.usuarios.modelo.UsuarioAdmin.
		return nome + " | " + email + " | " + getPerfil() + " | " + (ativo ? "ativo" : "inativo");
	}
}