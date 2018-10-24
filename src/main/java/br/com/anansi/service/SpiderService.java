package br.com.anansi.service;

import br.com.anansi.model.Specie;
import br.com.anansi.repository.SpecieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class SpiderService {

    @Autowired
    private SpecieRepository specieRepository;

    public List<Specie> findAllSpecies(){
        return specieRepository.findAllByOrderByName();
    }

    public List<Specie> findResult(List<Long> characteristics){

        List<List<Specie>> lists = new ArrayList<>();
        characteristics.forEach(c -> {
            lists.add(specieRepository.findByCharacteristics(characteristics));
        });

        return getCommonElements(lists);
    }

    public static List<Specie> getCommonElements(Collection<? extends Collection<Specie>> collections) {

        Set<Specie> common = new LinkedHashSet<>();
        if (!collections.isEmpty()) {
            Iterator<? extends Collection<Specie>> iterator = collections.iterator();
            common.addAll(iterator.next());
            while (iterator.hasNext()) {
                common.retainAll(iterator.next());
            }
        }
        List<Specie> species = new ArrayList<>();
        species.addAll(common);
        return species;

    }

    public List<Specie> findByName(String name){
        return specieRepository.findByNameIgnoreCaseContainingOrderByName(name);
    }

}
