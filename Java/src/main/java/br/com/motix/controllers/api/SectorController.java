package br.com.motix.controllers.api;

import br.com.motix.models.dto.SectorDTO;
import br.com.motix.models.dto.SpotDTO;
import br.com.motix.models.Sector;
import br.com.motix.services.interfaces.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/sectors")
public class SectorController {

    @Autowired
    private SectorService sectorService;


    @GetMapping
    public List<SectorDTO> getAllSectors() {
        return SectorDTO.fromEntityList(sectorService.findAll());
    }

    @GetMapping("/{id}")
    public SectorDTO getSectorById(@PathVariable UUID id) {
        return SectorDTO.fromEntity(sectorService.findById(id));
    }

    @PostMapping
    public SectorDTO createSector(@RequestBody SectorDTO dto) {
        Sector newSector = dto.toEntity();
        return SectorDTO.fromEntity(sectorService.save(newSector));
    }

    @PutMapping()
    public SectorDTO updateSector( @RequestBody SectorDTO dto) {
        return SectorDTO.fromEntity(sectorService.update(dto.toEntity()));
    }

    @DeleteMapping("/{id}")
    public void deleteSector(@PathVariable UUID id) {
        sectorService.delete(id);
    }
}
