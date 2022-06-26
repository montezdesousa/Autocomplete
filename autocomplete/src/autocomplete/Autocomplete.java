package autocomplete;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Autocomplete {

    private Term[] terms;

    // Initializes the data structure from the given array of terms.
    public Autocomplete(Term[] terms) {
    	
    	// Verifica se o array de termos é null
        if (terms == null)
        	throw new IllegalArgumentException("O array de termos nao pode ser null.");
        
        // Verifica se algum dos termos é null
        for (Term t : terms) {
            if (t == null) {
            	throw new IllegalArgumentException("Nenhum termo pode ser null.");
            }
        }
        
        // Inicializa a estrutura de termos e ordena-os por ordem lexicográfica
        this.terms = terms;
        Arrays.sort(this.terms);
    }

    // Returns all terms that start with the given prefix, in descending order of weight.
    public Term[] allMatches(String prefix) {
        if (prefix == null)
        	throw new IllegalArgumentException("O argumento nao pode ser null.");
        
        // Cria um termo auxiliar com query igual ao prefixo recebido (serve para usar nas funções do BinarySearch que procuram num array de Terms
        // Por esta razão o peso é indiferente
        Term t = new Term(prefix, 0);
        // Índices que balizam os termos com prefixo coincidente (o comparator .byPrefixOrder() permite comparar apenas a substring com tamanho
        // do prefixo e não a query toda)
        int start = BinarySearchDeluxe.firstIndexOf(terms, t, Term.byPrefixOrder(prefix.length()));
        if (start == -1) {
        	Term[] tmp = {new Term("O prefixo \"" + prefix + "\" nao existe no ficheiro.", 0)};
        	return tmp;
        }
        int end = BinarySearchDeluxe.lastIndexOf(terms, t, Term.byPrefixOrder(prefix.length()));
        if (end == -1) {
        	Term[] tmp = {new Term("O prefixo \"" + prefix + "\" nao existe no ficheiro.", 0)};
        	return tmp;
        }
        // Guarda os resultados da pesquisa pelo prefixo
        Term[] matches = new Term[end - start + 1];
        int index = 0;
        for (int i = start; i <= end; i++) {
        	matches[index] = terms[i];
        	index++;
        }
        // Ordena os resultados por ordem inversa de peso
        Arrays.sort(matches, Term.byReverseWeightOrder());
       
        return matches;
    }

    // Returns the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix) {
        if (prefix == null) 
        	throw new IllegalArgumentException("O argumento nao pode ser null.");
        
        // Procedimento idêntico ao da função allMatches() que obtém o número de termos pela diferença dos índices
        Term t = new Term(prefix, 0);
        int start = BinarySearchDeluxe.firstIndexOf(terms, t, Term.byPrefixOrder(prefix.length()));
        if (start == -1) {
        	return 0;
        }
        int end = BinarySearchDeluxe.lastIndexOf(terms, t, Term.byPrefixOrder(prefix.length()));
        if (end == -1) {
        	return 0;
        }
        return end - start + 1;
    }

    // unit testing (required)
    // Se necessário adicionar o algs4.jar ao classpath: selecionar project folder -> Project -> Properties -> Add External Jars... -> selecionar ficheiro algs4.jar
    // Adicionar CLASSPATH às variáveis de ambiente e incluir  C:\Users\monte\algs4\algs4.jar;.
    // 
    // Compilar (colocar-se na diretoria da pasta src):
    // cd C:\Users\monte\OneDrive\Desktop\LEI\EI\1ANO_2S\AED\autocomplete\src
    // javac autocomplete\*.java
    //
    // Correr sem GUI:
    // java autocomplete.Autocomplete autocomplete\wiktionary.txt 5
    // java autocomplete.Autocomplete autocomplete\cities.txt 7
    //
    // Correr com GUI: 
    // java autocomplete.AutocompleteGUI autocomplete\wiktionary.txt 5
    // java autocomplete.AutocompleteGUI autocomplete\cities.txt 7
    
    public static void main(String[] args) {
    	// Ler os termos de um ficheiro
    	String filename = args[0];
    	In in = new In(filename);
    	int n = in.readInt(); // Primeira linha contém o número de termos total
    	Term[] terms = new Term[n];  // Cria um array de terms com todos os termos do ficheiro
    	for (int i = 0; i < n; i++) {
    		long weight = in.readLong(); // Lê o próximo peso
	    	in.readChar(); // Consome o tab
	    	String query = in.readLine(); // Lê a próxima query
	    	terms[i] = new Term(query, weight); // Constrói um termo
    	}
    	// Lê uma query do standard input e mostra os primeiros k termos
    	int k = Integer.parseInt(args[1]); // Número de termos a mostrar ao utilizador
    	Autocomplete autocomplete = new Autocomplete(terms); // Cria um novo objeto autocomplete, que constrói o array de terms como atributo interno
    	while (StdIn.hasNextLine()) {
    		String prefix = StdIn.readLine(); // Lê o prefixo a procurar

	    	Term[] results = autocomplete.allMatches(prefix); // Devolve array com os termos que coincidem com o prefixo recebido
	    	StdOut.printf("%d matches\n", autocomplete.numberOfMatches(prefix));
	    	for (int i = 0; i < Math.min(k, results.length); i++)
	    		StdOut.println(results[i]); // Devolve os k termos que coincidem, ou todos eles se # de termos coincidentes < k
    	}
    	in.close();
    }
}