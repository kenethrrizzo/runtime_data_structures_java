public class Ordenamiento {

    /* Método de insersión */
    public static void Insertion_sort(int[] t) {
        int actual, j, i;
        for (i = 1; i < 1000; i++) {
            actual = t[i];
            for (j = i; j > 0 && t[j - 1] > actual; j--) {
                t[j] = t[j - 1];
            }
            t[j] = actual;
        }
    }

    /* Método de selección */
    public static void selection_sort(int[] vector, int taille) {
        int actual, mas_pequeno, j, temp;
        for (actual = 0; actual < taille - 1; actual++) {
            mas_pequeno = actual;
            for (j = actual; j < taille; j++)
                if (vector[j] < vector[mas_pequeno])
                    mas_pequeno = j;
            temp = vector[actual];
            vector[actual] = vector[mas_pequeno];
            vector[mas_pequeno] = temp;
        }
    }

    public static void quicksort(int A[], int izq, int der) {
        int pivote = A[izq]; // tomamos primer elemento como pivote
        int i = izq; // i realiza la búsqueda de izquierda a derecha
        int j = der; // j realiza la búsqueda de derecha a izquierda
        int aux;
        while (i < j) { // mientras no se crucen las búsquedas
            while (A[i] <= pivote && i < j) i++; // busca elemento mayor que pivote
            while (A[j] > pivote) j--; // busca elemento menor que pivote
            if (i < j) { // si no se han cruzado
                aux = A[i]; // los intercambia
                A[i] = A[j];
                A[j] = aux;
            }
        }
        A[izq] = A[j]; // se coloca el pivote en su lugar de forma que tendremos
        A[j] = pivote; // los menores a su izquierda y los mayores a su derecha
        if (izq < j - 1) quicksort(A, izq, j - 1); // ordenamos subarray izquierdo
        if (j + 1 < der) quicksort(A, j + 1, der); // ordenamos subarray derecho
    }

    public static void main(String[] args) throws InterruptedException {
        long startTime;
        long endTime;
        int tiempo;
        int[] arr = new int[1000];
        int aleatorio;
        for (int i = 0; i < 1000; i++) {
            aleatorio = (int) (Math.random() * 20) + 1;
            arr[i] = aleatorio;
        }
        /* INSERCIÓN */
        startTime = System.nanoTime();
        Insertion_sort(arr);
        endTime = System.nanoTime();
        tiempo = (int) ((endTime - startTime));
        System.out.println("Inserción: "+tiempo + " nanosegundos");
        /* SELECCIÓN */
        startTime = System.nanoTime();
        selection_sort(arr, 1000);
        endTime = System.nanoTime();
        tiempo = (int) ((endTime - startTime));
        System.out.println("Selección: "+tiempo + " nanosegundos");
        /* QUICKSORT */
        startTime = System.nanoTime();
        quicksort(arr, 0, arr.length - 1);
        endTime = System.nanoTime();
        tiempo = (int) ((endTime - startTime));
        System.out.println("Quicksort: "+tiempo + " nanosegundos");
    }
}