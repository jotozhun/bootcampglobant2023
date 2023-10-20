package Banco;

public class Cuenta {
    private int numero;
    private double dineroTotal;
    private String tipoCuenta;
    private String fechaDeCreacion;


    public Cuenta(int numero, double dineroTotal, String tipoCuenta, String fechaDeCreacion) {
        this.numero = numero;
        this.dineroTotal = dineroTotal;
        this.tipoCuenta = tipoCuenta;
        this.fechaDeCreacion = fechaDeCreacion;
    }


    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getDineroTotal() {
        return dineroTotal;
    }

    public void setDineroTotal(double dineroTotal) {
        this.dineroTotal = dineroTotal;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(String fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }
}
