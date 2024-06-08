package model.bd;

import br.edu.fateczl.list.List;

public interface IDatabaseAccess<T> {
	
	List<T> consultar();
	void adicionar(T objeto);
	void alterar(List<T> objetosAtualizados);
}
