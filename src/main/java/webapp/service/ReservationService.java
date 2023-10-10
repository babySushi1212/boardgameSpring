package webapp.service;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webapp.dto.OpenHourDTO;
import webapp.pojo.OpenHour;
import webapp.repository.OpenHourRepository;

@Service
public class ReservationService {
    @Autowired // DI
    private OpenHourRepository openHourRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<OpenHourDTO> getAllOpenHour(){
        modelMapper.getConfiguration()
            .setMatchingStrategy(MatchingStrategies.LOOSE);
        return openHourRepository.findAll()
            .stream()
            .map(this::EntityToDTO)
            .collect(Collectors.toList());
    }

    private OpenHourDTO EntityToDTO(OpenHour openHour) {
        modelMapper.getConfiguration()
            .setMatchingStrategy(MatchingStrategies.LOOSE);
        OpenHourDTO openHourDTO = new OpenHourDTO();
        openHourDTO = modelMapper.map(openHour, OpenHourDTO.class);
        return openHourDTO;
    }

    public Integer updateAllTime(List<OpenHourDTO> dtos) {
        try {
            openHourRepository.saveAll(toEntityList(dtos));
            return 1;
        } catch (Exception e){
            return 0;
        }
    }


    private static OpenHour toEntity(OpenHourDTO dto) {
        OpenHour entity = new OpenHour();
        entity.setOpenTimeNo(dto.getOpenTimeNo());
        entity.setWeek(dto.getWeek());
        entity.setOpenTimeStart(dto.getOpenTimeStart());
        entity.setOpenTimeEnd(dto.getOpenTimeEnd());
        return entity;
    }

    private static List<OpenHour> toEntityList(List<OpenHourDTO> dtoList) {
        return dtoList.stream()
                .map(ReservationService::toEntity)
                .collect(Collectors.toList());
    }
}
