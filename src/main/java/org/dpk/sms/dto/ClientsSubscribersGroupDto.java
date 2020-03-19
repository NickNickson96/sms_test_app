package org.dpk.sms.dto;
import lombok.Data;
import org.dpk.sms.entity.SubscriberEntity;

import java.util.ArrayList;
import java.util.List;

@Data
public class ClientsSubscribersGroupDto {
    private Long id;
    private String name;
    private List<Long> subIds = new ArrayList<>();

}
