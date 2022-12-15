package edu.umanizales.claro.entities.enums;

public enum EnumTipoVendedor {

    LINEA("Linea", 1),
    FISICO("Fisico", 2),
    CALLE("Calle", 3);

    private String valor;
    private int indice;
    EnumTipoVendedor(String valor, int indice) {
        this.valor = valor;
        this.indice = indice;
    }

    public String getValor() {
        return valor;
    }

    public int getIndice() {
        return indice;
    }
}
