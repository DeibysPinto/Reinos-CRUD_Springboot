package com.example.reinos1500.Services;

import com.example.reinos1500.Entities.ReinosEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ReinosService {

    private final List<ReinosEntity> reinos = new ArrayList<>();
    private final AtomicInteger idGenerator = new AtomicInteger(1);

    public ReinosService() {
        reinos.add(new ReinosEntity(1, "Sacrum Romanum Imperium", "Imperio", "Carlos V", "Cristianismo", "Latín", "Europa", "Viena", "Germánica", 16000000, "Comercio y agricultura", 50000));
        reinos.add(new ReinosEntity(2, "Reino de Francia", "Monarquía", "Francisco I", "Cristianismo", "Francés", "Europa", "París", "Francesa", 18000000, "Agricultura", 60000));
        reinos.add(new ReinosEntity(3, "Reino de Inglaterra", "Monarquía", "Enrique VIII", "Cristianismo", "Inglés", "Europa", "Londres", "Anglosajona", 3000000, "Comercio marítimo", 40000));
        reinos.add(new ReinosEntity(4, "Imperio Otomano", "Imperio", "Suleimán el Magnífico", "Islam", "Turco", "Asia y Europa", "Constantinopla", "Turca", 25000000, "Comercio y expansión militar", 100000));
        reinos.add(new ReinosEntity(5, "Reino de Portugal", "Monarquía", "Juan III", "Cristianismo", "Portugués", "Europa", "Lisboa", "Ibérica", 2000000, "Exploración y comercio", 20000));
        reinos.add(new ReinosEntity(6, "Reino de Castilla", "Monarquía", "Carlos I", "Cristianismo", "Castellano", "Europa", "Toledo", "Ibérica", 6000000, "Comercio y exploración", 30000));
        reinos.add(new ReinosEntity(7, "Reino de Aragón", "Monarquía", "Carlos I", "Cristianismo", "Catalán", "Europa", "Zaragoza", "Ibérica", 5000000, "Comercio y agricultura", 25000));
        reinos.add(new ReinosEntity(8, "Reino de Polonia", "Monarquía", "Segismundo I", "Cristianismo", "Polaco", "Europa", "Cracovia", "Eslava", 7000000, "Agricultura", 35000));
        reinos.add(new ReinosEntity(9, "Gran Ducado de Moscú", "Ducado", "Iván III", "Cristianismo Ortodoxo", "Ruso", "Europa", "Moscú", "Eslava", 9000000, "Agricultura", 45000));
        reinos.add(new ReinosEntity(10, "Reino de Dinamarca", "Monarquía", "Cristián III", "Cristianismo", "Danés", "Europa", "Copenhague", "Nórdica", 1500000, "Pesca y comercio", 20000));
        reinos.add(new ReinosEntity(11, "Reino de Escocia", "Monarquía", "Jacobo V", "Cristianismo", "Inglés", "Europa", "Edimburgo", "Celta", 1000000, "Agricultura", 15000));
        reinos.add(new ReinosEntity(12, "Reino de Suecia", "Monarquía", "Gustavo I", "Cristianismo", "Sueco", "Europa", "Estocolmo", "Nórdica", 2000000, "Minería y comercio", 25000));
        reinos.add(new ReinosEntity(13, "Reino de Hungría", "Monarquía", "Luis II", "Cristianismo", "Húngaro", "Europa", "Buda", "Magiar", 4000000, "Agricultura", 30000));
        reinos.add(new ReinosEntity(14, "Reino de Nápoles", "Monarquía", "Carlos I", "Cristianismo", "Italiano", "Europa", "Nápoles", "Itálica", 2500000, "Comercio y agricultura", 15000));
        reinos.add(new ReinosEntity(15, "Sultanato de Delhi", "Sultanato", "Ibrahim Lodhi", "Islam", "Persa", "Asia", "Delhi", "Indo-persa", 10000000, "Agricultura", 60000));
        reinos.add(new ReinosEntity(16, "Imperio Mogol", "Imperio", "Babur", "Islam", "Persa", "Asia", "Agra", "Indo-persa", 20000000, "Comercio y agricultura", 80000));
        reinos.add(new ReinosEntity(17, "Reino de Marruecos", "Monarquía", "Muhammad al-Burtuqali", "Islam", "Árabe", "África", "Fez", "Bereber", 3000000, "Comercio transahariano", 20000));
        reinos.add(new ReinosEntity(18, "Reino de Etiopía", "Monarquía", "Dawit II", "Cristianismo Ortodoxo", "Amárico", "África", "Axum", "Etíope", 4000000, "Agricultura", 25000));
        reinos.add(new ReinosEntity(19, "Reino de Bornu", "Monarquía", "Idris Katakarmabe", "Islam", "Kanuri", "África", "Ngazargamu", "Saheliana", 3000000, "Comercio y ganadería", 18000));
        reinos.add(new ReinosEntity(20, "Imperio Azteca", "Imperio", "Moctezuma II", "Politeísmo", "Náhuatl", "América", "Tenochtitlán", "Mesoamericana", 5000000, "Agricultura y tributo", 60000));
        reinos.add(new ReinosEntity(21, "Imperio Inca", "Imperio", "Huayna Cápac", "Politeísmo", "Quechua", "América", "Cusco", "Andina", 12000000, "Agricultura en terrazas", 80000));
    }

    public List<ReinosEntity> getAllReinos() {
        return reinos;
    }

    public ReinosEntity getReinoById(int id) {
        return reinos.stream().filter(reino -> reino.getId() == id).findFirst().orElse(null);
    }

    public ReinosEntity createReino(ReinosEntity reino) {
        reino.setId(idGenerator.getAndIncrement());
        reinos.add(reino);
        return reino;
    }

    public ReinosEntity updateReino(int id, ReinosEntity reino) {
        Optional<ReinosEntity> optionalReino = reinos.stream().filter(r -> r.getId() == id).findFirst();

        if (optionalReino.isPresent()) {
            ReinosEntity r = optionalReino.get();
            r.setNombre(reino.getNombre());
            r.setTipo(reino.getTipo());
            r.setGobernante(reino.getGobernante());
            r.setReligion(reino.getReligion());
            r.setLenguaje(reino.getLenguaje());
            r.setContinente(reino.getContinente());
            r.setCapital(reino.getCapital());
            r.setCultura(reino.getCultura());
            r.setPoblacion(reino.getPoblacion());
            r.setEconomia(reino.getEconomia());
            r.setEjercito(reino.getEjercito());
            return r;
        }

        return null;
    }

    public String deleteReino(int id) {
        return reinos.removeIf(reino -> reino.getId() == id) ? "Reino eliminado." : "Reino no encontrado.";
    }
}
