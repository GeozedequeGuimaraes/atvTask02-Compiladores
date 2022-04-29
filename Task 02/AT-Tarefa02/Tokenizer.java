import java.util.ArrayList;

public class Tokenizer {
	public ArrayList<Token> tokens;
	
	public Tokenizer() {
		this.tokens = new ArrayList<Token>();
	}
	
	public void createTokens(String expr) throws Exception{
		String aux = ""; 
		char character;
		
		for(int i = 0; i<expr.length(); i++) {
			character = expr.charAt(i);
			if(Character.isDigit(character)) {
				aux += character;
			}
			else if(character == ' ') {
				if(!aux.equals("")) {
					this.tokens.add(new Token(TokenType.NUM, aux));
					aux = "";
				}
			}
			else if(character == '+') {
				this.tokens.add(new Token(TokenType.PLUS, "+"));
			}
			else if(character == '-') {
				this.tokens.add(new Token(TokenType.MINUS, "-"));
			}
			else if(character == '*') {
				this.tokens.add(new Token(TokenType.STAR, "*"));
			}
			else if(character == '/'){
				this.tokens.add(new Token(TokenType.SLASH, "/"));
			}
			else {
				throw new Exception("Error: Unexpected character: " + character);
			}
		}
	}
}
