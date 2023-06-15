public class PairIntVisitor {
    private int i;
    private Visitor s;

    public PairIntVisitor(int i, Visitor s) {
        this.i = i;
        this.s = s;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public Visitor getS() {
        return s;
    }

    public void setS(Visitor s) {
        this.s = s;
    }
}
