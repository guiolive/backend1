package br.ufg.inf.backend;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculatorServlet
 */

public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculatorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println( "Bem indo a Calculadora"
				+ "\nExemplor: http://localhost:8080/Aula2/CalculatorServlet?&num1=1&num2=3&operacao=soma"
				+ "\nExemplor: http://localhost:8080/Aula2/CalculatorServlet?&num1=1&num2=3&operacao=subtracao"
				+ "\nExemplor: http://localhost:8080/Aula2/CalculatorServlet?&num1=1&num2=3&operacao=divisao"
				+ "\nExemplor: http://localhost:8080/Aula2/CalculatorServlet?&num1=1&num2=3&operacao=multiplicacao" );
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		String operacao = request.getParameter("operacao");

		try {
			double numero1 = Double.parseDouble(num1);
			double numero2 = Double.parseDouble(num2);

			String mensagem = "Operação informada é inválida: " + operacao;
			double resultado;
			
			switch (operacao) {
			case "soma":
				resultado = numero1 + numero2;
				mensagem = formatarRetorno(resultado);
				break;

			case "subtracao":
				resultado = numero1 - numero2;
				mensagem = formatarRetorno(resultado);
				break;

			case "divisao":
				try {
					resultado = numero1 / numero2;
					mensagem = formatarRetorno(resultado);					
				} catch (ArithmeticException e) {
					response.getWriter().println("Não é possível fazer divisão por zero.");
					response.setStatus(400);
					return;
				}
				break;

			case "multiplicacao":
				resultado = numero1 * numero2;
				mensagem = formatarRetorno(resultado);
				break;

			}
			response.getWriter().println(mensagem);
		} catch (NullPointerException | NumberFormatException e) {
			response.getWriter().println("Informe valores válidos para os parametros num1, num2 e operacao");
			response.setStatus(412);
		}
	}

	private String formatarRetorno(double resultado) {
		return "Resultado da Operação: " + resultado;
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
