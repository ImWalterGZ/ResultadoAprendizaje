import Ejercicio1.Terna;
import lista.DLinkedList;
import lista.Nodo;

public class Main {
    public static <T> DLinkedList<Terna<T>> Generar_Lista_Resumen(DLinkedList<T> lista1, DLinkedList<T> lista2) {

        if (!lista1.mismoTipoDato(lista2)) {
            System.out.println("No guardan el mismo tipo de dato");
            return null;
        }

        DLinkedList<Terna<T>> ternas = new DLinkedList<>();

        while (!lista1.isEmpty() || !lista2.isEmpty()) {
            int counter1 = 0;
            int counter2 = 0;
            Nodo<T> elemento;
            if (!lista1.isEmpty()) {
                elemento = lista1.getLastElement();
            } else {
                elemento = lista2.getLastElement();
            }

            while (lista1.isThere(elemento) || lista2.isThere(elemento)) {
                if (lista1.isThere(elemento)) {
                    counter1++;
                }
                if (lista2.isThere(elemento)) {
                    counter2++;
                }
                lista1.remove(lista1.getLastElement());
            }

            Terna<T> terna = new Terna<>(elemento.getValue(), counter1, counter2);
            ternas.add(terna);
        }

        return ternas;
    }

    public static void main(String[] args) {
        DLinkedList<Integer> numbers = new DLinkedList<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(7);
        numbers.add(10);
        if (numbers.isThere(3)) System.out.println("oui");
        System.out.println(numbers.getLength());

        DLinkedList<Integer> denso = new DLinkedList<>();
        denso.add(5);
        denso.add(2);
        denso.add(7);
        denso.add(10);

//        DLinkedList denso = new DLinkedList<>();
//        denso.add("dee");
//        denso.add("mom");
//        denso.add("dds");
//        denso.add("ahlo");

        DLinkedList<Terna<Integer>> resumen = Main.Generar_Lista_Resumen(numbers, denso);


    }
}
