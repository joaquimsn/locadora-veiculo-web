package br.com.jsn.noleggio;
import java.io.Serializable;

import br.com.jsn.noleggio.domain.model.Cliente;

public class Servico implements Serializable {

	private static final long serialVersionUID = 8564571366580650937L;
	private Cliente cliente;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
