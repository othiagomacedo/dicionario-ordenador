package br.com.phcsoftware.control;

import br.com.phcsoftware.model.Busca;
import br.com.phcsoftware.model.IBusca;

public class ControleBusca implements IControleBusca{

    IBusca busca;

    public ControleBusca() {
        this.busca = new Busca();
    }

    @Override
    public int buscaBinaria(String palavraBuscada) throws Exception{
        return busca.buscaBinaria(palavraBuscada);
    }

    @Override
    public int buscaSequencial(String palavraBuscada) throws Exception{
        return busca.buscaSequencial(palavraBuscada);
    }

}
