import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Grafondnp {
	int n;
	String[] id;
	byte[][] mady;

	public Grafondnp(int capacidad) {
		n = 0;
		id = new String[capacidad];
		mady = new byte[capacidad][capacidad];
	}

	public boolean dijkstra(String dato) {
		if (!existeNodo(dato))
			return false;
		else {
			int[] dist = new int[n];
			for (int i = 0; i < n; i++)
				dist[i] = Integer.MAX_VALUE;
			String[] ruta = new String[n];
			boolean[] visit = new boolean[n];
			int indice = indiceNodo(dato);
			dist[indice] = 0;
			ruta[indice] = "-";
			visit[indice] = true;
			for (int k = 0; k < n - 1; k++) {
				for (int i = 0; i < n; i++) {
					if (!visit[i] && mady[indice][i] == 1 && dist[indice] + 1 < dist[i]) {
						dist[i] = dist[indice] + 1;
						ruta[i] = id[indice];
					}
				}
				int ind = -1, distAcum = Integer.MAX_VALUE;
				for (int i = 0; i < n; i++) {
					if (!visit[i] && dist[i] < distAcum) {
						ind = i;
						distAcum = dist[i];
					}
				}
				if (ind > -1) {
					indice = ind;
					visit[ind] = true;
				}
			}
			for (int i = 0; i < n; i++)
				System.out.print(id[i] + " ");
			System.out.println();
			for (int i = 0; i < n; i++)
				System.out.print(dist[i] + " ");
			System.out.println();
			for (int i = 0; i < n; i++)
				System.out.print(ruta[i] + " ");
			System.out.println();

		}

		return true;
	}


	/// practica 1.
//	public void generarAleatorio(int nodos, int enlaces, int capacidad) {
//		n=nodos;
//		id = new String[capacidad];
//		mady = new byte[capacidad][capacidad];
//		for(int i=0; i<nodos; i++) {
//			String cad="";
//			String vocales="AEIOU";
//			String consonantes="BCDFGHJKLMNPQRSTVWXYZ";
//			cad=cad+vocales.charAt((int)(Math.random()*5));
//			cad=cad+vocales.charAt((int)(Math.random()*5));
//			cad=cad+consonantes.charAt((int)(Math.random()*21));
//			cad=cad+consonantes.charAt((int)(Math.random()*21));
//			for(int j=0; j<7; j++) {
//				int x=(int)(Math.random()*4);
//				int y=(int)(Math.random()*4);
//				String aux=cad.substring(x,x+1);
//				cad=cad.substring(0,x)+cad.substring(x+1);
//				cad=cad.substring(0,y)+aux+cad.substring(y);
//			}
//			boolean existe=false;
//			for(int j=0; j<i; j++) {
//				if(id[j].equals(cad)){
//					existe =true;
//					break;
//				}
//			}
//			System.out.println(cad);
//			if(!existe)
//				id[i]=cad;
//			else
//				i--;
//		}
//		if(enlaces>nodos*(nodos+1)/2)
//			enlaces=nodos*(nodos+1)/2;
//		for(int i=0; i<enlaces; i++) {
//			int x=(int)(Math.random()*nodos);
//			int y=(int)(Math.random()*nodos);
//			boolean existe=false;
//			if(mady[x][y]==1)
//				existe=true;
//			if(!existe) {
//			mady[x][y]=1;
//			mady[y][x]=1;
//			}else {
//				i--;
//			}
//			}
//		}

	public void generarAleatorio(int nodos, int enlaces, int capacidad) {
		n = 0;
		id = new String[capacidad];
		mady = new byte[capacidad][capacidad];
		for (int i = 0; i < nodos; i++) {
			String cad = "";
			String vocales = "AEIOU";
			String consonantes = "BCDFGHJKLMNPQRSTVWXYZ";
			cad = cad + vocales.charAt((int) (Math.random() * 5));
			cad = cad + vocales.charAt((int) (Math.random() * 5));
			cad = cad + consonantes.charAt((int) (Math.random() * 21));
			cad = cad + consonantes.charAt((int) (Math.random() * 21));
			for (int j = 0; j < 7; j++) {
				int x = (int) (Math.random() * 4);
				int y = (int) (Math.random() * 4);
				String aux = cad.substring(x, x + 1);
				cad = cad.substring(0, x) + cad.substring(x + 1);
				cad = cad.substring(0, y) + aux + cad.substring(y);
			}
			System.out.println(cad);
			if (!existeNodo(cad))
				insertarNodo(cad);
			else
				i--;
		}
		if (enlaces > nodos * (nodos + 1) / 2)
			enlaces = nodos * (nodos + 1) / 2;
		for (int i = 0; i < enlaces; i++) {
			int x = (int) (Math.random() * nodos);
			int y = (int) (Math.random() * nodos);
			boolean existe = false;
			if (existeEnlace(id[x], id[y]))
				existe = true;
			if (!existe) {
				insertarEnlace(id[x], id[y]);
			} else {
				i--;
			}
		}
	}

	public int capacidad() {
		return mady.length;
	}

	public int orden() {
		return n;
	}

	public boolean esNulo() {
		return n == 0;
	}

	// ok
	public boolean esVacio() {
		boolean vacio = true;
		int i = 0, j = 0;
		while (vacio && i < n) {
			j = 0;
			while (vacio && j < n) {
				if (mady[i][j] != 0)
					vacio = false;
				j++;
			}
			i++;
		}
		return vacio;
	}

	// ok
	public boolean esCompletoB() {
		boolean completo = true;
		int i = 0, j = 0;
		while (completo && i < n) {
			j = i;
			while (completo && j < n) {
				if (mady[i][j] == 0)
					completo = false;
				j++;
			}
			i++;
		}
		return completo;
	}

	public boolean esCompletoSB() {
		boolean completo = true;
		int i = 0, j = 0;
		while (completo && i < n) {
			j = i + 1;
			while (completo && j < n) {
				if (mady[i][j] == 0)
					completo = false;
				j++;
			}
			i++;
		}
		return completo;
	}

	public boolean insertarNodo(String id) {
		id = id.toUpperCase();
		if (!existeNodo(id) && n < capacidad()) {
			this.id[n] = id;
			n++;
			return true;
		} else
			return false;
	}

	public boolean existeNodo(String id) {
		id = id.toUpperCase();
		for (int i = 0; i < n; i++) {
			if (id.equals(this.id[i]))
				return true;
		}
		return false;
	}

	public int indiceNodo(String id) {
		id = id.toUpperCase();
		for (int i = 0; i < n; i++) {
			if (id.equals(this.id[i]))
				return i;
		}
		return -1;
	}

	public boolean reemplazarNodo(String ant, String act) {
		ant = ant.toUpperCase();
		act = act.toUpperCase();
		if (!existeNodo(act)) {
			int ind = indiceNodo(ant);
			if (ind > -1) {
				id[ind] = act;
				return true;
			} else
				return false;
		} else
			return false;
	}

	public boolean eliminarNodo(String id) {
		id = id.toUpperCase();
		if (existeNodo(id)) {
			int ind = indiceNodo(id);
			for (int i = ind; i < n - 1; i++) {
				this.id[i] = this.id[i + 1];
			}
			// desplaza las filas hacia arriba
			for (int i = ind; i < n - 1; i++) {
				for (int j = 0; j < n; j++) {
					mady[i][j] = mady[i + 1][j];
				}
			}
			// desplaza las columnas hacia la izquierda
			for (int j = ind; j < n - 1; j++) {
				for (int i = 0; i < n; i++) {
					mady[i][j] = mady[i][j + 1];
				}
			}

			for (int i = 0; i < n; i++) {
				mady[i][n - 1] = 0;
				mady[n - 1][i] = 0;
			}
			n--;
			return true;
		} else
			return false;
	}

	// para probar
	public String[] nodosAdyacentes(String id) {
		int ind = indiceNodo(id);
		if (ind > -1) {
			int cont = 0;
			for (int j = 0; j < n; j++)
				cont = cont + mady[ind][j];
			String[] ady = new String[cont];
			int i = 0;
			for (int j = 0; j < n; j++)
				if (mady[ind][j] == 1) {
					ady[i] = this.id[j];
					i++;
				}
			return ady;
		} else
			return null;
	}

	// ok
	public boolean insertarEnlace(String ini, String fin) {
		int indIni = indiceNodo(ini);
		int indFin = indiceNodo(fin);
		if (indIni > -1 && indFin > -1) {
			mady[indIni][indFin] = 1;
			mady[indFin][indIni] = 1;
			return true;
		} else
			return false;
	}

	// ok
	public boolean eliminarEnlace(String ini, String fin) {
		int indIni = indiceNodo(ini);
		int indFin = indiceNodo(fin);
		if (indIni > -1 && indFin > -1) {
			mady[indIni][indFin] = 0;
			mady[indFin][indIni] = 0;
			return true;
		} else
			return false;

	}

	// ok
	public boolean existeEnlace(String ini, String fin) {
		int indIni = indiceNodo(ini);
		int indFin = indiceNodo(fin);
		if (indIni > -1 && indFin > -1) {
			return mady[indIni][indFin] == 1;
		} else
			return false;
	}

	public String toString() {
		return "";
	}

	public void imprimirGrafo() {
		for (int i = 0; i < n; i++)
			System.out.print(id[i] + " ");
		System.out.println();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(mady[i][j] + " ");
			System.out.println();
		}
	}

	public boolean amplitud(String dato) {
		if (!existeNodo(dato))
			return false;
		else {
			Queue q = new LinkedList();
			boolean[] visitados = new boolean[n];
			q.offer(dato);
			visitados[indiceNodo(dato)] = true;
			while (!q.isEmpty()) {
				String aux = (String) q.poll();
				System.out.println(aux);
				String[] ady = nodosAdyacentes(aux);
				for (int i = 0; i < ady.length; i++) {
					if (visitados[indiceNodo(ady[i])] == false) {
						q.offer(ady[i]);
						visitados[indiceNodo(ady[i])] = true;
					}
				}

			}

			return true;
		}
	}

	public boolean profundidad(String dato) {
		if (!existeNodo(dato))
			return false;
		else {
			Stack p = new Stack();
			boolean[] visitados = new boolean[n];
			p.push(dato);
			visitados[indiceNodo(dato)] = true;
			while (!p.isEmpty()) {
				String aux = (String) p.pop();
				System.out.println(aux);
				String[] ady = nodosAdyacentes(aux);
				for (int i = 0; i < ady.length; i++) {
					if (visitados[indiceNodo(ady[i])] == false) {
						p.push(ady[i]);
						visitados[indiceNodo(ady[i])] = true;
					}
				}

			}

			return true;
		}
	}

}
