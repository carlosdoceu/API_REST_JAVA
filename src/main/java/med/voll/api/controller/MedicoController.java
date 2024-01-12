package med.voll.api.controller;


import jakarta.validation.Valid;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.DadosListagemMedicos;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    /*injeção de depedencias*/
    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping("/cadastroMedicos")
    @Transactional /*por ser um insert, precisa ter transação ativa no db*/
    public void cadastroMedico(@RequestBody  @Valid DadosCadastroMedico dadosCadastroMedico){
        medicoRepository.save(new Medico(dadosCadastroMedico));

    }

    @GetMapping("/listaMedicos")
    public Page<DadosListagemMedicos> listaMedicos(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable){
        return medicoRepository.findAll(pageable).map(DadosListagemMedicos::new); /* DadosListagemMedicos::new - chama o constructor do DTO de DadosListagemMEdicos  */
    }

}
