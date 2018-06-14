package others;

public class SplitString {
    public static void main(String[] args) {
        String str = "e788,2cbe,8ac8,3234";
        String[] arr = str.split(",");
        int cont = 0;
        for (int i = 0; i < arr.length; i++) {
            String string1 = arr[i];
            for (int j = 0; j < arr.length; j++) {
                if (!string1.equals(arr[j])) {
                    String string2 = arr[j];
                    for (int k = 0; k < arr.length; k++) {
                        if (!string1.equals(arr[k]) && !string2.equals(arr[k])) {
                            String string3 = arr[k];
                            for (int l = 0; l < arr.length; l++) {
                                if (!string1.equals(arr[l]) && !string2.equals(arr[l]) && !string3.equals(arr[l])) {
                                    String string4 = arr[l];
                                    System.out.println(string1 + string2 + string3 + string4);
                                    System.out.println(++cont);
                                }
                            }
                        }
                    }
                }
            }

        }
    }
}
