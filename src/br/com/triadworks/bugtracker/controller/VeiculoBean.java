package br.com.triadworks.bugtracker.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import com.fredcar.veiculos.domino.Veiculo;

import br.com.triadworks.bugtracker.dao.UsuarioDao;
import br.com.triadworks.bugtracker.dao.VeiculoDao;
import br.com.triadworks.bugtracker.modelo.Usuario;
import br.com.triadworks.bugtracker.util.FacesUtils;

@ManagedBean
public class VeiculoBean {
	
	private List<Veiculo> veiculos;

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
	
	private Veiculo veiculo = new Veiculo();

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
		//adiciona os Veículos
		public void adiciona(){
			
			VeiculoDao dao = new VeiculoDao();
			dao.adiciona(this.veiculo);
			this.veiculo = new Veiculo(); // limpa os campos
			new FacesUtils().adicionaMensagemDeSucesso("Carro adicionado com sucesso!");
		}
		//lista os Veículos
		public void lista(){
			
			VeiculoDao dao = new VeiculoDao();
			this.veiculos = dao.lista();
		}
		//remove os Veículos
		public void remove(Veiculo veiculo){
			
			VeiculoDao dao = new VeiculoDao();
			dao.remove(veiculo);
			this.veiculos = dao.lista();
			new FacesUtils().adicionaMensagemDeSucesso("Carro removido com sucesso!");
		}
		//altera os Veículos
		public void altera(){
			
			VeiculoDao dao = new VeiculoDao();
			dao.atualiza(veiculo);
			new FacesUtils().adicionaMensagemDeSucesso("Carro alterado com sucesso!");
		}


}
