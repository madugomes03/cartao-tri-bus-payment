package model;

public enum TipoCartao {
    COMUM("Comum", 5.00),
    ESTUDANTE("Estudante", 3.50),
    IDOSO("Idoso", 0.00),
    PCD("PCD - Pessoa com Deficiência", 0.00);

    private final String descricao;
    private final double tarifa;

    TipoCartao(String descricao, double tarifa) {
        this.descricao = descricao;
        this.tarifa = tarifa;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getTarifa() {
        return tarifa;
    }
}

//Enum (enumeration) é um tipo de dado especial usado para definir constantes fixas.