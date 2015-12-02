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
	//adiciona os Usu�rios
	public void adiciona(){
		
		UsuarioDao dao = new UsuarioDao();
		dao.adiciona(this.usuario);
		this.usuario = new Usuario(); // limpa os campos
		new FacesUtils().adicionaMensagemDeSucesso("Usu�rio adicionado com sucesso!");
	}
	//lista os Usu�rios
	public void lista(){
		
		UsuarioDao dao = new UsuarioDao();
		this.usuarios = dao.lista();
	}
	//remove os usu�rios
	public void remove(Usuario usuario){
		
		UsuarioDao dao = new UsuarioDao();
		dao.remove(usuario);
		this.usuarios = dao.lista();
		new FacesUtils().adicionaMensagemDeSucesso("Usu�rio removido com sucesso!");
	}
	//altera os usu�rios
	public void altera(){
		
		UsuarioDao dao = new UsuarioDao();
		dao.atualiza(usuario);
		new FacesUtils().adicionaMensagemDeSucesso("Usu�rio alterado com sucesso!");
	}

}
