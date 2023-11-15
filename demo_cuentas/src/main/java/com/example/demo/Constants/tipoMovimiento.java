package com.example.demo.Constants;

public enum tipoMovimiento {
    ABONO("Abono"),
    RETIRO("Retiro"),
    TRANSFERENCIA("Transferencia");

    private final String descripcion;

    tipoMovimiento(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    // Método estático para obtener una instancia dado su descripción
    public static tipoMovimiento fromDescripcion(String descripcion) {
        for (tipoMovimiento movimiento : tipoMovimiento.values()) {
            if (movimiento.descripcion.equals(descripcion)) {
                return movimiento;
            }
        }
        throw new IllegalArgumentException("Tipo no válido o no existe: " + descripcion);
    }
}
