package br.com.triadworks.bugtracker.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.triadworks.bugtracker.dao.UsuarioDao;
import br.com.triadworks.bugtracker.modelo.Usuario;
import br.com.triadworks.bugtracker.util.FacesUtils;

@ManagedBean
public class UsuarioBean {
	
	private List<Usuario> usuarios;
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	private Usuario usuario = new Usuario();

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	//adiciona os Usuários
	public void adiciona(){
		
		UsuarioDao dao = new UsuarioDao();
		dao.adiciona(this.usuario);
		this.usuario = new Usuario(); // limpa os campos
		new FacesUtils().adicionaMensagemDeSucesso("Usuário adicionado com sucesso!");
	}
	//lista os Usuários
	public void lista(){
		
		UsuarioDao dao = new UsuarioDao();
		this.usuarios = dao.lista();
	}
	//remove os usuários
	public void remove(Usuario usuario){
		
		UsuarioDao dao = new UsuarioDao();
		dao.remove(usuario);
		this.usuarios = dao.lista();
		new FacesUtils().adicionaMensagemDeSucesso("Usuário removido com sucesso!");
	}
	//altera os usuários
	public void altera(){
		
		UsuarioDao dao = new UsuarioDao();
		dao.atualiza(usuario);
		new FacesUtils().adicionaMensagemDeSucesso("Usuário alterado com sucesso!");
	}

}
