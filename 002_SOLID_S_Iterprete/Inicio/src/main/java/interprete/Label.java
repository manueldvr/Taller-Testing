package interprete;

import java.util.ArrayList;
import java.util.List;

public class Label {
	
	private List<Instruccion> instrucciones;
	
	public Label(){
		instrucciones=new ArrayList<Instruccion>();
	}
	
	public void addInstruccion(Instruccion i){
		instrucciones.add(i);
	}

	public List<Instruccion> getInstrucciones() {
		return instrucciones;
	}
	
	

}
