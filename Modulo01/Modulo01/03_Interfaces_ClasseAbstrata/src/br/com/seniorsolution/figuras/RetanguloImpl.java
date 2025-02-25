package br.com.seniorsolution.figuras;

import br.com.seniorsolution.interfaces.IFigura;

public class RetanguloImpl implements IFigura{

	private double base, altura;
	
	public RetanguloImpl(double base, double altura) {
		this.setAltura(altura);
		this.setBase(base);
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	@Override
	public double calcularArea() {
		// TODO Auto-generated method stub
		return this.getBase() * this.getAltura();
	}
	
}
