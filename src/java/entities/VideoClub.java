package entities;

public class VideoClub{

    private float importePorDia;
    private int plazoMaxADevolver;
    private int cantMaxPelPendientes;

    public float getImportePorDia() {
		return importePorDia;
	}
	public void setImportePorDia(int importePorDia) {
		this.importePorDia = importePorDia;
    }
    
    public int getPlazoMaxADevolver() {
		return plazoMaxADevolver;
	}
	public void setPlazoMaxADevolver(int plazoMaxADevolver) {
		this.plazoMaxADevolver = plazoMaxADevolver;
    }
    
    public int getCantMaxPelPendientes() {
		return cantMaxPelPendientes;
	}
	public void setCantMaxPelPendientes(int cantMaxPelPendientes) {
		this.cantMaxPelPendientes = cantMaxPelPendientes;
	}

}