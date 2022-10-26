public class Calculadora {
    private float n1;
    private float n2;
   /*private char op; Operando se necessário*/

    public Calculadora(float n1, float n2) {
        this.n1 = n1;
        this.n2 = n2;
      /*this.op = op;*/
    }

    public float getN1() {
        return n1;
    }

    public void setN1(float n1) {
        this.n1 = n1;
    }

    public float getN2() {
        return n2;
    }

    public void setN2(float n2) {
        this.n2 = n2;
    }

  /*  public char getOp() {
        return op;
    }

    public void setOp(char op) {
        this.op = op;
    }*/

    public float soma(){
        return getN1()+getN2();
    }
    public float subtracao(){ return getN1()-getN2();}
    public float multiplicacao(){ return getN1()*getN2();}
    public float divisao(){return getN1()/getN2();}
}
