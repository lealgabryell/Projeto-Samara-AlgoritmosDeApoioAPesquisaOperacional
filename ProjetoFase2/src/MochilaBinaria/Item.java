package MochilaBinaria;

public class Item {
    String identificador;
    Double valor;
    Double peso;
    Double valorPeso;
    Double frac;

    public Item(String identificador, Double peso, Double valor) {
        this.identificador = identificador;
        this.peso = peso;
        this.valorPeso = valor/peso;
        this.frac = 1.00;
        this.valor = valor*frac;
    }

    public void setFrac(Double frac) {
        this.frac = frac;
        this.setValor();
        this.setPeso();
    }

    private void setValor() {
        this.valor = this.valor * this.frac;
    }

    private void setPeso(){
        this.peso = this.peso * this.frac;
    }
}

