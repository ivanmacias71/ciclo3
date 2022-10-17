package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Tool;
import co.usa.ciclo3.ciclo3.repository.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToolService {
    @Autowired
    private ToolRepository toolRepository;

    public List<Tool> getAll(){
        return toolRepository.getAll();
    }

    public Optional<Tool> getTool(int id){
        return toolRepository.getTool(id);
    }

    public Tool save(Tool t){
        if(t.getId() == null){
            return toolRepository.save(t);
        }else{
            Optional<Tool> toolAux=toolRepository.getTool(t.getId());
            if(toolAux.isEmpty()){
                return toolRepository.save(t);
            }else{
                return t;
            }
        }
    }
}
