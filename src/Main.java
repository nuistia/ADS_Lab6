/*
Створити циклічний список із чисел.
 Знайти кількість максимальних елементів
 циклічного списку дійсних чисел і
 видалити всі максимальні елементи
 */

/*
в классе LinkedList реализуются
такие виды линейных структур, как
списки (двусвязные и циклические)
и очередь
*/

import java.util.LinkedList;
import java.util.Scanner;
public class Main {

    private static void printList(LinkedList<Double> list) {
        System.out.println(list);
    }

    private static void findAndDeleteMax(LinkedList<Double> list) {
        int i = 0;
        double max = list.get(i);
        while (i < list.size()) {
            if (max < list.get(i)) {
                max = list.get(i);

            }
            i++;
        }
        i = 0;
        int countMax = 0;
        while (i < list.size()) {
            if (list.get(i) == max) {
                countMax++;
                list.remove(i);
            } else i++;
        }
        System.out.println("Максимальний елемент: " + max);
        System.out.println("Кількість максимальних елементів: " + countMax);
        System.out.println("Список після видалення елементів, значення яких дорівнює максимальному:");
        printList(list);
    }

    public static void main(String[] args) {
        System.out.println("Введіть розмір вашого списку (1 і більше):");
        int count;
        Scanner scan = new Scanner(System.in);
        count = scan.nextInt();
        if (count < 1) {
            System.out.println("Потрібно було ввести значення 1 або більше!");
            return;
        }
        /*
        Вводить double значения через запятую, т.к. это особенность
        языковой локализации системы
        */
        System.out.println("Введіть " + count + " значень через пробіл:");
        LinkedList<Double> myList = new LinkedList<>();

        int i = 0;
        do {
            double valueOfNode = scan.nextDouble();
            if (i < 1) {
                myList.addFirst(valueOfNode);
            } else {
                myList.add(valueOfNode);
            }
            i++;
        } while (i < count);
        System.out.println("Ваш список:");
        printList(myList);
        findAndDeleteMax(myList);
    }
}