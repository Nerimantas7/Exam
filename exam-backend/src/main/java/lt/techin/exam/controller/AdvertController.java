package lt.techin.exam.controller;

import lombok.AllArgsConstructor;
import lt.techin.exam.dto.AdvertDto;
import lt.techin.exam.service.AdvertService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/adverts")
public class AdvertController {

    private AdvertService advertService;

    //Build Add Advert REST API
//    @PreAuthorize("hasRole('ADMIN')") //Method Level Security
    @PostMapping
    public ResponseEntity<AdvertDto> addAdvert(@RequestBody AdvertDto advertDto){
        AdvertDto addedAdvert = advertService.addAdvert(advertDto);
        System.out.println("Advert received: " + addedAdvert);
        return new ResponseEntity<>(addedAdvert, HttpStatus.CREATED);
    }

    // Build Get Advert REST API
//    @PreAuthorize("hasAnyRole('ADMIN', 'USER')") //Method Level Security
    @GetMapping("{id}")
    public ResponseEntity<AdvertDto> getAdvertById(@PathVariable("id") Long advertId){
        AdvertDto advertDto = advertService.getAdvertById(advertId);
        System.out.println("Advert find with given ID: " + advertDto);
        return ResponseEntity.ok(advertDto);
    }

    // Build Get All Adverts REST API
//    @PreAuthorize("hasAnyRole('ADMIN', 'USER')") //Method Level Security
    @GetMapping
    public  ResponseEntity<List<AdvertDto>> getAllAdverts(){
        List<AdvertDto> adverts = advertService.getAllAdverts();
        return ResponseEntity.ok(adverts);
    }

    //Build Update Advert REST API
//    @PreAuthorize("hasRole('ADMIN')") //Method Level Security
    @PutMapping("{id}")
    public ResponseEntity<AdvertDto> updateAdvert(@PathVariable("id") Long advertId,
                                              @RequestBody AdvertDto updatedAdvert){
        AdvertDto advertDto = advertService.updateAdvert(advertId, updatedAdvert);
        System.out.println("Advert successfully updated with given Id: " + advertId);
        return ResponseEntity.ok(advertDto);
    }

    // Build Delete Advert REST API
//    @PreAuthorize("hasRole('ADMIN')") //Method Level Security
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAdvert(@PathVariable("id") Long advertId){
        advertService.deleteAdvert(advertId);
        return ResponseEntity.ok("Advert deleted successfully!");
    }
}
