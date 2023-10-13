public class No {
    private int value;
    private No prox,ant;

    public No(int value, No prox, No ant) {
        this.value = value;
        this.prox = prox;
        this.ant = ant;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }

    public No getAnt() {
        return ant;
    }

    public void setAnt(No ant) {
        this.ant = ant;
    }
}
