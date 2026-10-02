package br.com.eduardo.usuarios;

import br.com.eduardo.usuarios.modelo.Usuario;
import br.com.eduardo.usuarios.modelo.UsuarioAdmin;
import br.com.eduardo.usuarios.modelo.UsuarioCliente;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {

		Usuario cliente = new UsuarioCliente("Eduardo", "edu@email.com", "123456");
		UsuarioAdmin admin = new UsuarioAdmin("Maria", "maria@email.com", "admin123", 2);

		// POLIMORFISMO: a lista é de br.com.eduardo.usuarios.modelo.Usuario, mas guarda os dois tipos
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(cliente);
		usuarios.add(admin);

		for (Usuario u : usuarios) {
			System.out.println(u.descrever()); // cada objeto usa o seu getPerfil()
		}

		// Autenticação
		System.out.println(cliente.autenticar("123456")); // true
		System.out.println(cliente.autenticar("errada"));  // false

		// Admin desativa o cliente, e depois ele não autentica mais
		admin.desativarUsuario(cliente);
		System.out.println(cliente.autenticar("123456")); // false

		// Validação: isso deve lançar IllegalArgumentException
		try {
			new UsuarioCliente("", "sem-arroba", "123");
		} catch (IllegalArgumentException e) {
			System.out.println("Erro esperado: " + e.getMessage());
		}
	}
}