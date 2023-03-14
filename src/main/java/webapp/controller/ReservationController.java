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

    @Autowired // DI 等下藥刪除
    private OpenHourRepository openHourRepository;

    @GetMapping("/test")
    public int test(@RequestParam String week) {
        return openHourRepository.findByUsername(week);
    }

    @PostMapping("/test_post")
    public void test_post(@RequestBody OpenHourDTO dto){
        System.out.println("Post Success");
        System.out.printf("%s %s %s", dto.getWeek(), dto.getOpenTimeEnd(), dto.getOpenTimeEnd());
    }
}
