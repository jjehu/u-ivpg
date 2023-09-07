import java.util.LinkedList;
import java.util.Queue;

public class ABB<T extends Comparable<T>> {

	public class Nodo<T> {
		T dato;
		int cont;
		Nodo izq;
		Nodo der;

		public Nodo(T dato) {
			this.dato = dato;
			this.cont = 1;
			this.izq = null;
			this.der = null;
		}
	}

	private Nodo raiz;

	public ABB() {
		raiz = null;
	}
	
	//Problema1
	public boolean esCompleto(T dato) {
		Nodo aux=nodo(dato);
		if(dato == null)
			return false;
		int altN=altNodo(aux);
		return esCompleto(aux, altN, 0);
	}
	private boolean esCompleto(Nodo aux, int altN, int NivelAct) {
		if(aux==null)
			return altN==NivelAct;
		return esCompleto(aux.izq, altN, NivelAct) && esCompleto(aux.der, altN, NivelAct);
	}
	public int altNodo(Nodo aux) {
		if(aux==null)
			return -1;
		int altIzq=altNodo(aux.izq);
		int altDer=altNodo(aux.der);
		return Math.max(altIzq, altDer)+1;
	}
	
	//Problema2
	public int nodosRepetidos(T dato) {
		if(dato==null)
			return 0;
		else {
			Nodo aux=nodo(dato);
			return nodosRepetidos(aux);
			
		}
	}
	private int nodosRepetidos(Nodo aux) {
		if (aux!=null) {
			if(aux.cont>1) {
				return nodosRepetidos(aux.izq)+nodosRepetidos(aux.der)+1;
			}else {
				return nodosRepetidos(aux.izq)+nodosRepetidos(aux.der);
			}
		}
		return 0;
	}
	
	//Problema3
	public LinkedList<T> listaDeNietos(T dato) {
	    if (!existe(dato))
	        return null;
	    else {
	        Nodo aux = nodo(dato);
	        LinkedList<T> lista = new LinkedList<>();
	        if (aux.izq != null) {
	            if (aux.izq.izq != null)
	                lista.add((T) aux.izq.izq.dato);
	            if (aux.izq.der != null)
	                lista.add((T) aux.izq.der.dato);
	        }
	        if (aux.der != null) {
	            if (aux.der.izq != null)
	                lista.add((T) aux.der.izq.dato);
	            if (aux.der.der != null)
	                lista.add((T) aux.der.der.dato);
	        }
	        return lista;
	    }
	}
	
	//Problema4
	public boolean mismaEstructura(ABB arb) {
		if(raiz!=null) {
			Queue cola1=new LinkedList();
			Queue cola2=new LinkedList();
			cola1.offer(raiz);
			cola1.offer(arb.raiz);
			while (!cola1.isEmpty() && !cola2.isEmpty()) {
				Nodo aux1=(Nodo) cola1.poll();
				Nodo aux2=(Nodo) cola2.poll();
				if(cola1.size()!= cola2.size())
					return false;
				if(aux1.izq!=null)
					cola1.offer(aux1.izq);
				if(aux1.der!=null)
					cola1.offer(aux1.der);
				if(aux2.izq!=null)
					cola2.offer(aux2.izq);
				if(aux2.izq!=null)
					cola2.offer(aux2.izq);
			}
		}
		return true;
	}
	
	//Problema5
	public boolean contieneSubarbol(ABB sub) {
		if(sub==null)
			return false;
		else {
			Nodo aux1=Nodo(sub.dato);
			Nodo aux2=raiz;
			contieneSubarbol(aux1, aux2);
		}
	}
	public boolean contieneSubarbol(Nodo aux1, Nodo aux2) {
		
	}
	

	public boolean estaVacio() {
		return raiz == null;
	}

	public boolean eliminarNodo(T dato) {
		if (raiz == null || !existe(dato))
			return false;
		else if (dato.equals(raiz.dato)) {
			if (raiz.izq == null & raiz.der == null) {
				raiz = null;
			} else if (raiz.izq == null) {
				raiz = raiz.der;
			} else if (raiz.der == null) {
				raiz = raiz.izq;
			}else {
				Nodo aux=nodo(dato);
				Nodo auxaux = menorDer(dato);
				Nodo auxauxp = nodoPadre((T) auxaux.dato);
				aux.dato = auxaux.dato;
				aux.cont = auxaux.cont;
				if (aux == auxauxp) {
					aux.der = auxaux.der;
				} else {
					auxauxp.izq = auxaux.der;
				}
			}
			return true;
		} else { // los tres casos generales
			Nodo aux = nodo(dato);
			if (aux.izq == null && aux.der == null) {
				Nodo auxp = nodoPadre(dato);
				if (dato.compareTo((T) auxp.dato) < 0) {
					auxp.izq = null;
				} else {
					auxp.der = null;
				}
				return true;
			} else {
				Nodo auxp = nodoPadre(dato);
				if (aux.izq == null) {
					if (dato.compareTo((T) auxp.dato) < 0)
						auxp.izq = aux.der;
					else
						auxp.der = aux.der;
				return true;
				}else if (aux.der == null) {
					if (dato.compareTo((T) auxp.dato) < 0)
						auxp.izq = aux.izq;
					else
						auxp.der = aux.izq;
				return true;
				}
			}
			Nodo auxaux = menorDer(dato);
			Nodo auxauxp = nodoPadre((T) auxaux.dato);
			aux.dato = auxaux.dato;
			aux.cont = auxaux.cont;
			if (aux == auxauxp) {
				aux.der = auxaux.der;
			} else {
				auxauxp.izq = auxaux.der;
			}
			return true;
		}
	}

	private Nodo nodo(T dato) {
		if (estaVacio())
			return null;
		else {
			Nodo aux = raiz;
			boolean fin = false;
			while (!fin) {
				if (dato.equals(aux.dato)) {
					return aux;
				} else {
					if (dato.compareTo((T) aux.dato) > 0) {
						if (aux.der == null) {
							fin = true;
						} else {
							aux = aux.der;
						}
					} else {
						if (aux.izq == null) {
							fin = true;
						} else {
							aux = aux.izq;
						}
					}
				}
			}
			return null;
		}

	}

	// BORRAR
	public void prueba(T dato) {
		Nodo temp = menorDer(dato);
		if (temp == null)
			System.out.println("null");
		else
			System.out.println(temp.dato);
	}

	private Nodo menorDer(T dato) {
		Nodo aux = nodo(dato);
		if (aux.der == null)
			return null;
		else {
			aux = aux.der;
			while (aux.izq != null)
				aux = aux.izq;
			return aux;
		}
	}

	private Nodo nodoPadre(T dato) {
		if (raiz == null || !existe(dato) || dato.equals(raiz.dato))
			return null;
		else {
			Nodo aux = raiz;
			while (true) {
				if (dato.compareTo((T) aux.dato) < 0) {
					if (dato.equals(aux.izq.dato))
						return aux;
					aux = aux.izq;
				} else {
					if (dato.equals(aux.der.dato))
						return aux;
					aux = aux.der;
				}
			}
		}
	}

	public void amplitud() {
		if (raiz != null) {
			Queue cola = new LinkedList();
			cola.offer(raiz);
			while (!cola.isEmpty()) {
				Nodo aux = (Nodo) cola.poll();
				if (aux.izq != null)
					cola.offer(aux.izq);
				if (aux.der != null)
					cola.offer(aux.der);
				System.out.print(aux.dato + " ");
			}
			System.out.println();
		}
	}

	// método existe iterativo
	public boolean existe(T dato) {
		if (estaVacio())
			return false;
		else {
			Nodo aux = raiz;
			boolean existe = false;
			boolean fin = false;
			while (!existe && !fin) {
				if (dato.equals(aux.dato)) {
					existe = true;
				} else {
					if (dato.compareTo((T) aux.dato) > 0) {
						if (aux.der == null) {
							fin = true;
						} else {
							aux = aux.der;
						}
					} else {
						if (aux.izq == null) {
							fin = true;
						} else {
							aux = aux.izq;
						}
					}
				}
			}
			return existe;
		}
	}

	/*
	 * 
	 * //Tarea 1, método insertar recursivo
	 * 
	 * public boolean existe(T dato) { if(estaVacio()) { return false; }else {
	 * return existe(dato, raiz); } } private boolean existe(T dato, Nodo aux) {
	 * if(dato.equals(aux.dato)) { return true; }else {
	 * if(dato.compareTo((T)aux.dato)>0) { if(aux.der==null) return false; else
	 * return existe(dato, aux.der); }else { if(aux.izq==null) return false; else
	 * return existe(dato, aux.izq); } } }
	 * 
	 */
	/*
	 * //inserta un nodo con el dato, en el árbol public void insertar(T dato) {
	 * if(estaVacio()) raiz=new Nodo(dato); else { Nodo aux=raiz; boolean
	 * insertado=false; while(!insertado) { if(dato.equals(aux.dato)) { aux.cont++;
	 * insertado=true; }else { if(dato.compareTo((T)aux.dato)>0) { if(aux.der==null)
	 * { aux.der=new Nodo(dato); insertado=true; }else { aux=aux.der; } }else {
	 * if(aux.izq==null) { aux.izq=new Nodo(dato); insertado=true; }else {
	 * aux=aux.izq; } } } } } }
	 */

	// método insertar recursivo
	public void insertar(T dato) {
		if (estaVacio()) {
			raiz = new Nodo(dato);
		} else {
			insertar(dato, raiz);
		}
	}

	private void insertar(T dato, Nodo aux) {
		if (dato.equals(aux.dato)) {
			aux.cont++;
		} else {
			if (dato.compareTo((T) aux.dato) > 0) {
				if (aux.der == null)
					aux.der = new Nodo(dato);
				else
					insertar(dato, aux.der);
			} else {
				if (aux.izq == null)
					aux.izq = new Nodo(dato);
				else
					insertar(dato, aux.izq);
			}
		}
	}

	public void preorden() {
		preorden(raiz);
		System.out.println();
	}

	private void preorden(Nodo aux) {
		if (aux != null) {
			System.out.print(aux.dato + " ");
			preorden(aux.izq);
			preorden(aux.der);
		}
	}

	public void enorden() {
		enorden(raiz);
		System.out.println();
	}

	private void enorden(Nodo aux) {
		if (aux != null) {
			enorden(aux.izq);
			System.out.print(aux.dato + " ");
			enorden(aux.der);
		}
	}

	public void postorden() {
		postorden(raiz);
		System.out.println();
	}

	private void postorden(Nodo aux) {
		if (aux != null) {
			postorden(aux.izq);
			postorden(aux.der);
			System.out.print(aux.dato + " ");
		}
	}

	public String toString() {
		if (estaVacio())
			return ">";
		else
			return toString(raiz, "", "", "");
	}

	public String toString(Nodo aux, String str, String espacios, String simb) {
		if (aux != null) {
			str = espacios + simb + aux.dato + "\n";
			espacios = espacios + "  ";
			str = str + toString(aux.der, str, espacios, ">");
			str = str + toString(aux.izq, str, espacios, "<");
			return str;
		} else {
			return "";
		}
	}

}
