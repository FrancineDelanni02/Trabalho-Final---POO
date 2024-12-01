package dados;

public enum Estado {

    PENDENTE,ALOCADO,TERMINADO,CANCELADO;


    public Estado compararComString(String str){
        switch(str){
            case "PENDENTE":
                return PENDENTE;
            case "ALOCADO":
                return ALOCADO;
            case "TERMINADO":
                return TERMINADO;
            case "CANCELADO":
                return CANCELADO;
        }
        return null;
    }
}