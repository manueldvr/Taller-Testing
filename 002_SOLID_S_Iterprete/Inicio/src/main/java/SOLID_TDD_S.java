import static org.junit.Assert.*;

import org.junit.Test;


public class SOLID_TDD_S {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	String CODIGO =
			
			"#Programa que pide dos numeros al usuario y los suma\n"
			+"LABEL pideNumeroUno\n"
			+"PRINT Escribe el primer número:\n"
			+"REQ numeroUno\n"
			+"GOTOIF pideNumeroUno numeroUno = NULL\n"
			+"END_LABEL\n"

			+"LABEL pideNumeroDos\n"
			+"PRINT Escribe el segundo número:\n"
			+"REQ numeroDos\n"
			+"GOTOIF pideNumeroDos numeroDos = NULL\n"
			+"END_LABEL\n"


			+"GOTOIF pideNumeroUno numeroUno = NULL\n"
			+"GOTOIF pideNumeroDos numeroDos = NULL\n"


			+"ADD suma numeroUno numeroDos\n"
			+"PRINT El resultado es \n"
			+"PRINT suma\n";
			
	String CODIGO_SIMPLE=
	
			"PRINT Escribe el primer número:\n"
			+"REQ numeroUno\n"
			+"PRINT Escribe el segundo número:\n"
			+"REQ numeroDos\n"
			+"ADD suma numeroUno numeroDos\n"
			+"PRINT El resultado es \n"
			+"PRINT suma\n";
		

}
