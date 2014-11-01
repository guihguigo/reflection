package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionTeste {
	private double d;
	private static final int i = 37;
	String s = "teste";
	
	public ReflectionTeste() {}
	protected ReflectionTeste(int i, double d){}
	
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		//getMethod();
		//isInstance();
		//escaneiaMetodosClasse();
		//escaneiaConstrutores();
		//escaneiaAtributos();
		
		
	}
	private static void escaneiaAtributos() throws ClassNotFoundException {
		Class cls = Class.forName("reflection.ReflectionTeste");
		
		Field[] fieldlist = cls.getDeclaredFields();
		for (int i = 0; i < fieldlist.length; i++) {
			Field field = fieldlist[i];
			System.out.println("Nome do atributo: " + field.getName());
			System.out.println("Membro da classe: " + field.getDeclaringClass());
			System.out.println("Tipo da class: " + field.getType());
			int mod = field.getModifiers();
			System.out.println("Modificadores: " + Modifier.toString(mod));
		}
	}
	
	private static void escaneiaConstrutores() throws ClassNotFoundException {
		Class cls = Class.forName("reflection.ReflectionTeste");
		Constructor ctorlist[] = cls.getDeclaredConstructors();
		
		for (int i = 0; i < ctorlist.length; i++) {
			Constructor ct = ctorlist[i];
			System.out.println("Nome: " + ct.getName());
			System.out.println("Membro da classe: " + ct.getDeclaringClass());
			
			Class pvec[] = ct.getParameterTypes();
			for (int j = 0; j < pvec.length; j++) 
				System.out.println("Parâmetro: " + j + " " + pvec[j]);
			
			Class evec[] = ct.getExceptionTypes();
			for (int j = 0; j < evec.length; j++) 
				System.out.println("Exceção: " + j + " " + evec[j]);
			
		}
	}


	
	private static void escaneiaMetodosClasse() throws ClassNotFoundException {
		Class cls = Class.forName("reflection.ReflectionTeste");
		Method[] methlist = cls.getDeclaredMethods();
		
		for (int i = 0; i < methlist.length; i++) {
			Method m = methlist[i];
			System.out.println("Nome: " + m.getName());
			System.out.println("Membro: " + m.getDeclaringClass());
			System.out.println("Modificador: " + Modifier.toString(m.getModifiers()));
			Class pvec[] = m.getParameterTypes();
			
			for (int j = 0; j < pvec.length; j++) 
				System.out.println("Parâmetro: " + j + " " + pvec[j]);
			
			System.out.println("Tipo de retorno: " + m.getReturnType());
			System.out.println("------");
		}
	}

	
	private static void getMethod() throws ClassNotFoundException {
		//listando metodos classe String via reflection
			Class c = Class.forName("java.lang.String");
			Method[] m = c.getMethods();
			for (int i = 0; i < m.length; i++) {
				System.out.println(m[i].toString());
			}
	}

	private static void isInstance() throws ClassNotFoundException {
		//recupera instancia e usa instanceof via reflaction
		
		Class cls = Class.forName("java.lang.String");
		
		boolean b1 = cls.isInstance(new Integer(14));
		System.out.println(b1);
		
		boolean b2 = cls.isInstance("teste");
		System.out.println(b2);
	}

}
