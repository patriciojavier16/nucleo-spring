package com.computadorasspring.service;

import com.computadorasspring.entity.Computadora;

import java.util.List;

public interface IComputadoraService {
    List<Computadora> obtenerTodo();
    Computadora crearComputadora(Computadora computadora);
    Computadora actualizarComputadora(Long id, Computadora computadora);
    void eliminarComputadora(Long id);
}
