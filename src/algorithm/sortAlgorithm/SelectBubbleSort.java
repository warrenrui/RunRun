package algorithm.sortAlgorithm;

public class SelectBubbleSort {
    public static void main(String args[]) {
        Date[] days = new Date[5];
        days[0] = new Date(2006, 7, 4);
        days[1] = new Date(2006, 5, 4);
        days[2] = new Date(2008, 5, 4);
        days[3] = new Date(2004, 5, 9);
        days[4] = new Date(2004, 5, 4);

//		bubbleSort(days);

//		selectSort(days);

        selectSortImprove(days);

        for (int i = 0; i < days.length; i++) {
            days[i].print();
        }
    }

    public static void selectSort(Date[] days) {
        int min;
        Date temp;
        for (int i = 0; i < days.length; i++) {
            min = i;
            for (int j = min + 1; j < days.length; j++) {
                if (days[min].compare(days[j]) > 0) {
                    min = j;
                }
            }
            if (min != i) {
                temp = days[i];
                days[i] = days[min];
                days[min] = temp;
            }
        }
    }

    public static void bubbleSort(Date[] days) {
        int len = days.length;
        Date temp;
        for (int i = len - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (days[j].compare(days[j + 1]) > 0) {
                    temp = days[j + 1];
                    days[j + 1] = days[j];
                    days[j] = temp;
                }
            }
        }
    }

    public static void selectSortImprove(Date[] days) {
        int len = days.length;
        int max;
        Date temp;
        for (int i = len - 1; i >= 1; i--) {
            max = i;
            for (int j = max - 1; j >= 0; j--) {
                if (days[max].compare(days[j]) < 0) {
                    max = j;
                }
            }
            if (max != i) {
                temp = days[i];
                days[i] = days[max];
                days[max] = temp;
            }
        }
    }
}

class Date {
    int year, month, day;

    Date(int y, int m, int d) {
        year = y;
        month = m;
        day = d;
    }

    public int compare(Date date) {
        return year > date.year ? 1 : year < date.year ? -1
                : month > date.month ? 1 : month < date.month ? -1
                : day > date.day ? 1 : day < date.day ? -1 : 0;
    }

    public void print() {
        System.out.println(year + " " + month + " " + day);
    }
}