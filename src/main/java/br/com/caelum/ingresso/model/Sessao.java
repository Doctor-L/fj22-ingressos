package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Sessao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalTime horario;
	
	@ManyToOne
	private Sala sala;
	@ManyToOne
	private Filme filme;
	private BigDecimal preco;

	public Sessao() {}
	
	public Sessao(LocalTime horario, Filme filme, Sala sala) {
		this.horario = horario;
		this.filme = filme;
		this.sala = sala;
		this.preco = sala.getPreco().add(filme.getPreco());
	}

	public LocalTime getHorario() {
		return horario;
	}

	public Filme getFilme() {
		return filme;
	}

	public Sala getSala() {
		return sala;
	}

	public Integer getId() {
		return id;
	}

	public BigDecimal getPreco() {
		return preco.setScale(2, RoundingMode.HALF_UP);
	}
	
	public void setPreco(BigDecimal preco) {
		 this.preco = preco;
	}

}
