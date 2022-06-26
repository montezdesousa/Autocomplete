package autocomplete;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Term implements Comparable<Term> {
	
	private String query;
	private long weight;
		
	
	// Initializes a term with the given query string and weight.
	public Term(String query, long weight) {
		if (query == null)
			throw new IllegalArgumentException("A query não pode ser null.");
		if (weight < 0)
			throw new IllegalArgumentException("O peso não pode ser negativo.");
		this.query = query;
		this.weight = weight;
	}
	 	
	// Compares the two terms in descending order by weight.
	public static Comparator<Term> byReverseWeightOrder() {
        return new Comparator<Term>() {
            @Override
            public int compare(Term t1, Term t2) {
            	if (t2.weight > t1.weight)
            		return 1;
            	else if (t2.weight < t1.weight)
            		return -1;
            	else
            		return 0;
            }
        };
	}
	 
	// Compares the two terms in lexicographic order,
	// but using only the first r characters of each query.
	public static Comparator<Term> byPrefixOrder(int r) {
        if (r < 0) throw new IllegalArgumentException("O input não pode ser negativo.");
        
        return new Comparator<Term>() {
            @Override
            public int compare(Term t1, Term t2) {
                int l1 = t1.query.length();
                int l2 = t2.query.length();
                // Limita r ao tamanho da menor substring
                int lr = Math.min(l2, Math.min(l1, r));
                String string1 = t1.query.substring(0, lr);
                String string2 = t2.query.substring(0, lr);
                // String compareTo() já executa a ordenação lexicográfica
                return string1.compareTo(string2);
            }
        };
	}
	 
	// Compares the two terms in lexicographic order by query.
	public int compareTo(Term that) {
		// String compareTo() já compara de forma lexicográfica
		return this.query.compareTo(that.query);
	}
	 
	// Returns a string representation of this term in the following format:
	// the weight, followed by a tab, followed by the query.
	public String toString() {
		return weight + "\t" + query;	
	}
	 
	// unit testing (required)
	public static void main(String[] args) {
        Term t1 = new Term("leiria", 15);
        Term t2 = new Term("leipzig", 20);
        Term t3 = new Term("lagos", 2);
        ArrayList<Term> terms = new ArrayList<>();
        terms.add(t1);
        terms.add(t2);
        terms.add(t3);
        
        // Ordena por ordem inversa de peso
        Collections.sort(terms, byReverseWeightOrder());
        System.out.println("byReverseWeightOrder:");
        for (Term t : terms) {
            System.out.println(t.toString());
        }	
        
        // Ordena pelos primeiros 4 caractéres
        System.out.println("byPrefixOrder:");
        Collections.sort(terms, byPrefixOrder(4));
        for (Term t : terms) {
            System.out.println(t.toString());
        }
        
        // Devolve a diferença entre os caractéres que ordenam os Terms
        // lei(r)ia vs lei(p)zig
        // => 2 porque 'r' - 'p' = 114 - 112 = 2
        System.out.println("compareTo:");
        System.out.println(t1.compareTo(t2));    
        
        // Testa toString
        System.out.println("toString:");
        System.out.println(t1.toString());    
	}
}