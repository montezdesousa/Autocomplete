//* *****************************************************************************
 *  Nome:    Diogo Montez de Sousa
 *  No. de aluno:   93794
 *  Curso: Engenharia Inform�tica (PL)
 *
 *  Outro(s) integrante(s):
 *  Nome:  N/A 
 *  No. de aluno: N/A  
 *  Curso: N/A
 *
 *  Horas para realizar o projeto (opcional): ~20h
 *
 **************************************************************************** */

Enunciado 2:  Autocomplete


/* *****************************************************************************
 *  Descreva como o seu m�todo firstIndexOf() do BinarySearchDeluxe.java
 *  encontra o primeiro �ndice de uma chave que � igual � chave de pesquisa.
 **************************************************************************** */
O m�todo implementa o BinarySearch com ligeiras modifica��es. Antes de entrar no
loop do BinarySearch cl�ssico, o m�todo verifica se o primeiro elemento do array
� igual � chave que procuramos e nesse caso retorna de imediato o �ndice 0. 
A necessidade desta altera��o ficar� clara de seguida, mas serve para evitar que
o algoritmo aceda a uma posi��o inv�lida (-1) do array. Se a chave n�o se encontra 
na primeira posi��o � inciado o loop do BinarySearch. 

Como se assume que o array j� est� ordenado segundo o comparator recebido, o 
algoritmo vai dividindo o array original em metades sucessivas. Caso a chave 
procurada seja inferior/superior (segundo o comparator) ao ponto central do 
array, descarta-se a metade superior/inferior do array. Assim que encontre um 
�ndice central cujo conte�do seja igual � chave procurada, o algoritmo (ao 
contr�rio do BinarySearch cl�ssico) n�o retorna de imediato. Em vez disso, 
verifica sucessivamente se a posi��o imediatamente inferior do array tem o mesmo 
conte�do. Nesse caso, estamos perante uma repeti��o com posi��o inferior. Assim 
que verifique que o conte�do "� esquerda" n�o � igual � chave retorna o �ndice,
que ir� corresponder ao primeiro �ndice com conte�do igual � chave procurada.

Caso os �ndices de pesquisa lo e hi se cruzem sem retornar qualquer �ndice,
termina o while e retorna -1, o que significa que o array n�o cont�m a chave.

A verifica��o inicial � necess�ria porque caso contr�rio, quando o primeiro
�ndice (0) tivesse a chave que procuramos, o algoritmo iria verificar se o 
elemento anterior a 0 (-1) � igual ao pr�prio elemento no �ndice 0. Isto
iria resultar num erro de acesso ao array, pois n�o existe posi��o -1. 


/* *****************************************************************************
 *  Identificar qual algoritmo de ordena��o (se houver) o seu programa utiliza no
 *  construtor do Autocomplete e nos m�todos de inst�ncia. 
 *  Escolha uma das seguintes op��es:
 *
 *    none, selection sort, insertion sort, mergesort, quicksort, heapsort
 *
 *  Se estiver a utilizar uma implementa��o optimizada, tal como Arrays.sort(),
 *  selecione o algoritmo que � utilizado internamente.
 **************************************************************************** */

Autocomplete() : Segundo a documenta��o oficial do Java, para objetos o m�todo
public static <T> void sort(T[] a, Comparator<? super T> c) utiliza uma vers�o
do mergesort Theta(n log n). A implementa��o � adaptada do TimSort originalmente 
implementado em Python. Como neste m�todo n�o � passado um Comparator, a 
ordena��o segue a ordem natural (neste caso lexicogr�fica).
Fonte: https://docs.oracle.com/javase/8/docs/api/java/util/Arrays.html

allMatches() : id�ntico ao Autocomplete(), mas com Comparator c igual a
Term.byReverseWeightOrder(), que corresponde ao Comparator definido no ficheiro
Term.java. Deste modo, a ordena��o seguir� a ordem inversa do peso de cada
term no array. 


numberOfMatches() : N�o utiliza, pois assume que o atributo terms j� foi
ordenado na constru��o.

/* *****************************************************************************
 *  Quantas compara��es (no pior caso) cada uma das opera��es do
 *  Autocomplete faz, em fun��o do n�mero de itens n e do n�mero de 
 *  matching terms m? Utilize a nota��o Big Theta para simplificar as
 *  suas respostas.
 *
 *  Recorde que com a nota��o Big Theta, deve descartar coeficientes
 *  e termos de ordem inferior, por exemplo, Theta(m^2 + m log n).
 **************************************************************************** */

Autocomplete():     Theta(n log n) -> sort terms

allMatches():       Theta(log n + m log m) -> 2 * binary search + save match + sort match

numberOfMatches():  Theta(log n) -> 2 * binary search




/* *****************************************************************************
 * Bugs / limita��es conhecidas.
 **************************************************************************** */


/* *****************************************************************************
 * Descreva qualquer ajuda (se houver) que tenha recebido.
 * N�o inclua leituras, palestras, e preceitos, mas inclua qualquer ajuda de pessoas
 * (incluindo colegas do curso, amigos, monitores de laborat�rio, etc.)
 * Identificar os colegas de curso pelo nome.
 *
 * Incluir tamb�m quaisquer recursos (incluindo a web) que possa
 * ter sido utilizados na cria��o do seu desenho da solu��o.
 **************************************************************************** */
https://github.com/bluenight1994/Algorithm/tree/master/Assignments/Autocomplete
https://github.com/andrew-lewin/CSIS_2420/tree/master/A03AutoComplete/src/autoComplete

* *****************************************************************************
 * Descreva quaisquer problemas graves que tenha encontrado.                    
 **************************************************************************** */




/* *****************************************************************************
 * Se trabalhou com um colega, afirme abaixo que seguiu
 * o protocolo, tal como descrito no enunciado. 
 * Incluir uma frase que explica como cada um de v�s contribuiu para o projeto.
 **************************************************************************** */




/* *****************************************************************************
 * Listar aqui quaisquer outros coment�rios. Sinta-se � vontade para dar qualquer   
 * feedback sobre o quanto aprendeu ao fazer o projeto, e se    
 * gostou de o fazer.                                             
 **************************************************************************** */
O projeto � interessante, no entanto na minha opini�o parece-me demasiado avan�ado
para o conhecimento pr�tico de Java que um aluno de 1� ano do ISCTE tem, 
tendo em conta que apenas tivemos contacto inicial em IP. A utiliza��o de 
comparators n�o foi especialmente abordada nas aulas pr�ticas, isso dificultou a 
cria��o e implementa��o apenas recorrendo � experi�ncia das aulas.
