import javax.swing.JOptionPane;

public class Controladora {
	
public String calcular(int numero1, int numero2, int operacao){
		
	String mens="";
	switch(operacao)
	{
	  case 1:
	          Soma soma = new Soma();
	         soma.ajustaValores(numero1, numero2);
	        mens=soma.calcular();
	  break;
	  case 2:
	         Subtracao sub = new Subtracao();
	         sub.ajustaValores(numero1, numero2); 
		  mens=sub.calcular();
	  break;
	  case 3:
		   Multiplicacao multi = new Multiplicacao();
	         multi.ajustaValores(numero1, numero2);
		  mens=multi.calcular();
	  break;  
	  case 4:
		   Divisao divi = new Divisao();
	         divi.ajustaValores(numero1, numero2);
		  mens=divi.calcular();
	   break;  
	   case 5:
		  System.exit(0);
	   break;
	   default:
		  JOptionPane.showMessageDialog(null, "Opção Inexistente", "Erro", JOptionPane.INFORMATION_MESSAGE);
	   break;
		
   return mens;
}

}