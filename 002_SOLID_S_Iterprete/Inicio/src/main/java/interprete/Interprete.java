package interprete;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Interprete {

	private Map<String, Label> labels;

	private Map<String, Double> variables;

	private Label main;

	public Interprete() {
		labels = new HashMap<String, Label>();
		variables = new HashMap<String, Double>();
	}

	public void execute(String program) {
		String[] lines = program.split("\n");
		Label label = new Label();
		main = label;
		labels.put("main", main);
		for (String l : lines) {
			String[] split = l.split(" ");
			if (split[0].startsWith("#")) {

			} else if (split[0].startsWith("END_LABEL")) {
				label = main;
			} else if (split[0].startsWith("LABEL")) {
				label = new Label();
				labels.put(split[1], label);
			} else {
				label.addInstruccion(new Instruccion(split));
			}
		}

		executeLabel(main);
	}

	private void executeLabel(Label label) {
		for (Instruccion i : label.getInstrucciones()) {
			if ("ADD".equals(i.getType())) {
				Double var = resolve(i.getArgs()[1]) + resolve(i.getArgs()[2]);
				variables.put(i.getArgs()[0], var);
			} else if ("DIV".equals(i.getType())) {
				Double var = resolve(i.getArgs()[1]) / resolve(i.getArgs()[2]);
				variables.put(i.getArgs()[0], var);
			} else if ("MUL".equals(i.getType())) {
				Double var = resolve(i.getArgs()[1]) * resolve(i.getArgs()[2]);
				variables.put(i.getArgs()[0], var);
			} else if ("MUL".equals(i.getType())) {
				Double var = resolve(i.getArgs()[1]) * resolve(i.getArgs()[2]);
				variables.put(i.getArgs()[0], var);
			} else if ("ASIGN ".equals(i.getType())) {
				Double var = resolve(i.getArgs()[0]);
				variables.put(i.getArgs()[0], var);
			} else if ("PRINT".equals(i.getType())) {

				Double var = resolve(i.getArgs()[0]);
				if (var != null) {
					System.out.print(var);
				} else {

					for (String a : i.getArgs()) {
						System.out.print(a + " ");
					}
				}

			} else if ("REQ".equals(i.getType())) {
				Scanner in = new Scanner(System.in);
				Double var = in.nextDouble();
				variables.put(i.getArgs()[0], var);
			} else if ("GOTOIF".equals(i.getType())) {
				Double varA = resolve(i.getArgs()[1]);
				Double varB = resolve(i.getArgs()[3]);
				String operator = i.getArgs()[2];
				boolean success = false;
				if ("=".equals(operator)) {
					if (varA == null && varB == null) {
						success = true;
					} else if (varA != null) {
						success = varA.equals(varB);
					}
				} else if ("!=".equals(operator)) {
					if (varA != null) {
						success = !varA.equals(varB);
					} else if (varB == null) {
						success = true;
					}
				} else if ("<".equals(operator)) {
					if (varA != null && varB != null) {
						success = varA < varB;
					}
				} else if (">".equals(operator)) {
					if (varA != null && varB != null) {
						success = varA > varB;
					}
				} else if ("<=".equals(operator)) {
					if (varA != null && varB != null) {
						success = varA <= varB;
					}
				} else if (">=".equals(operator)) {
					if (varA != null && varB != null) {
						success = varA >= varB;
					}
				}

				if (success) {
					executeLabel(labels.get(i.getArgs()[0]));
				}

			}

		}

	}

	private Double resolve(String id) {

		Double val = variables.get(id);
		if (val == null && !"NULL".equals(id)) {
			try {
				val = Double.parseDouble(id);
			} catch (Exception e) {
				val = null;
			}
		}

		return val;
	}

	public static void main(String[] args) {
		new Interprete()
				.execute("#Programa que pide dos numeros al usuario y los suma\n"
						+ "LABEL pideNumeroUno\n"
						+ "PRINT Escribe el primer número:\n"
						+ "REQ numeroUno\n"
						+ "GOTOIF pideNumeroUno numeroUno = NULL\n"
						+ "END_LABEL\n"

						+ "LABEL pideNumeroDos\n"
						+ "PRINT Escribe el segundo número:\n"
						+ "REQ numeroDos\n"
						+ "GOTOIF pideNumeroDos numeroDos = NULL\n"
						+ "END_LABEL\n"

						+ "GOTOIF pideNumeroUno numeroUno = NULL\n"
						+ "GOTOIF pideNumeroDos numeroDos = NULL\n"

						+ "ADD suma numeroUno numeroDos\n"
						+ "PRINT El resultado es \n" + "PRINT suma\n");

	}

}
