package br.com.fatecararas.f290_dsm_tp2_suggestionbox_ct.services;

import java.util.List;
import java.util.Optional;

import br.com.fatecararas.f290_dsm_tp2_suggestionbox_ct.config.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatecararas.f290_dsm_tp2_suggestionbox_ct.model.entities.Suggestion;
import br.com.fatecararas.f290_dsm_tp2_suggestionbox_ct.repositories.SuggestionRepository;

@Service
public class SuggestionService {

    @Autowired
    private SuggestionRepository repository;


    public Suggestion create(Suggestion suggestion) {
        if(suggestion == null){
            throw new IllegalArgumentException("Erro ao inserir");
        }
        return repository.save(suggestion);
    }

    public Suggestion find(Integer pId) {
        Optional<Suggestion> optional = repository.find(pId);
        if (optional.isEmpty()) {
            throw new ObjectNotFoundException("Erro ao encontrar sugestão de id: " + pId);
        }
        return optional.get();
    }

    public List<Suggestion> getAll() {
        return repository.findAll();
    }

    public Suggestion update(Integer id, Suggestion pSuggestion) {
        Suggestion suggestion = find(id);
        suggestion.setDescription(pSuggestion.getDescription());
        return repository.save(suggestion);
    }

    public void delete(Integer id) {
        Suggestion suggestion = find(id);
        repository.FdeleteById(suggestion.getId());
    }


}
