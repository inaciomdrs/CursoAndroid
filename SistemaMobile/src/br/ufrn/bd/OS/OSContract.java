package br.ufrn.bd.OS;

public class OSContract {

	public OSContract(){
		
	}
	
	public static abstract class OSEntry {
		public static final String TABLE_OS = "os";
		public static final String COLUMN_OS_ID = "os_id";
		public static final String COLUMN_NOME_CLIENTE = "nome_cliente";
		public static final String COLUMN_ENDERECO_ENTREGA = "endereco_entrega";
		public static final String COLUMN_ENDERECO_COLETA = "endereco_coleta";
		public static final String COLUMN_OBSERVACAO = "observacao";
		public static final String COLUMN_STATUS = "status";
		
	}
	
}
