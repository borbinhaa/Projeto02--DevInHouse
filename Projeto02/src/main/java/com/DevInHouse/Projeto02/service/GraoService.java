package com.DevInHouse.Projeto02.service;

import com.DevInHouse.Projeto02.controller.dto.QuantidadeGraoDTO;
import com.DevInHouse.Projeto02.model.Empresa;
import com.DevInHouse.Projeto02.model.Fazenda;
import com.DevInHouse.Projeto02.model.Grao;
import com.DevInHouse.Projeto02.repository.FazendaRepository;
import com.DevInHouse.Projeto02.repository.GraoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class GraoService {

    private GraoRepository graoRepository;
    private FazendaRepository fazendaRepository;
    private EmpresaService empresaService;

    public Grao save(Long id, Grao grao) {
        Empresa empresa = empresaService.findById(id);
        grao.setEmpresa(empresa);
        return graoRepository.save(grao);
    }

    public List<Grao> findByEmpresaId(Long id) {
        Empresa empresa = empresaService.findById(id);
        return graoRepository.findByEmpresa(empresa);
    }

    public List<QuantidadeGraoDTO> findGraoEstoque(Long empresaId) {
        List<Grao> graosEmpresa = graoRepository.findByEmpresa(empresaService.findById(empresaId));
        List<QuantidadeGraoDTO> lista = createDTOs(graosEmpresa);
        return organizaLista(lista);
    }

    private List<QuantidadeGraoDTO> organizaLista(List<QuantidadeGraoDTO> list) {
        return list.stream().sorted(QuantidadeGraoDTO::compareTo).toList();
    }

    public List<QuantidadeGraoDTO> createDTOs(List<Grao> graoList) {
        List<QuantidadeGraoDTO> lista = new ArrayList<>();

        for (Grao grao: graoList) {
            List<Fazenda> farmsByGrao = fazendaRepository.findByGrao(grao);
            if (farmsByGrao.isEmpty()) {
                lista.add(new QuantidadeGraoDTO(grao.getNome(), 0D));
                continue;
            }
            List<Double> estoques = new ArrayList<>();
            farmsByGrao.forEach(farm -> estoques.add(farm.getEstoque()));
            Double estoqueFinal = estoques.stream().reduce(Double::sum).get();
            lista.add(new QuantidadeGraoDTO(grao.getNome(), estoqueFinal));
        }
        return lista;
    }


}
