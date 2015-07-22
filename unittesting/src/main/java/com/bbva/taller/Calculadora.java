package com.bbva.taller;

public class Calculadora
{
	public int dimeElResultadoDe(final String cadena)
	{
		final Extractor extractor = new Extractor();
		final int[] operandos = extractor.extraerOperandos(cadena);

		final String operador = extractor.extraerOperador(cadena);
		int resultado = 0;


		switch (operador.charAt(0))
		{
			case '+':
				resultado = operandos[0] + operandos[1];
				break;
			case '-':
				resultado = operandos[0] - operandos[1];
				break;
		}

		return resultado;
	}

}
