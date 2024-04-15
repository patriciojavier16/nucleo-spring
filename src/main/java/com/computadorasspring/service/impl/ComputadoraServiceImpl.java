package com.computadorasspring.service.impl;
import com.computadorasspring.entity.Computadora;
import com.computadorasspring.repository.IComputadoraRepository;
import com.computadorasspring.service.IComputadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ComputadoraServiceImpl implements IComputadoraService {
    @Autowired
    IComputadoraRepository iComputadoraRepository;
    @Override
    public List<Computadora> obtenerTodo() {
        return iComputadoraRepository.findAll();
    }
    @Override
    public Computadora crearComputadora(Computadora computadora) {
        return iComputadoraRepository.save(computadora);
    }
    @Override
    public Computadora actualizarComputadora(Long id, Computadora computadora) {
        Computadora computadoradb = iComputadoraRepository.findById(id).orElse(null);
        if (computadoradb != null){
            computadoradb.setMarcaComputador(computadora.getMarcaComputador());
            computadoradb.setModeloComputador(computadora.getModeloComputador());
            computadoradb.setMarcaProcesador(computadora.getMarcaProcesador());
            computadoradb.setVelocidadProcesador(computadora.getVelocidadProcesador());
            computadoradb.setGeneracionProcesador(computadora.getGeneracionProcesador());
            computadoradb.setTipoRam(computadora.getTipoRam());
            computadoradb.setCapacidadRam(computadora.getCapacidadRam());
            computadoradb.setTipoDisco(computadora.getTipoDisco());
            computadoradb.setCapacidadDisco(computadora.getCapacidadDisco());
            computadoradb.setMarcaGrafica(computadora.getMarcaGrafica());
            computadoradb.setCapacidadGrafica(computadora.getCapacidadGrafica());
            return iComputadoraRepository.save(computadoradb);
        }
        return null;
    }
    @Override
    public void eliminarComputadora(Long id) {
        iComputadoraRepository.deleteById(id);
    }
}
