package br.com.motix.services.interfaces;

import br.com.motix.models.Sector;

import java.util.List;
import java.util.UUID;

public interface SectorService {

    List<Sector> findAll();
    Sector update(Sector sector);
    Sector findById(UUID id);
    Sector save(Sector sector);
    void delete(UUID id);
}
