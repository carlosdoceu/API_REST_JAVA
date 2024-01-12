package med.voll.api.controller;


import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.DadosListagemMedicos;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void cadastroMedico(@RequestBody DadosCadastroMedico dadosCadastroMedico){
        medicoRepository.save(new Medico(dadosCadastroMedico));


    }


    @GetMapping("/listaMedicos")
    public List<DadosListagemMedicos> listaMedicos(){
        return medicoRepository.findAll().stream().map(DadosListagemMedicos::new).toList();
    }

}
