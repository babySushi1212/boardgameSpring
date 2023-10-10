package webapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import webapp.dto.OpenHourDTO;
import webapp.repository.OpenHourRepository;
import webapp.service.ReservationService;

@RestController
@RequestMapping("/rev")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/ls")
    public List<OpenHourDTO> getAllOpenHour() {
        return reservationService.getAllOpenHour();
    }

    @PostMapping("/save-all")
    public Integer test_post(@RequestBody List<OpenHourDTO> dtos){
        return reservationService.updateAllTime(dtos);
    }
}
