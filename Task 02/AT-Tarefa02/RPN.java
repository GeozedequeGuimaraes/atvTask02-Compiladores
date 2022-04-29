import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Stack;

public class RPN {
    private Stack<Double> pilha;

    public RPN(){
            pilha = new Stack<Double>();
            }
    public static void main(String[] args) throws Exception{
        RPN stacker = new RPN();
        Tokenizer tokenizer = new Tokenizer();
        String expression = ""; Double result;
        
        FileReader fr = new FileReader("/Users/ggs/Dropbox/Mac/Downloads/Task 02/AT-Tarefa02/Calc1.stk");
        BufferedReader lerArq = new BufferedReader(fr);
        String line = lerArq.readLine();
        
        while (line != null) {
            expression+= line + " ";
            line = lerArq.readLine(); 
          }

        tokenizer.createTokens(expression);
        result = stacker.avaliar(tokenizer.tokens);
        System.out.println(result);
   }

	public Double avaliar(ArrayList<Token> tokens) throws Exception{
			for(int i = 0; i <tokens.size(); i++) {
				if(tokens.get(i).type == TokenType.NUM) {
					pilha.push(Double.parseDouble(tokens.get(i).lexeme));
				}
                else {
					pilha.push(check(tokens.get(i).lexeme));
				}
			}
			return pilha.pop();
        }

     private Double check(String operation){
             Double result = null;
             Double portion1 = this.pilha.pop();
             Double portion2 = this.pilha.pop();

            switch (operation)
            {
                case "+":
                    result = portion1 + portion2;
                    break;
                case "-":
                    result = portion1 - portion2;
                    break;
                case "*":
                    result = portion1 * portion2;
                    break;
                case "/":
                    result = portion1 / portion2;
                    break;
            }
            return result;
        }
}