package one.digitalInnovation;

public class Fila {
    private No refNoEntrada;

    public Fila() {
        this.refNoEntrada = null;
    }

    public No first(){
        if(!isEmpty()){
            No primeiroNo = refNoEntrada;
            while (true){
                if(primeiroNo.getRefNo() != null){
                    primeiroNo = primeiroNo.getRefNo();
                }
                else{
                    break;
                }
            }
            return primeiroNo;
        }
        return null;
    }


    public No dequeue(){
        if(!isEmpty()){
            No primeiroNo = refNoEntrada;
            No aux = refNoEntrada;
            while (true){
                if(primeiroNo.getRefNo() != null){
                    aux = primeiroNo;
                    primeiroNo = primeiroNo.getRefNo();
                } else{
                    aux.setRefNo(null);
                    break;
                }

            }
            return primeiroNo;
        }
        return null;
    }


    public void enqueue(No noNovo){
        noNovo.setRefNo(refNoEntrada);
        refNoEntrada = noNovo;
    }

    public boolean isEmpty(){
        return refNoEntrada==null;
    }

    @Override
    public String toString() {
        String stringRetorno = "";
        No aux = refNoEntrada;

        if(refNoEntrada !=null){
            while (true){
                stringRetorno += "[No{object=" + aux.getObject() + "}] ---->";
                if(aux.getRefNo()!=null){
                    aux=aux.getRefNo();
                }else{
                    stringRetorno += "null";
                    break;
                }

            }
        }else{
            stringRetorno += "null";
        }
        return stringRetorno;
    }
}
