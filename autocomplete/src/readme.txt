//* *****************************************************************************
 *  Nome:    
 *  No. de aluno:   
 *  Curso: Engenharia Informática (PL)
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
 *  Descreva como o seu método firstIndexOf() do BinarySearchDeluxe.java
 *  encontra o primeiro índice de uma chave que é igual à chave de pesquisa.
 **************************************************************************** */
O método implementa o BinarySearch com ligeiras modificações. Antes de entrar no
loop do BinarySearch clássico, o método verifica se o primeiro elemento do array
é igual à chave que procuramos e nesse caso retorna de imediato o índice 0. 
A necessidade desta alteração ficará clara de seguida, mas serve para evitar que
o algoritmo aceda a uma posição inválida (-1) do array. Se a chave não se encontra 
na primeira posição é inciado o loop do BinarySearch. 

Como se assume que o array já está ordenado segundo o comparator recebido, o 
algoritmo vai dividindo o array original em metades sucessivas. Caso a chave 
procurada seja inferior/superior (segundo o comparator) ao ponto central do 
array, descarta-se a metade superior/inferior do array. Assim que encontre um 
índice central cujo conteúdo seja igual à chave procurada, o algoritmo (ao 
contrário do BinarySearch clássico) não retorna de imediato. Em vez disso, 
verifica sucessivamente se a posição imediatamente inferior do array tem o mesmo 
conteúdo. Nesse caso, estamos perante uma repetição com posição inferior. Assim 
que verifique que o conteúdo "à esquerda" não é igual à chave retorna o índice,
que irá corresponder ao primeiro índice com conteúdo igual à chave procurada.

Caso os índices de pesquisa lo e hi se cruzem sem retornar qualquer índice,
termina o while e retorna -1, o que significa que o array não contém a chave.

A verificação inicial é necessária porque caso contrário, quando o primeiro
índice (0) tivesse a chave que procuramos, o algoritmo iria verificar se o 
elemento anterior a 0 (-1) é igual ao próprio elemento no índice 0. Isto
iria resultar num erro de acesso ao array, pois não existe posição -1. 


/* *****************************************************************************
 *  Identificar qual algoritmo de ordenação (se houver) o seu programa utiliza no
 *  construtor do Autocomplete e nos métodos de instância. 
 *  Escolha uma das seguintes opções:
 *
 *    none, selection sort, insertion sort, mergesort, quicksort, heapsort
 *
 *  Se estiver a utilizar uma implementação optimizada, tal como Arrays.sort(),
 *  selecione o algoritmo que é utilizado internamente.
 **************************************************************************** */

Autocomplete() : Segundo a documentação oficial do Java, para objetos o método
public static <T> void sort(T[] a, Comparator<? super T> c) utiliza uma versão
do mergesort Theta(n log n). A implementação é adaptada do TimSort originalmente 
implementado em Python. Como neste método não é passado um Comparator, a 
ordenação segue a ordem natural (neste caso lexicográfica).
Fonte: https://docs.oracle.com/javase/8/docs/api/java/util/Arrays.html

allMatches() : idêntico ao Autocomplete(), mas com Comparator c igual a
Term.byReverseWeightOrder(), que corresponde ao Comparator definido no ficheiro
Term.java. Deste modo, a ordenação seguirá a ordem inversa do peso de cada
term no array. 


numberOfMatches() : Não utiliza, pois assume que o atributo terms já foi
ordenado na construção.

/* *****************************************************************************
 *  Quantas comparações (no pior caso) cada uma das operações do
 *  Autocomplete faz, em função do número de itens n e do número de 
 *  matching terms m? Utilize a notação Big Theta para simplificar as
 *  suas respostas.
 *
 *  Recorde que com a notação Big Theta, deve descartar coeficientes
 *  e termos de ordem inferior, por exemplo, Theta(m^2 + m log n).
 **************************************************************************** */

Autocomplete():     Theta(n log n) -> sort terms

allMatches():       Theta(log n + m log m) -> 2 * binary search + save match + sort match

numberOfMatches():  Theta(log n) -> 2 * binary search




/* *****************************************************************************
 * Bugs / limitações conhecidas.
 **************************************************************************** */


/* *****************************************************************************
 * Descreva qualquer ajuda (se houver) que tenha recebido.
 * Não inclua leituras, palestras, e preceitos, mas inclua qualquer ajuda de pessoas
 * (incluindo colegas do curso, amigos, monitores de laboratório, etc.)
 * Identificar os colegas de curso pelo nome.
 *
 * Incluir também quaisquer recursos (incluindo a web) que possa
 * ter sido utilizados na criação do seu desenho da solução.
 **************************************************************************** */
https://github.com/bluenight1994/Algorithm/tree/master/Assignments/Autocomplete
https://github.com/andrew-lewin/CSIS_2420/tree/master/A03AutoComplete/src/autoComplete

* *****************************************************************************
 * Descreva quaisquer problemas graves que tenha encontrado.                    
 **************************************************************************** */




/* *****************************************************************************
 * Se trabalhou com um colega, afirme abaixo que seguiu
 * o protocolo, tal como descrito no enunciado. 
 * Incluir uma frase que explica como cada um de vós contribuiu para o projeto.
 **************************************************************************** */




/* *****************************************************************************
 * Listar aqui quaisquer outros comentários. Sinta-se à vontade para dar qualquer   
 * feedback sobre o quanto aprendeu ao fazer o projeto, e se    
 * gostou de o fazer.                                             
 **************************************************************************** */
