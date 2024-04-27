package br.com.mscartoes.model.clienteCartaoModel;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartoesPorClienteResponse {
	private String nome;
	private String bandeira;
	private BigDecimal limiteLiberado;

	public CartoesPorClienteResponse(String nome2, String string, BigDecimal limite) {
		// TODO Auto-generated constructor stub
	}

	public static CartoesPorClienteResponse fromModdel(ClienteCartao model) {
		return new CartoesPorClienteResponse(model.getCartao().getNome(), model.getCartao().getBandeira().toString(),
				model.getLimite());
	}

}
