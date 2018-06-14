package company.FuLong;

public class LostMsg {
    public void a() throws Aexception {
//		throw Aexception;
    }

    public void b() throws Bexception {
//		throw Bexception;
    }

    public void c() throws Exception {
        try {
            a();
        } finally {
            b();
        }
    }

    public static void main(String[] args) throws Exception {
        LostMsg lm = new LostMsg();
        try {
            lm.c();
        } catch (Exception ex) {
            System.out.println(ex.getClass().getName());
        }
    }

    class Aexception extends Exception {
    }

    class Bexception extends Exception {
    }
}