package one.digitalInnovation;

public class Fila<T> {
    private No<T> refNoEntrada;

    public Fila() {
        this.refNoEntrada = null;
    }

    public T first(){ //O metodo First retorna o primeiro nó da fila
        if(!isEmpty()){
            No primeiroNo = refNoEntrada;
            while (true){
                if(primeiroNo.getRefNo() != null){
                    primeiroNo = primeiroNo.getRefNo();
                    //O metodo percorre a lista até chegar ao nó que aponta para null.
                }
                else{
                    break;
                }
            }
            return (T) primeiroNo.getObject();
        }
        return null; //Caso a lista estiver vazia é retornado null.
    }


    public T dequeue(){ //O metodo dequeue remove o primeiro nó a entrar da fila
        if(!isEmpty()){
            No primeiroNo = refNoEntrada;
            No aux = refNoEntrada;
            while (true){
                if(primeiroNo.getRefNo() != null){
                    aux = primeiroNo;
                    primeiroNo = primeiroNo.getRefNo();
                    //O metodo percorre a lista até chegar ao nó que aponta para null.
                } else{
                    aux.setRefNo(null);
                    //Para remover o primeiro nó da lista o segundo nó aponta para null.
                    break;
                }

            }
            return (T) primeiroNo.getObject();
        }
        return null;
    }


    public void enqueue(T object){//Adiciona um nó a lista.
        No noNovo = new No(object);
        noNovo.setRefNo(refNoEntrada);
        //O nó que entra passa a apontar para o nó de referencia(o ultimo da fila)
        refNoEntrada = noNovo;
        //O nó de referencia(ultimo da fila) passa ser o novo nó.
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
