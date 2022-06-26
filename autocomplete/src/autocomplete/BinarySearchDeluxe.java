package autocomplete;

import java.util.Comparator;

public class BinarySearchDeluxe {
	
	 // Returns the index of the first key in the sorted array a[]
	 // that is equal to the search key, or -1 if no such key.
	 public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        if (a == null || key == null || comparator == null)
            throw new IllegalArgumentException("Nenhum argumento pode ser null.");
        
        if (a.length == 0) 
        	return -1;
        
        int lo = 0, hi = a.length-1;
        // Para evitar à partida que chegue à terceira condição dentro do while e aceda a uma posição fora da dimensão do array
        if (comparator.compare(key, a[0]) == 0) return 0;
        while (lo <= hi) {
        	int mid = lo + (hi - lo)/2;
            if (comparator.compare(key, a[mid]) < 0) hi = mid - 1;
            else if (comparator.compare(key, a[mid]) > 0) lo = mid + 1;
            // A diferença para o loop do binary search clássico é aqui. Verifico se o termo adjacente à esquerda é igual, nesse caso continua
            else if (comparator.compare(a[mid - 1], a[mid]) == 0) hi = mid - 1;
            else return mid;
        }
        return -1;
	 }
	 
	 // Returns the index of the last key in the sorted array a[]
	 // that is equal to the search key, or -1 if no such key.
	 public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        if (a == null || key == null || comparator == null)
        	throw new IllegalArgumentException("Nenhum argumento pode ser null.");
        
        if (a.length == 0) 
        	return -1;

        int lo = 0, hi = a.length - 1;
        // Para evitar à partida que chegue à terceira condição dentro do while e aceda a uma posição fora da dimensão do array
        if (comparator.compare(key, a[hi]) == 0) return hi;
    	while (lo <= hi) {
    		int mid = lo + (hi - lo) / 2;
    		if (comparator.compare(key, a[mid]) < 0) hi = mid - 1;
    		else if (comparator.compare(key, a[mid]) > 0) lo = mid + 1;
    		// A diferença para o loop do binary search clássico é aqui. Verifico se o termo adjacente à direita é igual, nesse caso continua
    		else if (comparator.compare(a[mid + 1], a[mid]) == 0) lo = mid + 1;
    		else return mid;
    	}
		return -1;
	 }
	 
	 // unit testing (required)
	 public static void main(String[] args) {
    	Integer[] numbers = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 8, 8};
    	
    	Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i1.compareTo(i2);
            }
        };
        
    	int n = 1;
    	System.out.println(BinarySearchDeluxe.firstIndexOf (numbers, n, comparator) + ":" + BinarySearchDeluxe.lastIndexOf(numbers, n, comparator));
    	n = 2;
    	System.out.println(BinarySearchDeluxe.firstIndexOf (numbers, n, comparator) + ":" + BinarySearchDeluxe.lastIndexOf(numbers, n, comparator));
    	n = 3;
    	System.out.println(BinarySearchDeluxe.firstIndexOf (numbers, n, comparator) + ":" + BinarySearchDeluxe.lastIndexOf(numbers, n, comparator));
    	n = 4;
    	System.out.println(BinarySearchDeluxe.firstIndexOf (numbers, n, comparator) + ":" + BinarySearchDeluxe.lastIndexOf(numbers, n, comparator));
    	n = 8;
    	System.out.println(BinarySearchDeluxe.firstIndexOf (numbers, n, comparator) + ":" + BinarySearchDeluxe.lastIndexOf(numbers, n, comparator));
    	n = 5;
    	System.out.println(BinarySearchDeluxe.firstIndexOf (numbers, n, comparator) + ":" + BinarySearchDeluxe.lastIndexOf(numbers, n, comparator));
	 }
}