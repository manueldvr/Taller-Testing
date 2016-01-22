package interprete;

public class Instruccion {

	private String type;

	private String[] args;

	public Instruccion(String[] all) {
		super();
		type = all[0];
		args = new String[all.length - 1];
		System.arraycopy(all, 1, args, 0, args.length);
	}

	public String getType() {
		return type;
	}

	public String[] getArgs() {
		return args;
	}

}
