package br.com.eduardo.usuarios.modelo;

public class UsuarioAdmin extends Usuario{
	private int nivelAcesso;

	public UsuarioAdmin(String nome, String email, String senha, int nivelAcesso) {
		super(nome, email, senha);
		this.nivelAcesso = nivelAcesso;
	}

	public int getNivelAcesso(){
		return nivelAcesso;
	}

	@Override
	public String getPerfil() {
		return "ADMIN (nivel " + nivelAcesso + ")";
	}

	public void desativarUsuario(Usuario alvo){
		alvo.desativar();
	}
}
