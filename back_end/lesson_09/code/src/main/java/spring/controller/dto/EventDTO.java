package spring.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import spring.domain.Event;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class EventDTO {
    private Integer id;
    private String name;
    private String city;

    public static EventDTO getInstance(Event event) {
        return new EventDTO(event.getId(), event.getName(), event.getCity());
    }
}
