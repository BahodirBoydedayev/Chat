package uz.unicon.websocket_demo.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProcessedMessage {
    private Date createdAt = new Date();
    private String text;
}
