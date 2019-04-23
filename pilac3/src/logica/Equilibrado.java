package logica;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Equilibrado {
	
	public Stack<String> pila;
	public boolean state = true;
	
	public boolean checkString(String s) {
		boolean state = true;
		if (s.equals("{") || s.equals("[") || s.equals("(") || s.equals(")") || s.equals("]") || s.equals("}")) {
			if (s.equals("{") || s.equals("[") || s.equals("(")) {
				System.out.println("Elemento Ingresado en la pila");
				pila.push(s);
				printStack(pila);
			}else if (s.equals(")") || s.equals("]") || s.equals("}")) {
				if (pila.size()==0) {
					System.out.println("La pila está vacia y no se pueden sacar elementos");
					state = false;
				}else if (pila.size() != 0) {
					String condition = pila.peek();
					if (s.equals(")")) {
						if (condition.equals("(")) {
							System.out.println("Bloque eliminado");
							pila.pop();
							printStack(pila);
						}else {
							System.out.println("El caracter ingresado no es del mismo tipo revise la pila");
							printStack(pila);
							System.out.println("Caracter ingresado: "+ s +" \t Tipo de caracter esperado:'"+condition+"'");
						}
					}else if (s.equals("]")) {
						if (condition.equals("[")) {
							System.out.println("Bloque eliminado");
							pila.pop();
							printStack(pila);
						}else {
							System.out.println("El caracter ingresado no es del mismo tipo revise la pila");
							printStack(pila);
							System.out.println("Caracter ingresado: "+ s +" \t Tipo de caracter esperado:'"+condition+"'");
						}
					}else if (s.equals("}")) {
						if (condition.equals("{")) {
							System.out.println("Bloque eliminado");
							pila.pop();
							printStack(pila);
						}else {
							System.out.println("El caracter ingresado no es del mismo tipo revise la pila");
							printStack(pila);
							System.out.println("Caracter ingresado: "+ s +" \t Tipo de caracter esperado:'"+condition+"'");
						}
					}
				}
			}
		}else {
			System.out.println("El caracter ingresado no es reconocido");
		}
		return state;
	}
	
	public void printStack(Stack<String> pila) {
		System.out.println(Arrays.toString(pila.toArray()));
	}
	
	public Equilibrado() {
		System.out.println("Utilice los caracteres \"(, [, {\" para ingeresar elementos en la pila");
		System.out.println("Utilice los caracteres \"), ], }\" para sacar bloques la pila");
		pila = new Stack<String>();
		Scanner scan  =  new Scanner(System.in);
		
		while(state) {
			String s = scan.nextLine();
			state = checkString(s);
		}
	}
}
