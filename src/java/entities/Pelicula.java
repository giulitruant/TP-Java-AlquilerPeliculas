package entities;

public class Pelicula {

    private int codPelicula;
    private String titulo;
    private String descripcion;
    private float duracion;
    private int stock;    

    public int getCodPelicula() {
		return codPelicula;
	}
	public void setCodPelicula(int codPelicula) {
		this.codPelicula = codPelicula;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
    }
    
    public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
    }
    
    public String getDuracion() {
		return descripcion;
	}
	public void setDuracion(String descripcion) {
		this.descripcion = descripcion;
    }
    
    public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}

}