package br.ufrn.bd.OS;

public class OS {

	private long osID;
	private String nomeCliente, enderecoEntrega, enderecoColeta, observacao, status;
	
	public OS(long osID, String nomeCliente, String enderecoEntrega,
			String enderecoColeta, String observacao, String status) {
		super();
		this.osID = osID;
		this.nomeCliente = nomeCliente;
		this.enderecoEntrega = enderecoEntrega;
		this.enderecoColeta = enderecoColeta;
		this.observacao = observacao;
		this.status = status;
	}
	
	public OS(){
	}

	public long getOsID() {
		return osID;
	}

	public void setOsID(long osID) {
		this.osID = osID;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(String enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}

	public String getEnderecoColeta() {
		return enderecoColeta;
	}

	public void setEnderecoColeta(String enderecoColeta) {
		this.enderecoColeta = enderecoColeta;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String toString(){
		return "OS nº " + this.getOsID() + "\n" +
			   "Cliente: " + this.getNomeCliente() + "\n" +
			   "Endereco de Coleta: " + this.getEnderecoColeta() + "\n" +
			   "Endereco de Entrega: " + this.getEnderecoEntrega() + "\n" +
			   "Status: " + this.getStatus() + "\n" +
			   "Observação: " + this.getObservacao();
	}
	
	public String resultadoBusca(){
		return "OS nº " + this.getOsID() + " Cliente: " + this.getNomeCliente() + " Status: " + this.getStatus();
	}
	
}
