package com.sdy.bbbb.data.dataDto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class JamTop5Dto {

//    private Long ww;

    private String areaNm;

    private Long scoreSum;


    public JamTop5Dto(JamDto jamDto) {
//        this.ww = jamDto.getWw();
        this.areaNm = jamDto.getArea_Nm();
        this.scoreSum = jamDto.getScore_Num();
    }
}

