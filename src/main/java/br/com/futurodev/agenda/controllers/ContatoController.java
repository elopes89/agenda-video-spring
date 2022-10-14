package br.com.futurodev.agenda.controllers;

import br.com.futurodev.agenda.model.ContatoModel;
import br.com.futurodev.agenda.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/contato")
public class ContatoController {

    @Autowired
    private ContatoRepository contatoRepository;

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<ContatoModel> cadastrar(@RequestBody ContatoModel contatoModel) {
       ContatoModel cont = contatoRepository.save(contatoModel);
        return new ResponseEntity<ContatoModel>(cont, HttpStatus.CREATED);
    }

    @PutMapping(value = "/", produces = "application/json")
    public ResponseEntity<ContatoModel> atualizar(@RequestBody ContatoModel cm) {
        ContatoModel cont = contatoRepository.save(cm);
        return new ResponseEntity<ContatoModel>(cont, HttpStatus.OK);
    }

    @DeleteMapping(value = "/")
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Long idContato) {
        contatoRepository.deleteById(idContato);
        return new ResponseEntity<String>("Contato deletado", HttpStatus.OK);
    }

    @GetMapping(value = "/{idContato}")
    public ResponseEntity<ContatoModel>  getContatoById(@PathVariable(value = "idContato") Long idContato) {
        ContatoModel cont = contatoRepository.findById(idContato).get();
        return new ResponseEntity<ContatoModel>(cont, HttpStatus.OK);
    }

    @GetMapping(value = "/" , produces = "application/json")
    public ResponseEntity<List<ContatoModel>> getContatoModelById(@RequestParam (name = "nome") String nome){
        List<ContatoModel> contatos =  contatoRepository.getContatoModelByName(nome);
        return new ResponseEntity<List<ContatoModel>>(contatos, HttpStatus.OK);
    }

}
